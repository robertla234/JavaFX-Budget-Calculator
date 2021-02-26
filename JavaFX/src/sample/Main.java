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
        Button btnProfile = Formatting.makeButtonHidden("Profile");

        //Main Scene Area setup
        //^--- Home ---
        VBox homePane = new VBox();
        homePane.setStyle("-fx-background-color: #ff0000");
        homePane.setAlignment(Pos.CENTER);
        homePane.setSpacing(0);
            //Welcome Display for Home
        Label welHomeLabel = Formatting.makeLabel("Welcome To Home");
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
                btnProfile.setVisible(true);
            }
        });
        Button regisBtn = Formatting.makeButton("Register");
        homePane.setMargin(regisBtn, new Insets(5, 5, 5, 5));
        regisBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //TODO open new registration window
                Stage newWindow = new Stage();

                VBox regLayout = new VBox();
                regLayout.setStyle("-fx-background-color: #af00af");
                regLayout.setAlignment(Pos.CENTER);
                regLayout.setSpacing(0);

                Label regWelcome = Formatting.makeLabel("Register New User");
                regLayout.setMargin(regWelcome, new Insets(5, 5, 25, 5));

                TextField userN = Formatting.makeTextField("username");
                regLayout.setMargin(userN, new Insets(5, 20, 5, 20));

                TextField passW = Formatting.makeTextFieldPass();
                regLayout.setMargin(passW, new Insets(5, 20, 5, 20));

                TextField name = Formatting.makeTextField("Full Name");
                regLayout.setMargin(name, new Insets(5, 20, 5, 20));

                TextField initialAmount = Formatting.makeTextField("initial amount");
                regLayout.setMargin(initialAmount, new Insets(5, 20, 5, 20));

                Button regisBtn = Formatting.makeButton("Register");
                regLayout.setMargin(regisBtn, new Insets(5, 5, 5, 5));
                regisBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        //TODO import action here
                        newWindow.close();
                    }
                });

                        regLayout.getChildren().addAll(regWelcome, name, userN, passW, initialAmount, regisBtn);
                Scene regScene = new Scene(regLayout, 300, 250);

                //New Window (Stage)

                newWindow.setTitle("Register New User");
                newWindow.setScene(regScene);
                newWindow.show();
            }
        });
        homePane.getChildren().addAll(welHomeLabel, userN, passW, signInBtn, regisBtn);
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

        //^--- Profile ---
        VBox profilePane = new VBox();
        profilePane.setStyle("-fx-background-color: #0000ff");
        profilePane.setAlignment(Pos.CENTER);
        profilePane.setSpacing(0);
            //Name Label
        Label nameLabel = Formatting.makeLabel("NAME");
        profilePane.setMargin(nameLabel, new Insets(5, 5, 5, 5));
            //Username Label
        Label userLabel = Formatting.makeLabel("username");
        profilePane.setMargin(userLabel, new Insets(5, 5, 5, 5));
        profilePane.getChildren().addAll(nameLabel, userLabel);


        //Left Navbar Setup
        VBox navBar = new VBox();
        navBar.setPadding(new Insets(20, 10, 20, 10));
        navBar.setSpacing(10);
        navBar.setStyle("-fx-background-color: #3A3B3C;");
        //Buttons Home and Tracker made above
        navBar.getChildren().addAll(btnHome, btnCalc, btnProfile);
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
        btnProfile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) { if (SignedIn) rootBPane.setCenter(profilePane); }
        });


        Scene scene = new Scene(rootBPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


