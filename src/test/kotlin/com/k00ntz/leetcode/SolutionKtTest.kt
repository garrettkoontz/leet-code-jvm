package com.k00ntz.leetcode

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SolutionKtTest {

    fun <T> assertArrayContentEquals(a1: Array<T>, a2: Array<T>){
        assertEquals(a1.size, a2.size)
        for ((index, t) in a1.withIndex()) {
            assertEquals(t, a2[index])
        }
    }

    @Test
    fun countAndSayTest(){
        assertEquals("1", countAndSay(1))
        assertEquals("11", countAndSay(2))
        assertEquals("21", countAndSay(3))
        assertEquals("1211", countAndSay(4))
        assertEquals("111221", countAndSay(5))
        assertEquals("312211", countAndSay(6))
        assertEquals("13112221", countAndSay(7))
        assertEquals("1113213211", countAndSay(8))
    }

    @Test
    fun searchInsertTest(){
        assertEquals(1309 + 5000, searchInsert((-5000 until 5000).toList().toIntArray(), 1309))
        assertEquals(6, searchInsert(intArrayOf(1,2,4,6,8,9,10), 10))
        assertEquals(2, searchInsert(intArrayOf(1,3,5), 5))
        assertEquals(0, searchInsert(intArrayOf(1,3,5,6), 0))
        assertEquals(2, searchInsert(intArrayOf(1,4,6,7,8,9), 6))
        assertEquals(0, searchInsert(intArrayOf(1,3), 0))
        assertEquals(1, searchInsert(intArrayOf(1), 2))
        assertEquals(0, searchInsert(intArrayOf(1), 0))
        assertEquals(2, searchInsert(intArrayOf(1,3,5,6), 5))
        assertEquals(1, searchInsert(intArrayOf(1,3,5,6), 2))
        assertEquals(4, searchInsert(intArrayOf(1,3,5,6), 7))
    }

    @Test
    fun strStrTest(){
        assertEquals(0, nativeStrStr("a", "a"))
        assertEquals(2, nativeStrStr("hello", "ll"))
        assertEquals(-1, nativeStrStr("aaaaa", "baa"))
        assertEquals(0, nativeStrStr("anything", ""))
        assertEquals(-1, nativeStrStr("anything", "something longer than that"))
        assertEquals(-1, nativeStrStr("mississippi", "sippia"))

    }

    @Test
    fun removeElementTest(){
        val array2 = intArrayOf(0,1,2,2,3,0,4,2)
        assertEquals(5, removeElement(array2, 2))
        assertEquals(array2.take(5).toSet(), setOf(0,1,3,4))
        val array1 = intArrayOf(3,2,2,3)
        assertEquals(2, removeElement(array1, 3))
        assertEquals(array1.take(2).toSet(), setOf(2))
        val array3 = intArrayOf()
        assertEquals(0, removeElement(array3, 0))

    }

    @Test
    fun reverseTest(){
        assertEquals(321, reverse(123))
        assertEquals(-321, reverse(-123))
        assertEquals(21, reverse(120))
        assertEquals(1, reverse(1))
        assertEquals(0,reverse(1534236469))
    }

    @Test
    fun removeDuplicates() {
        val intArray1 = intArrayOf(1, 1, 2)
        val intArray2 = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
        val intArray3 = intArrayOf(1,2)
        val intArray4 = intArrayOf(1,2,2)
        assertEquals(2, removeDuplicates(intArray1))
        assertArrayContentEquals(
            intArrayOf(1, 2).toTypedArray(),
            intArray1.sliceArray(0..1).toTypedArray()
        )
        assertEquals(5, removeDuplicates(intArray2))
        assertArrayContentEquals(
            intArrayOf(0, 1, 2, 3, 4).toTypedArray(),
            intArray2.sliceArray(0..4).toTypedArray()
        )
        assertEquals(2, removeDuplicates(intArray3))
        assertArrayContentEquals(
            intArrayOf(1, 2).toTypedArray(),
            intArray3.sliceArray(0..1).toTypedArray()
        )
        assertEquals(2, removeDuplicates(intArray4))
        assertArrayContentEquals(
            intArrayOf(1, 2).toTypedArray(),
            intArray4.sliceArray(0..1).toTypedArray()
        )
    }
}