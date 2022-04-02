import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


 public class init extends JFrame {

	private JPanel contentPane;
	static init frame;// to change visibility from constructor when open to new frame

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new init();
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
	public init() {
		setTitle("Employee's Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton insertButton = new JButton("INSERT");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertUpdateF.change='i';
				InsertUpdateF obj=new InsertUpdateF();
				obj.start();
			    frame.setVisible(false);
			}
		});
		insertButton.setHorizontalAlignment(SwingConstants.CENTER);
		insertButton.setBounds(58, 56, 91, 35);
		contentPane.add(insertButton);
		
		JButton viewButton = new JButton("VIEW");
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewF obj=new viewF();
				obj.start();
				frame.setVisible(false);
			}
		});
		viewButton.setBounds(254, 56, 91, 35);
		contentPane.add(viewButton);
		
		JButton deleteButton = new JButton("DELETE");
		deleteButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				DeleteF obj=new DeleteF();
				obj.start();
				frame.setVisible(false);
			}
		});
		deleteButton.setBounds(60, 153, 89, 35);
		contentPane.add(deleteButton);
		
		JButton updateButton = new JButton("UPDATE");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertUpdateF.change='u';
				InsertUpdateF obj=new InsertUpdateF();
				obj.start();
				frame.setVisible(false);
			}
		});
		updateButton.setBounds(254, 153, 91, 35);
		contentPane.add(updateButton);
	}
}
