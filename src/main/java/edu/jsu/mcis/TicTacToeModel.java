package edu.jsu.mcis;

public class TicTacToeModel {
    
    private Mark[][] grid; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */

    private boolean isMarkWin(Mark mark) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        
        /* Create board (width x width) as a 2D Mark array */
        
        grid = new Mark[width][width];

        /* Initialize board by filling every square with empty marks */
        
        //grid = new mark[width][width];
        for(int i = 0; i < width; i++){
            for (int j = 0; j <  width; j++){
                grid[i][j]= Mark.EMPTY;
        
        }
    }
	
    }
    public boolean makeMark(int row, int col){
        
        /* Use "isValidSquare()" to check if the specified location is in range,
           and use "isSquareMarked()" to see if the square is empty!  If the
           specified location is valid, make a mark for the current player, then
           toggle "xTurn" from true to false (or vice-versa) to switch to the
           other player before returning TRUE.  Otherwise, return FALSE. */
        
        // INSERT YOUR CODE HERE
        boolean check = false;
        if(isValidSquare(row, col) && !isSquareMarked(row, col)){
            
            if(xTurn){
                
                grid[row][col] = Mark.X;
                
            }else if (!xTurn) {
                grid[row][col] = Mark.O;
            } 
            
            xTurn = !xTurn;
            check = true;
            return check;
            
        }
        
        return check;
    }		
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified location is within the bounds of the board */
        
        // INSERT YOUR CODE HERE
		if((row >= 0) && (row < width)) {
			
				if((col >= 0) && (col < width)) {
					return true;
				}
		}
		return false;
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return TRUE if the square at specified location is marked */
        
        // INSERT YOUR CODE HERE
        if (isValidSquare(row, col)){
            
           if(getMark(row, col).equals(Mark.EMPTY)){
               
               return false;
           } 
        }
            
		
	return true;

        
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        
        // INSERT YOUR CODE HERE
		if (isValidSquare(row, col)) {
			
			return grid[row][col];
		
		}
		

        return null; // remove this line later
            
    }
	
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */
        
        // INSERT YOUR CODE HERE
		
	if(isMarkWin(Mark.O)) {
			
            return Result.O;
                    
	}else if (isMarkWin(Mark.X)) {
			
            return Result.X;
	}else if (isTie()) {
			
            return Result.TIE;
	}else {
            
            return Result.NONE;
		}

    }
	
        

	
	private boolean isMarkWin(Mark mark){

		/* Check the squares of the board to see if the specified mark is the
		   winner */

		// INSERT YOUR CODE HERE
		int count = 0;
		boolean won = false;
		//column

		for(int col = 0; col < width; ++col) {

			count = 0;

			for(int row = 0; row < width; ++row){
				if (grid[row][col].equals(mark)) {

					count++;
				}
			}
			if (count == width) {
				won = true;
			}

		}
		//row
		for (int row = 0; row < width; ++row) {

			count = 0;

			for (int col = 0; col < width; ++col) {
				if(grid[row][col].equals(mark)) {

					count++;
				}
			}
			if (count == width) {
				won = true;
			}
			return won;
		}
		// Checking diagonals from R to L.

		for (int i = 0; i < width; ++i) {
			if (grid[i][(width - i) - 1].equals(mark)) {

				count++;
			}
		}
		if (count == width) {
			 won = true;
		}



		//CHECKING diagonals from L to R.

		for (int i = 0; i < width; ++i) {
			if (grid[i][i].equals(mark)) {
				count++;
			}
		}
		if (count == width) {
			 won = true;
		}
		return won;

	}

	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */
        
        // INSERT YOUR CODE HERE
		boolean full = true;
		
		for (int i = 0; i < width; ++i) {
			for (int j = 0; j < width; ++j) {
				if (getMark(i, j) == Mark.EMPTY){
					full = false;
				}
			}
		}
		if (!full){
			return false;
                }
                     return !((isMarkWin(Mark.X)) || (isMarkWin(Mark.O)));
        
    }
     

    public boolean isGameover() {
        
        /* Return TRUE if the game is over */
        
        return (Result.NONE != getResult());
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder("  ");
        
        /* Output the board contents as a string (see examples) */
        
        // INSERT YOUR CODE HERE
		System.out.print("\n  ");

		for(int i = 0; i < getWidth(); i++){

			output.append(i);

		}
		output.append("\n");


        for(int i = 0; i < getWidth(); i++){

            System.out.print(i + " ");

            for (int j = 0; j < getWidth(); j++){

                output.append(getMark(i,j)); 

            }
            output.append("\n");
        
        }
         return output.toString();
    }
}
