package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        BorderPane borderPane = new BorderPane();

        //Left Navbar Setup
        VBox navBar = new VBox();
        navBar.setPadding(new Insets(20, 10, 20, 10));
        navBar.setSpacing(10);
        navBar.setStyle("-fx-background-color: #336699;");
        Button btnHome = makeButton("Home");
        Button btnCalc = makeButton("Calculator");
        navBar.getChildren().addAll(btnHome, btnCalc);
            //add navBar to Left side
        borderPane.setLeft(navBar);



        Scene scene = new Scene(borderPane, 400, 300);
        //primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private Button makeButton(String btnText) {
        Button btnMake = new Button(btnText);
        btnMake.setPrefSize(100, 20);
        return btnMake;
    }
}
