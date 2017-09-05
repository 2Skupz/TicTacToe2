import java.util.ArrayList;
/*------------------------------------------------------------------------------
	Move Class:
	Purpose: 
		The move class is used in the recursive look forward piece of the tic tac
		toe game. It tracks a row, a column, and, most importantly a score.

		After the recursion is done, the computer picks the highest score.

	Instructions:
		This program is a class designed to be run with playTicTacToe.java and 
		CPUPlayer.java. 
------------------------------------------------------------------------------*/
public class move {
	//member variables
	public int row;
	public int col;
	public int score = 0;
	
	//***************************************************************************
	//constructor(int,int)
	//***************************************************************************
	public move(int r, int c){
		setMove(r,c);
	}
	
	//***************************************************************************
	//setMove(int, int)
	//initialize variables
	//***************************************************************************
	public void setMove(int r, int c){
		row = r;
		col = c;
		score = 0;
	}
	
	//***************************************************************************
	//set score(void)
	//update score member variable
	//***************************************************************************
	public void setScore(int s){
		score = s;
	}
	
	//***************************************************************************
	//getScore(void)
	//return score member variable
	//***************************************************************************
	public int getScore(){
		return score;
	}
	
	//***************************************************************************
	// findAvailableMoves(game)
	// return an arraylist of all possible moves. In this case, all open squares
	//***************************************************************************
	private ArrayList<move> findAvailableMoves(ticTacToe game){
		System.out.println("Adding moves at level 2!");
		ArrayList<move> movesToMake = new ArrayList<move>();
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				if(game.getBoardVal(i, j) == 1){
					move newMove = new move(i,j);
					movesToMake.add(newMove);
				}
			}
		}
		return movesToMake;
	}
	
	//***************************************************************************
	//toString
	//overwrite toString function
	//***************************************************************************
	public String toString(){
		return "(" + row + "," + col + ")";
	}
	
	
	
}
