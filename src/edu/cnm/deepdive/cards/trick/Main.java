package edu.cnm.deepdive.cards.trick;

import edu.cnm.deepdive.cards.model.Card;
import edu.cnm.deepdive.cards.model.Deck;
import edu.cnm.deepdive.cards.model.Pile;
import edu.cnm.deepdive.cards.model.Suit.Color;
import java.security.SecureRandom;
import java.util.NoSuchElementException;
import java.util.Random;

public class Main {

  public static void main(String[] args) {

    Deck deck = Deck.newSingleSortedDeck();
    Pile left = new Pile();
    Pile right = new Pile();

    Random rng = new SecureRandom();
    deck.shuffle(rng);

      try {
        while (true){
          Card selector = deck.deal();

          if(selector.getSuit().getColor() == Color.BLACK){
            left.add(deck.deal());
          }
          else {
            right.add(deck.deal());
          }
        }
      } catch (NoSuchElementException expected){ }

    int upperLimit = Math.min(left.size(), right.size());
    int trade = rng.nextInt(upperLimit+1);

    for (int i = 0; i < trade; i++) {
      left.add(right.deal());
      right.add(left.deal());
    }
    int blackCount = 0;
    int redCount = 0;
    for (Card card : left) {
      if (card.getSuit().getColor()==Color.BLACK) {
        blackCount++;
      }
    }
    for (Card card : right) {
      if (card.getSuit().getColor()==Color.RED) {
        redCount++;
      }
    }
    System.out.printf("Left pile: %s black cards = %d%n", left, blackCount);
    System.out.printf("Right pile: %s red cards = %d%n", right, redCount);
  }


}
