package com.fila;

import java.util.Scanner;

public class Main {

	/**
	 * Aqui é a main
	 * @param args
	 * @throws Exception
	 */
	
	/*	Exercício 1. Faça um programa que receba duas filas Q1 e Q2 e gere uma terceira fila Q3
	contendo a união dos elementos de Q1 e Q2 sem repetição. As filas Q1 e Q2 devem ser
	mantidas */
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// Scanner para a leitura de entrada de dados
		Scanner leitura = new Scanner (System.in);
		
		// Instanciar a Fila
		Fila<Integer> q1 = new Fila();
		Fila<Integer> q2 = new Fila();
		Fila<Integer> q3 = new Fila();
		
		int i = 0;
		
		// entrada
		int valor = 0;
		
		System.out.println ("Ola usuário. Qual é o tamanho da sua fila Q1? ");
		int tamanho = leitura.nextInt();
		
		// enfileirar q1
		while (i < tamanho) {
			System.out.println("Digite o º"+(i+1)+" numero da fila Q1: ");
			valor = leitura.nextInt();
			
			q1.enqueue(valor);
			q3.enqueue(valor);
			i++;
		}
		
		// reiniciar contador 
		i = 0;
		
		// tamanho fila Q2
		System.out.println ("Ola usuário. Qual é o tamanho da sua fila Q2? ");
		tamanho = leitura.nextInt();

		//enfileirar q2
		while (i < tamanho) {
			System.out.println("Digite o º"+(i+1)+" numero da fila Q2: ");
			valor = leitura.nextInt();
					
			q2.enqueue(valor);
			q3.enqueue(valor);
			i++;
		}
		
		for (i = 0; i < q3.getSize(); i++) {
			
			int a = q3.getItem();
			q3.dequeue();
			
			for (int j = 0; j < q3.getSize(); j++) {
				
				 int b = q3.getItem();
				 
				 if (a == b)
					 q3.dequeue();
				 else {
					 q3.enqueue(b);
					 q3.dequeue();
				 }
			}
			q3.enqueue(a);
		}
		
		// desemfileirar Q3
		System.out.println("Esta é sua fila Q3 \n");
		while (!q3.isEmpty()) {
			System.out.println("" +q3.getItem());
			q3.dequeue();
		}	
		
		// desemfileirar
		System.out.println("Esta é sua fila Q2 \n");
		while (!q2.isEmpty()) {
			System.out.println("" +q2.getItem());
			q2.dequeue();
		}	
		
		// desemfileirar
		System.out.println("Esta é sua fila Q1 \n");
		while (!q1.isEmpty()) {
			System.out.println("" +q1.getItem());
			q1.dequeue();
		}	
	}
}
