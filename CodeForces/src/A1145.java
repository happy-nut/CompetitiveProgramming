import java.util.Arrays;
import java.util.Scanner;

public class A1145 {

  private static int answer(long[] ns) {
    long prev = ns[0];
    int len = ns.length;
    for (int i = 1; i < ns.length; i++) {
      if (prev > ns[i]) {
        long[] left = Arrays.copyOfRange(ns, 0, len / 2);
        long[] right = Arrays.copyOfRange(ns, ns.length / 2, ns.length);
        return Math.max(answer(left), answer(right));
      }
      prev = ns[i];
    }

    return len;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    long[] ns = new long[n];
    for (int i = 0; i < n; i++) {
      ns[i] = scan.nextInt();
    }

    System.out.println(answer(ns));
  }
}
