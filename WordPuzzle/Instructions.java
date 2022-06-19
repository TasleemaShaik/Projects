import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Instructions extends JInternalFrame implements ActionListener 
{
JLabel lb,lb1,lb2,lb3,lb4,lb5;
JButton bt1;
	Instructions()
	{
		setBounds(470,70,800,600);
		setTitle("Instructions");
		
		Icon ic=new ImageIcon("p4.png");
		lb5=new JLabel(ic);
		setLayout(new BorderLayout());
		add(lb5);
		lb=new JLabel("Instructions");
		lb1=new JLabel("1.A Jumbled word will be given to You");
		lb2=new JLabel("2.Hint will be shown below the Word when u will click the hint button. ");
		lb3=new JLabel("3.You have to enter the word correctly.");
		lb4=new JLabel("4.If the entered word is correct then the next word will be displayed.");
		bt1=new JButton("Close");
		bt1.addActionListener(this);
		lb5.setLayout(null);
		lb.setBounds(250,25,500,100);
		lb1.setBounds(50,75,500,100);
		lb2.setBounds(50,135,700,100);
		lb3.setBounds(50,195,500,100);
		lb4.setBounds(50,255,700,100);
		bt1.setBounds(300,350,75,50);
		lb.setFont(new Font("Arial",Font.BOLD,30));
		lb1.setFont(new Font("Arial",Font.BOLD,20));
		lb2.setFont(new Font("Arial",Font.BOLD,20));
		lb3.setFont(new Font("Arial",Font.BOLD,20));
		lb4.setFont(new Font("Arial",Font.BOLD,20));
		lb.setForeground(Color.RED);
		lb1.setForeground(Color.BLUE);
		lb2.setForeground(Color.BLUE);
		lb3.setForeground(Color.BLUE);
		lb4.setForeground(Color.BLUE);
		bt1.setForeground(Color.BLUE);
		bt1.setBackground(Color.PINK);
		lb5.add(lb);
		lb5.add(lb1);
		lb5.add(lb2);
		lb5.add(lb3);
		lb5.add(lb4);
		lb5.add(bt1);
	}
	public static void main(String args[])
	{
		Instructions ins=new Instructions();
		ins.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String str=ae.getActionCommand();
		if(str.equals("Close"))
		{
		dispose();
		}
	}

	
}
		