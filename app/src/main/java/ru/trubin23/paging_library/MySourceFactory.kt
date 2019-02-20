package ru.trubin23.paging_library

import android.arch.paging.DataSource

class MySourceFactory(private val employeeStorage: EmployeeStorage) : DataSource.Factory<Int, Employee>() {

    override fun create(): DataSource<Int, Employee> {
        return MyPositionDataSource(employeeStorage)
    }
}