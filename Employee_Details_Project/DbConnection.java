import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DbConnection {

	public static void main(String[] args) {
		BufferedReader br=null;
		Connection con=null;
		Statement st=null;
		try 
		{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//Connection conn=DriverManager.getConnection(url:"jdbc:Oracle:thin:",user:"harshitverma",password:"password");
				con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","harshitverma","password");
				st=con.createStatement();
				String query1="Select * from project";
				System.out.println(st.execute(query1));
				// for inserting
				br=new BufferedReader(new InputStreamReader(System.in));
				int id=Integer.parseInt(br.readLine());
				String name=br.readLine();
				String department=br.readLine();
				String address=br.readLine();
				int salary=Integer.parseInt(br.readLine());
				
				//insert into employeeproject values(111,'name','department','address',1000);
				String query="insert into employeeproject values("+id+",'"+name+"','"+department+"','"+address+"',"+salary+")";
				st.executeUpdate(query);
				
				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			try {
			br.close();
			st.close();
			con.close();
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		};
	}

}
