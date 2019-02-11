package edu.jsu.mcis;
import javax.swing.*;
import java.awt.event.*;

public class TicTacToeController implements ActionListener{

    private final TicTacToeModel model;
    private final TicTacToeView view;

    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView(this, width);
        
    }
	 public String getMarkAsString(int row, int col) {        
        return (model.getMark(row, col).toString());        
    }
    
    public TicTacToeView getView() {        
        return view;        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // INSERT YOUR CODE HERE
		
		String s = ((JButton) event.getSource()). getName();

		int width = model.getWidth();
		int row = Integer.parseInt(s.substring(6,7));
		int col = Integer.parseInt(s.substring(7));
		

        if(model.makeMark(row, col)) {
			view.updateSquares();
			String result = model.getResult().toString();
			switch(result) {
				case "X":
					view.showResult("X");
					view.disableSquares();
					break;
				case "O":
					view.showResult("O");
					view.disableSquares();
					break;
				case "TIE":
					view.showResult("TIE");
					view.disableSquares();
					break;
				
			}
			
		}
    
		
    }


    public void start() {
    
        /* MAIN LOOP (repeats until game is over) */

        /* Display the board using the View's "showBoard()", then use
           "getNextMove()" to get the next move from the player.  Enter
           the move (using the Model's "makeMark()", or display an error
           using the View's "showInputError()" if the move is invalid. */

        // INSERT YOUR CODE HERE
		/*while( !model.isGameover() ){
		
			view.showBoard(model.toString());
            TicTacToeMove nextMove = view.getNextMove(model.isXTurn());
            if( !model.makeMark(nextMove.getRow(), nextMove.getCol())){
				view.showInputError();
            }
                
        }
		
        /* After the game is over, show the final board and the winner */

		//view.showBoard(model.toString());

		view.showResult(model.getResult().toString());
        
   

    }
	
}


