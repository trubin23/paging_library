package ru.trubin23.paging_library

class EmployeeStorage {

    fun getData(position: Int, size: Int): List<Employee> {
        val employeeList = ArrayList<Employee>()

        for (index in position until position + size) {
            employeeList.add(Employee(index, "name $index", index * 1_000))
        }

        return employeeList
    }
}