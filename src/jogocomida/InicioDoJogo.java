package jogocomida;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jogocomida.constantes.Constantes;
import jogocomida.modelo.Pesquisa;
import jogocomida.negocio.Perguntar;

public class InicioDoJogo extends JFrame {

	private static final long serialVersionUID = 1L;
	private Pesquisa pesquisa;

	public static void main(String[] args) {
		new InicioDoJogo().setLayout(null);
	}

	public InicioDoJogo() {
		criarCaixaDeDialogo();
		criarObjetoPesquisa();
	}

	private void criarCaixaDeDialogo() {
		setTitle(Constantes.TITULO);
		JPanel jPanel = new JPanel();
		JButton button = criarBotao();
		acionarBotao(button);
		JLabel jLabel = criarLabel();
		jPanel.add(jLabel);
		jPanel.add(button);
		setContentPane(jPanel);
		setPreferredSize(new Dimension(400,100));
		pack();
		setVisible(true);
	}

	private JLabel criarLabel() {
		JLabel jLabel = new JLabel(Constantes.PENSE);
		jLabel.setAlignmentX(0.5F);
		return jLabel;
	}

	private JButton criarBotao() {
		JButton button = new JButton(Constantes.OK);
		button.setAlignmentX(0.5F);
		return button;
	}

	private void acionarBotao(JButton button) {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioDoJogo.this.precionarBotaoSim();
			}
		});
	}
	
	private void precionarBotaoSim() {
		this.pesquisa.perguntar();
	}

	private void criarObjetoPesquisa() {
		Perguntar pergunta1 = new Perguntar(this);
		pergunta1.setComida(Constantes.PRATO_UM);
		Perguntar pergunta2 = new Perguntar(this);
		pergunta2.setComida(Constantes.PRATO_DOIS);

		this.pesquisa = new Pesquisa(this);
		this.pesquisa.setPerguntas(Constantes.PERGUNTA_UM);
		this.pesquisa.setSim(pergunta1);
		this.pesquisa.setNao(pergunta2);
	}

}
