package br.univel.jshare.comum;

import java.io.Serializable;
import java.util.Date;

public class Arquivo implements Serializable {

	private static final long serialVersionUID = -6433462679928213637L;
	

	private long id;

	private String nome;
	private String extensao;
	private String path;

	private long tamanho;

	private String md5;

	private int qtdDowload;

	private Date dataHoraModificacao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public long getTamanho() {
		return tamanho;
	}

	public void setTamanho(long tamanho) {
		this.tamanho = tamanho;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public int getQtdDowload() {
		return qtdDowload;
	}

	public void setQtdDowload(int qtdDowload) {
		this.qtdDowload = qtdDowload;
	}

	public Date getDataHoraModificacao() {
		return dataHoraModificacao;
	}

	public void setDataHoraModificacao(Date dataHoraModificacao) {
		this.dataHoraModificacao = dataHoraModificacao;
	}

	@Override
	public String toString() {
		return "Arquivo [id=" + id + ", nome=" + nome + ", extensao=" + extensao + ", path=" + path + ", tamanho="
				+ tamanho + ", md5=" + md5 + ", qtdDowload=" + qtdDowload + ", dataHoraModificacao="
				+ dataHoraModificacao + "]";
	}

	

}
