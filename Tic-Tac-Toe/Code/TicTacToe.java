import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TicTacToe implements ActionListener
{
JFrame window = new JFrame("Tic-Tac-Toe ");
Font f=new Font("Arial",Font.BOLD,80);
JMenuBar mnuMain = new JMenuBar();
JMenuItem mnuNewGame = new JMenuItem("New Game"),
mnuInstruction = new JMenuItem("Instructions"),
mnuExit = new JMenuItem("Exit"),
mnuAbout = new JMenuItem("About");
JButton btn1v1 = new JButton("Player vs Player"),
btn1vCPU = new JButton("Player vs Computer");
JPanel pnlNewGame = new JPanel(),pnlMenu = new JPanel(),pnlMain = new JPanel(),pnlTop = new JPanel(),pnlBottom = new JPanel(),pnlPlayingField = new JPanel();
JLabel lblTitle = new JLabel("Tic-Tac-Toe");
JTextArea txtMessage = new JTextArea();
final int X = 600, Y = 600,mainColorR = 50, mainColorG = 190, mainColorB = 190,btnColorR = 80, btnColorG = 80, btnColorB = 80;
Color clrBtnWonColor = new Color(190, 190, 190);
String message;

public TicTacToe() 
{ 
window.setSize(X, Y);
window.setLocation(0,0);
lblTitle.setFont(f);
window.setLayout(new BorderLayout());
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
pnlMenu.setLayout(new FlowLayout(FlowLayout.CENTER));
pnlTop.setLayout(new FlowLayout(FlowLayout.CENTER));
pnlBottom.setLayout(new FlowLayout(FlowLayout.CENTER));
pnlNewGame.setBackground(new Color(mainColorR - 50, mainColorG - 50, mainColorB- 50));
pnlMenu.setBackground(new Color((mainColorR - 50), (mainColorG - 50), (mainColorB- 50)));
pnlMain.setBackground(new Color(mainColorR, mainColorG, mainColorB));
pnlTop.setBackground(new Color(mainColorR, mainColorG, mainColorB));
pnlBottom.setBackground(new Color(mainColorR, mainColorG, mainColorB));
mnuMain.add(mnuNewGame);
mnuMain.add(mnuInstruction);
mnuMain.add(mnuAbout);
mnuMain.add(mnuExit);
pnlNewGame.setLayout(new GridLayout(2, 4, 1, 40));
pnlNewGame.add(btn1v1);
pnlNewGame.add(btn1vCPU);
txtMessage.setBackground(new Color(mainColorR-30, mainColorG-30, mainColorB-30));
txtMessage.setForeground(Color.white);
txtMessage.setEditable(false);
mnuNewGame.addActionListener(this);
mnuExit.addActionListener(this);
mnuInstruction.addActionListener(this);
mnuAbout.addActionListener(this);
btn1v1.addActionListener(this);
btn1vCPU.addActionListener(this);
pnlPlayingField.setLayout(new GridLayout(3, 3, 2, 2));
pnlPlayingField.setBackground(Color.black);
pnlMenu.add(mnuMain);
pnlMain.add(lblTitle);
window.add(pnlMenu, BorderLayout.NORTH);
window.add(pnlMain, BorderLayout.CENTER);
window.setVisible(true);
}

public int askMessage(String msg, String tle, int op) 
{
return JOptionPane.showConfirmDialog(null, msg, tle, op);
}

public static void main(String[] args) 
{
new TicTacToe();
}
public void showGame() 
{ 
clearPanelSouth();
pnlMain.setLayout(new BorderLayout());
pnlTop.setLayout(new BorderLayout());
pnlBottom.setLayout(new BorderLayout());
pnlTop.add(pnlPlayingField);
pnlMain.add(pnlTop, BorderLayout.CENTER);
pnlMain.add(pnlBottom, BorderLayout.SOUTH);
pnlPlayingField.requestFocus();
}
public void setDefaultLayout() 
{
pnlMain.setLayout(new GridLayout(2, 1, 2, 5));
pnlTop.setLayout(new FlowLayout(FlowLayout.CENTER));
pnlBottom.setLayout(new FlowLayout(FlowLayout.CENTER));
}


public void clearPanelSouth() 
{ 
pnlMain.remove(lblTitle);
pnlMain.remove(pnlTop);
pnlMain.remove(pnlBottom);
pnlTop.remove(pnlNewGame);
pnlTop.remove(txtMessage);
pnlTop.remove(pnlPlayingField);
}

public void actionPerformed(ActionEvent click) 
{
	Object source = click.getSource();
	if(source == mnuNewGame || source == mnuInstruction || source == mnuAbout) 
	{
		clearPanelSouth();
		setDefaultLayout();
		if(source == mnuNewGame) 
		{
		pnlTop.add(pnlNewGame);
		}
		else if(source == mnuInstruction || source == mnuAbout) 
		{
		if(source == mnuInstruction) 
			message = "Instructions:\n\n" +"Your goal is to be the first player to get 3 X's or O's in a\n" +"row. (horizontally, diagonally, or vertically)\nPlayer1: X \tPlayer2:O\n";
		else 
			message = "About:\n\n" +"TicTacToe Game\n" + "\n";
		txtMessage.setText(message);
		pnlTop.add(txtMessage);
		}
		pnlMain.add(pnlTop);
	}
	else if(source == btn1v1 || source == btn1vCPU) 
	{
		if(source == btn1v1) 
			new TicTacToeMain_new().setVisible(true);
		else 
			new TicTacToeMain().setVisible(true);
	}
	else if(source == mnuExit) 
	{
		int option = askMessage("Are you sure you want to exit?", "Exit Game", JOptionPane.YES_NO_OPTION);
		if(option == JOptionPane.YES_OPTION)
		System.exit(0);
	}
	pnlMain.setVisible(false);
	pnlMain.setVisible(true);
}
}
