package edu.cnm.deepdive.cards.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {

  public static void main(String[] args) {

    Deck deck = Deck.newSingleSortedDeck();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    System.out.println(deck);
    System.out.println(gson.toJson(deck.getCards()));
    deck.shuffle(new Random());
    System.out.println(deck.deal(10));
    System.out.println("Shuffled");

    System.out.println(deck);

    Collections.sort(deck.getCards());
    System.out.println("Using Comparator");
    System.out.println(deck);
  }






}
