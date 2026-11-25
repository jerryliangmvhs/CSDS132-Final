package Project_Final;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Gomoku extends Application {

    private boolean turn = true;
    private boolean gameEnded = false;
    private int winRequirement;
    private int boardHeight;
    private int boardWidth;
    private Button[][] pieces;
    private Scene scene;
    private BorderPane gui;
    private GridPane board;
    private Background emptySpace = new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, new Insets(0.5)));
    private Background blackPiece = new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, new Insets(0.5)), new BackgroundFill(Color.BLACK, new CornerRadii(20), new Insets(0.5)));
    private Background whitePiece = new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, new Insets(0.5)), new BackgroundFill(Color.WHITE, new CornerRadii(20), new Insets(0.5)));
    private String[] directions = {"north","northwest","west","southwest","south","southeast","east","northeast"};

    public void start(Stage primaryStage) {
        setBoardHeight(19);
        setBoardWidth(19);
        setWinRequirement(5);
        pieces = new Button[getBoardHeight()][getBoardWidth()];
        gui = new BorderPane();
        board = new GridPane();

        for(int row = 0; row < pieces.length; row++) {
            for(int col = 0; col < pieces[row].length; col++) {
                pieces[row][col] = new Button();
                pieces[row][col].setMinSize(10,10);
                pieces[row][col].setPrefSize(30,30);
                pieces[row][col].setMaxSize(50,50);
                pieces[row][col].setBackground(emptySpace);
                pieces[row][col].setOnAction(new GameMove(row,col));
                board.add(pieces[row][col],col+1,row+1);
            }
        }

        gui.setCenter(board);
        scene = new Scene(gui);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Liang Jerry Gomoku Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void switchPlayer() {
        if(turn) {
            turn = false;
        }
        else if(!turn) {
            turn = true;
        }
    }

    public boolean getTurn() {
       return turn;
    }

    public void setWinRequirement(int requirement) {
        this.winRequirement = requirement;
    }

    public void setBoardHeight(int boardHeight) {
        this.boardHeight = boardHeight;
    }

    public void setBoardWidth(int boardWidth) {
        this.boardWidth = boardWidth;
    }

    public Button[][] getPieces() {
        return pieces;
    }

    public int getWinRequirement() {
        return winRequirement;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public boolean getGameEnded() {
        return gameEnded;
    }

    public void setGameEnded(boolean gameEnded) {
        this.gameEnded = gameEnded;
    }

    public boolean hasExactConsecutiveTiles(Button[][] pieces, int row, int col, int targetStreak) {
        for(int i = 0; i < directions.length; i++) {
            if(numberInLine(pieces,row,col,directions[i]) == targetStreak){
                if(!hasOverline(pieces,row,col,targetStreak+1)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasOverline(Button[][] pieces, int row, int col, int targetStreak) {
        for(int i = 0; i < directions.length; i++) {
            if(numberInLine(pieces,row,col,directions[i]) >= targetStreak){
                return true;
            }
        }
        return false;
    }

    public void displayWinner (boolean turn) {
        if(turn) {
            System.out.println("white won.");
        }
        else{
            System.out.println("black won.");
        }
    }

    public boolean hasConsecutiveTilesMinusOne(Button[][] pieces, int row, int col, int targetStreak) {
        return false;
    }

    public boolean hasConsecutiveTilesMinusTwo(Button[][] pieces, int row, int col, int targetStreak) {
        return false;
    }

    public boolean matchingBackgrounds (Button piece1, Button piece2) {
        return piece1.getBackground().equals(piece2.getBackground());
    }

    public int numberInLine(Button[][] pieces, int row, int col, String direction){
        int numberInLine = 0;
        Button referencePiece = pieces[row][col];

        if(direction.equals("west")){
            for(int colPointer = col; colPointer >= 0 && matchingBackgrounds(referencePiece,pieces[row][colPointer]); colPointer--){
                numberInLine++;
            }
        }
        else if(direction.equals("southwest")){
            int rowPointer = row;
            int colPointer = col;

            while(rowPointer < pieces.length && colPointer >= 0 && matchingBackgrounds(referencePiece,pieces[rowPointer][colPointer])){
                numberInLine++;
                rowPointer++;
                colPointer--;
            }
        }
        else if(direction.equals("south")){
            for(int rowPointer = row; rowPointer < pieces.length && matchingBackgrounds(referencePiece,pieces[rowPointer][col]); rowPointer++){
                numberInLine++;
            }
        }
        else if(direction.equals("southeast")){
            int rowPointer = row;
            int colPointer = col;

            while(rowPointer < pieces.length && colPointer < pieces[row].length && matchingBackgrounds(referencePiece,pieces[rowPointer][colPointer])){
                numberInLine++;
                rowPointer++;
                colPointer++;
            }
        }
        else if(direction.equals("east")){
            for(int colPointer = col; colPointer < pieces[row].length && matchingBackgrounds(referencePiece,pieces[row][colPointer]); colPointer++){
                numberInLine++;
            }
        }
        else if(direction.equals("northeast")){
            int rowPointer = row;
            int colPointer = col;

            while(rowPointer >= 0 && colPointer < pieces[row].length && matchingBackgrounds(referencePiece,pieces[rowPointer][colPointer])){
                numberInLine++;
                rowPointer--;
                colPointer++;
            }
        }
        else if(direction.equals("north")){
            for(int rowPointer = row; rowPointer >=0 && matchingBackgrounds(referencePiece,pieces[rowPointer][col]); rowPointer--){
                numberInLine++;
            }
        }
        else if(direction.equals("northwest")){
            int rowPointer = row;
            int colPointer = col;

            while(rowPointer >= 0 && colPointer >= 0 && matchingBackgrounds(referencePiece,pieces[rowPointer][colPointer])){
                numberInLine++;
                rowPointer--;
                colPointer--;
            }
        }
        return numberInLine;
    }

    public boolean isOpen(Button[][] pieces, int row, int col, String direction){
        return false;
    }

    private class GameMove implements EventHandler<ActionEvent> {
        private int buttonRow;
        private int buttonCol;

        public GameMove(int buttonRow, int buttonCol) {
            this.buttonRow = buttonRow;
            this.buttonCol = buttonCol;
        }

        public void handle(ActionEvent e) {
            Button buttonClicked = (Button)e.getSource();
            boolean previousTurn = Gomoku.this.getTurn();

            if(buttonClicked.getBackground().equals(emptySpace) && !getGameEnded()){
                if(Gomoku.this.getTurn()){
                    buttonClicked.setBackground(whitePiece);
                    Gomoku.this.switchPlayer();
                }
                else if(!Gomoku.this.getTurn()){
                    buttonClicked.setBackground(blackPiece);
                    Gomoku.this.switchPlayer();
                }
            }
            if(Gomoku.this.hasExactConsecutiveTiles(getPieces(), buttonRow, buttonCol, getWinRequirement()) && !getGameEnded()){
                setGameEnded(true);
                displayWinner(previousTurn);
            }
        }
    }

}
