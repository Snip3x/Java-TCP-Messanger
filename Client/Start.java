package Client;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class Start {

	private JFrame frame;
	private JTextField textIP;
	private JTextField textPort;
	static Socket s;
    static DataInputStream DataInStream ;
    static DataOutputStream DataOutStream ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
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
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Setting up main Frame and adding components
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(33, 104, 105));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("IP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 24, 104, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Port");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 107, 104, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setBackground(new Color(73, 160, 120));
		btnConnect.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConnect.setBounds(154, 196, 110, 31);
		frame.getContentPane().add(btnConnect);
		
		textIP = new JTextField();
		textIP.setCaretColor(Color.WHITE);
		textIP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		textIP.setForeground(Color.WHITE);
		textIP.setBackground(new Color(31, 36, 33));
		textIP.setBounds(124, 27, 219, 31);
		frame.getContentPane().add(textIP);
		textIP.setColumns(10);
		
		textPort = new JTextField();
		textPort.setCaretColor(Color.WHITE);
		textPort.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		textPort.setForeground(Color.WHITE);
		textPort.setBackground(new Color(31, 36, 33));
		textPort.setBounds(124, 106, 219, 31);
		frame.getContentPane().add(textPort);
		textPort.setColumns(10);
		
		JLabel LabelTe = new JLabel("");
		LabelTe.setForeground(Color.RED);
		LabelTe.setFont(new Font("Tahoma", Font.BOLD, 15));
		LabelTe.setBounds(124, 148, 209, 23);
		frame.getContentPane().add(LabelTe);
		
		JLabel LabelTe_1 = new JLabel("");
		LabelTe_1.setForeground(Color.RED);
		LabelTe_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		LabelTe_1.setBounds(124, 69, 219, 23);
		frame.getContentPane().add(LabelTe_1);
		//Adding Restriction to stop typing Alphabets on Port Field
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
		//Adding Restriction to stop typing Alphabets on IP Field
		textIP.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '.' || ke.isControlDown() && ke.getKeyChar() != 'v' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					textIP.setEditable(true);
					LabelTe_1.setText("");
				} else {
					textIP.setEditable(false);
					LabelTe_1.setText("Only numerics(0-9) and .");
				}
			}
		});
		//Adding Connect Button Listener
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Starting socket , connecting to server and starting all the IO-Streams
					Start.s = new Socket(textIP.getText(),Integer.parseInt(textPort.getText()));
					Start.DataInStream = new DataInputStream(Start.s.getInputStream());
					Start.DataOutStream = new DataOutputStream(Start.s.getOutputStream());
					frame.dispose();
					//Opening Main Menu
					(new Menu()).start();
					
					
					
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
