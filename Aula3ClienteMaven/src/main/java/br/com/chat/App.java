package br.com.chat;

import br.com.chat.DAO.PedidoDAO;
import br.com.chat.entidade.Pedido;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
        System.out.println( "Hello World!" );
        PedidoDAO pd = new PedidoDAO();
        
        Pedido p = pd.selectTo("1");
        
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    }
}
