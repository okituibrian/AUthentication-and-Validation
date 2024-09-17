/*
package com.example.e_dawapharmacy

// Function to update the screen with the filtered employee list
fun updateScreen(employeeList: List<Employee>) {
    adapter.updateEmployeeListItems(employeeList)
    adapter.notifyDataSetChanged()
    binding?.addEmployeeBtn?.isEnabled = true
}

// Function to get all employees without any filters
fun getAll() {
    val filterEmployeeArrayList = employeeList.toMutableList()
    updateScreen(filterEmployeeArrayList)
}

// Function to get employees with names exactly matching the given name
fun getEmployeeEqualName(name: String) {
    val filterEmployeeArrayList = employeeList.filter { it.name == name }.toMutableList()
    updateScreen(filterEmployeeArrayList)
}

// Function to get employees whose names contain the given part of the name
fun getEmployeeContainsPartName(partName: String?) {
    if (partName.isNullOrBlank()) {
        updateScreen(employeeList)
    } else {
        val filterEmployeeArrayList = employeeList.filter { it.name.contains(partName, ignoreCase = true) }.toMutableList()
        updateScreen(filterEmployeeArrayList)
    }
}





// Function to update the screen with the filtered employee list
fun updateScreen(employeeList: List<Employee>) {
    adapter.updateEmployeeListItems(employeeList)
    adapter.notifyDataSetChanged()
    binding?.addEmployeeBtn?.isEnabled = true
}

// Function to get all employees without any filters
fun getAll() {
    val filterEmployeeArrayList = employeeList.toMutableList()
    updateScreen(filterEmployeeArrayList)
}

// Function to get employees with names exactly matching the given name
fun getEmployeeEqualName(name: String) {
    val filterEmployeeArrayList = employeeList.filter { it.name == name }.toMutableList()
    updateScreen(filterEmployeeArrayList)
}

// Function to get employees whose names contain the given part of the name
fun getEmployeeContainsPartName(partName: String?) {Teg
    if (partName.isNullOrBlank()) {
        updateScreen(employeeList)
    } else {
        val filterEmployeeArrayList = employeeList.filter { it.name.contains(partName, ignoreCase = true) }.toMutableList()
        updateScreen(filterEmployeeArrayList)
    }
}

// Function to get employees with salary less than the given max salary
fun getEmployeeLessThan(maxSalary: Float) {
    val filterEmployeeArrayList = employeeList.filter { it.salary < maxSalary }.toMutableList()
    updateScreen(filterEmployeeArrayList)
}

// Function to get employees with salary more than the given min salary
fun getEmployeeMoreThan(minSalary: Float) {
    val filterEmployeeArrayList = employeeList.filter { it.salary > minSalary }.toMutableList()
    updateScreen(filterEmployeeArrayList)
}

// Function to delete an employee by ID
fun deleteEmployeeById(id: Int) {
    val filterEmployeeArrayList = employeeList.filter { it.id != id }.toMutableList()
    updateScreen(filterEmployeeArrayList)
}




fun updateScreen (employeeList: List<Employee>)
adapter.updateEmployeeListItems (employeeList
adapter.notifyDataSetChanged()
binding?.addEmployeeBtn?.isEnabled = true
fun getAll() {
//Write code and add filters here
    filterEmployeeArrayList = mutableListOf()
    updateScreen (filterEmployeeArrayList)
    fun getEmployeeEqualName (name: String) {
//Write code and add filters here
        filterEmployeeArrayList = mutableListOf()
        updateScreen (filterEmployeeArrayList)

        fun getEmployeeLessThan (maxSalary: Float) {
//Write code and add filters here
            filterEmployeeArrayList = mutableListOf()
            updateScreen (filterEmployeeArrayList)
            fun getEmployeeMoreThan (minSalary: Float) {
//Write code and add filters here
                filterEmployeeArrayList = mutableListOf ()
                updateScreen (filterEmployeeArrayList)
                fun delete EmployeeById(id: Int) {
//Write code and add filters here
                    filterEmployeeArrayList = mutableListOf()
                    updateScreen (filterEmployeeArrayList)*/
