# cs310-tic-tac-toe-1

This project gave me additional experience with the Gradle build system, and with the software testing tools that I was introduced to during my software engineering class.  For this project, I implemented a working two-player Tic-Tac-Toe game.

Complete the implementation, using the incomplete versions provided in the repository as a starting point.  The only files that I are the Java source files:

TicTacToe.java
TicTacToeMove.java
TicTacToeModel.java
TicTacToeView.java
TicTacToeController.java

My first version of this program will use the console for input and output; 

Part Two of this assignment will involve upgrading my implementation to use a GUI.  To make this transition easier, I provided implementation which is structured using the Model-View-Controller design pattern, in which the board is the Model, the terminal window is the View, and the Controller receives and processes keyboard input.

## Output

When the game is finished, the output should precisely match the following example (the players' input is shown in bold):

  012

0 ---
1 ---
2 ---

Player 1 (X) Move:
Enter the row and column numbers, separated by a space: 1 1


  012

0 ---
1 -X-
2 ---

Player 2 (O) Move:
Enter the row and column numbers, separated by a space: 0 1


  012

0 -O-
1 -X-
2 ---

Player 1 (X) Move:
Enter the row and column numbers, separated by a space: 0 0


  012

0 XO-
1 -X-
2 ---

Player 2 (O) Move:
Enter the row and column numbers, separated by a space: 1 2


  012

0 XO-
1 -XO
2 ---

Player 1 (X) Move:
Enter the row and column numbers, separated by a space: 2 2


  012

0 XO-
1 -XO
2 --X

X!
