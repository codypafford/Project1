package p1;

import java.util.ArrayList;
import java.util.Arrays;

public class HashTable {


    private final String[] hashArray;

    public HashTable(int primeSize){
        
       hashArray = new String[primeSize];  // will store the Strings in the correct location after hashing

    }

    void createHashArray(int hashValue, String line) {  //The Insertion
        int probe;
        ArrayList<Integer> collisionTracker = new ArrayList<>();

        if (hashArray[hashValue] == null) { //if location is empty

            hashArray[hashValue] = line;


            probe = -1;
            System.out.println("Storing " + hashArray[hashValue] + ":");   //used to say pairArray[counter] instead
            System.out.println("\t" + hashArray[hashValue] + " stored at location: " + hashValue);

        }  else {

            if (hashValue == (hashArray.length - 1)){    // Checks if it is the end of the array

                probe = 0;     // moves the probing index to the beginning

            } else{
                probe = hashValue + 1;   // If not the end of array, add one because its Linear Probing!
            }

        }

        while ( (probe != -1) && (probe != hashValue) ) {    // probe cannot equal hashValue because of next else
            //statement
            if (hashArray[probe] == null) {

                hashArray[probe] = line;
                System.out.println("Storing " + hashArray[probe] + ":");   //Originally pairArray[counter]
                System.out.println("\tCollision at " + hashValue);
                if(collisionTracker != null){
                    for(Integer number : collisionTracker){
                        System.out.println("\tCollision at " + number);
                    }
                }
                System.out.println("\t" + hashArray[probe] + " stored at location: " + probe);
                probe = -1;


            } else {

                if (probe == (hashArray.length - 1)) {     // Checks if it is the end of the array

                    probe = 0;

                } else {
                    collisionTracker.add(probe);
                    probe++;    // increments index because Linear Probing!
                }

            }
        }
    }

    void SearchLinearProbe(int hashValue, Pair pair, int prime) {    //The Search
                                                                   // pair = The Pair made from each new Line
        while (hashArray[hashValue] != null)
        {
            Pair p = new Pair(hashArray[hashValue]);

            if (p.getWord().equals(pair.getWord())) {

                System.out.println(pair.getWord() + " found at location: " + hashValue);
                return;

            }

            hashValue = (hashValue + 1) % (prime);



        }

        if(!pair.unrecognized) {
            System.out.println("ERROR: " + pair.getWord() + " could not be found");
        }
    }

    void printArray(){
        System.out.println(Arrays.toString(hashArray));
    }


    
}
