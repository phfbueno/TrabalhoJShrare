package br.univel.clienteservidor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import br.univel.comum.interfaces.Arquivo;
import br.univel.comum.interfaces.Cliente;

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

		colunas = new Object[linhas][8];

		int linha = 0;
		for (Entry<Cliente, List<Arquivo>> e : listaDeArquivos.entrySet()) {

			for (Arquivo arq : e.getValue()) {

				colunas[linha][0] = e.getKey().getNome();
				colunas[linha][1] = e.getKey().getIp();
				colunas[linha][2] = e.getKey().getPorta();
				colunas[linha][3] = arq.getNome();
				colunas[linha][4] = arq.getTamanho();
				colunas[linha][5] = arq.getExtensao();
				colunas[linha][5] = arq.getDataHoraModificacao();
				colunas[linha][6] = arq.getPath();
				colunas[linha][7] = arq.getMd5();

				linha++;
			}

		}

	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public int getRowCount() {

		return linhas;
	}

	@Override
	public Object getValueAt(int row, int col) {

		switch (col) {
		case 0:

			return colunas[row][0];

		case 1:

			return colunas[row][1];
		case 2:

			return colunas[row][2];
		case 3:

			return colunas[row][3];
		case 4:

			return colunas[row][4];
		case 5:

			return colunas[row][5];
		case 6:

			return colunas[row][6];

		case 7:

			return colunas[row][7];
		
		default:
			return "";
		}
	}
	
	public String getCoumnName(int Column){
		
		
			switch (Column) {
			case 0:

				return "Nome do Cliente";

			case 1:

				return "Ip do Cliente";
			case 2:

				return "Nome do Arquivo";
			case 3:

				return "Nome do Arquivo";
			case 4:

				return "Tamanho do Arquivo";
			case 5:

				return "Data da Modificação";
			case 6:

				return "Path do Arquivo";

			case 7:

				return "MD5";
			
			default:
				return "";
		}
		
	}

}
