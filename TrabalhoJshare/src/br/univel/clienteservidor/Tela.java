package br.univel.clienteservidor;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AccessException;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.univel.comum.interfaces.Arquivo;
import br.univel.comum.interfaces.Cliente;
import br.univel.comum.interfaces.IServer;
import br.univel.comum.interfaces.TipoFiltro;

public class Tela extends JFrame implements IServer {

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
	private JButton btnLigarServidor;
	private IServer servidor;
	private JButton btnDesligarServidor;

	private IServer conexaoServidor;
	private Registry registryServidor;

	private Registry registryCliente;
	private IServer conexaoCliente;

	private List<Cliente> clienteRegistrados;
	private JScrollPane scrollPane_2;
	private JTextArea textArea;
	
	Map<Cliente, List<Arquivo>> listaDeArquivos = new HashMap<>();

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
		setBounds(100, 100, 813, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0,
				0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
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
		gbc_txtNome.gridx = 3;
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
		txtServidor.setText("localhost");
		GridBagConstraints gbc_txtServidor = new GridBagConstraints();
		gbc_txtServidor.gridwidth = 10;
		gbc_txtServidor.insets = new Insets(0, 0, 5, 5);
		gbc_txtServidor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtServidor.gridx = 3;
		gbc_txtServidor.gridy = 1;
		contentPane.add(txtServidor, gbc_txtServidor);
		txtServidor.setColumns(10);

		lblPorta = new JLabel("Porta");
		GridBagConstraints gbc_lblPorta = new GridBagConstraints();
		gbc_lblPorta.anchor = GridBagConstraints.EAST;
		gbc_lblPorta.insets = new Insets(0, 0, 5, 5);
		gbc_lblPorta.gridx = 13;
		gbc_lblPorta.gridy = 1;
		contentPane.add(lblPorta, gbc_lblPorta);

		txtPorta = new JTextField();
		txtPorta.setText("1818");
		GridBagConstraints gbc_txtPorta = new GridBagConstraints();
		gbc_txtPorta.insets = new Insets(0, 0, 5, 5);
		gbc_txtPorta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPorta.gridx = 14;
		gbc_txtPorta.gridy = 1;
		contentPane.add(txtPorta, gbc_txtPorta);
		txtPorta.setColumns(10);

		btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				conectarnoServidor();
			}

			private void conectarnoServidor() {
				String server = txtServidor.getText();
				int porta = Integer.parseInt(txtPorta.getText());

				try {
					registryCliente = LocateRegistry.getRegistry(server, porta);
					conexaoCliente = (IServer) registryCliente.lookup(IServer.NOME_SERVICO);

					conexaoCliente.registrarCliente(getMyCliente());
					List<Arquivo> myFiles = getMyFiles();
					
					conexaoCliente.publicarListaArquivos(getMyCliente(), getMyFiles());
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			public Cliente getMyCliente() {
				Cliente cliente = null;
				try {
					cliente = new Cliente(1, InetAddress.getLocalHost().getHostName(),
							InetAddress.getLocalHost().getHostAddress(), 1818);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return cliente;
			}

			

		});
		GridBagConstraints gbc_btnConectar = new GridBagConstraints();
		gbc_btnConectar.insets = new Insets(0, 0, 5, 5);
		gbc_btnConectar.gridx = 16;
		gbc_btnConectar.gridy = 1;
		contentPane.add(btnConectar, gbc_btnConectar);

		JLabel lblPesquisar = new JLabel("Pesquisar");
		GridBagConstraints gbc_lblPesquisar = new GridBagConstraints();
		gbc_lblPesquisar.anchor = GridBagConstraints.EAST;
		gbc_lblPesquisar.insets = new Insets(0, 0, 5, 5);
		gbc_lblPesquisar.gridx = 0;
		gbc_lblPesquisar.gridy = 2;
		contentPane.add(lblPesquisar, gbc_lblPesquisar);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 12;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnPesquisar = new GridBagConstraints();
		gbc_btnPesquisar.anchor = GridBagConstraints.WEST;
		gbc_btnPesquisar.insets = new Insets(0, 0, 5, 5);
		gbc_btnPesquisar.gridwidth = 3;
		gbc_btnPesquisar.gridx = 16;
		gbc_btnPesquisar.gridy = 2;
		contentPane.add(btnPesquisar, gbc_btnPesquisar);

		lblNewLabel = new JLabel("Meus Arquivos");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 4;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		lblNewLabel_1 = new JLabel("Arquivos Servidor");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 14;
		gbc_lblNewLabel_1.gridy = 4;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 9;
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
		gbc_btnTrans.gridx = 9;
		gbc_btnTrans.gridy = 5;
		contentPane.add(btnTrans, gbc_btnTrans);

		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridheight = 3;
		gbc_scrollPane_1.gridwidth = 9;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 11;
		gbc_scrollPane_1.gridy = 5;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);

