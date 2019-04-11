package com.fila;

/**
 * Esta classe tem como objetivo cuidar dos comandos basicos de uma fila
 * @author Eloa Cardozo
 *
 * @param <TipoItem> o tipo da fila, podendo ser boolean, Integer, String ..
 */

public class Fila<TipoItem> {
	private class No {
		private TipoItem item;
		private No proximo;

		/**
		 * Esta funcao tem como objetivo criar um No, com 1 ponteiro e 1 lugar para 
		 * guardar o item
		 * @param item adicionado pelo usuario
		 * @param proximo ponteiro do proximo item
		 */
		public No(TipoItem item, No proximo) {
			this.item = item;
			this.proximo = proximo;
		}

		/**
		 * Esta funcao retorna um item
		 * @return item
		 */
		public TipoItem getItem() {
			return this.item;
		}

		/**
		 * Esta funcao retorna um ponteiro
		 * @return o ponteiro no proximo
		 */
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

	/**
	 * Esta funcao tem como objetivo adicionar um item ao final da fila
	 * @param item que o usu·rio ir· adicionar a fila
	 * @throws Exception
	 */
	
	public void enqueue(TipoItem item) throws Exception {
		if (item == null)
			throw new Exception("Valor ausente");
		
		// guarda o atual ultimo da fila, antes da insercao (sera o penultimo)
		No penultimo = this.ultimo;
		
		// insere o novo item como ultimo da fila, com proximo null
		this.ultimo = new No (item, null);
		
		if(this.isEmpty())
			// se a fila estiver vazia, atribui o ultimo ao primeiro tamb√©m
			this.primeiro = this.ultimo;
		else
			// sen√£o estiver vazia, define o pr√≥ximo do penultimo como o ultimo
			penultimo.setProximo(this.ultimo);
        
        this.tamanho++;
	}

	/**
	 * Esta funcao tem como objetivo de remover o primeiro item adicionado a fila
	 * Ela remove o primeiro adicionado a fila e atribui o segundo numero ao primeiro
	 * @throws Exception caso a pilha esteja vazia
	 */
	public void dequeue() throws Exception {
		if (this.isEmpty())
			throw new Exception("Nada guardado");
		
        this.primeiro = this.primeiro.getProximo();
        this.tamanho--;
	}

	/**
	 * Esta funcao tem como objetivo pegar o primeiro item adicionado a fila
	 * @return o primeiro item adicionado da fila 
	 * @throws Exception caso a pilha esteja vazia
	 */
	public TipoItem getItem() throws Exception {
		if (this.isEmpty())
			throw new Exception("Nada guardado");

		return this.primeiro.getItem();
	}

	/**
	 * Esta funcao tem como objetivo verificar se a pilha esta ou nao vazia
	 * @return true se estiver vazia, false se nao
	 */
	public boolean isEmpty() {
		return this.primeiro == null;
	}
	
	/**
	 * Esta funcao tem como objetivo retornar o tamanho da fila
	 * @return um inteiro com o tamanho da fila
	 */
	public int getSize() {
		return this.tamanho;
	}
}