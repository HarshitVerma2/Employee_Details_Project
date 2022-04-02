import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class viewF extends JFrame {
	
	static viewF frame;
	
	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField idTextField;
	private JTextField departmentTextField;
	private JTextField addressTextField;
	private JTextField salaryTextField;
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	private String name;
	private String address;
	private String department;
	private int id;
	private int salary;
	/**
	 * Launch the application.
	 */
	 void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						frame = new viewF();
						frame.setVisible(true);
				} 
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public viewF() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","harshitverma","password");
			//st=con.createStatement(); problem come with previous();
			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String query="select * from employeeproject";
			rs=st.executeQuery(query);
			boolean notEmpty=rs.next();//to start pointing to 1
			if(notEmpty){
		    name=rs.getString("name");
		    id=rs.getInt("id");
		    address=rs.getString("address");
		    department=rs.getString("department");
		    salary=rs.getInt("salary");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		setTitle("Employee's Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton previousButton = new JButton("previous");
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(rs.previous()) 
					{
						if(!rs.isBeforeFirst())
						{
							id=rs.getInt("id");
							name=rs.getString("name");
							department=rs.getString("department");
							address=rs.getString("address");
							salary=rs.getInt("salary");
						
							nameTextField.setText(name);
							idTextField.setText(""+id);
							addressTextField.setText(address);
							salaryTextField.setText(""+salary);
							departmentTextField.setText(department);
						}
						else rs.next();// to make pointer to 1position
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		previousButton.setHorizontalAlignment(SwingConstants.LEFT);
		previousButton.setBounds(0, 107, 73, 45);
		contentPane.add(previousButton);
		
		JButton nextButton = new JButton("next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(rs.next())
					{
						id=rs.getInt("id");
						name=rs.getString("name");
						department=rs.getString("department");
						address=rs.getString("address");
						salary=rs.getInt("salary");
						
						nameTextField.setText(name);
						idTextField.setText(""+id);
						addressTextField.setText(address);
						salaryTextField.setText(""+salary);
						departmentTextField.setText(department);
						
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		nextButton.setBounds(351, 107, 73, 45);
		contentPane.add(nextButton);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(79, 31, 46, 14);
		contentPane.add(nameLabel);
		
		JLabel idLabel = new JLabel("Id");
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setBounds(79, 56, 46, 14);
		contentPane.add(idLabel);
		
		JLabel departmentLabel = new JLabel("Department");
		departmentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		departmentLabel.setBounds(79, 81, 57, 14);
		contentPane.add(departmentLabel);
		
		JLabel AddressLabel = new JLabel("Address");
		AddressLabel.setBounds(83, 107, 46, 14);
		contentPane.add(AddressLabel);
		
		JLabel salaryLabel = new JLabel("Salary");
		salaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		salaryLabel.setBounds(79, 138, 46, 14);
		contentPane.add(salaryLabel);
		
		nameTextField = new JTextField();
		nameTextField.setEditable(false);
		nameTextField.setText(name);//here setting
		nameTextField.setBounds(152, 28, 155, 20);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		idTextField = new JTextField();
		idTextField.setEditable(false);
		idTextField.setText(""+id);//bcz id is integer here
		idTextField.setBounds(152, 53, 155, 20);
		contentPane.add(idTextField);
		idTextField.setColumns(10);
		
		departmentTextField = new JTextField();
		departmentTextField.setEditable(false);
		departmentTextField.setText(department);
		departmentTextField.setBounds(151, 78, 156, 20);
		contentPane.add(departmentTextField);
		departmentTextField.setColumns(10);
		
		addressTextField = new JTextField();
		addressTextField.setEditable(false);
		addressTextField.setText(address);
		addressTextField.setBounds(152, 104, 155, 20);
		contentPane.add(addressTextField);
		addressTextField.setColumns(10);
		
		salaryTextField = new JTextField();
		salaryTextField.setEditable(false);
		salaryTextField.setText(""+salary);
		salaryTextField.setBounds(152, 135, 155, 20);
		contentPane.add(salaryTextField);
		salaryTextField.setColumns(10);
		
		JButton backButton = new JButton("Back To Menu");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init.frame.setVisible(true);
				viewF.frame.setVisible(false);
			}
		});
		backButton.setBounds(166, 204, 118, 46);
		contentPane.add(backButton);
	}

}
