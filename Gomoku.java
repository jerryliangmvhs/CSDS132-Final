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
    private int winRequirement;
    private int boardHeight;
    private int boardWidth;
    private Button[][] pieces;
    private Scene scene;
    private BorderPane gui;
    private GridPane board;
    private BackgroundFill emptySpace = new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, new Insets(0.5));
    private BackgroundFill blackPiece = new BackgroundFill(Color.BLACK, new CornerRadii(20), new Insets(0.5));
    private BackgroundFill whitePiece = new BackgroundFill(Color.WHITE, new CornerRadii(20), new Insets(0.5));

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
                pieces[row][col].setBackground(new Background(emptySpace));
                pieces[row][col].setOnAction(new GameMove(row,col));
                board.add(pieces[row][col],col+1,row+1);
            }
        }

        gui.setCenter(board);
        scene = new Scene(gui);
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

    public boolean hasExactConsecutiveTiles(Button[][] board, int row, int col, int targetStreak) {
        return false;
    }

    public boolean hasConsecutiveTilesMinusOne(Button[][] board, int row, int col, int targetStreak) {
        return false;
    }

    public boolean hasConsecutiveTilesMinusTwo(Button[][] board, int row, int col, int targetStreak) {
        return false;
    }

    public int numberInLine(Button[][] board, int row, int col, String direction){
        return -1;
    }

    public boolean isOpen(Button[][] board, int row, int col, String direction){
        return false;
    }

    private class GameMove implements EventHandler<ActionEvent>{
        private int buttonRow;
        private int buttonCol;

        public GameMove(int buttonRow, int buttonCol) {
            this.buttonRow = buttonRow;
            this.buttonCol = buttonCol;
        }

        public void handle(ActionEvent e) {
            Button buttonClicked = (Button)e.getSource();
            System.out.println("Row: " + buttonRow + "Col: " + buttonCol);

            if(Gomoku.this.getTurn() && buttonClicked.getBackground().equals(new Background(emptySpace))){
                buttonClicked.setBackground(new Background(emptySpace, whitePiece));
            }
            else if(!Gomoku.this.getTurn() && buttonClicked.getBackground().equals(new Background(emptySpace))){
                buttonClicked.setBackground(new Background(emptySpace, blackPiece));
            }
            Gomoku.this.switchPlayer();
        }
    }

}
