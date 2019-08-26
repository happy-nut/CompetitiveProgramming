import java.util.Arrays;
import java.util.Scanner;

/**
 * https://atcoder.jp/contests/abc138/tasks/abc138_c
 */
public class ABC138C {

  private static double answer(int[] vs) {
    Arrays.sort(vs);
    double prev = 0;
    for (int v : vs) {
      if (prev == 0) {
        prev = v;
        continue;
      }

      prev = (prev + v) / 2;
    }

    return prev;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int[] vs = new int[N];
    for (int i = 0; i < N; i++) {
      vs[i] = scan.nextInt();
    }
    scan.close();

    System.out.println(answer(vs));
  }
}