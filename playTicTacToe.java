import java.util.Scanner;

//Ken Schroeder
// August 2nd, 2015, 1101
// Starbucks, 5th Ave Portland, OR
// TicTacToe
// PlayTicTacToe.java

public class playTicTacToe {
	//***************************************************************************
	//global variables
	static String YES = "y";
	static CPUPlayer CPU;
	static int[] rowCol = new int[2];
	
	//***************************************************************************
	//main
	public static void main(String[] args){
		//initialize game
		ticTacToe game = new ticTacToe();
		CPU = new CPUPlayer(game);
		game.welcome();
		Scanner console = new Scanner(System.in);
		int piece;
		String yn = YES;
		int row;
		int col;
		boolean won = false;
		boolean another = true;
		//play game
		while(another){
			while(!won){
				System.out.println("\n\n");
				game.displayBoard();
				//human move
				if(game.getTurn() == game.getXMove()){
					piece = game.getXMove();
					System.out.println("\nPlease enter which row you'd like to use: ");
					row = console.nextInt();
					System.out.println("\nPlease enter which column you'd like to use: ");
					col = console.nextInt();
					System.out.println("\n\n");
					game.placePiece(game.getTurn(), row,col);
					won = game.gameOver(piece);
					if (game.isWinner()){
						System.out.println("You've won!");
					}
				}
				//computer move
				else{
					piece = game.getOMove();
					CPU.getMove();
					won = game.gameOver(piece);
					if (game.isWinner()){
						System.out.println("The Computer won :(");
					}
				}
			}
			game.gameStats();
			game.displayBoard();
			System.out.print("Would you like to play another? [y/n]: ");
			yn = console.next();
			if(yn.equals(YES)){
				game.resetBoard();
				won = false;
			}else{
				another = false;
				game.displayBoard();
				game.gameStats();
			}

		}
		game.goodBye();
		console.close();
	}
}
