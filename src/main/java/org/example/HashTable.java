package org.example;

import java.util.LinkedList;
import java.util.List;

public class HashTable {
    private class EntryHashObject{ //private class creation for internal class usage it will store as object the keys and the values
        private int key;
        private String value;

        public EntryHashObject(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
    private LinkedList<EntryHashObject>[] entriesArrayOfArrayLists = new LinkedList[5];


    //TODO put(int k, value v)
    public void put(int key, String value){
        var indexStoring = hashFunction(key); //create hash function with key % length of the array (ex. 100 % 5 = 0)
        if(entriesArrayOfArrayLists[indexStoring] == null){ //if that entry is empty (null)
            entriesArrayOfArrayLists[indexStoring] = new LinkedList<>(); //new array list will be created to the array list
        }

//      iterate through linkList and find if an entry with the same value exists and update the value
        for(var entry : entriesArrayOfArrayLists[indexStoring]){
            if(entry.key == key) entry.value = value;   //if iteration key equals to key parameter,then iteration value takes the value and updating it to iteration value
            return; //for stop running to the next lines
        }
//        var entry = new EntryHashObject(key, value); //creating object wrap for key, value parameters
        entriesArrayOfArrayLists[indexStoring].addLast(new EntryHashObject(key, value)); //adding new object entry(creating insideOf arrayList instead of a new line)

    }

    public String get(int key){
        var indexStoring = hashFunction(key);  //possible hash storing value to the list
        for(var iteration : entriesArrayOfArrayLists[indexStoring]){
            if(iteration.key == key){
                return iteration.value;
            }
        }
    }

    private int hashFunction(int key){
        return Math.abs(key) % hashTableArrayOfLinkList.length;
    }

    public void remove(int k){
        for(var iteration : hashTableArrayOfLinkList){
            if(iteration.getK() == k){
                hashTableArrayOfLinkList.remove();
            }
        }
    }



    //get(k) : v
    //remove(k)
//    Colissions chain


}
