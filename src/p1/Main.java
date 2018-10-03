package p1;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        if(args.length==0)  // checks for arguments

        {

            System.out.println("Missing File Name...");

            System.exit(0);

        }

        int size = getSize(args[0]); //gets the number size of the pairArray based on how many lines are in file
        int prime = findPrime(2 * size);  //Finds prime number larger than 2 * Size
        HashTable table = new HashTable(prime); //create the HashTable to store String and Value


        try {
            FileReader fileReader = new FileReader(args[0]);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                Pair pair = new Pair(line);
                if(pair.getNum() == null){      //handle searching

                    int hashValue = findhashVal(pair.getWord(), prime);
                    table.SearchLinearProbe(hashValue, pair, prime);

                }else {
                    int hashValue = findhashVal(pair.getWord(), prime);
                    table.createHashArray(hashValue,line);
                }
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


       // System.out.println("the size is " + size);
      //  System.out.println("Prime is " + prime);
     //   int hv = findhashVal("bruster", prime);
       // table.createHashArray(hv, "bruster 35");
        table.printArray();


    }

    private static int findPrime(int p) {
        if(p==0)

            return 2;

        if(p%2==0)

            p++;

        else

            p+=2;

        while(true)

        {

            if(isNoPrime(p)==1)

            {

                return p;

            }

            p+=2;

        }
    }

    private static int isNoPrime(int p) {
        for(int aa=3;aa<=Math.sqrt(p);aa+=2)

            if(p%aa==0)

                return 0;

        return 1;
    }

    private static int getSize(String file) throws IOException {

        BufferedReader bb= null;
        try {
            bb = new BufferedReader(new FileReader(file));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line;

        int n=0;

        while((line=bb.readLine())!=null)

        {

            n++;

        }

        bb.close();

        return n;

    }


    public static int findhashVal(String key, int p)   // Get Hash Value of each String

    {

        int hashVal=0;

        for(int j=0; j < key.length(); j++)

        {
            int Val = key.charAt(j);    //Using ASCII Values
            hashVal=(hashVal*26+Val)%p;

        }

        return hashVal;

    }




}
