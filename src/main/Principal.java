package main;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import dao.JogoDao;
import model.Jogo;

public class Principal {

	static JogoDao dao = new JogoDao();
	
	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);

		System.out.println("BEM-VINDO");

		while (true) {
			System.out.println("----------MENU----------");
			System.out.println("1. CADASTRAR JOGO");
			System.out.println("2. LISTAR JOGOS");
			System.out.println("3. EXCLUIR UM JOGO");
			System.out.println("4. SAIR");
			
			int opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
			case 1: { //quero que o jogo seja inserido após verificar se o nome dele já existe na lista.
				
				System.out.println("DIGITE O NOME DO JOGO.");
				String nomeNovo= sc.nextLine();
				
				System.out.println("DIGITE O GÊNERO DO JOGO.");
				String generoNovo = sc.nextLine();
				
				System.out.println("DIGITE O DATA DE LANÇAMENTO DO JOGO - aaaa-MM-dd.");
				String dataLancNovo = sc.nextLine();
				Date data = Date.valueOf(dataLancNovo); // -> 
				
				System.out.println("DIGITE O NOTA DO JOGO.");
				double notaNovo = sc.nextDouble();
				
				Jogo jogoNovo = new Jogo (nomeNovo, generoNovo, data, notaNovo);
				jogoNovo = dao.inserirJogo(jogoNovo);
				
				break;
			}

			case 2: {
				listarJogos();
				break;
			}
			
			case 3: {
				listarJogos();
				System.out.println("DIGITE O ID DO JOGO QUE SERÁ EXCLUÍDO.");
				int id = sc.nextInt();
				dao.excluirJogo(id);
				
				break;
			}
			
			case 4: {
				
				System.out.println("FECHANDO O PROGRAMA.");
				return;
			}
			default:
				
				System.out.println("OPÇÃO INVÁLIDA.");
				
			}
		}
		}
			
	public static void listarJogos() {
		List<Jogo> jogos = dao.listarJogos();
		for(Jogo jogo: jogos) {
			System.out.println(jogo);
		}
	}
}
		