package com.fila;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// Scanner para a leitura de entrada de dados
		Scanner leitura = new Scanner (System.in);
		
		// Instanciar a Fila
		Fila<Integer> f = new Fila();
		
		int i = 0;
		
		// entrada
		int valor = 0;
		
		// enfileirar
		while (i != 5) {
			System.out.println("Digite o numero: ");
			valor = leitura.nextInt();
			
			f.insereItem(valor);
			i++;
		}
		
		System.out.println("Esta é sua fila\n");
		
		// desemfileirar
		while (!f.isVazia()) {
			System.out.println("" +f.getItem());
			f.removeItem();
		}
		
	}

}
