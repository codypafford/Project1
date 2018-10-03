# Project1
Hashing
i. Purpose of the project: To implement a symbol table that will be used by the assembler during pass 1 and pass 2. The “main” will read a file name off of the command line. Implemented using a hash table.

ii. Source File: Main.java Pair.java HashTable.java

iii. Input File: A file read from the command line. The program reads each line looking for a String or a String and an Int. If the line has an Int, then it will store the String and its Value in the appropriate index found by hashing. If the line has just a String, then it will search for that String in the Hash Array.

iv. Output: The output will be to the console. It will print the location that the String and Value were stored at if successful. It will produce an error if an unrecognized input has been read. The program also reports all collisions prior to finding its final resting place. 

v. To execute the project: Step 1: Run make
Step 2: java -cp src p1.Main file1.txt
