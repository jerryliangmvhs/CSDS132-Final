package Project_Final;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
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
    private GameMove gameMove;

    public void start(Stage primaryStage) {
        setBoardHeight(19);
        setBoardWidth(19);
        setWinRequirement(5);
        pieces = new Button[getBoardHeight()][getBoardWidth()];
        gui = new BorderPane();
        board = new GridPane();
        gameMove = new GameMove();

        for(int row = 0; row < pieces.length; row++) {
            for(int col = 0; col < pieces[row].length; col++) {
                pieces[row][col] = new Button();
                pieces[row][col].setMinSize(10,10);
                pieces[row][col].setPrefSize(30,30);
                pieces[row][col].setMaxSize(50,50);
                pieces[row][col].setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, new Insets(0.5))));
                pieces[row][col].setOnAction(gameMove);
                board.add(pieces[row][col],row+1,col+1);
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
        public void handle(ActionEvent e) {

        }
    }

}
