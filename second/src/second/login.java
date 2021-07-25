package second;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class login extends JFrame {
	
	JLabel username,password;
	JComboBox<String> user_name;
	JPasswordField Password;
	JButton login,register;
	Container cn;
	
	login()
	{
		cn= getContentPane();
		cn.setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		username = new JLabel("USERNAME");
		password = new JLabel("PASSWORD");
		
		user_name = new JComboBox<String>();
		Password = new JPasswordField();
		Password.setEchoChar('*');
		login = new JButton("Login");
		register = new JButton("Register");
		
		username.setBounds(200,100,120,25);
		password.setBounds(200,180,120,25);
		
		
		user_name.setBounds(330,100,150,25);
		Password.setBounds(330,180,150,25);
		
		login.setBounds(210,280,120,25);
		register.setBounds(350,280,120,25);
		
		Password.setEchoChar('*');
		cn.add(username);
		cn.add(password);
		cn.add(user_name);
		cn.add(Password);
		cn.add(login);
		cn.add(register);
		
		
		try
		{
			user_name.addItem("Select Username");
			Connection con = DataBaseConnection.getCon();
			Statement smt = con.createStatement();
			String sq = "select username from bootcamp";
			PreparedStatement pstmt = con.prepareStatement(sq);
			
			ResultSet rst = pstmt.executeQuery();
			
			while(rst.next())
			{
				user_name.addItem(rst.getString("username"));
			}
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				backend dd = new backend();
				String username = user_name.getSelectedItem().toString();
				String password = Password.getText().toString();
				boolean ans = dd.check(username, password);
				if(ans)
				{
					view v = new view();
					JOptionPane.showMessageDialog(null, "Login Succefull");
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Password is wrong");
				}
			}
		});
		
		register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new form();
				setVisible(false);
			}
		});
		cn.setBackground(Color.cyan);
		setSize(800,800);
		setVisible(true);
	}
	public static void main(String[] args) {
		new login();
	}
}
