package br.com.kllayd.cm;

import br.com.kllayd.cm.modelo.Tabuleiro;
import br.com.kllayd.cm.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6,6,5);
		new TabuleiroConsole(tabuleiro);
		
	}
}
