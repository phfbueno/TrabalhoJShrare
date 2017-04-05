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

public class ListaArquivos extends AbstractTableModel implements TableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1293228726079825126L;

	Map<Cliente, List<Arquivo>> ListaDeArquivos = new HashMap<>();

	private int linhas;

	private Object[][] Colunas;

	public ListaArquivos(Map<Cliente, List<Arquivo>> resultadoMapa) {

		this.ListaDeArquivos = resultadoMapa;

		linhas = 0;

		for (Entry<Cliente, List<Arquivo>> e : ListaDeArquivos.entrySet()) {
			linhas += e.getValue().size();
		}

		Colunas = new Object[linhas][8];

		int linha = 0;
		for (Entry<Cliente, List<Arquivo>> e : ListaDeArquivos.entrySet()) {

			for (Arquivo arq : e.getValue()) {

				Colunas[linha][0] = e.getKey().getNome();
				Colunas[linha][1] = e.getKey().getIp();
				Colunas[linha][2] = e.getKey().getPorta();
				Colunas[linha][3] = arq.getNome();
				Colunas[linha][4] = arq.getTamanho();
				Colunas[linha][5] = arq.getExtensao();
				Colunas[linha][5] = arq.getDataHoraModificacao();
				Colunas[linha][6] = arq.getPath();
				Colunas[linha][7] = arq.getMd5();

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

			return Colunas[row][1];

		case 1:

			return Colunas[row][2];
		case 2:

			return Colunas[row][3];
		case 3:

			return Colunas[row][4];
		case 4:

			return Colunas[row][5];
		case 5:

			return Colunas[row][6];
		case 6:

			return Colunas[row][7];

		case 7:

			return Colunas[row][1];
		
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
