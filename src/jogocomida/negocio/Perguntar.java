package jogocomida.negocio;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import jogocomida.constantes.Constantes;
import jogocomida.modelo.Pesquisa;

public class Perguntar extends Pesquisa {

	private String comida;

	public Perguntar(JFrame jframe) {
		super(jframe);
	}

	public void perguntar() {
		boolean resposta = confirmarPrato();
		if (resposta) {
			confimarRespostaCorreta();
		} else {
			Pesquisa pesquisa = new Pesquisa(getJframe());
			String prato = criarComponenteEValidaInformacao(); 
			String pergunta = criarComponenteDePerguntaEMas(prato);
			
			pergunta = Constantes.PERGUNTA_TRES + pergunta + Constantes.INTERROG;
			Perguntar perguntar = new Perguntar(getJframe());
			perguntar.setComida(prato);
			validarPerguntas(pesquisa);
			pesquisa.setPerguntas(pergunta);
			pesquisa.setSim(perguntar);
			pesquisa.setNao(this);
		}
	}
	
	public String getComida() {
		return comida;
	}

	public void setComida(String comida) {
		this.comida = comida;
	}


	private String criarComponenteDePerguntaEMas(String prato) {
		String pergunta = JOptionPane.showInputDialog(getJframe(), prato + Constantes.EMAS + this.comida + Constantes.NAO,
				"", 3);
		while(pergunta == null || pergunta.equals("")) {
			pergunta = JOptionPane.showInputDialog(getJframe(), prato + Constantes.EMAS + this.comida + Constantes.NAO,
					"", 3);
		}
		return pergunta;
	}

	private String criarComponenteEValidaInformacao() {
		String prato = JOptionPane.showInputDialog(getJframe(), Constantes.PERGUNTA_DOIS, Constantes.SEM_RESP, 3);
		
		while(prato == null || prato.equals("")) {
			prato = JOptionPane.showInputDialog(getJframe(), Constantes.PERGUNTA_DOIS_NOVAMENTE, Constantes.SEM_RESP, 3);
		}
		return prato;
	}

	private void confimarRespostaCorreta() {
		JOptionPane.showMessageDialog(getJframe(), Constantes.CORRETO, Constantes.TITULO, 1);
	}

	private void validarPerguntas(Pesquisa pesquisa) {
		if (isFlag()) {
			getPesquisa().setSim(pesquisa);
		} else {
			getPesquisa().setNao(pesquisa);
		}
	}

	private boolean confirmarPrato() {
		boolean resposta = (JOptionPane.showConfirmDialog(getJframe(), Constantes.PENSOU + this.comida + "?",
				"", 0) == 0);
		return resposta;
	}

}
