import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class First extends JFrame implements ActionListener
{
JDesktopPane jdp;
JLabel lb1,lb2,lb;
JButton bt1,bt2,bt3;
First()
{
setSize(1500,1000);
jdp=new JDesktopPane();
lb1=new JLabel("Welcome To Word Puzzle");
lb2=new JLabel("_______________________________________________________________");
bt1=new JButton("Start Game");
bt2=new JButton("Instructions");
bt3=new JButton("Exit");
Font ft=new Font("Gabriola",Font.BOLD,46);
Font ft1=new Font("Times New Roman",Font.BOLD,26);
lb1.setFont(ft);
bt1.setFont(ft1);
bt2.setFont(ft1);
bt3.setFont(ft1);
lb1.setForeground(Color.RED);
lb2.setForeground(Color.PINK);
bt1.setForeground(Color.BLUE);
bt2.setForeground(Color.BLUE);
bt3.setForeground(Color.BLUE);
bt1.setBackground(Color.PINK);
bt2.setBackground(Color.PINK);
bt3.setBackground(Color.PINK);
jdp.setLayout(null);
lb1.setBounds(50,20,600,35);
lb2.setBounds(50,40,600,20);
bt1.setBounds(150,100,250,50);
bt2.setBounds(150,200,250,50);
bt3.setBounds(150,300,250,50);
bt1.addActionListener(this);
bt2.addActionListener(this);
bt3.addActionListener(this);
add(jdp);
jdp.add(lb1,1);
jdp.add(lb2,2);
jdp.add(bt1,3);
jdp.add(bt2,4);
jdp.add(bt3,5);
}
public static void main(String args[])
{
First f=new First();
f.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==bt1)
	{
		JOptionPane.showMessageDialog(this,"Starting  new game");
		NewGame ng=new NewGame();
		ng.setVisible(true);
		jdp.add(ng,new Integer(1));
	}
	else if(ae.getSource()==bt2)
	{
		JOptionPane.showMessageDialog(this,"Instructions page");
		Instructions ins=new Instructions();
		ins.setVisible(true);
		jdp.add(ins,new Integer(2));
	}
	else
	{
		JOptionPane.showMessageDialog(this,"Game is Closing");
		dispose();
	}
}
}
