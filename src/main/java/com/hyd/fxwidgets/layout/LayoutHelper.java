package com.hyd.fxwidgets.layout;

import java.util.Collections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public interface LayoutHelper {

    double[] NO_PADDING = {0, 0, 0, 0};

    default BorderPane borderPane(Node center) {
        return new BorderPane(center);
    }

    default Label label(String text) {
        Label label = new Label(text);
        label.setMinWidth(Region.USE_PREF_SIZE);
        return label;
    }

    default VBox vbox(double padding, double spacing, Node... children) {
        return vbox(new double[]{padding, padding, padding, padding}, spacing, children);
    }

    default VBox vbox(double[] padding, double spacing, Node... children) {
        VBox vBox = new VBox(children);
        vBox.setPadding(new Insets(padding[0], padding[1], padding[2], padding[3]));
        vBox.setSpacing(spacing);
        return vBox;
    }

    default HBox hbox(Pos alignment, double spacing, Node... children) {
        return hbox(alignment, NO_PADDING, spacing, children);
    }

    default HBox hbox(Pos alignment, double padding, double spacing, Node... children) {
        return hbox(alignment, new double[]{padding, padding, padding, padding}, spacing, children);
    }

    default HBox hbox(Pos alignment, double[] padding, double spacing, Node... children) {
        HBox hBox = new HBox(children);
        hBox.setPadding(new Insets(padding[0], padding[1], padding[2], padding[3]));
        hBox.setAlignment(alignment);
        hBox.setSpacing(spacing);
        return hBox;
    }

    default TextField textField() {
        return new TextField();
    }

    default PasswordField passwordField() {
        return new PasswordField();
    }

    default CssClass cssClass(String... values) {
        return new CssClass(values);
    }

    default CssStyleSheet cssStyleSheet(String... values) {
        return new CssStyleSheet(values);
    }

    default Button button(String text, CssClass cssClass, Runnable action) {
        Button button = new Button(text);
        button.getStyleClass().addAll(cssClass.get());
        button.setOnAction(e -> action.run());
        return button;
    }

    default Button button(String text, Runnable action) {
        return button(text, new CssClass(Collections.emptyList()), action);
    }

    default Scene scene(Parent root) {
        return scene(new CssStyleSheet(Collections.emptyList()), root);
    }

    default Scene scene(CssStyleSheet styleSheet, Parent root) {
        Scene scene = new Scene(root);
        scene.getStylesheets().addAll(styleSheet.get());
        return scene;
    }

    default MenuBar menuBar(Menu... menus) {
        return new MenuBar(menus);
    }

    default Menu menu(String text, MenuItem... items) {
        return new Menu(text, null, items);
    }

    default MenuItem menuItem(String text, Runnable action) {
        return menuItem(text, null, action);
    }

    default MenuItem menuItem(String text, String iconPath, Runnable action) {
        MenuItem menuItem = new MenuItem(text);
        if (iconPath != null) {
            Image image = new Image(LayoutHelper.class.getResourceAsStream(iconPath), 16, 16, true, true);
            menuItem.setGraphic(new ImageView(image));
        }
        if (action != null) {
            menuItem.setOnAction(e -> action.run());
        }
        return menuItem;
    }
}
