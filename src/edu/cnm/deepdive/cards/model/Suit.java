package edu.cnm.deepdive.cards.model;

public enum Suit {

  CLUBS(),
  DIAMONDS(),
  HEARTS(),
  SPADES();

  private static final String [] SYMBOLS = {"\u2663","\u2662","\u2661","\u2660"};

  public String getSymbol(){

    return SYMBOLS[ordinal()];
  }

  public Color getColor(){
    return (ordinal() % 3 == 0) ? Color.BLACK : Color.RED;
  }
  public enum Color{
    BLACK,
    RED
  }



}
