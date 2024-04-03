package edu.ntnu.idatt2003.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckOfCards {
  private final char[] suits = { 'S', 'H', 'D', 'C' };
  private final String[] ranks = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
  private List<String> cards;
  private Random random = new Random();

  public DeckOfCards() {
    cards = new ArrayList<>();
    for (char suit : suits) {
      for (String rank : ranks) {
        cards.add(suit + rank);
      }
    }
  }

  public List<String> dealHand(int n) {
    List<String> hand = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int index = random.nextInt(cards.size());
      hand.add(cards.remove(index));
    }
    return hand;
  }
}
