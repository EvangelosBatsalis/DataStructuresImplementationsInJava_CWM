package org.example;

import java.util.LinkedList;

public class HashTable {
    private class HashTableEntry{ //private class creation for internal class usage it will store as object the keys and the values
        private int key;
        private String value;

        public HashTableEntry(int key, String value) {
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
    LinkedList<HashTableEntry>[] hashTableArrayOfLinkList = new LinkedList[5];


    //put(k,v)
    public void put(int key, String value){
        var index = hashFunction(key);


        hashTableArrayOfLinkList.add(new HashTableEntry(k,v));
    }
    public String get(int key){
        for(var iteration : hashTableArrayOfLinkList){
            if(iteration.getK() == k){
                return iteration.getV();
            }
        }
        return "Not found";
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
