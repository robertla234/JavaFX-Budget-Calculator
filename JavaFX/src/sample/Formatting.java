package sample;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

class Formatting {
    public static Button makeButton(String btnText) {
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

    public static Button makeButtonHidden(String btnText){
        Button btnHidden = makeButton(btnText);
        btnHidden.setVisible(false);
        return btnHidden;
    }

    public static TextField makeTextField(String txtflText){
        TextField txtflMake = new TextField();
        txtflMake.setPromptText(txtflText);
        return txtflMake;
    }

    public static TextField makeTextFieldPass(){
        PasswordField txtflPass = new PasswordField();
        txtflPass.setPromptText("password");
        return txtflPass;
    }
}
