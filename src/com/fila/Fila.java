package com.fila;

public class Fila<TipoItem> {
	private class No {
		private TipoItem item;
		private No proximo;

		public No(TipoItem item, No proximo) {
			this.item = item;
			this.proximo = proximo;
		}

		public TipoItem getItem() {
			return this.item;
		}

		public No getProximo() {
			return this.proximo;
		}

		@SuppressWarnings("unused")
		public void setItem(TipoItem item) {
			this.item = item;
		}

		public void setProximo(No proximo) {
			this.proximo = proximo;
		}
	} // fim da classe No

	private No primeiro, ultimo;
	private int tamanho;
	
	public Fila() throws Exception {
		this.primeiro = null;
		this.ultimo = null;
		this.tamanho = 0;
	}

	// enqueue
	public void insereItem(TipoItem item) throws Exception {
		if (item == null)
			throw new Exception("Valor ausente");
		
		// guarda o atual ultimo da fila, antes da insercao (sera o penultimo)
		No penultimo = this.ultimo;
		
		// insere o novo item como ultimo da fila, com proximo null
		this.ultimo = new No (item, null);
		
		if(this.isVazia())
			// se a fila estiver vazia, atribui o ultimo ao primeiro também
			this.primeiro = this.ultimo;
		else
			// senão estiver vazia, define o próximo do penultimo como o ultimo
			penultimo.setProximo(this.ultimo);
        
        this.tamanho++;
	}

	// dequeue
	public void removeItem() throws Exception {
		if (this.isVazia())
			throw new Exception("Nada guardado");
		
        this.primeiro = this.primeiro.getProximo();
        this.tamanho--;
	}

	// first
	public TipoItem getItem() throws Exception {
		if (this.isVazia())
			throw new Exception("Nada guardado");

		return this.primeiro.getItem();
	}

	// isEmpty
	public boolean isVazia() {
		return this.primeiro == null;
	}
	
	// getSize
	public int getTamanho() {
		return this.tamanho;
	}
}
