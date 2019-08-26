import java.util.Scanner;

/**
 * https://atcoder.jp/contests/abc138/tasks/abc138_b
 */
public class ABC138B {

  private static double answer(int[] hs) {
    double d = 0.0;
    for (int h : hs) {
      d += 1.0 / h;
    }

    return 1.0 / d;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] as = new int[n];
    for (int i = 0; i < n; i++) {
      as[i] = scan.nextInt();
    }
    scan.close();

    System.out.println(answer(as));
  }
}
