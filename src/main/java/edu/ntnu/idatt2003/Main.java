package edu.ntnu.idatt2003;

import javafx.application.Application;
import javafx.stage.Stage;
import edu.ntnu.idatt2003.controller.CardGameController;

public class Main extends Application {
  @Override
  public void start(Stage stage) {
    CardGameController controller = new CardGameController(stage);
    controller.startGame();
  }

  public static void main(String[] args) {
    launch();
  }
}