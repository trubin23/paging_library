package ru.trubin23.paging_library

import android.annotation.SuppressLint
import android.arch.paging.PagedList
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Executors


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataSource = MyPositionDataSource(EmployeeStorage())

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(11)
            .build()

        @SuppressLint("WrongThread")
        val pagedList = PagedList.Builder(dataSource, config)
            .setFetchExecutor(Executors.newSingleThreadExecutor())
            .setNotifyExecutor(MainThreadExecutor())
            .setInitialKey(90)
            .build()

        val adapter = EmployeeAdapter(EmployeeDiffCallback())
        adapter.submitList(pagedList)

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        recycler_view.layoutManager = linearLayoutManager
        recycler_view.adapter = adapter
    }
}
