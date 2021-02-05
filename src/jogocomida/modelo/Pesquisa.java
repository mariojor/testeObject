package jogocomida.modelo;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Pesquisa {
	
	private boolean flag;
	private String perguntas;
	private JFrame jframe;
	private Pesquisa sim;
	private Pesquisa nao;
	private Pesquisa pesquisa;

	public Pesquisa(JFrame parent) {
		this.jframe = parent;
	}
	
	public void setPesquisa(Pesquisa pesquisa, boolean flag) {
		this.pesquisa = pesquisa;
		this.flag = flag;
	}
	
	public Pesquisa getPesquisa() {
		return this.pesquisa;
	}

	public boolean isFlag() {
		return this.flag;
	}
	
	public String getPerguntas() {
		return this.perguntas;
	}

	public void setPerguntas(String question) {
		this.perguntas = question;
	}

	public Pesquisa getSim() {
		return this.sim;
	}

	public void setSim(Pesquisa sim) {
		this.sim = sim;
		sim.setPesquisa(this, true);
	}

	public Pesquisa getNao() {
		return this.nao;
	}

	public void setNao(Pesquisa nao) {
		this.nao = nao;
		nao.setPesquisa(this, false);
	}

	public JFrame getJframe() {
		return this.jframe;
	}
	
	public void perguntar() {
		boolean response = (JOptionPane.showConfirmDialog(this.jframe, this.perguntas, "", 0) == 0);
		if (response) {
			this.sim.perguntar();
		} else {
			this.nao.perguntar();
		}
	}
}
