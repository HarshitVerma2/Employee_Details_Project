import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteF extends JFrame {

	private JPanel contentPane;
	private JTextField idTextField;
	private static DeleteF frame;
	boolean isExecuted=true;

	/**
	 * Launch the application.
	 */
	void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new DeleteF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DeleteF() {
		setTitle("Employee's Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel idLabel = new JLabel("INSERT THE EMPLOYEE ID");
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setBounds(91, 62, 202, 27);
		contentPane.add(idLabel);
		
		idTextField = new JTextField();
		idTextField.setBounds(133, 121, 160, 20);
		contentPane.add(idTextField);
		idTextField.setColumns(10);
		
		JButton changeButton = new JButton("Click to Delete");
		changeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete(Integer.parseInt(idTextField.getText()));
			}
		});
		changeButton.setBounds(133, 174, 120, 35);
		contentPane.add(changeButton);
	}
	private void delete(int id)
	{
		Connection con=null;
		Statement st=null;
		isExecuted=true;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","harshitverma","password");
			st=con.createStatement();
			String s="delete from employeeproject where id="+id+"";
			isExecuted=st.execute(s);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			try {
				init.frame.setVisible(true);
				st.close();
				con.close();
				frame.setVisible(false);
					
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
}
