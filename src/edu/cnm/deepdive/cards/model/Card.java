package edu.cnm.deepdive.cards.model;

public class Card implements Comparable<Card>{


  private final Suit suit;
  private final Rank rank;

  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  public Suit getSuit() {
    return suit;
  }

  public Rank getRank() {
    return rank;
  }

  @Override
  public String toString() {
    return rank.getSymbol() + suit.getSymbol();
  }

  @Override
  public int compareTo(Card other) {
    int comparison = suit.compareTo(other.suit);
    return comparison == 0 ? rank.compareTo(other.rank) : comparison;
  }
}
