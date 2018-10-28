package alberto.alves.vetor;

import java.lang.reflect.Array;
import java.util.Iterator;

public class Vetor<T> implements Iterable<T>{
 
	private T[] elementos;
	private int size;
	private int extraArray;
	
	@SuppressWarnings("unchecked")
	public Vetor(int capacidade){
		this.elementos = (T[]) new Object[capacidade];
		this.size = 0;
		this.extraArray = 10;
	}
	
	@SuppressWarnings("unchecked")
	public Vetor(int capacidade, Class<T> tipoClasse){
		this.elementos = (T[]) Array.newInstance(tipoClasse, capacidade);
		this.size = 0;
		this.extraArray = 10;
	}
	
	public void setExtraArray(int extraArray) {
		this.extraArray = extraArray;
	}

	public boolean adicionar(T object) {
		this.verificarArrayCheio();
		this.elementos[this.size] = object;
		this.size++;
		return true;
		
	}
	
	public boolean adicionar(int index, T object) {
		if(index >= 0) {
			this.verificarArrayCheio();
			for(int i = size; i >= index; i--) {
				this.elementos[i + 1] = this.elementos[i];
			}
			this.elementos[index] = object;
			this.size++;
			return true;
		}
		return false;
	}

	public boolean remover(int index) {
		if(index > 0 && index < this.size) {
			for(int i = index; i < this.size - 1; i++) {
				this.elementos[index] = this.elementos[i + 1];
			}
			--size;
			return true;
		}else {
			throw new IllegalArgumentException("Posição inválida: " + index);
		}
	}
	
	public boolean remover(T object) {
		int index = indexOf(object);
		if(index != -1) {
			return remover(index);
		}
		return false;
	}
	
	public T buscaPosicao(int posicao) {
		if(posicao < size && posicao >= 0) {
			return this.elementos[posicao];
		}
		throw new IllegalArgumentException("Posicão inválida: " + posicao);
	}
	
	public int getSize() {
		return size;
	}
	
	public int indexOf(T object) {
		if(object != null) {
			for(int i = 0; i < this.size; i++) {
				if(this.elementos[i].equals(object))
					return i;
			}
		}
		return -1;
	}
	
	private void verificarArrayCheio() {
		if(this.size == this.elementos.length) {
			this.dobrarArray();
		}
	}

	@SuppressWarnings("unchecked")
	private void dobrarArray() {
		T[] novoArray = (T[]) new Object[this.elementos.length + this.extraArray];
		for(int i = 0; i < this.elementos.length; i++) {
			novoArray[i] = this.elementos[i];
		}
		this.elementos = novoArray;
	}
	
	@Override
	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append("Vetor [elementos=[");
		for(int i = 0; i < size; i++) {
			if(this.elementos[i] == null)
				break;
			build.append(this.elementos[i]);
			if(i < this.size - 1)
				build.append(", ");
		}
		build.append("]]");
		return build.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			private int index = 0;
			@Override
			public boolean hasNext() {
				return this.index < getSize();
			}

			@Override
			public T next() {
				return buscaPosicao(index++);
			}
		};
	}
	
}
