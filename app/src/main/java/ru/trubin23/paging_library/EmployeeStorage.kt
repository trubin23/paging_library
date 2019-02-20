package ru.trubin23.paging_library

class EmployeeStorage {

    fun getInitialData(startPosition: Int, loadSize: Int): EmployeeData {
        val position = if (startPosition + loadSize < NUMBER_OF_EMPLOYEES) {
            startPosition
        } else {
            NUMBER_OF_EMPLOYEES - loadSize
        }
        val data: List<Employee> = getData(position, loadSize)

        return EmployeeData(data, position, NUMBER_OF_EMPLOYEES)
    }

    fun getData(position: Int, size: Int): List<Employee> {
        val employeeList = ArrayList<Employee>()

        Thread.sleep(1000)

        for (index in position until position + size) {
            if (index >= NUMBER_OF_EMPLOYEES) {
                break
            }
            employeeList.add(Employee(index, "name $index", index * 1_000))
        }

        return employeeList
    }

    companion object {
        const val NUMBER_OF_EMPLOYEES = 100
    }
}