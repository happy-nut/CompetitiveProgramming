import kotlin.math.absoluteValue
import kotlin.math.sign

// https://leetcode.com/problems/reverse-integer/
// 정수 뒤집어서 출력. 뒤집었을 때 integer 범위를 넘는 오버플로우인 경우 0 을 출력해야한다.
// 32 bit signed integer 만 담을 수 있는 시스템이라고 가정한다. 즉 Long 같은 걸 못쓴다.

// 내 처음 풀이.
// 1. 오버플로우를 어떻게 탐지하지? -> 하나씩 빼서 뒤집어야겠다.
// 2. 기가 막히다. Int.MIN_VALUE.absoluteValue 는 오버플로우가 나서 내부적으로 Int.MIN_VALUE(즉, 음수) 를 그냥 리턴한다. 이게 말이 돼?
// 3. 양수는 1..9 이런식으로 범위 표시할 수 있지만 음수는  downTo를 써야 하네: -1 downTo -9
fun reverseInteger(x: Int): Int {
  var value: Int = x
  var result: Int = 0
  while (value != 0) {
    val pop = value % 10
    value /= 10
    result = result * 10 + pop

    if (value in 1..9 && result >= Integer.MAX_VALUE / 10) {
      if (result == Integer.MAX_VALUE / 10 && value <= Integer.MAX_VALUE % 10) {
        continue
      }
      return 0
    }

    if (value in -1 downTo -9 && result <= Integer.MIN_VALUE / 10) {
      if (result == Integer.MIN_VALUE / 10 && value >= Integer.MIN_VALUE % 10) {
        continue
      }
      return 0
    }
  }

  return result
}

// 한 줄로 짜버린 다른 사람 풀이. 음 로직 이해후 이해한 대로 구현해보니 이 사람 풀이와 똑같다.
// 0. 일단 Long 같은 자료형을 쓴 다른 사람들 풀이는 다 제꼈다.
// 1. 별로 좋은 코드는 아니다. 일단 x.absoluteValue 에서 x 가 MIN_VALUE 일 때 음수가 뒤집히게 된다.
// 이 음수 기호 때문에 intOrNull 이 null을 뱉는다. 만약 x.absoluteValue 가 MIN_VALUE 를 그대로 뱉지 않았으면 이 코드는 실패한다.
// 2. 그런데 string은 Kotlin에서 몇 비트를 차지하지? 32bit 안에서 아래 연산이 일어난다고 확신할 수 있나?
// 인코딩에 따라 다르겠지만, 기본적으로 문자열 길이만큼의 바이트 이상씩 차지한다. 즉 이 풀이도 32 bit signed integer 만 담을 수 있는 시스템에선 돌지
// 않는다.
fun reverseIntegerFromOthers(x: Int): Int {
  return x.sign * (x.absoluteValue.toString().reversed().toIntOrNull() ?: 0)
}
