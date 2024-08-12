package com.example.e_dawapharmacy


fun getMinMachines(start: IntArray, end: IntArray): Int {
    // Create a list to store the events
    val events = mutableListOf<Pair<Int, Int>>()

    // Populate the events list with start and end times
    for (i in start.indices) {
        events.add(Pair(start[i], 1))  // +1 indicates the start of a task
        events.add(Pair(end[i], -1))   // -1 indicates the end of a task
    }

    // Sort the events: first by time, then by type (-1 before +1 if times are equal)
    events.sortWith(compareBy({ it.first }, { it.second }))

    var maxMachines = 0
    var currentMachines = 0

    // Traverse the sorted events to count the number of concurrent tasks
    for (event in events) {
        currentMachines += event.second
        if (currentMachines > maxMachines) {
            maxMachines = currentMachines
        }
    }

    return maxMachines
}

fun main() {
    val start1 = intArrayOf(1, 8, 3, 9, 6)
    val end1 = intArrayOf(7, 9, 6, 14, 7)
    println(getMinMachines(start1, end1))  // Expected output: 3

    val start2 = intArrayOf(2, 2, 2, 2)
    val end2 = intArrayOf(5, 5, 5, 5)
    println(getMinMachines(start2, end2))  // Expected output: 4
}
