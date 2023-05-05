package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    public char findFirstNonRepeatedCharacterWithHashMap(String str) {
        //this method finds the first non-repeated character from an unordered hashMap
        Map<Character, Integer> map = new HashMap<>();
        for (var ch: str.toCharArray()){ //iterates to all string characters from word str
            var count = map.containsKey(ch) ? map.get(ch) : 0;  //if a map contains the key, it gets the key, and it stores to var count so later on we will increment the value, otherwise the count will be set to zero
            //here I can use getOrDefault method e.g. map.getOrDefault(ch, 0); if it gets it returns the value of ch otherwise store will be 0
            map.put(ch, count+1); //it puts the character and counts the value by one
        }

        for (var ch: str.toCharArray()) //iteration through given String
                if(map.get(ch) == 1) return ch; //when a character from that string finds the first repeated character returns that char

        return Character.MIN_VALUE;
    }

    //returns the first repeated character
    public char findFirstRepeatedCharacterWithHashSet(String str){
        Set<Character> map = new HashSet<>();
//if a character is existed then means its repeated and returns the first repeated character, if its not then character added to Set

        for (var ch : str.toCharArray()){
            if(map.contains(ch)) return ch;
            else map.add(ch);
        }

        return Character.MIN_VALUE;
    }


}
