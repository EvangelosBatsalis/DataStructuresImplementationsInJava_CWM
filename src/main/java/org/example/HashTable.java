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
            if(entry.key == key){
                entry.value = value;   //if iteration key equals to key parameter, then iteration value takes the value and updating it to iteration value
                return; //for stop running to the next lines
            }
        }
//        var entry = new EntryHashObject(key, value); //creating object wrap for key, value parameters
        entriesArrayOfArrayLists[indexStoring].add(new EntryHashObject(key, value)); //adding new object entry(creating insideOf arrayList instead of a new line)

    }

    public String get(int key){
        var indexStoring = hashFunction(key);  //running hash function, to find in what index hash function store the key previously
        if(entriesArrayOfArrayLists[indexStoring] != null){ //if we don't have a Linked list at this position (must be null) before iteration to the list.
            for(var entry : entriesArrayOfArrayLists[indexStoring] ){ //check all the entries of that position for the key and returns that key
                if(entry.key == key) {
                    return entry.value;
                }
            }
        }
        return null; //if it does not find anything, then it returns null
    }

    private int hashFunction(int key){
        return Math.abs(key) % entriesArrayOfArrayLists.length;
    }

    public void remove(int key){
        var indexStoring = hashFunction(key);
        if(entriesArrayOfArrayLists[indexStoring] == null) throw new IllegalStateException();  //if its null meaning doesnt have any antry so it will throw an exception, or I can customise to throw a message
        if(entriesArrayOfArrayLists[indexStoring] != null){ //if its no null
            for(var entry : entriesArrayOfArrayLists[indexStoring]){  //iteration to the indexing area to find the key
                if(entry.key == key){ //if the key is found
                    entriesArrayOfArrayLists[indexStoring].remove(entry);  //the list will be removed through linkedList remove method of that "iteration entry"
                    return;  //stops the iteration
                }
            }
        }
        throw new IllegalStateException(); //through new exception if the key was not found in my bucket list
    }
}
