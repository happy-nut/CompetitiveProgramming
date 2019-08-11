import java.util.Scanner;

/**
 * https://atcoder.jp/contests/abc135/tasks/abc135_b
 */
public class ABC135B {

  private static boolean answer(long[] ps) {
    int count = 0;
    for (int i = 0; i < ps.length; i++) {
      if (ps[i] != i + 1) {
        count++;
      }
    }

    return count == 2 || count == 0;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    long[] ps = new long[n];
    for (int i = 0; i < n; i++) {
      ps[i] = scan.nextInt();
    }
    scan.close();

    if (answer(ps)) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
}
