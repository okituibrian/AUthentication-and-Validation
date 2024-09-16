package com.example.e_dawapharmacy

fun main(){
    val updatedNames  = simpleArrayNames(arrayOf("james", "anne", "mike"))

    println(updatedNames)
}

fun simpleArrayNames(array: Array<String>):String{
    var employees = ""
    for (name in array){
       if (name == "james"){
           employees += "john\n"
       }else{
           employees += "$name\n"
       }
    }
    return employees
}

/*fun simpleArraySum(array: Array<Int>): Int{
    var sum = 0
    for (element in array){
        sum += element
    }
    return sum
}*/

