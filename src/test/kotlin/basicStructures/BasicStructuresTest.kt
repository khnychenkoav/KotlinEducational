package basicStructures

import org.example.algorithms.sortingAlgorithms.*
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.assertFailsWith
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertTrue
import kotlin.test.assertFalse
import org.example.basicStructures.linearStructures.arrays.*
import basicStructures.linearStructures.lists.linkedList.*
import basicStructures.linearStructures.lists.doublyLinkedList.*
import org.example.basicStructures.linearStructures.lists.circularLinkedList.*
import basicStructures.queuesStacks.Queue
import org.example.basicStructures.queuesStacks.PriorityQueue


class BasicStructuresTest {

    @Nested
    inner class FixedArrayTest {
        @Test fun `sets and gets elements correctly`() {
            val array = FixedArray<Int>(3)
            array.set(0, 10)
            array.set(1, 20)
            array.set(2, 30)
            assertEquals(10, array.get(0))
            assertEquals(20, array.get(1))
            assertEquals(30, array.get(2))
        }

        @Test fun `throws on out-of-bounds access`() {
            val array = FixedArray<String>(2)
            assertFailsWith<IllegalArgumentException> { array.get(3) }
        }
    }

    @Nested
    inner class DynamicArrayTest {
        @Test fun `adds and retrieves elements`() {
            val da = DynamicArray<String>()
            da.add("a")
            da.add("b")
            da.add("c")
            assertEquals("a", da.get(0))
            assertEquals("b", da.get(1))
            assertEquals("c", da.get(2))
            assertEquals(3, da.size())
        }
    }

    @Nested
    inner class LinkedListTest {
        @Test fun `inserts and finds elements`() {
            val list = LinkedList<Int>()
            list.insertEnd(1)
            list.insertEnd(2)
            list.insertEnd(3)
            assertNotNull(list.find(2))
            assertNull(list.find(42))
        }

        @Test fun `deletes correct element`() {
            val list = LinkedList<Int>()
            list.insertEnd(1)
            list.insertEnd(2)
            list.insertEnd(3)
            list.delete(2)
            assertNull(list.find(2))
        }
    }

    @Nested
    inner class DoublyLinkedListTest {
        @Test fun `supports insert and find`() {
            val list = DoublyLinkedList<String>()
            list.insertEnd("a")
            list.insertEnd("b")
            assertNotNull(list.find("a"))
            assertNull(list.find("z"))
        }

        @Test fun `supports deletion`() {
            val list = DoublyLinkedList<String>()
            list.insertEnd("a")
            list.insertEnd("b")
            list.delete("a")
            assertNull(list.find("a"))
        }
    }

    @Nested
    inner class CircularLinkedListTest {
        @Test fun `inserts and finds correctly`() {
            val cll = CircularLinkedList<Int>()
            cll.insert(1)
            cll.insert(2)
            cll.insert(3)
            assertTrue(cll.contains(1))
            assertFalse(cll.contains(42))
        }

        @Test fun `deletes correctly`() {
            val cll = CircularLinkedList<Int>()
            cll.insert(1)
            cll.insert(2)
            cll.insert(3)
            cll.delete(2)
            assertFalse(cll.contains(2))
        }
    }

    @Nested
    inner class QueueTest {
        @Test fun `push pop and peek`() {
            val queue = Queue<Int>()
            queue.push(1)
            queue.push(2)
            assertEquals(1, queue.peek())
            assertEquals(2, queue.size())
            assertEquals(1, queue.pop())
            assertEquals(1, queue.size())
        }

        @Test fun `empty queue throws`() {
            val queue = Queue<Int>()
            assertFailsWith<NoSuchElementException> { queue.pop() }
            assertFailsWith<NoSuchElementException> { queue.peek() }
        }
    }

    @Nested
    inner class PriorityQueueTest {
        @Test fun `push pop and peek`() {
            val pq = PriorityQueue<Int>()
            pq.push(3)
            pq.push(1)
            pq.push(2)
            assertEquals(1, pq.peek())
            assertEquals(3, pq.size())
            assertEquals(1, pq.pop())
            assertEquals(2, pq.peek())
        }

        @Test fun `empty priority queue throws`() {
            val pq = PriorityQueue<Int>()
            assertFailsWith<NoSuchElementException> { pq.pop() }
            assertFailsWith<NoSuchElementException> { pq.peek() }
        }
    }
}
