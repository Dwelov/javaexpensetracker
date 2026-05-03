package com.example.frontend;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField ;

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
        } else if ("admin".equals(username) && "admin".equals(password)) {
            // Authentication successful, navigate to Dashboard
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-view.fxml"));
                Parent root = loader.load();
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 1000, 700); // Set dashboard dimensions
                stage.setScene(scene);
                stage.setTitle("Expense Tracker — Dashboard");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                errorLabel.setText("Error loading dashboard");
                errorLabel.setStyle("-fx-text-fill: #ff4c4c;");
                errorLabel.setVisible(true);
            }
        } else {
            // Authentication failed
            errorLabel.setText("Invalid username or password");
            errorLabel.setStyle("-fx-text-fill: #ff4c4c;");
            errorLabel.setVisible(true);
        }
    }

    @FXML
    public void handleSignup(ActionEvent event) {
        System.out.println("Navigate to Sign Up");
    }
}
