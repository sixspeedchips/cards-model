package edu.cnm.deepdive.cards.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.IntStream;

public class Deck {


  private final List<Card> cards;
  private final List<Card> dealt;


  private Deck() {
    cards = new ArrayList<>();
    dealt = new ArrayList<>();
  }

  public static Deck newSingleSortedDeck(){
    Deck deck = new Deck();

    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        deck.cards.add(new Card(rank,suit));
      }
    }
    return deck;
  }

  public Card deal(){
    if( cards.isEmpty() ){
      throw new NoSuchElementException();
    }

    Card card = cards.remove(0);
    dealt.add(card);
    return card;

  }
  public void shuffle(Random rng){
    cards.addAll(dealt);
    Collections.shuffle(cards, rng);
    dealt.clear();
  }

  public void sort(){
    cards.addAll(dealt);
    dealt.clear();
    Collections.sort(cards);
  }

  public List<Card> deal(int n){
    List<Card> temp = new ArrayList<>();
    IntStream.range(0,n).forEach(i->{
      temp.add(this.deal());
    });
    return temp;
  }



  public List<Card> getCards() {
    return cards;
  }

  @Override
  public String toString() {
    return cards.toString();
  }
}
