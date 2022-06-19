public class TicTacToeAI_new {
 private int board[][];
 public static final int EMPTY = 0;
 public static final int ONE = 1;
 public static final int TWO = 2;

 public TicTacToeAI_new() 
 {
  board = new int[3][3];
 }

 /* get the board value for position (i,j) */
 public int getBoardValue(int i,int j)
  {
  if(i < 0 || i >= 3) return EMPTY;
  if(j < 0 || j >= 3) return EMPTY;
  return board[i][j];
    }

 /* set the board value for position (i,j) */
 public void setBoardValue(int i,int j,int token) {
  if(i < 0 || i >= 3) return;
  if(j < 0 || j >= 3) return;
  board[i][j] = token;
    }

    public int inverse(int token)  {
  return token==ONE ? TWO : ONE;
 }


 public boolean isWin(int token) {
  final int DI[]={-1,0,1,1};		//They are winning conditions 
  final int DJ[]={1,1,1,0};
  for(int i=0;i<3;i++)
   for(int j=0;j<3;j++) {

    if(getBoardValue(i, j)!=token) continue;

    for(int k=0;k<4;k++) {
     int ctr = 0;
                 while(getBoardValue(i+DI[k]*ctr, j+DJ[k]*ctr)==token) 
					ctr++;

     if(ctr==3) return true;
    }
  }
  return false;
    }
} 
