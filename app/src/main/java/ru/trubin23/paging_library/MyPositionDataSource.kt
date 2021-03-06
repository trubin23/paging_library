package ru.trubin23.paging_library

import android.arch.paging.PositionalDataSource
import android.util.Log

class MyPositionDataSource(private val storage: EmployeeStorage) : PositionalDataSource<Employee>() {

    private val TAG = MyPositionDataSource::class.java.simpleName

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Employee>) {
        Log.d(TAG, "loadInitial, requestedStartPosition = ${params.requestedStartPosition} " +
                    ", requestedLoadSize = ${params.requestedLoadSize}")

        val employeeData = storage.getInitialData(params.requestedStartPosition, params.requestedLoadSize)
        if (params.placeholdersEnabled) {
            callback.onResult(employeeData.data, employeeData.startPosition, employeeData.count)
        } else {
            callback.onResult(employeeData.data, employeeData.startPosition)
        }
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Employee>) {
        Log.d(TAG, "loadInitial, startPosition = ${params.startPosition} " +
                    ", loadSize = ${params.loadSize}")

        val result: List<Employee> = storage.getData(params.startPosition, params.loadSize)
        callback.onResult(result)
    }
}