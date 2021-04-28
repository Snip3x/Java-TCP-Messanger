package Server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class StartServer {

	private JFrame frame;
	private JTextField textPort;
	private Listener listener = new Listener(this);
	JLabel lClient;
	int port ;
	

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartServer window = new StartServer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartServer() {
		this.port = 3000;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Creating Frame
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(33, 104, 105));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBackground(new Color(73, 160, 120));
		btnStart.setBounds(77, 204, 89, 23);
		frame.getContentPane().add(btnStart);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(73, 160, 120));
		btnExit.setBounds(234, 204, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JLabel lStat = new JLabel("Server Offline");
		lStat.setFont(new Font("Tahoma", Font.BOLD, 16));
		lStat.setBounds(32, 104, 298, 39);
		frame.getContentPane().add(lStat);
		
		textPort = new JTextField();
		textPort.setText("3000");
		textPort.setCaretColor(Color.WHITE);
		textPort.setBackground(Color.DARK_GRAY);
		textPort.setForeground(new Color(255, 255, 255));
		textPort.setBounds(118, 65, 135, 28);
		frame.getContentPane().add(textPort);
		textPort.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Port");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(32, 65, 76, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		lClient = new JLabel("Clients: ");
		lClient.setFont(new Font("Tahoma", Font.BOLD, 16));
		lClient.setBounds(32, 154, 298, 39);
		frame.getContentPane().add(lClient);
		
		JLabel LabelTe = new JLabel("");
		LabelTe.setFont(new Font("Tahoma", Font.BOLD, 14));
		LabelTe.setForeground(Color.RED);
		LabelTe.setBounds(263, 65, 150, 28);
		frame.getContentPane().add(LabelTe);
		//Creating Listener Thread
		Thread t = new Thread(listener);
		
		//Start button function
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Getting Port and Disabling Start button
				btnStart.setEnabled(false);
				btnStart.setBackground(Color.GRAY);
				lStat.setText("Server Running on Port:"+textPort.getText());
				port = Integer.parseInt(textPort.getText());
				//Starting Listener Thread
				t.start();
				
				
			}
		});
		//Exit Button
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Server Wont Shutdown till All Clients are Disconnect but you can force it
				if(listener.clients==0) {
					listener.loop = false;
					System.exit(0);}
				else {
					lClient.setForeground(Color.red);
				}
			}
		});
		
		//Text Port input Restriction
		textPort.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	             if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.isControlDown() && ke.getKeyChar() != 'v' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
	                textPort.setEditable(true);
	                LabelTe.setText("");
	             } else {
	                textPort.setEditable(false);
	                LabelTe.setText("Only numerics(0-9)");
	             }
	          }
	       });
	}


}
