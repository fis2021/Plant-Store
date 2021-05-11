package org.FIS2021.controllers;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.FIS2021.exceptions.UserNotFoundException;
import org.FIS2021.services.UserService;

import java.io.IOException;

public class LoginController {

    @FXML
    public Text loginMessage;
    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField usernameField;

    @FXML
    public void handleLoginAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username == null || username.isEmpty()) {
            loginMessage.setText("Please type in a username!");
            return;
        }

        if (password == null || password.isEmpty()) {
            loginMessage.setText("Password cannot be empty");
            return;
        }

        String encoded_password = UserService.encodePassword(username, password);

        try{
            String stored_password = UserService.getHashedUserPassword(username);
            if(stored_password.equals(encoded_password)){
               loginMessage.setText(String.format("Logged in as %s!", username));
                return;
            }

        } catch(UserNotFoundException e){
            loginMessage.setText(e.getMessage());
            return;
        }

        loginMessage.setText("Incorrect login!");
    }

    @FXML
    public void loadRegisterPage(){
        try {
            Stage stage = (Stage) loginMessage.getScene().getWindow();
            Parent registerRoot = FXMLLoader.load(getClass().getResource("/FXML/Register.fxml"));
            Scene scene = new Scene(registerRoot, 640, 800);
            stage.setTitle("Plant Store log in!");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
