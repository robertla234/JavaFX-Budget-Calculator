package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import java.util.Date;

public class Main extends Application {

    boolean SignedIn; //temp sign in indicator

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");
        BorderPane rootBPane = new BorderPane();
        SignedIn = false; //initial not-signed-in on open
        Functions func = new Functions();

        //pre-initialize of buttons for Sign In color change
        Button btnHome = Formatting.makeButton("Home");
        Button btnCalc = Formatting.makeButtonHidden("Tracker");

        //Main Scene Area setup
        //^--- Home ---
        VBox homePane = new VBox();
        homePane.setStyle("-fx-background-color: #ff0000");
        homePane.setAlignment(Pos.CENTER);
        homePane.setSpacing(0);
            //Welcome Display for Home
        Label welHomeLabel = new Label("Welcome To Home");
        welHomeLabel.setPadding(new Insets(5, 5, 5, 5));
        welHomeLabel.setStyle("-fx-background-color: #B3B3B3");
        homePane.setMargin(welHomeLabel, new Insets(5, 5, 25, 5));
            //Username Input
        TextField userN = Formatting.makeTextField("username");
        homePane.setMargin(userN, new Insets(5, 20, 5, 20));
            //Password Input
        TextField passW = Formatting.makeTextFieldPass();
        homePane.setMargin(passW, new Insets(5, 20,5, 20));
            //Sign In Button
        Button signInBtn = new Button("Sign In");
        homePane.setMargin(signInBtn, new Insets(5, 5, 5, 5));
        signInBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //TODO call verificiation of sign in to DB
                String username = userN.getText();
                String password = passW.getText();
                System.out.println(username + " " + password);
                SignedIn = true;
                btnCalc.setVisible(true);
            }
        });
        Button regisBtn = new Button("Register");
        homePane.setMargin(regisBtn, new Insets(5, 5, 5, 5));
        regisBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //TODO open new registration window
            }
        });
        homePane.getChildren().addAll(welHomeLabel, userN, passW, signInBtn);
            //add homePane to Center side
        rootBPane.setCenter(homePane);

        //^--- Entries ---
        BorderPane entryPane = new BorderPane();
        entryPane.setStyle("-fx-background-color: #00ff00");
            //Display Box for Current-In-Budget
        Label CalcSum = new Label();
        CalcSum.setMinHeight(20);
        CalcSum.setMinWidth(100);
        CalcSum.setStyle("-fx-padding: 10 10 10 10; -fx-background-color: #B3B3B3;");
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
        //dateColumn.setSortType(TableColumn.SortType.);
        for (int i = 0; i < func.getSize(); i++) {
            budgetEntries.getItems().add(func.getEntry(i));
        }
        CalcSum.setText(func.getTotal());
        entryPane.setCenter(budgetEntries);

        //Left Navbar Setup
        VBox navBar = new VBox();
        navBar.setPadding(new Insets(20, 10, 20, 10));
        navBar.setSpacing(10);
        navBar.setStyle("-fx-background-color: #3A3B3C;");
        //Buttons Home and Tracker made above
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
                if (SignedIn) rootBPane.setCenter(entryPane);
            }
        });


        Scene scene = new Scene(rootBPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


