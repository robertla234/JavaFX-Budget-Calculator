package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");
        BorderPane rootBPane = new BorderPane();

        //Left Navbar Setup
        VBox navBar = new VBox();
        navBar.setPadding(new Insets(20, 10, 20, 10));
        navBar.setSpacing(10);
        navBar.setStyle("-fx-background-color: #3A3B3C;");
        Button btnHome = makeButton("Home");
        Button btnCalc = makeButton("Calculator");
        navBar.getChildren().addAll(btnHome, btnCalc);
            //add navBar to Left side
        rootBPane.setLeft(navBar);

        //Main Scene Area setup
        //--- Home ---
        StackPane homePane = new StackPane();
        //VBox homePane = new VBox();
        homePane.setStyle("-fx-background-color: #ff0000");
        //Label welHomeLabel = new Label("Welcome to Home");
        Label welHomeLabel = new Label("Welcome To Home");
        welHomeLabel.setPadding(new Insets(10, 10, 10, 10));
        welHomeLabel.setStyle("-fx-background-color: #B3B3B3");
        homePane.getChildren().add(welHomeLabel);
            //add homePane to Center side
        rootBPane.setCenter(homePane);

        Scene scene = new Scene(rootBPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private Button makeButton(String btnText) {
        Button btnMake = new Button(btnText);
        btnMake.setPrefSize(100, 20);
        btnMake.setStyle("-fx-focus-color: transparent");
        btnMake.setOnMouseEntered(e ->
                btnMake.setStyle(
                        "-fx-background-color: #ffffff"));
        btnMake.setOnMouseExited(e ->
                btnMake.setStyle(
                        "-fx-backgroud-color: #3A3B3C; -fx-focus-color: transparent"));
        return btnMake;
    }
}
