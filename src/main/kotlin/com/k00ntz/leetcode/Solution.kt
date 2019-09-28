package com.k00ntz.leetcode

import kotlin.math.abs

//fun maxSubArray(nums: IntArray): Int {
//
//}

fun countAndSay(n: Int): String {
    var str = StringBuilder("1")
    if (n <= 1) return str.toString()
    for (i in (1 until n)) {
        var count = 0
        val newStr = StringBuilder("")
        var lastVal: Char? = null
        for (c in (0 .. str.length)) {
            if (c == str.length) {
                newStr.append("$count$lastVal")
            } else {
                if (lastVal != str[c]) {
                    if (lastVal != null) newStr.append("$count$lastVal")
                    lastVal = str[c]
                    count = 1
                } else {
                    count++
                }
            }
        }
        str = newStr
    }
    return str.toString()
}

fun searchInsert(nums: IntArray, target: Int): Int {
/*    fun binaryIndexSearch(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return 0
        if (nums.size == 1 && target != nums[0]) return 1
        val midIdx = nums.size / 2
        val midVal = nums[midIdx]
        if (target == midVal) return midIdx
        else if (target > midVal) return midIdx + binaryIndexSearch(nums.copyOfRange(midIdx + 1, nums.size), target)
        else *//*if (target < midVal)*//* return binaryIndexSearch(nums.copyOfRange(0, midIdx), target)
    }*/

    var left = 0
    var right = nums.size
    var ansIdx = nums.size / 2
    while (ansIdx < nums.size && nums[ansIdx] != target) {
        if (ansIdx == 0) {
            if (target < nums[0]) break
            else {
                ansIdx++; break
            }
        }
        if (ansIdx == nums.size - 1) {
            if (target > nums[nums.size - 1]) {
                ++ansIdx
                break
            }
        }
        if (nums[ansIdx] > target) {
            if (nums[ansIdx - 1] < target) break
            else {
                right = ansIdx
                ansIdx = (left + right) / 2
            }
        } else /*if (nums[ansIdx] < target) */ {
            if (nums[ansIdx + 1] > target) {
                ++ansIdx; break
            } else {
                left = ansIdx
                ansIdx = (left + right) / 2
            }
        }

    }
    return ansIdx
}

fun strStr(haystack: String, needle: String): Int {
    return haystack.indexOf(needle)
}

fun nativeStrStr(haystack: String, needle: String): Int {
    val hayChar = haystack.toCharArray()
    val needleChar = needle.toCharArray()
    if (needleChar.isEmpty()) return 0
    if (needleChar.size > hayChar.size) return -1
    hay@ for (i in (0..hayChar.size - needleChar.size)) {
        for (j in needleChar.indices) {
            if (haystack[i + j] != needle[j]) continue@hay
        }
        return i
    }
    return -1
}

fun IntArray.lastIndexBefore(stopIndex: Int, predicate: (Int) -> Boolean): Int {
    for (index in this.indices.reversed().drop(this.size - stopIndex)) {
        val element = this[index]
        if (predicate(element)) return index
    }
    return -1
}

fun removeElement(nums: IntArray, `val`: Int): Int {
    var j = nums.lastIndexBefore(nums.size) { it != `val` }
    if (j == -1) return 0
    for (i in nums.indices) {
        if (nums[i] == `val`) {
            nums[i] = nums[j]
            nums[j] = `val`
            j = nums.lastIndexBefore(j) { it != `val` }
        }
        if (j == i) return j + 1
    }
    return j + 1
}

fun reverse(x: Int): Int {
    var ans = 0
    var nxt = abs(x)
    while (nxt / 10.0 > 0) {
        if (ans > Int.MAX_VALUE / 10) return 0
        ans = ans * 10 + (nxt % 10)
        nxt /= 10
    }
    if (x < 0) ans *= -1
    return ans
}

fun removeDuplicates(nums: IntArray): Int {
    return if (nums.size == 1) 1
    else if (nums.size == 2) {
        if (nums[0] == nums[1]) 1 else 2
    } else {
        var i = 1
        for (j in (1 until nums.size)) {
            if (nums[j - 1] == nums[j]) {
            } else {
                nums[i++] = nums[j]
            }
        }
        i
    }
}


fun romanToInt(s: String): Int {
    val mp = mapOf(
        Pair('I', 1),
        Pair('V', 5),
        Pair('X', 10),
        Pair('L', 50),
        Pair('C', 100),
        Pair('D', 500),
        Pair('M', 1000)
    )
    val intList = java.util.ArrayDeque(s.toCharArray().map { mp.getValue(it) })
    var result = 0
    while (intList.isNotEmpty()) {
        val f = intList.pollFirst()
        val n = intList.peekFirst() ?: 0
        result += if (n > f) {
            intList.pollFirst()
            (n - f)
        } else f
    }
    return result
}