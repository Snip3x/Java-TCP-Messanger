package Client;


import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;

//Simulate all the Server Requests
public class Commands {

	private JFrame frame;
	private JTextField listTime;

	/**
	 * Launch the application.
	 */
	public void start() {
		
		this.frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public Commands() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Setting up Main Frame and Adding all the component
		frame = new JFrame();
		frame.setBounds(100, 100, 734, 560);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(33, 104, 105));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LIST Request");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 138, 23);
		panel.add(lblNewLabel);
		
		//DROP-DOWN List for Header
		JComboBox<String> selectHeader = new JComboBox<String>();
		selectHeader.setForeground(Color.WHITE);
		selectHeader.setBackground(Color.DARK_GRAY);
		selectHeader.setModel(new DefaultComboBoxModel<String>(new String[] {"From", "To", "Topic", "Subject"}));
		selectHeader.setBounds(29, 93, 110, 24);
		panel.add(selectHeader);
		
		JLabel lblNewLabel_4 = new JLabel("Header");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(29, 68, 86, 14);
		panel.add(lblNewLabel_4);
		
		JButton listReq = new JButton("Request");
		listReq.setBackground(new Color(73, 160, 120));
		listReq.setFont(new Font("Tahoma", Font.BOLD, 11));
		listReq.setBounds(240, 213, 89, 24);
		panel.add(listReq);
		
		JLabel lblNewLabel_4_1 = new JLabel("Content");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(29, 128, 86, 14);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Time");
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_2.setBounds(197, 68, 86, 14);
		panel.add(lblNewLabel_4_2);
		
		listTime = new JTextField();
		listTime.setCaretColor(Color.WHITE);
		listTime.setForeground(Color.WHITE);
		listTime.setBackground(Color.DARK_GRAY);
		listTime.setBounds(197, 93, 110, 24);
		panel.add(listTime);
		listTime.setColumns(10);
		
		JTextArea contentText = new JTextArea();
		contentText.setCaretColor(Color.WHITE);
		contentText.setForeground(Color.WHITE);
		contentText.setBackground(Color.DARK_GRAY);
		contentText.setLineWrap(true);
		contentText.setBounds(29, 148, 191, 89);
		panel.add(contentText);
		
		JLabel LabelTe = new JLabel("");
		LabelTe.setFont(new Font("Tahoma", Font.BOLD, 15));
		LabelTe.setForeground(Color.RED);
		LabelTe.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTe.setBounds(158, 119, 191, 23);
		panel.add(LabelTe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(33, 104, 105));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("GET Request");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 11, 113, 22);
		panel_1.add(lblNewLabel_1);
		
		JButton getReq = new JButton("Request");
		getReq.setBackground(new Color(73, 160, 120));
		getReq.setFont(new Font("Tahoma", Font.BOLD, 11));
		getReq.setBounds(227, 214, 89, 23);
		panel_1.add(getReq);
		
		JTextArea textHash = new JTextArea();
		textHash.setForeground(new Color(255, 255, 255));
		textHash.setLineWrap(true);
		textHash.setCaretColor(Color.WHITE);
		textHash.setBackground(Color.DARK_GRAY);
		textHash.setBounds(10, 91, 187, 146);
		panel_1.add(textHash);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Hash Code");
		lblNewLabel_4_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_2_1.setBounds(10, 66, 86, 14);
		panel_1.add(lblNewLabel_4_2_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(33, 104, 105));
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("BYE Request");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 11, 104, 23);
		panel_2.add(lblNewLabel_2);
		
		//this button will close the all the IO-Streams and Socket and Closing the App
		JButton btnBye = new JButton("Bye ");
		btnBye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
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
		btnBye.setBackground(new Color(255, 0, 51));
		btnBye.setForeground(new Color(255, 255, 255));
		btnBye.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 23));
		btnBye.setBounds(101, 92, 133, 79);
		panel_2.add(btnBye);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(33, 104, 105));
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("TIME Request");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 11, 139, 19);
		panel_3.add(lblNewLabel_3);
		
		JButton btnTime = new JButton("Time");
		btnTime.setBackground(new Color(73, 160, 120));
		btnTime.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTime.setBounds(140, 128, 89, 23);
		panel_3.add(btnTime);
		
		JLabel timeLabel = new JLabel("---------");
		timeLabel.setForeground(new Color(255, 255, 255));
		timeLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setBounds(10, 62, 339, 55);
		panel_3.add(timeLabel);
		//Adding List Request Function
		listReq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//Confirming all info is added
					if(selectHeader.getSelectedItem().toString().equals("")||contentText.getText().toString().equals("") || listTime.getText().equals("")) {
						LabelTe.setText("Enter all Info");
					}else {
						//Telling Server LIST Request is coming
						Start.DataOutStream.writeUTF("List");
						Start.DataOutStream.flush();
						//Sending Data
						Start.DataOutStream.writeUTF(selectHeader.getSelectedItem().toString()+"##"+contentText.getText()+"##"+listTime.getText());
						Start.DataOutStream.flush();
						//Sending Received Response from to Viewer Window
						new ListResult(Start.DataInStream.readUTF()).start();
						
						
					}
					
					
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
//Added Get Request Functionality 
		getReq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hash = textHash.getText();
				getReq(hash);
				
			}
		});
		//Adding Time Request
		btnTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Asking Server For Time
					Start.DataOutStream.writeUTF("Time");
					Start.DataOutStream.flush();
					//Receiving Time From Server
					timeLabel.setText(Start.DataInStream.readUTF());
	
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		//Adding Restriction on TextField
		listTime.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	             if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.isControlDown() && ke.getKeyChar() != 'v' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
	                listTime.setEditable(true);
	                LabelTe.setText("");
	             } else {
	                listTime.setEditable(false);
	                LabelTe.setText("Only numerics(0-9)");
	             }
	          }
	       });
	}
	
	public static void getReq(String hash) {
		try {
			
			if(!(hash.contains("SHA-256 ")))
				hash="SHA-256 "+hash;
				
			//Telling server That Get request is coming
			Start.DataOutStream.writeUTF("Get");
			Start.DataOutStream.flush();
			//Sending Hash to Search
			Start.DataOutStream.writeUTF(hash);
			Start.DataOutStream.flush();
			//Getting result and passing to GET result window
			new GetResult(hash+"--"+Start.DataInStream.readUTF()).start();
			
			
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
