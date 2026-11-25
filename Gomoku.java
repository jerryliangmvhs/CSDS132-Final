package Project_Final;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Gomoku extends Application {

    private int turn;
    private int winRequirement;
    private int boardLength;
    private int boardWidth;

    public void start(Stage primaryStage) {

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void switchPlayer() {

    }

    public boolean FiveInARow(Button[][] board, int row, int col, int targetStreak) {
        return false;
    }

    public boolean fourFour(Button[][] board, int row, int col, int targetStreak) {
        return false;
    }

    public boolean threeThree(Button[][] board, int row, int col, int targetStreak) {
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
