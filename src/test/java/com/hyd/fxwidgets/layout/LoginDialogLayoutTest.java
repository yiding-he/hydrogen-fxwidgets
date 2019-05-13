package com.hyd.fxwidgets.layout;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginDialogLayoutTest extends LayoutHelperApplication {

    private TextField txtUserName;

    private PasswordField txtPassword;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(scene(
            cssStyleSheet("/login.css"), root()
        ));
        stage.setResizable(false);
        stage.show();
    }

    private Parent root() {
        return vbox(new double[]{30, 50, 30, 50}, 10,
            vbox(0, 3,
                label("用户名："), txtUserName = textField()),
            vbox(0, 3,
                label("密码："), txtPassword = passwordField()),
            hbox(Pos.CENTER, 10, 10,
                button("登录", cssClass("login-button"), this::loginClicked))
        );
    }

    private void loginClicked() {
        System.out.println("User " + txtUserName.getText() + " tries to login.");
    }
}
