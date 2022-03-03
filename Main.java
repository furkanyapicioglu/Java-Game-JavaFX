package sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//150119724 MUSTAFA FURKAN YAPICIOGLU
//150119760 MUHAMMED ENSAR SANDIKCI
public class Main extends Application {
    private Stage primary;
    private Scene scene;
    private GridPane gridPane;
    private Button[] buttons;
    private final int MAXBUTTONS = 100;
    //THESE VARIABLES ADDED FOR CALCULATION OF COORDINATES CLICKED BUTTONS
    int points;
    int k;int u;int f;int v;int c;int d;int r;int p;int x;int y;int q;int z;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {
        //THESE FUNCTION IS GAME ENGINE,ANY TXT FILES WHICH INCLUDES (PROPERLY) GAME ORDER, WILL WORK.
        primary = arg0;
        gridPane = new GridPane();
        scene = new Scene(gridPane, 300, 300);
        buttons = new Button[MAXBUTTONS];
        //THESE TEXT AREA CREATED FOR SHOWING CLICKED BUTTONS,POINTS AND EFFECTED NEIGHBORS.
        TextArea textArea = new TextArea();
        Stage stagescores = new Stage();
        stagescores.setTitle("Scores");
        //WE ARE CREATING OUR GAME BOARD IN HERE
        for (int i = 0; i < MAXBUTTONS; i++) {
            buttons[i] = new Button();
            buttons[i].setPrefSize(100, 100);
            buttons[i].setStyle("-fx-border-color: black; -fx-border-width: 1px;");
            int finalI = i;
            EventHandler<ActionEvent> event = new EventHandler<>() {
                public void handle(ActionEvent e) {                                 //IN THIS FUNCTION THERE ARE IF STATEMENTS AND LEVEL1 TXT READING
                        if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;")) {
                        points = points + 2;
                    }
                    //THESE IF STATEMENT PART REFERS TO ALONE AND NO NEIGHBOR MIRROR TYPE***********************************
                    //**************************EMPTY-EMPTY-EMPTY-EMPTY***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points - 3;
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n" + "Points: " + points + "\n");
                                            }
                    //**************************WALL-WALL-WALL-WALL***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI - 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;")) {
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points - 3;
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n" + "Points: " + points + "\n");
                                            }
                    //**************************WALL-WALL-WALL-EMPTY***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI - 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points - 3;
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n" + "Points: " + points + "\n");
                                            }
                    //**************************WALL-WALL-EMPTY-EMPTY***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points - 3;
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n" + "Points: " + points + "\n");
                                            }
                    //**************************WALL-EMPTY-EMPTY-EMPTY***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points - 3;
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n" + "Points: " + points + "\n");
                                            }
                    //**************************EMPTY-EMPTY-EMPTY-WALL***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;")) {
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points - 3;
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n" + "Points: " + points + "\n");
                                            }
                    //**************************EMPTY-EMPTY-WALL-WALL***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;")) {
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points - 3;
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n" + "Points: " + points + "\n");
                                            }
                    //**************************EMPTY-WALL-WALL-WALL***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI - 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;")) {
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points - 3;
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n" + "Points: " + points + "\n");
                                            }
                    //**************************WALL-WALL-EMPTY-WALL***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;")) {
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points - 3;
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n" + "Points: " + points + "\n");
                                            }
                    //**************************WALL-EMPTY-WALL-EMPTY***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points - 3;
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n" + "Points: " + points + "\n");
                                            }
                    //**************************EMPTY-WALL-EMPTY-WALL***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;")) {
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points - 3;
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n" + "Points: " + points + "\n");
                                            }
                    //**************************WALL-EMPTY-EMPTY-WALL***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;")) {
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points - 3;
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n" + "Points: " + points + "\n");
                                            }
                    //**************************EMPTY-WALL-WALL-EMPTY***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI - 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points - 3;
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n" + "Points: " + points + "\n");
                                            }
                    //**************************EMPTY-EMPTY-WALL-EMPTY***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points - 3;
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n" + "Points: " + points + "\n");
                                            }
                    //**************************WALL-EMPTY-WALL-WALL***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;")) {
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points - 3;
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n" + "Points: " + points + "\n");
                                            }
                    //**************************EMPTY-WALL-EMPTY-EMPTY***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points - 3;
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n" + "Points: " + points + "\n");
                                            }
                    //THESE IF STATEMENT PART REFERS TO ALONE AND NO NEIGHBOR WOOD TYPE***********************************
                    //**************************EMPTY-EMPTY-EMPTY-EMPTY***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n" + "Points: " + points + "\n");
                    }
                    //**************************WALL-WALL-WALL-WALL***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI - 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;")) {
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n");
                    }
                    //**************************WALL-WALL-WALL-EMPTY***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI - 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n");
                    }
                    //**************************WALL-WALL-EMPTY-EMPTY***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n");
                    }
                    //**************************WALL-EMPTY-EMPTY-EMPTY***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n");
                    }
                    //**************************EMPTY-EMPTY-EMPTY-WALL***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;")) {
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n");
                    }
                    //**************************EMPTY-EMPTY-WALL-WALL***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;")) {
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n");
                    }
                    //**************************EMPTY-WALL-WALL-WALL***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI - 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;")) {
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n");
                    }
                    //**************************WALL-WALL-EMPTY-WALL***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;")) {
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n");
                    }
                    //**************************WALL-EMPTY-WALL-EMPTY***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n");
                    }
                    //**************************EMPTY-WALL-EMPTY-WALL***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;")) {
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n");
                    }
                    //**************************WALL-EMPTY-EMPTY-WALL***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;")) {
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n");
                    }
                    //**************************EMPTY-WALL-WALL-EMPTY***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI - 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n");
                    }
                    //**************************EMPTY-EMPTY-WALL-EMPTY***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n");
                    }
                    //**************************WALL-EMPTY-WALL-WALL***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI + 10].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;")) {
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n");
                    }
                    //**************************EMPTY-WALL-EMPTY-EMPTY***********************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-border-color: black; -fx-border-width: 1px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        k = finalI/10;
                        v = finalI%10;
                        textArea.appendText("Hitting Box: " + k + "," + v + "\n" + "No Neighbor\n");
                    }
                    //CLICKING WOOD BLOCK HITTING ALSO MIRROR BLOCK************************************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI - 1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points + 1;
                        x = finalI/10;
                        y = finalI%10;
                        c = (finalI+1)/10;
                        d = (finalI+1)%10;
                        textArea.appendText("Here is the Point: " + points + "\n" + "Clicked Box: " + x + "," + y + "\n" + "Hitting also: " + "[" + c + "," + d + "]\n");
                                            }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI + 1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points + 1;
                        x = finalI/10;
                        y = finalI%10;
                        c = (finalI+1)/10;
                        d = (finalI+1)%10;
                        textArea.appendText("Here is the Point: " + points + "\n" + "Clicked Box: " + x + "," + y + "\n" + "Hitting also: " + "[" + c + "," + d + "]\n");
                                            }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI - 10].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points + 1;
                        x = finalI/10;
                        y = finalI%10;
                        c = (finalI-10)/10;
                        d = (finalI-10)%10;
                        textArea.appendText("Here is the Point: " + points + "\n" + "Clicked Box: " + x + "," + y + "\n" + "Hitting also: " + "[" + c + "," + d + "]\n");
                                            }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI + 10].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points + 1;
                        x = finalI/10;
                        y = finalI%10;
                        c = (finalI+10)/10;
                        d = (finalI+10)%10;
                        textArea.appendText("Here is the Point: " + points + "\n" + "Clicked Box: " + x + "," + y + "\n" + "Hitting also: " + "[" + c + "," + d + "]\n");
                                            }
                    //*************************HERE IS THE FIVE BLOCK IF STATEMENT FOR MIRROR TYPE************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI - 1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI - 10].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 10].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points + 4;
                        x = finalI/10;
                        y = finalI%10;
                        c = (finalI+1)/10;
                        d = (finalI+1)%10;
                        r = (finalI-1)/10;
                        p = (finalI-1)%10;
                        u = (finalI-10)/10;
                        f = (finalI-10)%10;
                        q = (finalI+10)/10;
                        z = (finalI+10)%10;
                        textArea.appendText("Here is the Point: " + points + "\n" + "Clicked Box: " + x + "," + y + "\n" + "Hitting also: " + "[" + c + "," + d + "]"+ " and " + "[" + r + "," + p + "]"+ " and " + "[" + u + "," + f + "]"+ " and " + "[" + q + "," + z + "]\n");
                                            }
                    //*********************HERE IS THE FOUR BLOCK IF STATEMENT FOR MIRROR TYPE****************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI - 10].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 10].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points + 2;
                        x = finalI/10;
                        y = finalI%10;
                        c = (finalI+1)/10;
                        d = (finalI+1)%10;
                        r = (finalI-10)/10;
                        p = (finalI-10)%10;
                        u = (finalI-10)/10;
                        f = (finalI-10)%10;
                        textArea.appendText("Here is the Point: " + points + "\n" + "Clicked Box: " + x + "," + y + "\n" + "Hitting also: " + "[" + c + "," + d + "]"+ " and " + "[" + r + "," + p + "]"+ " and " + "[" + u + "," + f + "]\n");
                                            }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI - 10].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI - 1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 10].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points + 2;
                        x = finalI/10;
                        y = finalI%10;
                        c = (finalI-1)/10;
                        d = (finalI-1)%10;
                        r = (finalI-10)/10;
                        p = (finalI-10)%10;
                        u = (finalI+10)/10;
                        f = (finalI+10)%10;
                        textArea.appendText("Here is the Point: " + points + "\n" + "Clicked Box: " + x + "," + y + "\n" + "Hitting also: " + "[" + c + "," + d + "]"+ " and " + "[" + r + "," + p + "]"+ " and " + "[" + u + "," + f + "]\n");
                    }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI - 1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 10].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points + 2;
                        x = finalI/10;
                        y = finalI%10;
                        c = (finalI+1)/10;
                        d = (finalI+1)%10;
                        r = (finalI-1)/10;
                        p = (finalI-1)%10;
                        u = (finalI+10)/10;
                        f = (finalI+10)%10;
                        textArea.appendText("Here is the Point: " + points + "\n" + "Clicked Box: " + x + "," + y + "\n" + "Hitting also: " + "[" + c + "," + d + "]"+ " and " + "[" + r + "," + p + "]"+ " and " + "[" + u + "," + f + "]\n");
                    }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI - 1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI - 10].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points + 2;
                        x = finalI/10;
                        y = finalI%10;
                        c = (finalI+1)/10;
                        d = (finalI+1)%10;
                        r = (finalI-10)/10;
                        p = (finalI-10)%10;
                        u = (finalI-1)/10;
                        f = (finalI-1)%10;
                        textArea.appendText("Here is the Point: " + points + "\n" + "Clicked Box: " + x + "," + y + "\n" + "Hitting also: " + "[" + c + "," + d + "]"+ " and " + "[" + r + "," + p + "]"+ " and " + "[" + u + "," + f + "]\n");
                    }
