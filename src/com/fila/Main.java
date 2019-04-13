package com.fila;

import java.util.Scanner;

public class Main {

	/**
	 * Aqui é a main
	 * @param args
	 * @throws Exception
	 */
	
	//Exercício 2. Criar um programa que permita inserir um elemento depois do 
	//enésimo elemento de uma fila
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// Scanner para a leitura de entrada de dados
		Scanner leitura = new Scanner (System.in);
		
		// Instanciar a Fila
		Fila<Integer> f = new Fila();
		Fila<Integer> aux = new Fila();
		
		int i = 0;
		
		// entrada
		int valor = 0;
		
		System.out.println ("Ola usuário. Qual é o tamanho da sua fila ? ");
		int tamanho = leitura.nextInt();
		
		// enfileirar
		while (i < tamanho) {
			System.out.println("Digite o numero: ");
			valor = leitura.nextInt();
			
			f.enqueue(valor);
			i++;
		}
		
		// reiniciar contador 
		i = 0;
		
		// criar um novo contador
		int c = 1;
		
		// numero a adicionar
		System.out.println ("Qual numero voce deseja adicionar ? ");
		valor = leitura.nextInt();
		
		// posicao a considerar
		System.out.println ("Qual posicao da fila voce deseja colocar o numero ");
		int posicao = leitura.nextInt();
		
		// Pegar o tamanho da filha
		tamanho = f.getSize();

		// Ele pode adicionar no final da fila mas nao mais que isso
		if (posicao > tamanho+1 || posicao < 0) {
			System.err.println("Nao é possivel inserir nessa posicao. ");
			System.exit(0);
		}
		
		//Se ele quiser adicionar no fim da fila, ja adiciona direto
		if (posicao == tamanho+1) {
			f.enqueue(valor);
		}
		else if (posicao == 1) {
			while (!f.isEmpty()) {
				int primeiro = f.getItem();
				aux.enqueue(primeiro);
				f.dequeue();
			} //final do while fila vazia
			f.enqueue(valor);
			i++; // 
		}
		else { // se ele quiser adicionar em outra posicao, precisa entrar no while  
			while (!(c == posicao)) {
				int primeiro = f.getItem();
				aux.enqueue(primeiro);
				f.dequeue();
				c++;
				tamanho = f.getSize();
				
			} // final do while comparacao
			aux.enqueue(valor);
		
			while (!f.isEmpty()) {
				int primeiro = f.getItem();
				aux.enqueue(primeiro);
				f.dequeue();
			} //final do while fila vazia
			i++;
		} // final do elseif
		
		// entrar nessa condicao se i for maior que 1
		if (i > 0) {
			while (!aux.isEmpty()) {
				int primeiro = aux.getItem();
				f.enqueue(primeiro);
				aux.dequeue();
			}
		} // final do while aux vazia

				
		// desemfileirar
		System.out.println("Esta é sua fila: \n");
		while (!f.isEmpty()) {
			System.out.println("" +f.getItem());
			f.dequeue();;
		}	
	}
}
