package com.example.e_dawapharmacy

fun main() {
    // Predefined variables
    val i = 4
    val d = 4.0
    val s = "HackerRank "
    println(s)

    val intInput: Int = 8
    val doubleInput: Double = 4.0
    val stringInput: String = "welcome brian!"

    // Declare variables to hold user input
    //val intInput: Int = readLine()!!.toInt()          // Read integer input
    //val doubleInput: Double = readLine()!!.toDouble() // Read double input
   // val stringInput: String = readLine()!!            // Read string input

    // Perform operations and print results

    println(i + intInput)                             // Sum of i and intInput
    println("%.1f".format(d + doubleInput))           // Sum of d and doubleInput, formatted to 1 decimal place
    println(s + stringInput) // Concatenate and print s and stringInput

}
