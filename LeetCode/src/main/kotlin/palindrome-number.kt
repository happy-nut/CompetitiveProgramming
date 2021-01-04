import java.util.*
import kotlin.math.log10

// https://leetcode.com/problems/palindrome-number/
// string 으로 변환하지 말고 풀어볼래? 라고 한다.

// 내 처음 풀이.
// 1. log10 은 kotlin.math 안에 있다.
// 2. string 으로 변환해서 풀려면 간단하다. x.toString().reversed() === x.toString() 하면 됨.
// 3. Stack 은 java.util 패키지에 있음.
fun isPalindrome(x: Int): Boolean {
  if (x < 0) {
    return false
  }

  val n = log10(x.toDouble()).toInt() + 1
  val stack = Stack<Int>()
  var target = x
  for (i in 0 until n / 2) {
    stack.push(target % 10)
    target /= 10
  }
  if (n % 2 == 1) {
    target /= 10
  }
  for (i in 0 until n / 2) {
    if (target % 10 != stack.pop()) {
      return false
    }
    target /= 10
  }

  return true
}

// 다른 사람 풀이 중에 reversed integer 가 있었다.
// 1. 음 왜 이 생각을 못했지? 어떻게 하면 이런 생각을 바로 떠올릴 수 있지..
fun isPalindromeFromOthers(x: Int): Boolean {
  if (x < 0) {
    return false
  }

  var num = x
  var reversed = 0
  while (num != 0) {
    val mod = num % 10
    reversed = reversed * 10 + mod
    num /= 10
  }

  return x == reversed
}
