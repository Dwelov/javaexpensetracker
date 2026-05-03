package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;


public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    @FXML private void  handleLogin(ActionEvent e){
        String userName = usernameField.getText();
        String passWord = passwordField.getText();

        System.out.println("Username: " + userName);
        System.out.println("Password: " + passWord);
    }


}
