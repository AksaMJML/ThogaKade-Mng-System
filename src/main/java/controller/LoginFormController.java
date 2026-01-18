package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public TextField txtUserName;
    public PasswordField txtPwd;

    public void btnLoginOnAction(ActionEvent actionEvent) {
        Stage stage = new Stage();

        String userName = txtUserName.getText();
        String password = txtPwd.getText();

        if (userName.equals("Aksa") && password.equals("1234")){
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.show();
            new Alert(Alert.AlertType.CONFIRMATION ).show();
        }else {
            new Alert(Alert.AlertType.ERROR).show();
            txtUserName.clear();
            txtPwd.clear();
        }
    }
}
