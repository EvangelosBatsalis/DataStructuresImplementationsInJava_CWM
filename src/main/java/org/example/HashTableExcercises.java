package org.example;

import java.util.HashMap;
import java.util.Map;

public class HashTableExcercises {

    public int mostFrequent(int[] array){
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int items : array){
            if(map.containsKey(items)){
                map.put(items, ++count);
            }
            map.put(items, count);
        }

        int mostFrequentItems = 0;
        for(var items : map.keySet()){
            if(items.floatValue() > mostFrequentItems){
                mostFrequentItems = ma
            }
        }



    }

}
