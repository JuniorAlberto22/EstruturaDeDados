package alberto.alves.vetor.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import alberto.alves.vetor.Vetor;

class VetorTest {

	private Vetor<String> vetor;
	
	@BeforeEach
	void init() {
		this.vetor = new Vetor<>(10);
		this.vetor.adicionar("String 1");
		this.vetor.adicionar("String 2");
		this.vetor.adicionar("String 3");
	}
	
	@Test
	void buscaPosicaoTest() {
		assertEquals(this.vetor.buscaPosicao(0), "String 1");
		assertEquals(this.vetor.buscaPosicao(1), "String 2");
	}
	
	@Test
	void adicionarTest() {
		String add = "Adicionada";
		this.vetor.adicionar(add);
		Integer tamanho = this.vetor.getSize();
		assertEquals(this.vetor.buscaPosicao(tamanho - 1), add);
	}
	
	@Test
	void adicionarIndexTest() {
		String add = "Adicionada";
		String valorPosi1 = this.vetor.buscaPosicao(1);
		String valorPosi0 = this.vetor.buscaPosicao(0);
		this.vetor.adicionar(1, add);
		
		assertEquals(this.vetor.buscaPosicao(1), add);
		assertEquals(this.vetor.buscaPosicao(2), valorPosi1);
		assertEquals(this.vetor.buscaPosicao(0), valorPosi0);
	}
	
	@Test
	void indexOfTest() {
		String valor = this.vetor.buscaPosicao(1);
		int indexOf = this.vetor.indexOf(valor);
		assertEquals(indexOf, 1);
	}
	
	@Test
	void getSizeTest() {
		int size = this.vetor.getSize();
		
		this.vetor.adicionar("Teste");
		assertEquals(this.vetor.getSize(), size + 1);

		this.vetor.adicionar(2, "Teste");
		assertEquals(this.vetor.getSize(), size + 2);
	}
	
	@Test
	void extensaoTest() {
		for(int i = 4; i <= 100; i++) {
			this.vetor.adicionar("String " + i);
		}
		assertEquals(this.vetor.getSize(), 100);
		int cont = 0;
		for(String s: this.vetor) {
			cont++;
		}
		assertEquals(cont, 100);
	}
	
	@Test
	void removeTest() {
		String elemento3 = this.vetor.buscaPosicao(2);
		String elemento1 = this.vetor.buscaPosicao(0);
		int tamanho = this.vetor.getSize();
		
		this.vetor.remover(1);
		assertEquals(vetor.buscaPosicao(1), elemento3);
		assertEquals(vetor.buscaPosicao(0), elemento1);
		assertEquals(vetor.getSize(), tamanho - 1);
	}
	
	@Test
	void removeObjetoTest() {
		String elemento3 = this.vetor.buscaPosicao(2);
		String elemento1 = this.vetor.buscaPosicao(0);
		int tamanho = this.vetor.getSize();
		
		this.vetor.remover("String 2");
		assertEquals(vetor.buscaPosicao(1), elemento3);
		assertEquals(vetor.buscaPosicao(0), elemento1);
		assertEquals(vetor.getSize(), tamanho - 1);
	}

}
