package algorithms.simpleAlgorithms

import org.example.algorithms.simpleAlgorithms.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class SimpleAlgorithmsTest {

    @Test fun `ArrayReverser works`() {
        val list = listOf(1, 2, 3, 4)
        assertEquals(listOf(4,3,2,1), ArrayReverser.reverse(list))
    }

    @Test fun `BinarySearch search, lowerBound, upperBound`() {
        val arr = listOf(1,2,2,3,4)
        assertEquals(3, BinarySearch.search(arr, 3))
        assertEquals(-1, BinarySearch.search(arr, 5))

        assertEquals(3, BinarySearch.lowerBound(arr, 3))
        assertEquals(4, BinarySearch.upperBound(arr, 3))

        assertEquals(1, BinarySearch.lowerBound(arr, 2, checkSorted = true))
        assertThrows<IllegalArgumentException> {
            BinarySearch.lowerBound(listOf(3, 1, 2), 2, checkSorted = true)
        }
    }


    @Test fun `FibonacciGenerator base cases and sequence`() {
        assertEquals(0, FibonacciGenerator.get(0))
        assertEquals(1, FibonacciGenerator.get(1))
        assertEquals(1, FibonacciGenerator.get(2))
        assertEquals(5, FibonacciGenerator.get(5))
    }

    @Test fun `FrequencyCounter counts correctly`() {
        val input = listOf("a","b","a","c","b","a")
        val expected = mapOf("a" to 3, "b" to 2, "c" to 1)
        assertEquals(expected, FrequencyCounter.countFrequency(input))
    }

    @Test fun `GcdLcmCalculator gcd and lcm`() {
        assertEquals(6, GcdLcmCalculator.gcd(48, 18))
        assertEquals(6, GcdLcmCalculator.gcd(48, 18, isRecursive = true))
        assertEquals(12, GcdLcmCalculator.lcm(4, 6))
        assertThrows<IllegalArgumentException> { GcdLcmCalculator.gcd(0, 0) }
    }

    @Test fun `IsSortedChecker works`() {
        assertTrue(IsSortedChecker.isSorted(listOf(1, 2, 2, 3)))
        assertFalse(IsSortedChecker.isSorted(listOf(3, 1, 2)))
        // частичный диапазон
        assertTrue(IsSortedChecker.isSorted(listOf(3, 1, 2, 4), start = 2, end = 4))
        assertThrows<IllegalArgumentException> {
            IsSortedChecker.isSorted(listOf(1, 2), start = 1, end = 3)
        }
    }

    @Test fun `LinearSearch finds or not`() {
        val arr = listOf(5,3,9,1)
        assertEquals(2, LinearSearch.search(arr, 9))
        assertEquals(-1, LinearSearch.search(arr, 7))
    }

    @Test fun `MinMaxFinder returns min and max or null`() {
        assertNull(MinMaxFinder.findMinMax(emptyList()))
        assertEquals(Pair(1,5), MinMaxFinder.findMinMax(listOf(3, 1, 5, 2)))
    }

    @Test fun `PalindromeChecker works`() {
        assertTrue(PalindromeChecker.isPalindrome("radar"))
        assertFalse(PalindromeChecker.isPalindrome("kotlin"))
    }

    @Test fun `PrimeChecker identifies primes`() {
        val checker = PrimeChecker()
        listOf(2,3,5,13,97).forEach { assertTrue(checker.isPrime(it), "should be prime: $it") }
        listOf(0,1,4,100).forEach { assertFalse(checker.isPrime(it), "should not be prime: $it") }
    }

    @Test fun `StringReverser works`() {
        assertEquals("olleh", StringReverser.reverse("hello"))
    }

    @Test fun `Swapper swaps elements`() {
        val lst = mutableListOf(1,2,3)
        lst.swap(0,2)
        assertEquals(listOf(3,2,1), lst)
    }
}
