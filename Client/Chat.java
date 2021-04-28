package Client;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.awt.event.ActionEvent;
//This class Takes all the info about message and send to server
public class Chat {

	private JFrame frame;
	private JTextField textTo;
	private JTextField textFrom;
	private JTextField textTopic;
	private JTextField textSub;

	/**
	 * Launch the application.
	 */
	public void start() {
		
		this.frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public Chat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Creating Main App Frame and adding all the components
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(33, 104, 105));
		frame.setBounds(100, 100, 454, 636);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(28, 326, 372, 189);
		frame.getContentPane().add(scrollPane_1);
		
		JTextArea textMessage = new JTextArea();
		textMessage.setCaretColor(Color.WHITE);
		textMessage.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		textMessage.setForeground(new Color(220, 225, 222));
		textMessage.setBackground(Color.DARK_GRAY);
		textMessage.setLineWrap(true);
		scrollPane_1.setViewportView(textMessage);
		
		textTo = new JTextField();
		textTo.setCaretColor(Color.WHITE);
		textTo.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		textTo.setBackground(Color.DARK_GRAY);
		textTo.setForeground(Color.WHITE);
		textTo.setBounds(28, 57, 189, 36);
		frame.getContentPane().add(textTo);
		textTo.setColumns(10);
		
		textFrom = new JTextField();
		textFrom.setCaretColor(Color.WHITE);
		textFrom.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		textFrom.setBackground(Color.DARK_GRAY);
		textFrom.setForeground(Color.WHITE);
		textFrom.setBounds(28, 121, 189, 36);
		frame.getContentPane().add(textFrom);
		textFrom.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("To");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(28, 31, 89, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("From");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblNewLabel_1.setBounds(28, 96, 89, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Message");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(28, 295, 89, 20);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Topic");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(28, 158, 89, 20);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		textTopic = new JTextField();
		textTopic.setCaretColor(Color.WHITE);
		textTopic.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		textTopic.setForeground(Color.WHITE);
		textTopic.setColumns(10);
		textTopic.setBackground(Color.DARK_GRAY);
		textTopic.setBounds(28, 183, 189, 36);
		frame.getContentPane().add(textTopic);
		
		JLabel lblNewLabel_1_3 = new JLabel("Subject");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(28, 220, 89, 20);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		textSub = new JTextField();
		textSub.setCaretColor(Color.WHITE);
		textSub.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		textSub.setForeground(Color.WHITE);
		textSub.setColumns(10);
		textSub.setBackground(Color.DARK_GRAY);
		textSub.setBounds(28, 245, 189, 36);
		frame.getContentPane().add(textSub);

		JButton btnSend = new JButton("Send");
		btnSend.setBackground(new Color(73, 160, 120));
		btnSend.setForeground(new Color(255, 255, 255));
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSend.setBounds(28, 539, 189, 47);
		frame.getContentPane().add(btnSend);
		
		JLabel errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setBounds(277, 96, 105, 61);
		frame.getContentPane().add(errorLabel);
		
		//Adding Listener on the Send Button
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//getting all the data from the text fields
				String from = textFrom.getText();
				String to = textTo.getText();
				String topic = textTopic.getText();
				String sub = textSub.getText();
				String message = textMessage.getText();
				//getting current time
				String time = String.valueOf(Instant.now().getEpochSecond());
				//getting SHA 256 Hash for the message
				String hashID;
				try {
					hashID = towards_hex(getSHA(message)).toString();
					String finalMessage = "Message ID : SHA-256 "+hashID+ "__Time Sent : "+time+"__From : "+from+"__To : "+to+"__Topic : "+topic+"__Subject : "+sub+"__Content : "+message;
					Start.DataOutStream.writeUTF("Message");
					Start.DataOutStream.flush();
					Start.DataOutStream.writeUTF(finalMessage);
					Start.DataOutStream.flush();
					if(Start.DataInStream.readInt()==0) {
						errorLabel.setText("Failed");
					}
					textFrom.setText("");
					textTo.setText("");
					textTopic.setText("");
					textSub.setText("");
					textMessage.setText("");
					
				
				
				} catch (NoSuchAlgorithmException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				
						
						
						
			}
		});
	}
	
	
	
	public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        // hash value generator function
        MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
        return messagedigest.digest(input.getBytes(StandardCharsets.UTF_8));
        }
    
	
	public static String towards_hex(byte[] valuesmessage)
    { 
		BigInteger number = new BigInteger(1, valuesmessage);
        StringBuilder HexString = new StringBuilder(number.toString(16));
        while (HexString.length() < 32){  
        	HexString.insert(0, '0');}
        	return HexString.toString(); 
        	}
}
