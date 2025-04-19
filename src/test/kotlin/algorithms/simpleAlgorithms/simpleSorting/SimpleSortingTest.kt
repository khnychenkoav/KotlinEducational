package algorithms.simpleAlgorithms.simpleSorting

import org.example.algorithms.simpleAlgorithms.simpleSorting.BubbleSort
import org.example.algorithms.simpleAlgorithms.simpleSorting.InsertionSort
import org.example.algorithms.simpleAlgorithms.simpleSorting.SelectionSort
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SimpleSortingTest {

    private fun testSort(sorter: (MutableList<Int>) -> Unit) {
        val original = mutableListOf(5, 3, 8, 1, 2)
        val expected = original.sorted()
        val list = original.toMutableList()
        sorter(list)
        assertEquals(expected, list)
    }

    @Test fun `BubbleSort sorts`() = testSort { BubbleSort.sort(it) }
    @Test fun `InsertionSort sorts`() = testSort { InsertionSort.sort(it) }
    @Test fun `SelectionSort sorts`() = testSort { SelectionSort.sort(it) }
}