		btnLigarServidor = new JButton("Ligar Servidor");
		btnLigarServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (servidor == null) {

					try {
						inicializaServidor();
					} catch (Exception e) {
						e.printStackTrace();
					}
					btnLigarServidor.setEnabled(false);
					btnDesligarServidor.setEnabled(true);
				} else {
					destroiServidor();

				}
			}
		});
		GridBagConstraints gbc_btnLigarServidor = new GridBagConstraints();
		gbc_btnLigarServidor.insets = new Insets(0, 0, 5, 5);
		gbc_btnLigarServidor.gridx = 0;
		gbc_btnLigarServidor.gridy = 8;
		contentPane.add(btnLigarServidor, gbc_btnLigarServidor);

		btnDesligarServidor = new JButton("Desligar Servidor");
		btnDesligarServidor.setEnabled(false);
		btnDesligarServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					UnicastRemoteObject.unexportObject(registryServidor, true);
					registryServidor = null;

					btnLigarServidor.setEnabled(true);
					btnDesligarServidor.setEnabled(false);

					textArea.append("Servidor Desligado\n");

				} catch (NoSuchObjectException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnDesligarServidor = new GridBagConstraints();
		gbc_btnDesligarServidor.insets = new Insets(0, 0, 5, 5);
		gbc_btnDesligarServidor.gridx = 1;
		gbc_btnDesligarServidor.gridy = 8;
		contentPane.add(btnDesligarServidor, gbc_btnDesligarServidor);

		scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridwidth = 20;
		gbc_scrollPane_2.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 9;
		contentPane.add(scrollPane_2, gbc_scrollPane_2);

		textArea = new JTextArea();
		scrollPane_2.setViewportView(textArea);
	}

	protected void destroiServidor() {
		// TODO Auto-generated method stub

	}

	private void inicializaServidor() throws AccessException, RemoteException {

		System.setProperty("java.rmi.server.hostname", txtServidor.getText()); // seta o
																		// hostname
																		// do
																		// RMI

		conexaoServidor = (IServer) UnicastRemoteObject.exportObject(Tela.this, 0); // exporta

		registryServidor = LocateRegistry.createRegistry(1818);

		registryServidor.rebind(IServer.NOME_SERVICO, conexaoServidor);

		clienteRegistrados = new ArrayList<Cliente>();

		textArea.append("Serviço iniciado\n");

	}

	public List<Arquivo> getMyFiles() {

		File diretorioPadrao = new File("." + File.separatorChar + "shared" + File.separatorChar);
		List<Arquivo> myFiles = new ArrayList<>();
		for (File file : diretorioPadrao.listFiles()) {
			if (file.isFile()) {
				Arquivo arquivo = new Arquivo();

				arquivo.setPath(file.getPath());
				arquivo.setDataHoraModificacao(new Date(file.lastModified()));
				arquivo.setTamanho(file.length());
				arquivo.setNome(file.getName());
				arquivo.setExtensao(
						file.getName().substring(file.getName().lastIndexOf("."), file.getName().length()));

				myFiles.add(arquivo);
			}
		}
		return myFiles;
	}
	@Override
	public void registrarCliente(Cliente c) throws RemoteException {

		textArea.append("Cliente" + c.getNome() + " se conectou !\n");

		clienteRegistrados.add(c);
		
		listaDeArquivos.put(c, getMyFiles());

	}

	@Override
	public void publicarListaArquivos(Cliente c, List<Arquivo> lista) throws RemoteException {
		
		if (listaDeArquivos.containsKey(c)) {
			listaDeArquivos.entrySet().forEach(e -> {
				if (e.getKey().equals(c)) {
					e.setValue(lista);
					textArea.append("Lista de arquivos de " + e.getKey().getNome() + " foi atualizada!\n");
				}
			});
		} else {
			textArea.append("Cliente não encontrado\n");
		}

		System.out.println("Lista de Arquivos no servidor");
		
		for (Arquivo arquivo : lista) {
			System.out.println(arquivo);
		}
		
	}

	@Override
	public Map<Cliente, List<Arquivo>> procurarArquivo(String query, TipoFiltro tipoFiltro, String filtro)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] baixarArquivo(Cliente cli, Arquivo arq) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void desconectar(Cliente c) throws RemoteException {
		// TODO Auto-generated method stub

	}

}
