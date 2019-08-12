import java.util.Scanner;

/**
 * https://codeforces.com/contest/1200/problem/0
 */
public class A1200 {

  private static int[] rooms = new int[10];

  private static void answer(String memory) {
    for(char c : memory.toCharArray()) {
      if (c == 'L') {
        for (int i = 0; i < rooms.length; i++) {
          if (rooms[i] == 0) {
            rooms[i] = 1;
            break;
          }
        }
      } else if (c == 'R') {
        for (int i = rooms.length - 1; i >= 0; i--) {
          if (rooms[i] == 0) {
            rooms[i] = 1;
            break;
          }
        }
      } else {
        int room = Character.getNumericValue(c);
        rooms[room] = 0;
      }
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    String s = scan.next();
    scan.close();

    answer(s);
    StringBuilder ans = new StringBuilder();
    for (int room : rooms) {
      ans.append(room);
    }
    System.out.println(ans);
  }
}
