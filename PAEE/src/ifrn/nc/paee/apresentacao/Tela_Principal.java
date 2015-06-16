package ifrn.nc.paee.apresentacao;

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
		
		
		JPanel panel_Botoes_Experimentos = new JPanel();
		
		JPanel panel_Nome_Experimentos = new JPanel();
		
		JPanel panel_Imagem = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_Nome_Experimentos, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_Botoes_Experimentos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(69)
					.addComponent(panel_Imagem, GroupLayout.PREFERRED_SIZE, 630, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(430, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_Imagem, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_Nome_Experimentos, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_Botoes_Experimentos, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(238, Short.MAX_VALUE))
		);
		
		JLabel lblImagem = new JLabel("IMAGEM");
		panel_Imagem.add(lblImagem);
		
		JLabel lblExperimentos = new JLabel("Experimentos");
		GroupLayout gl_panel_Nome_Experimentos = new GroupLayout(panel_Nome_Experimentos);
		gl_panel_Nome_Experimentos.setHorizontalGroup(
			gl_panel_Nome_Experimentos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Nome_Experimentos.createSequentialGroup()
					.addGap(57)
					.addComponent(lblExperimentos))
		);
		gl_panel_Nome_Experimentos.setVerticalGroup(
			gl_panel_Nome_Experimentos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Nome_Experimentos.createSequentialGroup()
					.addGap(5)
					.addComponent(lblExperimentos))
		);
		panel_Nome_Experimentos.setLayout(gl_panel_Nome_Experimentos);
		
		JButton btnEnsFund = new JButton("Ensino Fundamental");
		
		JButton btnEnsMedio = new JButton("Ensino M\u00E9dio");
		
		JButton btnEnsSuperior = new JButton("Ensino Superior");
		GroupLayout gl_panel_Botoes_Experimentos = new GroupLayout(panel_Botoes_Experimentos);
		gl_panel_Botoes_Experimentos.setHorizontalGroup(
			gl_panel_Botoes_Experimentos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Botoes_Experimentos.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_Botoes_Experimentos.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnEnsSuperior, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnEnsMedio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnEnsFund, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		gl_panel_Botoes_Experimentos.setVerticalGroup(
			gl_panel_Botoes_Experimentos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Botoes_Experimentos.createSequentialGroup()
					.addGap(33)
					.addComponent(btnEnsFund, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnEnsMedio, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnEnsSuperior, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(204))
		);
		panel_Botoes_Experimentos.setLayout(gl_panel_Botoes_Experimentos);
		frame.getContentPane().setLayout(groupLayout);
	}

}
