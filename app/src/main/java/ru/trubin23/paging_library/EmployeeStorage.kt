package ru.trubin23.paging_library

class EmployeeStorage {

    //fun getInitialData(startPosition: Int, loasSize: Int) :EmployeeData {
//
    //    //EmployeeData
    //}

    fun getData(position: Int, size: Int): List<Employee> {
        val employeeList = ArrayList<Employee>()

        for (index in position until position + size) {
            if (index>=NUMBER_OF_EMPLOYEES){
                break
            }
            employeeList.add(Employee(index, "name $index", index * 1_000))
        }

        return employeeList
    }

    companion object {
        const val NUMBER_OF_EMPLOYEES = 70
    }
}