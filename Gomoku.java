package Project_Final;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Gomoku extends Application {

    private boolean turn = true;
    private int winRequirement;
    private int boardHeight;
    private int boardWidth;
    private Button[][] board;

    public void start(Stage primaryStage) {
        setBoardHeight(19);
        setBoardWidth(19);
        setWinRequirement(5);
        board = new Button[getBoardHeight()][getBoardWidth()];
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

    public Button[][] getBoard() {
        return board;
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
