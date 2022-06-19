import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TicTacToeMain_new extends JFrame implements ActionListener 
{

 private JButton [][]buttons = new JButton[3][3];
 private JButton playButton = new JButton("Play");
 private JLabel statusLabel = new JLabel("");
 private JLabel count=new JLabel("");
 private JLabel count2=new JLabel("");
 private TicTacToeAI_new game = null;
 private int player1 = 0;
 private int player2= 0;
 private int player1_win=0;
 private int player2_win=0;
 private int player=0;
 private boolean isPlay = false;
 private String []chars=new String[]{"","X","O"};

 private void setStatus(String s) {
  statusLabel.setText(s);
 }
 
 private void setCount(int c) {
String str=Integer.toString(c),text="Player1:";
  count.setText(text+str);
 }
 
 private void setValue(int c) {
String str=Integer.toString(c),text="Player2:";
  count2.setText(text+str);
 }

 private void setButtonsEnabled(boolean enabled) {
  for(int i=0;i<3;i++)
   for(int j=0;j<3;j++) {
    buttons[i][j].setEnabled(enabled);
    if(enabled) buttons[i][j].setText(" ");
   }
 }

 public TicTacToeMain_new() {

  setTitle("Tic Tac Toe");
  setResizable(false);

  JPanel centerPanel = new JPanel(new GridLayout(3,3));
  Font font = new Font("Arial",Font.BOLD, 32);
  for(int i=0;i<3;i++)
   for(int j=0;j<3;j++) {
    buttons[i][j] = new JButton(" ");
    buttons[i][j].setFont(font);
    buttons[i][j].addActionListener(this);
    buttons[i][j].setFocusable(false);
    centerPanel.add(buttons[i][j]);
   }

  playButton.addActionListener(this);
  JPanel northPanel = new JPanel();
  northPanel.add(statusLabel);
  JPanel southPanel = new JPanel();
  southPanel.add(playButton);
  setCount(0);
  setValue(0);
  southPanel.add(count);
  southPanel.add(count2);
  setStatus("Click 'Play' To Start");
  setButtonsEnabled(false);
  add(northPanel,"North");
  add(centerPanel,"Center");
  add(southPanel,"South");
  setSize(600,600);
 }

 public static void main(String []args) {
  new TicTacToeMain_new().setVisible(true);
 }

 private void gameOver(String s) {
  setStatus(s);
  setButtonsEnabled(false);
  isPlay = false;
 }

 private void checkState() {
	 boolean check1=game.isWin(player1);
	 boolean check2=game.isWin(player2);
  if(check1) {
   gameOver("Congratulations,Player1 wins!");
   player1_win++;
   setCount(player1_win);
  }
  if(check2) {
   gameOver("Congratulations,Player2 Wins!");
   player2_win++;
   setValue(player2_win);
  }
 }

 private void click(int i,int j,int player) {
  if(game.getBoardValue(i,j)==TicTacToeAI_new.EMPTY) {
   if(player%2==0)
   {
	   buttons[i][j].setText(chars[player1]);
	   game.setBoardValue(i,j,player1);
   }
   else
   {
	   buttons[i][j].setText(chars[player2]);
	   game.setBoardValue(i,j,player2);
   }
   checkState();
  }	
 }

 public void actionPerformed(ActionEvent event) {
  if(event.getSource()==playButton) {
   play();
  }else {
   for(int i=0;i<3;i++)
    for(int j=0;j<3;j++)
     if(event.getSource()==buttons[i][j])
     {
		  click(i,j,player);
		  player++;
     }
     if(player==9)
		gameOver("Draw Match");
  }
 }

 private void play() {
	player=0;	//no of moves
  game = new TicTacToeAI_new();
  player1= TicTacToeAI_new.ONE;
  player2= TicTacToeAI_new.TWO;
  setButtonsEnabled(true);
  setStatus("New Game");
  isPlay = true;
 }
}
