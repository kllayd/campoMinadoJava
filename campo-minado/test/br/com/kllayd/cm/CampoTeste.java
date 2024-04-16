package br.com.kllayd.cm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.kllayd.cm.excecao.ExplosaoException;
import br.com.kllayd.cm.modelo.Campo;

public class CampoTeste {

	private Campo campo;
	
	@BeforeEach
	void iniciarCampo () {
		campo = new Campo (3,3);
	}
	
	@Test
	void testeVizinhoD1() {
		Campo vizinho = new Campo(2,3);
		boolean resultado = campo.addVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoD2() {
		Campo vizinho = new Campo(2,2);
		boolean resultado = campo.addVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeNaoVizinho () {
		Campo vizinho = new Campo(5,5);
		boolean resultado = campo.addVizinho(vizinho);
		assertFalse(resultado);
	}
	
	@Test
	void testeValorPadraoMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlterarMarcado() {
		campo.alternarMarcado();
		assertTrue(campo.isMarcado());
	}
	@Test
	void testeAlterarMarcado2x() {
		campo.alternarMarcado();
		campo.alternarMarcado();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		boolean resultado = campo.abrir();
		assertTrue(resultado);
	}
	
	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcado();
		boolean resultado = campo.abrir();
		assertFalse(resultado);
	}
	
	@Test
	void testeAbrirMinadoMarcado() {
		campo.minar();
		campo.alternarMarcado();
		boolean resultado = campo.abrir();
		assertFalse(resultado);
	}
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
	}
	
	@Test
	void testeAbrirVizinho() {
		Campo vizinho1 = new Campo(1,1);
		Campo vizinho2 = new Campo(2,2);

		campo.addVizinho(vizinho2);
		vizinho2.addVizinho(vizinho1);
		campo.abrir();
		boolean resultado = vizinho1.isAberto() && vizinho2.isAberto();
		assertTrue(resultado);
	}
	
	@Test
	void testeAbrirVizinho2() {
		Campo vizinho1 = new Campo(1,1);
		Campo vizinho2 = new Campo(1,2);
		vizinho2.minar();
		
		Campo vizinho3 = new Campo(2,2);
		vizinho3.addVizinho(vizinho1);
		vizinho3.addVizinho(vizinho2);
		
		campo.addVizinho(vizinho3);
		campo.abrir();
		
		boolean resultado = vizinho3.isAberto() && vizinho2.isFechado();
		assertTrue(resultado);
	}
	
	
	
	
	
}
