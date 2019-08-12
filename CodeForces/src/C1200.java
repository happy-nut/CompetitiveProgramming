import java.util.Scanner;

/**
 * https://codeforces.com/contest/1200/problem/C
 */
public class C1200 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    long n = scan.nextLong();
    long m = scan.nextLong();
    int q = scan.nextInt();

    long r = 1;
    long t1 = n;
    long t2 = m;
    if (m > n) {
      t1 = m;
      t2 = n;
    }
    while (r > 0) {
      r = t1 % t2;
      t1 = t2;
      t2 = r;
      // 최대 공약수가 공통 벽 개수
      long nt1 = n / t1;
      long mt1 = m / t1;

      for (int i = 0; i < q; i++) {
        int sx = scan.nextInt();
        long sy = scan.nextLong();
        int ex = scan.nextInt();
        long ey = scan.nextLong();

        if (sx == 1) {
          sy *= m / t1;
        } else {
          sy *= n / t1;
        }
        sy--;
        if (ex == 1) {
          ey *= m / t1;
        } else {
          ey *= n / t1;
        }
        ey--;
        long x = (ey / nt1) / mt1;
        long y = (sy / nt1) / mt1;
        if (x == y) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }
      }
      scan.close();
    }
  }
}