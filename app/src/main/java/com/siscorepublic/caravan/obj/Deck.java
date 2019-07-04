package com.siscorepublic.caravan.obj;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Collections;


public class Deck {
    HashMap<Integer, HashMap<String, String>> deck;
    private final String[] SUITS = {"hearts", "diamonds", "clubs", "spades"};
    private final String[] RANKS = {"2","3","4","5","6","7","8","9","10","jack","queen","king","ace"};

    public Deck() {
        // Populate deck
        deck = new HashMap<>();
        int cardId = 1;
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
        if (!deck.isEmpty()) {
            int maxId = Collections.max(deck.keySet());
            int cardId = ThreadLocalRandom.current().nextInt(0, maxId + 1);
            while (!deck.containsKey(cardId)) {
                cardId = ThreadLocalRandom.current().nextInt(0, maxId + 1);
            }
            HashMap<String, String> card = deck.get(cardId);
            deck.remove(cardId);
            return card;
        } else {
            return new HashMap<String, String>(){
                {
                    put("none","none");
                }
            };
        }

    }
}
