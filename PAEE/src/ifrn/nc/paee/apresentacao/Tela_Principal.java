package ifrn.nc.paee.apresentacao;

import ifrn.nc.paee.Teste;
import ifrn.nc.paee.servicos.bd.Experimento;
import ifrn.nc.paee.util.CarregadorDeExperimentos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import java.awt.Frame;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;

public class Tela_Principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Principal window = new Tela_Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tela_Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Plataforma de Apoio Ao Ensino Experimental");
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel panel_Imagem = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(294)
					.addComponent(panel_Imagem, GroupLayout.PREFERRED_SIZE, 630, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(438, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(panel_Imagem, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(238, Short.MAX_VALUE))
		);
		
		
		
		Experimento[] exps = (new CarregadorDeExperimentos())
				.getExperimentos();
		for (Experimento experimento : exps) {
			JButton btnExp = new JButton(experimento.getNome());
			panel_Imagem.add(btnExp);
			
		}
		
	}

}
