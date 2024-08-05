package mitratech.interview;
import java.util.*; 
import java.io.*;

class Primenumber {

  public static boolean Primes(int num) {
    if (num < 2) {
      return false;
    }
    if (num <= 65536) {
      for (int i = 2; i * i <= num; i++) {
        if (num % i == 0) {
          return false;
        }
      }
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    // Keep this function call here     
    Scanner s = new Scanner(System.in);
    int number = Integer.valueOf(s.nextLine());
    System.out.println(Primes(number));
  }
}
