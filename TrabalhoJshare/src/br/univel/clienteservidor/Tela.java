package br.univel.clienteservidor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Label;
import java.awt.TextField;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnPesquisar;
	private JLabel lblN;
	private JTextField txtNome;
	private JLabel lblServidor;
	private JTextField txtServidor;
	private JLabel lblPorta;
	private JTextField txtPorta;
	private JButton btnTrans;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JTable table_1;
	private JButton btnConectar;
	private Label label;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setTitle("SofrenciaShare");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblN = new JLabel("Nome");
		GridBagConstraints gbc_lblN = new GridBagConstraints();
		gbc_lblN.anchor = GridBagConstraints.WEST;
		gbc_lblN.insets = new Insets(0, 0, 5, 5);
		gbc_lblN.gridx = 0;
		gbc_lblN.gridy = 0;
		contentPane.add(lblN, gbc_lblN);
		
		txtNome = new JTextField();
		txtNome.setText("PAULO HENRIQUE DA FONSECA BUENO");
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.gridwidth = 10;
		gbc_txtNome.insets = new Insets(0, 0, 5, 5);
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.gridx = 2;
		gbc_txtNome.gridy = 0;
		contentPane.add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);
		
		lblServidor = new JLabel("Servidor");
		GridBagConstraints gbc_lblServidor = new GridBagConstraints();
		gbc_lblServidor.anchor = GridBagConstraints.WEST;
		gbc_lblServidor.insets = new Insets(0, 0, 5, 5);
		gbc_lblServidor.gridx = 0;
		gbc_lblServidor.gridy = 1;
		contentPane.add(lblServidor, gbc_lblServidor);
		
		txtServidor = new JTextField();
		GridBagConstraints gbc_txtServidor = new GridBagConstraints();
		gbc_txtServidor.gridwidth = 10;
		gbc_txtServidor.insets = new Insets(0, 0, 5, 5);
		gbc_txtServidor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtServidor.gridx = 2;
		gbc_txtServidor.gridy = 1;
		contentPane.add(txtServidor, gbc_txtServidor);
		txtServidor.setColumns(10);
		
		lblPorta = new JLabel("Porta");
		GridBagConstraints gbc_lblPorta = new GridBagConstraints();
		gbc_lblPorta.anchor = GridBagConstraints.EAST;
		gbc_lblPorta.insets = new Insets(0, 0, 5, 5);
		gbc_lblPorta.gridx = 12;
		gbc_lblPorta.gridy = 1;
		contentPane.add(lblPorta, gbc_lblPorta);
		
		txtPorta = new JTextField();
		GridBagConstraints gbc_txtPorta = new GridBagConstraints();
		gbc_txtPorta.gridwidth = 3;
		gbc_txtPorta.insets = new Insets(0, 0, 5, 5);
		gbc_txtPorta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPorta.gridx = 13;
		gbc_txtPorta.gridy = 1;
		contentPane.add(txtPorta, gbc_txtPorta);
		txtPorta.setColumns(10);
		
		label = new Label("Pasta");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 2;
		contentPane.add(label, gbc_label);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 10;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		btnConectar = new JButton("Conectar");
		GridBagConstraints gbc_btnConectar = new GridBagConstraints();
		gbc_btnConectar.insets = new Insets(0, 0, 5, 5);
		gbc_btnConectar.gridx = 13;
		gbc_btnConectar.gridy = 2;
		contentPane.add(btnConectar, gbc_btnConectar);
		
		JLabel lblPesquisar = new JLabel("Pesquisar");
		GridBagConstraints gbc_lblPesquisar = new GridBagConstraints();
		gbc_lblPesquisar.anchor = GridBagConstraints.EAST;
		gbc_lblPesquisar.insets = new Insets(0, 0, 5, 5);
		gbc_lblPesquisar.gridx = 0;
		gbc_lblPesquisar.gridy = 3;
		contentPane.add(lblPesquisar, gbc_lblPesquisar);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 12;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 3;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnPesquisar = new GridBagConstraints();
		gbc_btnPesquisar.insets = new Insets(0, 0, 5, 0);
		gbc_btnPesquisar.gridwidth = 3;
		gbc_btnPesquisar.gridx = 15;
		gbc_btnPesquisar.gridy = 3;
		contentPane.add(btnPesquisar, gbc_btnPesquisar);
		
		lblNewLabel = new JLabel("Meus Arquivos");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 4;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Arquivos Servidor");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 13;
		gbc_lblNewLabel_1.gridy = 4;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 8;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 5;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnTrans = new JButton("Transferir");
		GridBagConstraints gbc_btnTrans = new GridBagConstraints();
		gbc_btnTrans.anchor = GridBagConstraints.WEST;
		gbc_btnTrans.insets = new Insets(0, 0, 5, 5);
		gbc_btnTrans.gridx = 8;
		gbc_btnTrans.gridy = 5;
		contentPane.add(btnTrans, gbc_btnTrans);
		
		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridheight = 3;
		gbc_scrollPane_1.gridwidth = 9;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 10;
		gbc_scrollPane_1.gridy = 5;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
	}

	
	
}
