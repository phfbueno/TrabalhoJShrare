package br.univel.comum.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;




public interface IServer  extends Remote {

	public static final String NOME_SERVICO = "JShare";
	
	public void registrarCliente(Cliente c) throws RemoteException;
	

}
