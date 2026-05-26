package ru.zelmex.Clubs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class Clubs extends Application {
   public static Stage primaryStage;
   public static Scene amplua;

   @Override
   public void start(Stage stage) throws IOException {
       primaryStage = stage;
       amplua= createScene("main-view.fxml");
       primaryStage.setMinWidth(1200);
       primaryStage.setMinHeight(675);
       primaryStage.setTitle("Продажа футбольных игроков");
       amplua.getStylesheets().add("base-styles.css");
       primaryStage.setScene(amplua);
       primaryStage.show();
   }
   
   private Scene createScene(String name) throws IOException {
       FXMLLoader fxmlLoader = new FXMLLoader(Clubs.class.getResource(name));
       return new Scene(fxmlLoader.load());
   }
   
   public static void main(String[] args) {
      launch();
   }
}