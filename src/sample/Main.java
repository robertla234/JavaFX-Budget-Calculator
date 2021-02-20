package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Box;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

import java.util.Date;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");
        BorderPane rootBPane = new BorderPane();


        //Main Scene Area setup
        //^--- Home ---
            //Welcome Display for Home
        StackPane homePane = new StackPane();
        homePane.setStyle("-fx-background-color: #ff0000");
        Label welHomeLabel = new Label("Welcome To Home");
        welHomeLabel.setPadding(new Insets(10, 10, 10, 10));
        welHomeLabel.setStyle("-fx-background-color: #B3B3B3");
        homePane.getChildren().add(welHomeLabel);
            //add homePane to Center side
        rootBPane.setCenter(homePane);

        //^--- Entries ---
        BorderPane entryPane = new BorderPane();
        entryPane.setStyle("-fx-background-color: #00ff00");
            //Display Box for Current-In-Budget
        Box CalcSum = new Box();
        CalcSum.setHeight(20);
        CalcSum.setWidth(100);
        CalcSum.setStyle("-fx-padding: 10 10 10 10;");
        entryPane.setTop(CalcSum);
        entryPane.setMargin(CalcSum, new Insets(10));
        entryPane.setAlignment(CalcSum, Pos.CENTER);
            //Entry Table for Calc
        TableView budgetEntries = new TableView();
        TableColumn<BudgetEntry, Date> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        TableColumn<BudgetEntry, Integer> amountColumn = new TableColumn<>("Amount");
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        budgetEntries.getColumns().add(dateColumn);
        budgetEntries.getColumns().add(amountColumn);
        budgetEntries.getItems().add(new BudgetEntry(new Date(), 300));
        budgetEntries.getItems().add(new BudgetEntry(new Date(), -200));
        entryPane.setCenter(budgetEntries);

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
        btnHome.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                rootBPane.setCenter(homePane);
            }
        });
        btnCalc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                rootBPane.setCenter(entryPane);
            }
        });


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