//******************HERE IS THE THREE BLOCK IF STATEMENT OF MIRROR TYPE*******************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI + 1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI - 10].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points + 1;
                        x = finalI/10;
                        y = finalI%10;
                        c = (finalI+1)/10;
                        d = (finalI+1)%10;
                        r = (finalI-10)/10;
                        p = (finalI-10)%10;
                        textArea.appendText("Here is the Point: " + points + "\n" + "Clicked Box: " + x + "," + y + "\n" + "Hitting also: " + "[" + c + "," + d + "]"+ " and " + "[" + r + "," + p + "]\n");
                                            }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI + 1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 10].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points + 1;
                        x = finalI/10;
                        y = finalI%10;
                        c = (finalI+1)/10;
                        d = (finalI+1)%10;
                        r = (finalI+10)/10;
                        p = (finalI+10)%10;
                        textArea.appendText("Here is the Point: " + points + "\n" + "Clicked Box: " + x + "," + y + "\n" + "Hitting also: " + "[" + c + "," + d + "]"+ " and " + "[" + r + "," + p + "]\n");
                                            }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI - 1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 10].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points + 1;
                        x = finalI/10;
                        y = finalI%10;
                        c = (finalI-1)/10;
                        d = (finalI-1)%10;
                        r = (finalI+10)/10;
                        p = (finalI+10)%10;
                        textArea.appendText("Here is the Point: " + points + "\n" + "Clicked Box: " + x + "," + y + "\n" + "Hitting also: " + "[" + c + "," + d + "]"+ " and " + "[" + r + "," + p + "]\n");
                    }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI - 1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI - 10].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points + 1;
                        x = finalI/10;
                        y = finalI%10;
                        c = (finalI-1)/10;
                        d = (finalI-1)%10;
                        r = (finalI-10)/10;
                        p = (finalI-10)%10;
                        textArea.appendText("Here is the Point: " + points + "\n" + "Clicked Box: " + x + "," + y + "\n" + "Hitting also: " + "[" + c + "," + d + "]"+ " and " + "[" + r + "," + p + "]\n");
                    }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI - 10].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 10].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points + 1;
                        x = finalI/10;
                        y = finalI%10;
                        c = (finalI-10)/10;
                        d = (finalI-10)%10;
                        r = (finalI+10)/10;
                        p = (finalI+10)%10;
                        textArea.appendText("Here is the Point: " + points + "\n" + "Clicked Box: " + x + "," + y + "\n" + "Hitting also: " + "[" + c + "," + d + "]"+ " and " + "[" + r + "," + p + "]\n");
                    }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI - 1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points + 1;
                        x = finalI/10;
                        y = finalI%10;
                        c = (finalI-1)/10;
                        d = (finalI-1)%10;
                        r = (finalI+1)/10;
                        p = (finalI+1)%10;
                        textArea.appendText("Here is the Point: " + points + "\n" + "Clicked Box: " + x + "," + y + "\n" + "Hitting also: " + "[" + c + "," + d + "]"+ " and " + "[" + r + "," + p + "]\n");
                    }
                    //********************HERE IS THE TWO BLOCK IF STATEMENT FOR MIRROR TYPE******************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points - 1;
                        x = finalI/10;
                        y = finalI%10;
                        c = (finalI+1)/10;
                        d = (finalI+1)%10;
                        textArea.appendText("Here is the Point: " + points + "\n" + "Clicked Box: " + x + "," + y + "\n" + "Hitting also: " + "[" + c + "," + d + "]\n");
                    }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI - 10].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points - 1;
                        x = finalI/10;
                        y = finalI%10;
                        c = (finalI-1)/10;
                        d = (finalI-1)%10;
                        textArea.appendText("Here is the Point: " + points + "\n" + "Clicked Box: " + x + "," + y + "\n" + "Hitting also: " + "[" + c + "," + d + "]\n");
                    }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 10].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points - 1;
                        x = finalI/10;
                        y = finalI%10;
                        c = (finalI+10)/10;
                        d = (finalI+10)%10;
                        textArea.appendText("Here is the Point: " + points + "\n" + "Clicked Box: " + x + "," + y + "\n" + "Hitting also: " + "[" + c + "," + d + "]\n");
                    }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI - 1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        points = points - 1;
                        x = finalI/10;
                        y = finalI%10;
                        c = (finalI-1)/10;
                        d = (finalI-1)%10;
                        textArea.appendText("Here is the Point: " + points + "\n" + "Clicked Box: " + x + "," + y + "\n" + "Hitting also: " + "[" + c + "," + d + "]\n");
                    }
                    //*************************HERE IS THE FIVE BLOCK IF STATEMENT FOR WOOD TYPE************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI - 1].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 1].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI - 10].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 10].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                    }
                    //*********************HERE IS THE FOUR BLOCK IF STATEMENT FOR WOOD TYPE****************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI - 10].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 1].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 10].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                    }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI - 10].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI - 1].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 10].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                    }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI - 1].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 1].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 10].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                    }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI - 1].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 1].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI - 10].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                    }
                    //******************HERE IS THE THREE BLOCK IF STATEMENT OF WOOD TYPE*******************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI + 1].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI - 10].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                    }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI + 1].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 10].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                    }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI - 1].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 10].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                    }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI - 1].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI - 10].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                    }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI - 10].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 10].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                    }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI - 1].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 1].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                    }
                    //********************HERE IS THE TWO BLOCK IF STATEMENT FOR WOOD TYPE******************************
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 1].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 1].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                    }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 10].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI - 10].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                    }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI + 10].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI + 10].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                    }
                    if (buttons[finalI].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;") && buttons[finalI - 1].getStyle().equals("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;")) {
                        buttons[finalI].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[finalI - 1].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                    }
                }
            };
          buttons[i].setOnAction(event);        //WHEN PRESSED ANY BUTTON ON GAME BOARD, IT TAKES COMMAND FROM HERE
        }
