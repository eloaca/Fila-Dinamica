package com.fila;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// Scanner para a leitura de entrada de dados
		Scanner leitura = new Scanner (System.in);
		
		// Instanciar a Fila
		Fila<Double> f = new Fila();
		Fila<Double> aux = new Fila ();
		Fila<Double> f2 = new Fila();
		
		// contador
		int i = 0;
		
		Double valor = 0.0;

		/*
		// enfileirar
		while (i < 6) {
			System.out.println("Digite o numero: ");
			valor = leitura.nextDouble();

			f.enqueue(valor);
			i++;
		}
		*/
		f.enqueue(5.6);
		f.enqueue(7.8);
		f.enqueue(1.3);
		f.enqueue(3.2);
		f.enqueue(4.0);
		f.enqueue(2.5);
		
		while (!f.isEmpty()) {
			
			// Logica
			double primeiroF = f.getItem();
			f.dequeue();
			aux.enqueue(primeiroF);
			double primeiroA = aux.getItem();
			i = 0;
			
			while (!(i == f.getSize())) {
				primeiroF = f.getItem();
				f.dequeue();
				
				primeiroA = aux.getItem();
				aux.dequeue();
				
				if (primeiroF > primeiroA) {
					
					f.enqueue(primeiroF);
					aux.enqueue(primeiroA);
				}
				else {
					aux.enqueue(primeiroF);
					f.enqueue(primeiroA);
				}
				i++;
				
			}
			primeiroA = aux.getItem();
			f2.enqueue(primeiroA);
			
			while (!aux.isEmpty())
				aux.dequeue();
		}
		
		System.out.println("Esta é sua fila\n");
		
		// desemfileirar
		while (!f2.isEmpty()) {
			System.out.println("" +f2.getItem());
			f.dequeue();
		}
		
	}

}
