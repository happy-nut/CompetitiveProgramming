import java.util.Scanner;

/**
 * https://atcoder.jp/contests/abc135/tasks/abc135_c
 */
public class ABC135C {

  private static long answer(long[] mons, long[] heroes) {
    long remain = mons[0];
    long sum = 0;
    for (int i = 0; i < heroes.length; i++) {
      long killed = Math.min(heroes[i], remain);
      long killed2 = Math.min(heroes[i] - killed, mons[i + 1]);
      remain = mons[i + 1] - killed2;
      sum += killed + killed2;
    }

    return sum;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    long[] mons = new long[n+1];
    long[] heroes = new long[n];
    for (int i = 0; i < n + 1; i++) {
      mons[i] = scan.nextInt();
    }
    for (int i = 0; i < n; i++) {
      heroes[i] = scan.nextInt();
    }
    scan.close();

    System.out.println(answer(mons, heroes));
  }
}
