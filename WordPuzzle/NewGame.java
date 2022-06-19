import javax.swing.*;  //for JFrame
import java.awt.*;   //for font 
import java.awt.event.*;  //for events 
import java.util.*;   //for array list
import java.lang.String; //for string arrays
import java.io.*;   //to read files

public class NewGame extends JInternalFrame implements ActionListener
{
JLabel lb,lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9;  
JButton bt,bt1,bt2;
JTextField tf;
String s3,s4,str;
char[] scramword;
int score=0;
String WORDS_DATABASE = "words.txt";
ArrayList<WordClue> wordsClues = new ArrayList<WordClue> ();
	NewGame()
	{
		setBounds(450,70,800,600);
		setTitle("Word Puzzle");
		InputStream is = getClass().getResourceAsStream (WORDS_DATABASE);
		InputStreamReader isr = new InputStreamReader (is);
     		BufferedReader br = new BufferedReader (isr);

		Icon ic=new ImageIcon("p8.jpg");
		lb5=new JLabel(ic);
		lb=new JLabel("Find the shuffled word");
		lb1=new JLabel("Hint will be given for the given word");
		lb2=new JLabel("Score : 0");
		lb3=new JLabel("Word");
		lb4=new JLabel("Your answer is wrong..");
		lb6=new JLabel("__________________________________________________________________________________________________________________________________________________________________________");
		lb7=new JLabel("__________________________________________________________________________________________________________________________________________________________________________");
		lb9=new JLabel("Your answer is correct");
		tf=new JTextField(20);
		bt=new JButton("Hint");
		bt1=new JButton("Submit");
		bt2=new JButton("Close");
	
		setLayout(new BorderLayout());
		add(lb5);

		lb5.setLayout(null);
		lb.setBounds(250,10,500,40);
		lb2.setBounds(620,70,200,40);
		lb6.setBounds(10,100,900,20);
		lb3.setBounds(230,180,800,50);
		lb7.setBounds(10,250,900,20);
		tf.setBounds(200,300,350,50);
		bt.setBounds(200,380,100,35);
		lb1.setBounds(310,370,280,50);                                                                                                                    
		bt1.setBounds(555,305,150,35);
		lb4.setBounds(250,450,500,30);
		bt2.setBounds(590,370,100,35);
		lb9.setBounds(300,420,150,35);

		lb.setForeground(Color.RED);
		lb3.setForeground(Color.BLUE);
		//lb.setForeground(Color.RED);	
		tf.setForeground(Color.RED);
		bt.setForeground(Color.BLUE);
		bt1.setForeground(Color.BLUE);
		bt2.setForeground(Color.BLUE);
		lb2.setForeground(Color.RED);
		lb1.setForeground(Color.MAGENTA);
		lb4.setForeground(Color.RED);
		Font ft=new Font("Times New Roman",Font.BOLD,30);
		Font ft1=new Font("Footlight MT",Font.ITALIC,24);
		Font ft3=new Font("Gabriola",Font.BOLD,50);
		Font ft2=new Font("Cooper",Font.BOLD,56);
		
		lb.setFont(ft);
		lb1.setFont(ft1);
		lb2.setFont(ft3);
		lb3.setFont(ft2);
		lb4.setFont(ft1);
		tf.setFont(ft1);
		bt.setFont(ft1);
		bt1.setFont(ft1);
		bt2.setFont(ft1);

		bt.addActionListener(this);
		bt1.addActionListener(this);
		bt2.addActionListener(this);

		lb5.add(lb);
		lb5.add(lb1);
		lb5.add(lb2);
		lb5.add(lb3);
		lb5.add(bt);
		lb5.add(bt1);
		lb5.add(tf);
		lb5.add(lb4);
		lb5.add(lb6);
		lb5.add(lb7);
		lb5.add(bt2);
		lb5.add(lb9);
		lb1.setVisible(false);
		lb4.setVisible(false);
		lb9.setVisible(false);
		 try
		      {
			          String line;
			          while ((line = br.readLine ()) != null)
			          {
				String [] parts=line.toUpperCase().split(":");
				if (parts.length != 2)
                				   break;
				WordClue wc=new WordClue();
				wc.word=parts[0].trim();
				wc.hint=parts[1].trim();
				wordsClues.add(wc);
		                            }
	                }
		 catch (IOException ioe)
	                 {
		          System.err.println (ioe);
		          return;
      		}
		try
		{
			 String word,hint;
			  int prevIndex;
			  WordClue wc = wordsClues.get (prevIndex = rnd (wordsClues.size ()));
      			   word = wc.word;
		                    str=word;
    			   hint=wc.hint;
			   scramword=scramble(word.toCharArray());
			   s4=new String(scramword);
			   lb3.setText(s4);
			   lb1.setText(hint);
		}
		catch (Exception e)
		{
		}
             		
	}
	public int rnd(int limit)
	{
		return (int) (Math.random()*limit);
	}
	public static void main(String args[])
	{
		NewGame ng=new NewGame();
		ng.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String t=ae.getActionCommand();
		if(t.equals("Hint"))	//If Hint Button is clicked,Hint will be displayed
		{
			lb1.setVisible(true);
		}
		if(t.equals("Submit") || t.equals("") )	//If Done Button is clicked,compares the user input with original word
		{
			if(str.equalsIgnoreCase(tf.getText()))
			{
				//JOptionPane.showMessageDialog(this,"Your answer is correct");
				lb4.setVisible(false);
				lb9.setVisible(true);
				tf.setText("");
				lb1.setVisible(false);
				score=score+10;
				lb2.setText("Score:"+score);
				lb9.setVisible(false);
				try
				{
				 String word,hint;
				  int prevIndex;
				  WordClue wc = wordsClues.get (prevIndex = rnd (wordsClues.size ()));
	      			   word = wc.word;
			           str=word;
	    			   hint=wc.hint;
				   scramword=scramble(word.toCharArray());
				   s3=new String(scramword);
				   lb3.setText(s3);
				   lb1.setText(hint);

				}
				catch (Exception e)
				{
				}	
			}
			else
			{
				lb4.setText("Your answer is Wrong!");
				lb4.setVisible(true);
			}
		}
		if(t.equals("Close"))
		{
			dispose();
		}
	}
	private char[] scramble(char[] word)
	{
	      	 char [] scramWord = new char [word.length];
		  System.arraycopy (word, 0, scramWord, 0, word.length);
	
	     	 mainloop:
	     	 do
	     	 {
	        	 for (int i = 0; i < 100; i++) 
	        	 {
	                     	int x = rnd (word.length);
	          	                 int y = rnd (word.length);

             	                  	char ch = scramWord [x];
                    	 	scramWord [x] = scramWord [y];
              		 	scramWord [y] = ch;
        	        	 }
		 // Make sure word is scrambled in the forward and reverse directions.
                                  // For example, if word contains "StringShuffle", scramWord must not
                                 // contain "StringShuffle" or "elffuhSgnirtS" (must make it harder to guess).
        		for (int i = 0; i < word.length; i++)
		{
             		 	if (word [i] != scramWord [i] && word [i] != scramWord [word.length-1-i])
                 				 break mainloop;
		}
     	                 } while (true);
	 	 return scramWord;
  	 }	
}
class WordClue
{
   String word,hint;
}