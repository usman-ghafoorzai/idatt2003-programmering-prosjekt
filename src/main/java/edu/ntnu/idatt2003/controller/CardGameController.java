package edu.ntnu.idatt2003.controller;

import javafx.geometry.Rectangle2D;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import edu.ntnu.idatt2003.model.DeckOfCards;
import edu.ntnu.idatt2003.model.HandOfCards;
import edu.ntnu.idatt2003.view.CardGameView;

public class CardGameController {
  private CardGameView view;
  private VBox root;

  public CardGameController(Stage stage) {
    this.root = new VBox();
    Rectangle2D primaryScreenBounds = javafx.stage.Screen.getPrimary().getVisualBounds();
    this.view = new CardGameView(this, primaryScreenBounds);
    stage.setScene(view.getScene());
    stage.setTitle("Card Game");
    stage.show();
  }

  public void setRoot(VBox root) {
    this.root = root;
  }
  public VBox getRoot() {
    return root;
  }

  public void startGame() {
    dealCards();
  }

  public void dealCards() {
    DeckOfCards deck = new DeckOfCards();
    this.view.setCardContainer(new HandOfCards(deck.dealHand(5)));
  }

  public void checkHand(HandOfCards hand) {
    int sumOfFaces = hand.getSumOfFaces();
    boolean hasFlush = hand.hasFlush();
    boolean hasQueenOfSpades = hand.hasQueenOfSpades();
    String cardsOfHeartAsString = hand.getCardsOfHeartAsString();
    this.view.setTextContainer(sumOfFaces, hasFlush, hasQueenOfSpades, cardsOfHeartAsString);
  }
}