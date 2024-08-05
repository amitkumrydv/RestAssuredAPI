package mitratech.interview;
import java.util.*; 
import java.io.*;
import java.util.Arrays;

class SortAphabate {

  public static String AlphabetSoup(String str) {
    // code goes here  

char[] chars= str.toCharArray();

Arrays.sort(chars);

    return new String(chars);
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(AlphabetSoup(s.nextLine())); 
  }

}