package algorithms.sortingAlgorithms

import org.example.algorithms.sortingAlgorithms.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class SortingAlgorithmsTest {

    private fun runSortTest(sortFn: (MutableList<Int>) -> Unit) {
        val original = listOf(9, 3, 7, 1, 5, 2, 8, 4, 6)
        val expected = original.sorted()
        val list = original.toMutableList()
        sortFn(list)
        assertEquals(expected, list)
    }

    @Test fun `AmericanFlagSort sorts`()           = runSortTest { AmericanFlagSort.sort(it) }
    @Test fun `BeadSort sorts`()                    = runSortTest { BeadSort.sort(it) }
    @Test fun `BinaryInsertionSort sorts`()         = runSortTest { BinaryInsertionSort.sort(it) }
    @Test fun `BitonicSort sorts power-of-two length`() {
        val original = listOf(9, 3, 7, 1, 5, 2, 8, 4)
        val expected = original.sorted()
        val list = original.toMutableList()
        BitonicSort.sort(list)
        assertEquals(expected, list)
    }

    @Test fun `BlockSort sorts`()                   = runSortTest { BlockSort.sort(it) }
    @Test fun `BubbleSort sorts`()                  = runSortTest { BubbleSort.sort(it) }
    @Test fun `BucketSort sorts doubles`() {
        val original = mutableListOf(3.2, 1.5, 4.8, 2.1)
        val expected = original.sorted()
        BucketSort.sort(original)
        assertEquals(expected, original)
    }
    @Test fun `CocktailShakerSort sorts`()          = runSortTest { CocktailShakerSort.sort(it) }
    @Test fun `CombSort sorts`()                    = runSortTest { CombSort.sort(it) }
    @Test fun `CountingSort sorts`()                = runSortTest { CountingSort.sort(it) }
    @Test fun `CycleSort sorts`()                   = runSortTest { CycleSort.sort(it) }
    @Test fun `FlashSort sorts doubles`() {
        val original = mutableListOf(5.0, 2.5, 9.0, 3.5)
        val expected = original.sorted()
        FlashSort.sort(original)
        assertEquals(expected, original)
    }
    @Test fun `GnomeSort sorts`()                   = runSortTest { GnomeSort.sort(it) }
    @Test fun `HeapSort sorts`()                    = runSortTest { HeapSort.sort(it) }
    @Test fun `InsertionSort sorts`()               = runSortTest { InsertionSort.sort(it) }
    @Test fun `MergeSort sorts`()                   = runSortTest { MergeSort.sort(it) }
    @Test fun `OddEvenSort sorts`()                 = runSortTest { OddEvenSort.sort(it) }
    @Test fun `PancakeSort sorts`()                 = runSortTest { PancakeSort.sort(it) }
    @Test fun `PatienceSort sorts`()                = runSortTest { PatienceSort.sort(it) }
    @Test fun `QuickSort sorts`()                   = runSortTest { QuickSort.sort(it) }
    @Test fun `RadixSort sorts`()                   = runSortTest { RadixSort.sort(it) }
    @Test fun `SelectionSort sorts`()               = runSortTest { SelectionSort.sort(it) }
    @Test fun `ShellSort sorts`()                   = runSortTest { ShellSort.sort(it) }
    @Test fun `SleepSort sorts`()                   = runSortTest { SleepSort.sort(it) }
    @Test fun `SmoothSort sorts`()                  = runSortTest { SmoothSort.sort(it) }
    @Test fun `StoogeSort sorts`()                  = runSortTest { StoogeSort.sort(it) }
    @Test fun `TimSort sorts`()                     = runSortTest { TimSort.sort(it) }
    @Test fun `TournamentSort sorts`()              = runSortTest { TournamentSort.sort(it) }
    @Test fun `TreeSort sorts`()                    = runSortTest { TreeSort.sort(it) }

    @Test fun `TreeSort sorts list with duplicates`() {
        val original = mutableListOf(3, 1, 4, 3, 2, 2, 1)
        val expected = original.sorted()
        TreeSort.sort(original)
        assertEquals(expected, original)
    }
}
