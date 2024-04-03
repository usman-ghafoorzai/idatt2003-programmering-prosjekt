package edu.ntnu.idatt2003.view;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import edu.ntnu.idatt2003.controller.CardGameController;
import edu.ntnu.idatt2003.model.HandOfCards;
import edu.ntnu.idatt2003.model.PlayingCard;

public class CardGameView extends Scene {
  final CardGameController controller;
  private VBox root;
  private HBox cardContainer;
  private HBox textContainer;
  private HandOfCards hand;

  public CardGameView(CardGameController controller, Rectangle2D screenSizes) {
    super(controller.getRoot(), screenSizes.getWidth(), screenSizes.getHeight());
    this.controller = controller;
    root = (VBox) this.getRoot();
    setTopOfPage(root);
    this.controller.setRoot(root);
    createCardButtonLine(root);
    textContainer = new HBox(20);
    root.getChildren().add(textContainer);
  }

  private void setTopOfPage(VBox root) {
    Text title = new Text("Card Game");
    title.setFont(new Font(50));
    Separator separator = new Separator();
    separator.setPrefWidth(800);
    separator.setStyle("-fx-background-color: #000000");
    VBox vBox = new VBox();
    vBox.getChildren().addAll(
        title,
        separator
    );
    vBox.setAlignment(Pos.CENTER);
    root.getChildren().add(vBox);
  }

  private void createCardButtonLine(VBox root) {
    HBox cardButtonRow = new HBox(20);
    cardButtonRow.setMaxHeight(300);
    cardButtonRow.setPadding(new javafx.geometry.Insets(20));
    cardContainer = new HBox(20);
    for (int i = 0; i < 5; i++) {
      cardContainer.getChildren().add(new CardViewComponent("Not drawn").getCard());
    }
    cardButtonRow.getChildren().addAll(
        cardContainer,
        createButtons()
    );
    cardButtonRow.setAlignment(Pos.TOP_CENTER);
    root.getChildren().add(cardButtonRow);
  }

  private VBox createButtons() {
    VBox buttons = new VBox(20);
    buttons.setPadding(new javafx.geometry.Insets(20));
    Button dealButton = new Button("Deal hand");
    dealButton.setPrefSize(100, 50);
    dealButton.setOnAction(e -> controller.dealCards());
    Button checkHandButton = new Button("Check hand");
    checkHandButton.setOnAction(e -> controller.checkHand(hand));
    checkHandButton.setPrefSize(100, 50);
    buttons.getChildren().addAll(
        dealButton,
        checkHandButton
    );
    buttons.setAlignment(Pos.CENTER);
    return buttons;
  }

  public void setTextContainer(int sumOfFaces, boolean isFlush,
                               boolean hasQueenOfSpades, String cardsOfHeart) {
    textContainer.getChildren().clear();
    Text sumOfFacesText = new Text("Sum of faces: " + sumOfFaces);
    Text isFlushText = new Text("Flush: " + isFlush);
    Text hasQueenOfSpadesText = new Text("Queen of spades: " + hasQueenOfSpades);
    Text cardsOfHeartText = new Text("Cards of heart: " + cardsOfHeart);
    textContainer.getChildren().addAll(
        sumOfFacesText,
        isFlushText,
        hasQueenOfSpadesText,
        cardsOfHeartText
    );
  }

  public Scene getScene() {
    return this;
  }

  public void setCardContainer(HandOfCards cards) {
    this.hand = cards;
    cardContainer.getChildren().clear();
    for (PlayingCard card : cards.getHand()) {
      cardContainer.getChildren().add(new CardViewComponent(card.getAsString()).getCard());
    }
  }
}