package com.example.frontend;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    public void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Please enter username and password");
            errorLabel.setStyle("-fx-text-fill: #ff4c4c;");
            errorLabel.setVisible(true);
        } else {
            // TODO: Implement actual authentication logic here
            System.out.println("Login attempt: " + username);
            errorLabel.setText("Login successful!");
            errorLabel.setStyle("-fx-text-fill: #4caf50;");
            errorLabel.setVisible(true);
        }
    }

    @FXML
    public void handleSignup(ActionEvent event) {
        System.out.println("Navigate to Sign Up");
    }
}
