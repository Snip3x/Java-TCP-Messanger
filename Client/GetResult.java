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
		frame.setBounds(100, 100, 575, 517);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lTo = new JLabel("To:");
		lTo.setForeground(Color.WHITE);
		lTo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lTo.setBounds(24, 37, 512, 19);
		frame.getContentPane().add(lTo);
		
		JLabel lFrom = new JLabel("From:");
		lFrom.setForeground(Color.WHITE);
		lFrom.setFont(new Font("Tahoma", Font.BOLD, 16));
		lFrom.setBounds(24, 67, 512, 19);
		frame.getContentPane().add(lFrom);
		
		JLabel lTime = new JLabel("Time:");
		lTime.setForeground(Color.WHITE);
		lTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		lTime.setBounds(24, 97, 512, 19);
		frame.getContentPane().add(lTime);
		
		JLabel lTopic = new JLabel("Topic:");
		lTopic.setForeground(Color.WHITE);
		lTopic.setFont(new Font("Tahoma", Font.BOLD, 16));
		lTopic.setBounds(24, 127, 512, 19);
		frame.getContentPane().add(lTopic);
		
		JLabel lSub = new JLabel("Subject:");
		lSub.setForeground(Color.WHITE);
		lSub.setFont(new Font("Tahoma", Font.BOLD, 16));
		lSub.setBounds(24, 157, 512, 19);
		frame.getContentPane().add(lSub);
		
		JLabel lMessage = new JLabel("Message:");
		lMessage.setForeground(Color.WHITE);
		lMessage.setFont(new Font("Tahoma", Font.BOLD, 16));
		lMessage.setBounds(24, 187, 512, 19);
		frame.getContentPane().add(lMessage);
		
		JTextArea textMessage = new JTextArea();
		textMessage.setForeground(Color.WHITE);
		textMessage.setBackground(Color.DARK_GRAY);
		textMessage.setEditable(false);
		textMessage.setLineWrap(true);
		textMessage.setBounds(24, 217, 512, 250);
		frame.getContentPane().add(textMessage);
		
		String arr[] = this.data.split("--");
		System.out.println(this.data+""+arr.length);
		lTime.setText(lTime.getText()+""+arr[0]);
		lTo.setText(lTo.getText()+""+arr[1]);
		lFrom.setText(lFrom.getText()+""+arr[2]);
		lTopic.setText(lTopic.getText()+""+arr[3]);
		lSub.setText(lSub.getText()+""+arr[4]);
		textMessage.setText(arr[5]);
		
		
		
	}
}
