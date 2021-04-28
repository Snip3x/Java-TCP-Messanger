package Client;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JTextArea;
import java.awt.Color;
// This Window Shows all the data received from GET request
public class GetResult {

	private JFrame frame;
	String data ;
	/**
	 * Launch the application.
	 */
	public void start() {
		this.frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */


	public GetResult(String data) {
		this.data = data;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Setting up Frame and adding Component
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(33, 104, 105));
		frame.setBounds(100, 100, 713, 517);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lResponse = new JLabel("Response");
		lResponse.setForeground(Color.WHITE);
		lResponse.setFont(new Font("Tahoma", Font.BOLD, 16));
		lResponse.setBounds(10, 36, 512, 19);
		frame.getContentPane().add(lResponse);
		
		JTextArea textMessage = new JTextArea();
		textMessage.setForeground(Color.WHITE);
		textMessage.setBackground(Color.DARK_GRAY);
		textMessage.setEditable(false);
		textMessage.setLineWrap(true);
		textMessage.setBounds(20, 66, 659, 401);
		frame.getContentPane().add(textMessage);
		
		String arr[] = this.data.split("--");
		int con = arr[6].split("\\r?\\n").length;
		textMessage.setText("Message ID: "+arr[0]+"\nTime Sent: "+arr[1]+"\nTo: "+arr[2]+"\nFrom: "+arr[3]+"\nTopic: "+arr[4]+"\nSubject: "+arr[5]+"\nContent: "+con+"\n"+arr[6]);
		
		
		
	}
}
