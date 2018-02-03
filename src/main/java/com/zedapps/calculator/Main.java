package com.zedapps.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Shamah M Zoha
 * @since 02-Feb-18
 */
public class Main extends Application {

    private static final String APP_TITLE = "Calculator 1.0 by ZedApps";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent layout = FXMLLoader.load(getClass().getResource("/view/calc_view.fxml"));

        Scene layoutHolder = new Scene(layout, 300, 400);
        layoutHolder.getStylesheets().add(getClass().getResource("/css/view.css").toExternalForm());

        setupStage(primaryStage, layoutHolder);
        primaryStage.show();
    }

    private void setupStage(Stage primaryStage, Scene layoutHolder) {
        primaryStage.setTitle(APP_TITLE);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        primaryStage.setScene(layoutHolder);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
