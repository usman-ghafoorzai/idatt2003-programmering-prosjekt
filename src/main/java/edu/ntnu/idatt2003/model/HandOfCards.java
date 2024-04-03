package edu.ntnu.idatt2003.model;

import java.util.List;

public class HandOfCards {
  private List<PlayingCard> hand;

  public HandOfCards(List<PlayingCard> hand) {
    this.hand = hand;
  }

  public int getSumOfFaces() {
    return hand.stream()
        .mapToInt(PlayingCard::getFace)
        .sum();
  }

  public boolean hasFlush() {
    char suit = hand.get(0).getSuit();
    return hand.stream()
        .allMatch(card -> card.getSuit() == suit);
  }

  public boolean hasQueenOfSpades() {
    return hand.stream()
        .anyMatch(card -> card.getAsString().equals("S12"));
  }

  public String getCardsOfHeartAsString() {
    String hearts = hand.stream()
        .filter(card -> card.getSuit() == 'H')
        .map(PlayingCard::getAsString)
        .reduce("", (s1, s2) -> s1 + " " + s2);
    if (hearts.isEmpty()) {
      return "No hearts";
    }
    return hearts;
  }

  public List<PlayingCard> getHand() {
    return hand;
  }
}