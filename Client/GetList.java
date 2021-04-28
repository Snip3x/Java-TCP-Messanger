package Client;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
//This Window Shows all the data received from LIST request
public class GetList {

	private JFrame frame;
	private JTable table;
	String data;

	/**
	 * Launch the application.
	 */
	public void start() {
		
		this.frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public GetList(String data) {
		this.data = data;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(33, 104, 105));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 414, 137);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setBackground(Color.DARK_GRAY);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hash ID"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);
		DefaultTableModel model =  (DefaultTableModel) table.getModel();
		JLabel lTotal = new JLabel("Found: ");
		lTotal.setForeground(Color.WHITE);
		lTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lTotal.setBounds(10, 11, 190, 38);
		frame.getContentPane().add(lTotal);
		String data[] = this.data.split("--");
		lTotal.setText(lTotal.getText()+""+data[0]);
		for(int i=1;i<data.length;i++)
			model.addRow(new Object[] {data[i]});
		
		
	}
}
