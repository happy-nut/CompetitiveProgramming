import java.util.Scanner;

/**
 * https://atcoder.jp/contests/abc136/tasks/abc136_b
 */
public class ABC136B {

  private static int answer(int n) {
    int count = 0;
    count += Math.min(n, 9);
    if (n >= 100) {
      count += Math.min(n, 999) - 99;
    }
    if (n >= 10000) {
      count += Math.min(n, 99999) - 9999;
    }

    return count;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    scan.close();

    System.out.println(answer(n));
  }
}
