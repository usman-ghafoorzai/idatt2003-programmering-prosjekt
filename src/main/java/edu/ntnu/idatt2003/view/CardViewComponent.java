package edu.ntnu.idatt2003.view;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CardViewComponent {
  private final String cardName;
  private BorderPane card;

  public CardViewComponent(String cardName) {
    this.cardName = cardName;
    this.card = new BorderPane();
    styleCard();
  }

  private void styleCard() {
    card.setMaxWidth(200);
    card.setMinWidth(200);
    card.setMaxHeight(300);
    card.setMinHeight(300);
    Text cardText = new Text(cardName);
    cardText.setFont(new Font(20));
    card.setCenter(cardText);
    BorderStroke borderStroke = new BorderStroke(Color.BLACK,
        BorderStrokeStyle.SOLID,
        new CornerRadii(20),
        new BorderWidths(1));
    card.setBorder(new Border(borderStroke));
  }

  public BorderPane getCard() {
    return card;
  }
}