package Client;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;

//Main Menu
public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void start() {
		
		this.frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Adding main Frame and all the Components
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(33, 104, 105));
		frame.setBounds(100, 100, 471, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addWindowListener(new WindowAdapter() {
		    //Adding Custom Close Procedure
			public void windowClosing(WindowEvent e) {
		        try {
		        	//Closing All IO-Streams and Socket
					Start.DataOutStream.writeUTF("Bye");
					Start.DataOutStream.flush();
					Start.DataInStream.close();
					Start.DataOutStream.close();
					Start.s.close();
					System.exit(0);
					
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		        
		    	
		    }
		});
		
		JLabel lblNewLabel = new JLabel("Main Menu");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(78, 28, 304, 64);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnMessage = new JButton("Message");
		//Adding Listener to Message button
		btnMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					//Opening Compose Message Window
					new Chat().start();
			
			}
		});
		btnMessage.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMessage.setForeground(Color.WHITE);
		btnMessage.setBackground(new Color(73, 160, 120));
		btnMessage.setBounds(157, 134, 138, 39);
		frame.getContentPane().add(btnMessage);
		
		JButton btnCommand = new JButton("Command");
		btnCommand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Opening Commands Window
					new Commands().start();
					
				
			}
		});
		btnCommand.setForeground(Color.WHITE);
		btnCommand.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCommand.setBackground(new Color(73, 160, 120));
		btnCommand.setBounds(157, 201, 138, 39);
		frame.getContentPane().add(btnCommand);
		//Add Closing Function and Closing all the IO-Streams and Socket
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Closing All IO-Streams and Socket
					Start.DataOutStream.writeUTF("Bye");
					Start.DataOutStream.flush();
					Start.DataInStream.close();
					Start.DataOutStream.close();
					Start.s.close();
					System.exit(0);
					
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(new Color(73, 160, 120));
		btnExit.setBounds(157, 266, 138, 39);
		frame.getContentPane().add(btnExit);
	}
}
