package br.univel.clienteservidor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import br.univel.jshare.comum.Arquivo;
import br.univel.jshare.comum.Cliente;

public class MyTableModel extends AbstractTableModel implements TableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1293228726079825126L;

	Map<Cliente, List<Arquivo>> listaDeArquivos = new HashMap<>();

	private int linhas;

	private Object[][] colunas;

	public MyTableModel(Map<Cliente, List<Arquivo>> resultadoMapa) {

		this.listaDeArquivos = resultadoMapa;

		linhas = 0;

		for (Entry<Cliente, List<Arquivo>> e : listaDeArquivos.entrySet()) {
			linhas += e.getValue().size();
		}

		colunas = new Object[linhas][9];

		int linha = 0;
		for (Entry<Cliente, List<Arquivo>> e : listaDeArquivos.entrySet()) {

			for (Arquivo arq : e.getValue()) {

				colunas[linha][0] = e.getKey().getNome();
				colunas[linha][1] = e.getKey().getIp();
				colunas[linha][2] = e.getKey().getPorta();
				colunas[linha][3] = arq.getNome();
				colunas[linha][4] = arq.getTamanho();
				colunas[linha][5] = arq.getExtensao();
				colunas[linha][6] = arq.getDataHoraModificacao();
				colunas[linha][7] = arq.getPath();
				colunas[linha][8] = arq.getMd5();

				linha++;
			}

		}

	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 9;
	}

	@Override
	public int getRowCount() {

		return linhas;
	}

	@Override
	public Object getValueAt(int row, int col) {

		return colunas[row][col];

	}

	public String getColumnName(int Column) {

		switch (Column) {
		case 0:

			return "Nome do Cliente";

		case 1:

			return "Ip do Cliente";
			
		case 2:
			return "Porta do Cliente";
			
		case 3:

			return "Nome do Arquivo";
		case 4:

			return "Tamanho do Arquivo";
		case 5:

			return "Extensao";
		case 6:

			return "Data da Modificação";
		case 7:

			return "Path do Arquivo";

		case 8:

			return "MD5";

		default:
			return "";

		}

	}

}
