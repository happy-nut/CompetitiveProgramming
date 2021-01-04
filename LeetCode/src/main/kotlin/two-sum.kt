// https://leetcode.com/problems/two-sum/

// 내 처음 풀이.
// 1. forEachIndexed, drop 등을 배웠다. 어차피 함수형 언어라 원본 배열이 수정되지 않는다.
// 2. subList 를 쓰는 방법도 있더라.
fun twoSum(nums: IntArray, target: Int): IntArray {
  nums.forEachIndexed { i, num1 ->
    nums.drop(i + 1).forEachIndexed { j, num2 ->
      if (num1 + num2 == target) {
        return intArrayOf(i, j + i + 1)
      }
    }
  }

  throw Error()
}

// 사람들 풀이 보니까 반복문을 하나만 써서 풀었길래, 따라해봤다. 핵심은 hash map 을 쓰는 것.
// 1. 맞다 코틀린은 val로 변수 선언했었지.
// 2. HashMap에는 타입 선언이 필요하다. 그리고 int가 아니라 Int. containsKey 로 키 존재 유무 검사.
// 3. array의 indices 를 쓰면 0 부터 배열 길이 -1 까지의 range 를 얻는다.
fun twoSumFromOthers(nums: IntArray, target: Int): IntArray {
  val hashMap = HashMap<Int, Int>()
  for (i in nums.indices) {
    if (hashMap.containsKey(target - nums[i])) {
      return intArrayOf(hashMap[target - nums[i]]!!, i)
    } else {
      hashMap[nums[i]] = i
    }
  }

  throw Error()
}
