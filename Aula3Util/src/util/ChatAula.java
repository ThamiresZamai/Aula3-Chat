package util;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import br.com.chat.DAO.PedidoDAO;
import br.com.chat.entidade.Pedido;

public class ChatAula extends UnicastRemoteObject implements IChatAula{

	private static final long serialVersionUID = 1L;
	PedidoDAO pedidoDao = new PedidoDAO();
	
	public ChatAula() throws RemoteException{
		super();
	}

	@Override
	public void sendMessage(Message msg) throws RemoteException {
		Message.setLstMessage(msg);
		
	}

	@Override
	public List<Message> retrieveMessage() throws RemoteException {
		return Message.getLstMessage();
	}

	@Override
	public void inserirBanco(String user, String msg) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedido selectTo(String ped) throws RemoteException {
		return pedidoDao.selectTo(ped);
		
	}
}
