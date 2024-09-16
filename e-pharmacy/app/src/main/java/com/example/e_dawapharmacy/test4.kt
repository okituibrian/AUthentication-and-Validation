package com.example.e_dawapharmacy

fun getMinimumCost(arr: IntArray): Long {
    val n = arr.size
    var minCost = Long.MAX_VALUE

    // Calculate the initial cost
    var initialCost = 0L
    for (i in 1 until n) {
        initialCost += (arr[i] - arr[i - 1]).toLong() * (arr[i] - arr[i - 1])
    }

    // Try inserting a new element between every pair of elements
    for (i in 0 until n - 1) {
        val a = arr[i]
        val b = arr[i + 1]

        // Insert a new element x between arr[i] and arr[i + 1]
        // Optimal x is (a + b) / 2 to minimize (x - a)^2 + (b - x)^2
        val x = (a + b) / 2

        // Calculate the new cost
        val newCost = initialCost - (b - a).toLong() * (b - a) +
                (x - a).toLong() * (x - a) +
                (b - x).toLong() * (b - x)

        minCost = minOf(minCost, newCost)
    }

    return minCost
}

// Test the function
fun main() {
    val arr1 = intArrayOf(1, 3, 5, 2, 10)
    println(getMinimumCost(arr1)) // Output: 49

    val arr2 = intArrayOf(4, 7, 1, 4)
    println(getMinimumCost(arr2)) // Output: 36
}

/*
fun getTotalMills(arr: IntArray){
    val n = arr.size
    for(i in 0 <= until< n-1){
        var millA = 5
        var millB = 8
        val totalMiller = millA + millB
    }
}*/
