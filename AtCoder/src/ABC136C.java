import java.util.Scanner;

/**
 * https://atcoder.jp/contests/abc136/tasks/abc136_c
 */
public class ABC136C {

  private static void answer(long[] hs) {
    if (hs.length <= 1) {
      System.out.println("Yes");
      return;
    }

    long prev = hs[0] - 1;
    for (int i = 1; i < hs.length; i++) {
      long h = hs[i];
      if (prev < h) {
        prev = h - 1;
      }

      if (prev > h) {
        System.out.println("No");
        return;
      }
    }

    System.out.println("Yes");
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    long[] hs = new long[n];
    for (int i = 0; i < n; i++) {
      hs[i] = scan.nextLong();
    }
    scan.close();

    answer(hs);
  }
}
