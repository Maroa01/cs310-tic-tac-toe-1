package edu.jsu.mcis;

public class TicTacToeModel {
    
    private Mark[][] grid; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */

   
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
		boolean won = false;
		int c = width -1;
		int markCountRow = 0;
		int markCountCol = 0;
		int markCountLR = 0;
		int markCountRL = 0;
		
		for (int i=0; i<width; i++){
			for(int j=0; j<width; j++){
				
				if (grid[i][j].equals(mark))
					markCountRow++;
				
				if (grid[j][i].equals(mark))
					markCountCol++;
			}
			if (grid[i][i].equals(mark))
				markCountLR++;
			
			if (grid[i][c].equals(mark))
				markCountRL++;
			
			if (markCountCol == width || markCountRow == width || markCountLR == width || markCountRL == width)
				won = true;
			markCountRow = 0;
			markCountCol = 0;
			c--;
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
					break;
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
		//System.out.print("\n\n");

		for(int i = 0; i < getWidth(); i++){

			output.append(i);

		}
		output.append("\n\n");

		int width = getWidth();
        for(int i = 0; i < width; i++){

            output.append(i).append(" ");

            for (int j = 0; j < width; j++){

                output.append(getMark(i,j).toString()); 

            }
			if (i < width-1) {
				output.append("\n");
			}
        
        }
        return output.toString();
    }
}
