package server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import util.ChatAula;

public class ChatServer {

	public ChatServer() throws RemoteException{
		try {
			LocateRegistry.createRegistry(8282);
			System.out.println("INICIO");
			Naming.rebind("rmi://localhost:8282/chat", new ChatAula());
			System.out.println("FIM");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws RemoteException{
		new ChatServer();
	}
}
