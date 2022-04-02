import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class InsertUpdateF extends JFrame {
	
	 static char change;

	private static InsertUpdateF frame;//without static it is not able to  setVisibility 
	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField idTextField;
	private JTextField departmentTextField;
	private JTextField addressTextField;
	private JTextField salaryTextField;
	

	/**
	 * Launch the application.
	 */
	 void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new InsertUpdateF();
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
	public InsertUpdateF() {
		setTitle("Employee's Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(433, 263, -13, -264);
		contentPane.add(scrollPane);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(21, 21, 52, 20);
		contentPane.add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(104, 21, 186, 20);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel idLabel = new JLabel("Employee ID");
		idLabel.setBounds(21, 53, 80, 20);
		contentPane.add(idLabel);
		
		idTextField = new JTextField();
		idTextField.setBounds(104, 52, 186, 21);
		contentPane.add(idTextField);
		idTextField.setColumns(10);
		
		JLabel departmentLabel = new JLabel("Department");
		departmentLabel.setBounds(21, 84, 73, 20);
		contentPane.add(departmentLabel);
		
		departmentTextField = new JTextField();
		departmentTextField.setBounds(104, 83, 186, 20);
		contentPane.add(departmentTextField);
		departmentTextField.setColumns(10);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setBounds(21, 109, 52, 20);
		contentPane.add(addressLabel);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(104, 114, 186, 20);
		contentPane.add(addressTextField);
		addressTextField.setColumns(10);
		
		JLabel salaryLabel = new JLabel("Salary");
		salaryLabel.setBounds(21, 140, 52, 14);
		contentPane.add(salaryLabel);
		
		salaryTextField = new JTextField();
		salaryTextField.setBounds(104, 145, 186, 20);
		contentPane.add(salaryTextField);
		salaryTextField.setColumns(10);
		
		JButton changeButton = new JButton("Click Here To change");
		changeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(idTextField.getText());
				String name=nameTextField.getText();
				String address=addressTextField.getText();
				String department=addressTextField.getText();
				int salary=Integer.parseInt(salaryTextField.getText());
				
				if(change=='i')
					insert(id,name,department,address,salary);
				if(change=='u')
					update(id,name,department,address,salary);
			}
		});
		changeButton.setBounds(122, 193, 138, 34);
		contentPane.add(changeButton);
		
		
	}
	
	private void insert(int id,String name,String department,String address,int salary)
	{
		Connection con=null;
		Statement st=null;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","harshitverma","password");
			st=con.createStatement();
			//format in oracle insert into employeeproject values(1,'name','department','address',50000);
			String query="insert into employeeproject values("+id+",'"+name+"','"+department+"','"+address+"',"+salary+")";
			st.executeUpdate(query);
			//System.out.println("executed");
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		finally
		{
			try 
			{
				
				init.frame.setVisible(true);//main class frame
				frame.setVisible(false);//this class frame
				st.close();
				con.close();
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
			}
			
		}
	}
	
	private void update(int id,String name,String department,String address,int salary )
	{
		Connection con=null;
		Statement st=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","harshitverma","password");
			st=con.createStatement();
			//ResultSet rs=st.executeQuery("select * from employeeproject");
			//if(rs.getInt(id)==id)
			//{
				String query="update employeeproject set id="+id+",name='"+name+"',department='"+department+"',address='"+address+"',salary="+salary+" where id="+id+"";
				st.executeUpdate(query);
			//}
			//else
			//{
				
			//}
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		finally
		{
			init.frame.setVisible(true);// main class frame
			frame.setVisible(false);//this class frame
			try {
			st.close();
			con.close();
			}
			catch(Exception e3)
			{
				e3.printStackTrace();
			}
		}
	}
}
