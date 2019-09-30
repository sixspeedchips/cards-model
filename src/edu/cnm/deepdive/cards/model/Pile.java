package edu.cnm.deepdive.cards.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class Pile implements Iterable<Card>{

  private final List<Card> cards;



  public Pile() {
    cards = new LinkedList<>();
  }

  public void add(Card card) {
    cards.add(card);
  }

  public void clear() {
    cards.clear();
  }

  public int size() {
    return cards.size();
  }

  public Card deal(){
    if( cards.isEmpty() ){
      throw new NoSuchElementException();
    }

    Card card = cards.remove(0);
    return card;

  }


  public List<Card> deal(int n){
    List<Card> temp = new ArrayList<>();
    IntStream.range(0,n).forEach(i->{
      temp.add(this.deal());
    });
    return temp;
  }

  @Override
  public Iterator<Card> iterator() {
    return cards.iterator();
  }

  @Override
  public String toString() {
    return cards.toString();
  }
}
