package org.example;

public class Array {
    private int[] arrayList;
    private int index;


    public Array(int size) {
        if (size == 0)
            throw new IllegalArgumentException();
        arrayList = new int[size];
    }

    //TODO print
    public void printArray() {
        for (int i = 0; i < index; i++) {
            System.out.println(arrayList[i]);
        }
    }

    //TODO insert
    public void insertArray(int data) {
        if (arrayList.length == index) {
            //create a new array (twice the size)
            int[] tempNewArray = new int[arrayList.length * 2];

            //copy all items to a new array Complexity = O(n)
            for (int i = 0; i < arrayList.length; i++) {
                tempNewArray[i] = arrayList[i];
            }

            //make temp Array (tempNewArray) to primary array(arrayList)
            arrayList = tempNewArray;
        }
        arrayList[index++] = data;
    }


    //TODO removeAt
    public void removeAtIndex(int userIndex) {
        if (userIndex < 0 || userIndex > index)
            throw new IllegalArgumentException();

        for (int i = userIndex; i < index; i++)
            arrayList[i] = arrayList[++i];

        index--;
    }


    //TODO indexOf
    public int indexOfArray(int indexOf) {

//        int returnValue = -1;

        for (int i = 0; i < index; i++)
            if (indexOf == arrayList[i])
                return i;

        return -1;
    }

    //TODO maxMethod
    public int max() {
        int largestNumber = arrayList[0];
        for (int i = 0; i < index; i++)
            if (arrayList[i] > largestNumber)
                largestNumber = arrayList[i];

        return largestNumber;
    }

    //TODO Array.intersect()
    public Array intersect(int[] intersectArray) {
        Array array = new Array(1);

        for (int i = 0; i < arrayList.length; i++) {
            for (int j = 0; j < intersectArray.length; j++) {
                if (arrayList[i] == intersectArray[j])
                    array.insertArray(arrayList[i]);
            }
        }


        array.printArray();
        return array;
    }

    //TODO Array.reverse()
    public void reverse() {
        int[] newTempArray = new int[index];

        int newIndex = 0;
        for (int i = index - 1; i >= 0; i--) {
            newTempArray[newIndex] = arrayList[i];
            newIndex++;
        }
        arrayList = newTempArray;
    }

    //FIXME Array.insertAt()
    public void insertAt(int userIndex, int newData) {
        int[] newTempArray = new int[arrayList.length + 1];

        if (userIndex < 0 || userIndex > index )
            throw new IllegalArgumentException();

        for (int i = 0; i < userIndex; i++) {
            newTempArray[i] = arrayList[i];
        }
        newTempArray[userIndex] = newData;
        for (int i = userIndex + 1; i < arrayList.length; i++) {
            newTempArray[i] = arrayList[i];
        }
        arrayList = newTempArray;
    }
}
