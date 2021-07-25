package second;

import java.awt.Color;
import java.awt.Container;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class signup extends JFrame{
	
	JLabel name,username,dob,age,address,mob,gender,password,repass;
	JTextField Name,Username,Dob,Age,Address,Password,Repass,Mob;
	Container cnn;
	ButtonGroup bg;
	JRadioButton male,female;
	JButton signup;
	signup()
	{
		cnn = getContentPane();
		cnn.setLayout(null);
		
		name = new JLabel("NAME");
		username = new JLabel("USERNAME");
		mob = new JLabel("MOBILE");
		password = new JLabel("PASSWORD");
		repass = new JLabel("RE-TYPE PASSWORD");
		
		Name = new JTextField();
		Username = new JTextField();
		Password = new JTextField();
		Repass = new JTextField();
		Mob = new JTextField();
				
		signup = new JButton("SignUp");
		
		name.setBounds(100,50,120,25);
		username.setBounds(100,100,120,25);
		mob.setBounds(100,150,120,25);
		password.setBounds(100,200,120,25);
		repass.setBounds(100,250,150,25);
		
		Name.setBounds(300,50,200,25);
		Username.setBounds(300,100,200,25);
		Mob.setBounds(300,150,200,25);
		Password.setBounds(300,200,200,25);
		Repass.setBounds(300,250,200,25);
		
		signup.setBounds(200,320,100, 25);;
		cnn.add(name);
		cnn.add(username);
		cnn.add(mob);
		cnn.add(password);
		cnn.add(repass);
		
		cnn.add(Name);
		cnn.add(Username);
		cnn.add(Mob);
		cnn.add(Password);
		cnn.add(Repass);
		
		cnn.add(signup);
		
		cnn.setBackground(Color.cyan);
		setSize(700,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new signup();
	}
}
