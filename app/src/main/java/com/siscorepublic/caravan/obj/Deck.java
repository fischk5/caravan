package com.siscorepublic.caravan.obj;
import java.util.HashMap;
import java.util.Random;

public class Deck {
    HashMap<Integer, HashMap<String, String>> deck;
    private final String[] SUITS = {"hearts", "diamonds", "clubs", "spades"};
    private final String[] RANKS = {"2","3","4","5","6","7","8","9","10","jack","queen","king","ace"};

    public Deck() {
        // Populate deck
        deck = new HashMap<>();
        Integer cardId = 1;
        for (int i = 0; i < SUITS.length; i++) {
            for (int j = 0; j < RANKS.length; j++) {
                HashMap<String, String> entry = new HashMap<>();
                entry.put(RANKS[j], SUITS[i]);
                deck.put(cardId, entry);
                cardId++;
            }
        }
        deck.put(cardId, new HashMap<String, String>(){
            {
                put("joker","none");
            }
        });
    }

    public HashMap<String, String> draw() {
        Random rand = new Random();
        Integer id = rand.nextInt(deck.size())+1;
        HashMap<String, String> card = deck.get(id);
        deck.remove(id);
        return card;
    }
}
