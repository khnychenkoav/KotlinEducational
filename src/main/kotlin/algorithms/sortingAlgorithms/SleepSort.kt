package org.example.algorithms.sortingAlgorithms

object SleepSort {
    fun sort(list: MutableList<Int>) {
        val result = mutableListOf<Int>()
        val lock = Any()
        val threads = mutableListOf<Thread>()
        for (num in list) {
            if (num < 0) throw IllegalArgumentException("SleepSort doesn't work with negative numbers!")
            val thread = Thread {
                Thread.sleep(num.toLong())
                synchronized(lock) {
                    result.add(num)
                }
            }
            threads += thread
            thread.start()
        }
        for (thread in threads) {
            thread.join()
        }
        for (i in list.indices) {
            list[i] = result[i]
        }
    }
}
