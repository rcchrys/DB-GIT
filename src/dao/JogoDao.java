package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Jogo;

public class JogoDao {
	
	public Connection getConexao() {
		
		// Driver
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// URL: onde esta meu banco de dados
		String url = "jdbc:mysql://localhost:3306/ies"; 
		
		// Senha
		String senha = "aluno123";
		
		// Usuario
		String user = "aluno";
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, senha);
			//System.out.println("Banco de dados conectado!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;		
		
	}
	
	public List<Jogo> listarJogos() {
		
		List<Jogo> jogos = new ArrayList<>();
		String consulta = "select * from jogo";
		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(consulta);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String genero = rs.getString(3);
				Date data = rs.getDate(4);
				double nota = rs.getDouble(5);
				Jogo jogo = new Jogo(id, nome, genero,data, nota);
				jogos.add(jogo);
					
		}
			
			rs.close();
			pst.close();	
			con.close();	
			
		} catch (Exception e) {
			System.out.println(e);	
			
		}
		
		return jogos;
	}
	
	public Jogo inserirJogo(Jogo jogoNovo) {
		
		String consulta = "INSERT INTO "
				+ "jogo(nome,genero, data_lancamento, nota)"
				+ "VALUES (?,?,?,?)";
		
		try {
			Connection conn = getConexao();
			PreparedStatement pst 
			= conn.prepareStatement(consulta,Statement.RETURN_GENERATED_KEYS);
			//pst.setInt(1, jogoNovo.getId());
			pst.setString(1, jogoNovo.getNome());
			pst.setString(2, jogoNovo.getGenero());
			pst.setDate(3, jogoNovo.getDataLancamento());
			pst.setDouble(4, jogoNovo.getNota());
			pst.executeUpdate();
			
			// Pegando a chave
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				jogoNovo.setId(id);
			}
			
			rs.close();
			pst.close();
			conn.close();
			
			return jogoNovo;
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	public void excluirJogo(int id) {
		
		String consulta = "Delete from jogo where (id = ?)";
		try {
			
			Connection conn = getConexao();
			PreparedStatement pst = conn.prepareStatement(consulta);
			pst.setInt(1, id);
			pst.executeUpdate();
			pst.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}