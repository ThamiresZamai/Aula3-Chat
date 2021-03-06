package viewCliente;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.chat.DAO.PedidoDAO;
import br.com.chat.entidade.Pedido;

public class TelaChat extends JFrame {

	private JPanel contentPane;
	private JTextField txtResposta;
	JTextArea textArea = new JTextArea();
	JButton btnEnviar = new JButton("Enviar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
		            
//			            System.out.println("About to try to print!");
//			            
//			            String messageToEcho = "Hi from the client!";
//			            if( args.length > 0 ){
//			                messageToEcho = args[ 0 ];
//			            }
//			            int returnVal = comp.echoMessage( messageToEcho );
//			            
//			            System.out.println( "The return value from the server is: " + returnVal );
					
				    TelaChat frame = new TelaChat();
					frame.setVisible(true);
					

				} catch (Exception e) {
					System.out.println("erro");
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws InterruptedException
	 */
	public TelaChat() throws InterruptedException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtResposta = new JTextField();
		txtResposta.setBounds(10, 223, 343, 25);
		contentPane.add(txtResposta);
		txtResposta.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 442, 201);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);

		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String valor = txtResposta.getText();
				

				if (indexChat == 0) {
					nomeUsuario = valor;
					textArea.setText(textArea.getText() + "\n" + "(" + nomeUsuario + "):" + valor);
					
				}else if(indexChat == 1) {
					n_pedido = valor;
					Pedido p = new Pedido();
					PedidoDAO pdao = new PedidoDAO();
					
					textArea.setText(textArea.getText() + "\n" + "(" + nomeUsuario + "): N� do Pedido: "+valor + "\nDescri��o do Pedido : "+p.getDescricao()+
										"\nStatus: "+p.getStatus()+"\nData de Compra: "+p.getDt_compra());
				}

				// if (indexChat == 0)
				// textArea.setText(textArea.getText() + "\n" + valor);
				// else
				

				txtResposta.setText("");
				txtResposta.setFocusable(true);

				indexChat++;

				if (indexChat == 3) {
					indexChat = 0;
					textArea.setText("");
				}
				
				chat();
			}
		});
		btnEnviar.setBounds(363, 223, 89, 25);
		contentPane.add(btnEnviar);
		txtResposta.setFocusable(true);
		textArea.setText("");

		chatArray[0] = "\n(Robo): Bem vindo, ao Chat de consulta de pedidos, Qual � o seu nome?";
		chatArray[1] = " qual � o n�mero do pedido?";
		chatArray[2] = "\n(Robo): O status do seu pedido �: PENDENTE \n";
		indexChat = 0;
		nomeUsuario = "";
		chat();
	}

	private String[] chatArray = new String[5];
	private int indexChat;
	private String nomeUsuario = "";
	private String n_pedido = "";
   
    
	private void chat()  {
		if (indexChat == 1)
			textArea.setText(textArea.getText() + "\n(Robo): " + nomeUsuario + chatArray[indexChat]);
		else
			textArea.setText(textArea.getText() + chatArray[indexChat]);

		if (indexChat == 2) {
			btnEnviar.setText("Resetar");
		} else if (indexChat == 0) {
			btnEnviar.setText("Enviar");
		}
	}
}
