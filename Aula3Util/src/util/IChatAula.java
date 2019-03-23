package util;

import java.rmi.RemoteException;
import java.util.List;

import br.com.chat.entidade.Pedido;

import java.rmi.Remote;

public interface IChatAula extends Remote{

	void sendMessage(Message msg) throws RemoteException;
	List<Message> retrieveMessage() throws RemoteException;
	void inserirBanco(String user, String msg) throws RemoteException;
	Pedido selectTo(String ped) throws RemoteException; 
}