//*********AGAIN SOME FOR LOOPS FOR MAKING GAME BOARD TO GET 10X10 MATRIX WHICH IS TOLD IN PDF.
        int buttonIndex = 0;
        for (int rowIndex = 0; rowIndex < 10; ++rowIndex) {
            for (int colIndex = 0; colIndex < 10; ++colIndex) {
                gridPane.add(buttons[buttonIndex], colIndex, rowIndex);
                ++buttonIndex;
            }
        }
        BufferedReader csvReader = new BufferedReader(new FileReader("level1.txt"));
        String row;
        ////////////LEVEL 1////////////////////
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            String row1;
            row1 = data[1];
            int re_row = Integer.parseInt(row1);
            String column1;
            column1 = data[2];
            int re_column = Integer.parseInt(column1);
            int accessing_buttons_calculation_level1 = re_column + re_row * 10;
            if (data[0].equals("Mirror")) {
                buttons[accessing_buttons_calculation_level1].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                buttons[accessing_buttons_calculation_level1].setDisable(false);

            }
            if (data[0].equals("Empty")) {
                buttons[accessing_buttons_calculation_level1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                buttons[accessing_buttons_calculation_level1].setDisable(false);

            }
            if (data[0].equals("Wood")) {
                buttons[accessing_buttons_calculation_level1].setStyle("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;");
                buttons[accessing_buttons_calculation_level1].setDisable(false);
            }
        }
        csvReader.close();
        primary.setTitle("Game BOX");
        primary.setScene(scene);
        primary.show();
        Scene scenenew = new Scene(textArea,200,150);
        stagescores.setX(915);
        stagescores.setY(160);
        stagescores.setScene(scenenew);
        stagescores.show();
        displayButton();
    }
    //FOR THESE PART, IDENTICAL BUTTONS WORKS FOR SAME AIM: GOING TO THE NEXT LEVEL
    private void displayButton() {
        Stage stage = new Stage();
        stage.setTitle("Next Levels");
        Button buttonlevel_2  = new Button("GO TO THE \nSECOND LEVEL");
        Button buttonlevel_3 = new Button("GO TO THE \nTHIRD LEVEL");
        Font font1 = Font.font("Courier New", FontWeight.BOLD, 16);
        buttonlevel_3.setStyle("-fx-background-color: RED; -fx-border-color: black; -fx-border-width: 5px;");
        buttonlevel_3.setFont(font1);
        Button buttonlevel_4 = new Button("GO TO THE \nFOURTH LEVEL");
        Font font2 = Font.font("Courier New", FontWeight.BOLD, 16);
        buttonlevel_4.setStyle("-fx-background-color: RED; -fx-border-color: black; -fx-border-width: 5px;");
        buttonlevel_4.setFont(font2);
        Button buttonlevel_5 = new Button("GO TO THE \nFIFTH LEVEL");
        Font font3 = Font.font("Courier New", FontWeight.BOLD, 16);
        buttonlevel_5.setStyle("-fx-background-color: RED; -fx-border-color: black; -fx-border-width: 5px;");
        buttonlevel_5.setFont(font3);
        Font font = Font.font("Courier New", FontWeight.BOLD, 16);
        buttonlevel_2.setStyle("-fx-background-color: RED; -fx-border-color: black; -fx-border-width: 5px;");
        buttonlevel_2.setFont(font);
        Label label = new Label("SORRY :( \n NO MORE LEVELS");
        label.setStyle("-fx-background-color: RED; -fx-border-color: black; -fx-border-width: 5px;");
        Font font4 = Font.font("Courier New", FontWeight.BOLD, 16);
        label.setFont(font4);
        EventHandler<ActionEvent> event = new EventHandler<>() {
            public void handle(ActionEvent e) {
                try {
                    nextLevel();   //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                } catch (IOException ioException) {                                                                      //                                            ^
                    ioException.printStackTrace();                                                                       //                                            ^
                }                                                                                                        //                                            ^
            }                                                                                                            //                                            ^
                                                                                                                        //IMPLYING LEVEL2 TO OUR GAME BOARD ^
            private void nextLevel() throws IOException {
                BufferedReader csvReader = new BufferedReader(new FileReader("level2.txt"));
                String row;
                for (int abc = 0; abc < MAXBUTTONS; abc++) {
                    buttons[abc].setStyle("-fx-border-color: black; -fx-border-width: 1px;");
                }
                ////////////LEVEL 2////////////////////
                while ((row = csvReader.readLine()) != null) {
                    String[] data = row.split(",");
                    String row1;
                    row1 = data[1];
                    int re_row = Integer.parseInt(row1);
                    String column1;
                    column1 = data[2];
                    int re_column = Integer.parseInt(column1);
                    int accessing_buttons_calculation_level1 = re_column + re_row * 10;
                    if (data[0].equals("Mirror")) {
                        buttons[accessing_buttons_calculation_level1].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[accessing_buttons_calculation_level1].setDisable(false);

                    }
                    if (data[0].equals("Empty")) {
                        buttons[accessing_buttons_calculation_level1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[accessing_buttons_calculation_level1].setDisable(false);

                    }
                    if (data[0].equals("Wood")) {
                        buttons[accessing_buttons_calculation_level1].setStyle("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[accessing_buttons_calculation_level1].setDisable(false);
                    }

                }
                Scene scene2 = new Scene(buttonlevel_3, 160, 120);
                //WE NEED DIFFERENT SCENES TO SHOW EVERY LEVEL
                //SO WE CREATED NEW SCENES
                stage.setScene(scene2);
                csvReader.close();

            }

        };
        EventHandler<ActionEvent> event1 = new EventHandler<>() {
            public void handle(ActionEvent e) {
                try {
                    nextLevel1();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            private void nextLevel1() throws IOException {
                BufferedReader csvReader = new BufferedReader(new FileReader("level3.txt"));          //AGAIN WE FOLLOW SAME PATH TO IMPLY LEVEL3 TO OUR GAME BOARD
                String row;
                for (int abc = 0; abc < MAXBUTTONS; abc++) {
                    buttons[abc].setStyle("-fx-border-color: black; -fx-border-width: 1px;");
                }
                ////////////LEVEL 3////////////////////
                while ((row = csvReader.readLine()) != null) {
                    String[] data = row.split(",");
                    String row1;
                    row1 = data[1];
                    int re_row = Integer.parseInt(row1);
                    String column1;
                    column1 = data[2];
                    int re_column = Integer.parseInt(column1);
                    int accessing_buttons_calculation_level1 = re_column + re_row * 10;
                    if (data[0].equals("Mirror")) {
                        buttons[accessing_buttons_calculation_level1].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[accessing_buttons_calculation_level1].setDisable(false);

                    }
                    if (data[0].equals("Empty")) {
                        buttons[accessing_buttons_calculation_level1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[accessing_buttons_calculation_level1].setDisable(false);

                    }
                    if (data[0].equals("Wood")) {
                        buttons[accessing_buttons_calculation_level1].setStyle("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[accessing_buttons_calculation_level1].setDisable(false);
                    }

                }
                Scene scene3 = new Scene(buttonlevel_4, 160, 120);
                stage.setScene(scene3);
                csvReader.close();
            }
        };
        EventHandler<ActionEvent> event2 = new EventHandler<>() {
            public void handle(ActionEvent e) {
                try {
                    nextLevel1();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            private void nextLevel1() throws IOException {
                BufferedReader csvReader = new BufferedReader(new FileReader("level4.txt"));
                String row;
                for (int abc = 0; abc < MAXBUTTONS; abc++) {
                    buttons[abc].setStyle("-fx-border-color: black; -fx-border-width: 1px;");
                }
                ////////////LEVEL 4////////////////////
                while ((row = csvReader.readLine()) != null) {
                    String[] data = row.split(",");
                    String row1;
                    row1 = data[1];
                    int re_row = Integer.parseInt(row1);
                    String column1;
                    column1 = data[2];
                    int re_column = Integer.parseInt(column1);
                    int accessing_buttons_calculation_level1 = re_column + re_row * 10;
                    if (data[0].equals("Mirror")) {
                        buttons[accessing_buttons_calculation_level1].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[accessing_buttons_calculation_level1].setDisable(false);

                    }
                    if (data[0].equals("Empty")) {
                        buttons[accessing_buttons_calculation_level1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[accessing_buttons_calculation_level1].setDisable(false);

                    }
                    if (data[0].equals("Wood")) {
                        buttons[accessing_buttons_calculation_level1].setStyle("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[accessing_buttons_calculation_level1].setDisable(false);
                    }

                }
                Scene scene3 = new Scene(buttonlevel_5, 160, 120);
                stage.setScene(scene3);
                csvReader.close();
            }
        };
        EventHandler<ActionEvent> event3 = new EventHandler<>() {
            public void handle(ActionEvent e) {
                try {
                    nextLevel1();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            private void nextLevel1() throws IOException {
                BufferedReader csvReader = new BufferedReader(new FileReader("level5.txt"));
                String row;
                for (int abc = 0; abc < MAXBUTTONS; abc++) {
                    buttons[abc].setStyle("-fx-border-color: black; -fx-border-width: 1px;");
                }
                ////////////LEVEL 5////////////////////
                while ((row = csvReader.readLine()) != null) {
                    String[] data = row.split(",");
                    String row1;
                    row1 = data[1];
                    int re_row = Integer.parseInt(row1);
                    String column1;
                    column1 = data[2];
                    int re_column = Integer.parseInt(column1);
                    int accessing_buttons_calculation_level1 = re_column + re_row * 10;
                    if (data[0].equals("Mirror")) {
                        buttons[accessing_buttons_calculation_level1].setStyle("-fx-background-color: cyan; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[accessing_buttons_calculation_level1].setDisable(false);

                    }
                    if (data[0].equals("Empty")) {
                        buttons[accessing_buttons_calculation_level1].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[accessing_buttons_calculation_level1].setDisable(false);

                    }
                    if (data[0].equals("Wood")) {
                        buttons[accessing_buttons_calculation_level1].setStyle("-fx-background-color: magenta; -fx-border-color: black; -fx-border-width: 2px;");
                        buttons[accessing_buttons_calculation_level1].setDisable(false);
                    }

                }
                Scene scene4 = new Scene(label, 160, 120);
                stage.setScene(scene4);
                csvReader.close();
            }
        };
        //PUTTING EVENT(CLICK COMMAND) TO BUTTONS
        //CREATING FIRST SCENE AND STAGE FOR NEXT LEVEL BUTTON
        buttonlevel_2.setOnAction(event);
        buttonlevel_3.setOnAction(event1);
        buttonlevel_4.setOnAction(event2);
        buttonlevel_5.setOnAction(event3);
        Scene scene1 = new Scene(buttonlevel_2,160,120);
        stage.setX(915);
        stage.setY(340);
        stage.setScene(scene1);
        stage.show();
    }
}