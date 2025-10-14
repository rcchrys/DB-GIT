package main;

import java.util.Scanner;

import model.Jogo;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("BEM-VINDO");

		System.out.println("----------MENU----------");
		System.out.println("1. CADASTRAR JOGO");
		System.out.println("2.LISTAR JOGOS");
		System.out.println("3.EXCLUIR UM JOGO");
		System.out.println("4.SAIR");
		System.out.println("");
		int opcao = sc.nextInt();

		switch (opcao) {
		case 1: {
			
			//quero que o jogo seja inserido após verificar se o nome dele já existe na lista.
			
			Jogo jogoNovo = new Jogo();

			break;
		}
	}
		switch (opcao) {
		case 2: {
			
			//mostrar a lista de jogos

			break;
		}
	}
		switch (opcao) {
		case 3: {
			
			//excluir um jogo da lista por id ou nome

			break;
		}
	}
		switch (opcao) {
		case 4: {
			
			System.out.println("FECHANDO O PROGRAMA.");
			return;
		}
		default:
			
			System.out.println("OPÇÃO INVÁLIDA.");
			
		}
	}
}
		