package com.fila;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// Scanner para a leitura de entrada de dados
		Scanner leitura = new Scanner (System.in);
		
		// Instanciar a Fila
		Fila<Integer> f1 	= new Fila();
		Fila<Integer> aux 	= new Fila();
		Fila<Integer> f2 	= new Fila();
	
		// tamanho da fila 
		System.out.println("Ola. Defina o tamanho da fila: ");
		int tamanho = leitura.nextInt();
		
		// contador
		int i = 0;
		
		// variavel para enfileirar
		int ordem  	= 0;
		int num		= 0;
		
		// enfileirar numero e ordem
		while (!(i == tamanho)) {
			System.out.println ("Insira a ordem: "+(i+1));
			ordem = leitura.nextInt();
			f1.enqueue(ordem);
			
			System.out.println("Insira o º"+(i+1)+" numero");
			num = leitura.nextInt();
			f1.enqueue(num);
			
			i++;
		}
		
		// zerar o contador
		i = 0;
		

		// primeiro da fila 
		int a = 0;
		int b = 0;
		
		int c = 0;
		int d = 0;
		
		int t = 0;
		
		
		
		while (!f1.isEmpty()) {
									
			a = f1.getItem();
			f1.dequeue();
			b = f1.getItem();
			f1.dequeue();
			
			f2.enqueue(a);
			f2.enqueue(b);
			
			i = 0;
			t = f1.getSize()/2;
			
						
			while (i < t) {
				
				a = f1.getItem();
				f1.dequeue();
				b = f1.getItem();
				f1.dequeue();
				
				/*if (i >= 1) {
					f2.enqueue(a);
					f2.enqueue(b);
				}*/
				
				c = f2.getItem();
				f2.dequeue();
				d = f2.getItem();
				f2.dequeue();
				
				if (a < c) {
					
					f1.enqueue(c);
					f1.enqueue(d);

					f2.enqueue(a);
					f2.enqueue(b);
					
				}
				else if (a > c) {
					
					f1.enqueue(a);
					f1.enqueue(b);

					f2.enqueue(c);
					f2.enqueue(d);
				}
				
				else if (a == c) {
					
					if (b > d) {
						
						f1.enqueue(a);
						f1.enqueue(b);
						
						f2.enqueue(c);
						f2.enqueue(d);
					}
					else if (b < d) {
						
						f1.enqueue(c);
						f1.enqueue(d);

						f2.enqueue(a);
						f2.enqueue(b);
					}
					else if (b == d) {
						
						f2.enqueue(a);
						f2.enqueue(b);
						
						f2.enqueue(c);
						f2.enqueue(d);
					}
				}
				i++;
			}
			while (!f2.isEmpty()) {
				int x = f2.getItem();
				aux.enqueue(x);
				f2.dequeue();
			}
		}

		
		// desemfileirar
		System.out.println("\nEssa é sua fila ");
		while (!aux.isEmpty()) {
			System.out.println("" +aux.getItem());
				aux.dequeue();
		}
		
	}
}