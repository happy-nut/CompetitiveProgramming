// https://leetcode.com/problems/longest-common-prefix/
// 주어진 문자열들 중에 가장 긴 common prefix 를 찾아라.

// 내 처음 풀이.
// 이 때부터 알고리즘 구현하기 전에 미리 시간 복잡도를 계산하기로 한다. N의 제한 때문에 못풀 수도 있으니..
// 아이디어:
//   일단 아무 문자열이나 집어도 됨. prfix 가 가장 길어봤자 가장 짧은 문자열 길이 일거니까 셋 중에 하나라도 끝나버리면 그 즉시 반복문 탈출 하면 됨
//   곂치는 것만 이어붙이면 O(n)
// 1. 근데 짜고보니 이중 반복이었다. 충격이다. 나는 똥멍청이라 짜보지 않으면 복잡도 계산도 못하는 구나...
// 2. current == null 일 때 continue 해버렸다. 이러면 ["a"] 이런거 하나만 받으면 result 가 아직 empty 잖아...
fun longestCommonPrefix(strs: Array<String>): String {
  var result = ""
  var current: Char? = null
  if (strs.isEmpty()) {
    return ""
  }

  for (i in strs[0].indices) {
    for (j in strs.indices) {
      val str = strs[j]
      val target = str.getOrNull(i) ?: return result
      if (current == null) {
        current = target
      }

      if (current != target) {
        return result
      }

      if (j == strs.size - 1) {
        current = null
        result += target
        continue
      }
    }
  }

  return result
}

// 다른 사람 풀이 중에 reversed integer 가 있었다. nlog(n) 최악이면 n^2 인 풀이가 있었다. 깔끔하면서.
// 1. 정렬을 사용한다. 이러면 인덱스가 돌면서 맨 처음과 끝이 같은지만 비교하면 된다. 이게 핵심.
// 2. 만약 sts[0]가 길고 그 이후 str 들이 길이가 더 짧다면 indexOutOfRange 에러가 나야 하지 않나?
//    그렇지 않다. sort 를 하게 되면 길이가 더 짧은 건 무조건 처음으로 오기 때문에...
fun longestCommonPrefixFromOthers(strs: Array<String>): String {
  if (strs.isEmpty()) {
    return ""
  }

  strs.sort()
  println(strs.toList())
  for (i in strs[0].indices) {
    if (strs[0][i] != strs[strs.size - 1][i]) {
      return strs[0].slice(0 until i)
    }
  }

  return strs[0]
}
