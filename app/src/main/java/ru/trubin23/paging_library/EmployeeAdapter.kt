package ru.trubin23.paging_library

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class EmployeeAdapter(diffCallback: DiffUtil.ItemCallback<Employee>) :
    PagedListAdapter<Employee, EmployeeAdapter.EmployeeViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.employee, parent, false)
        return EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        Log.d("EmployeeAdapter", position.toString())
        holder.bind(getItem(position) ?: return)
    }

    class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Employee) {
            itemView.findViewById<TextView>(R.id.employee_name).text = item.name
            itemView.findViewById<TextView>(R.id.employee_salary).text = item.salary.toString()
        }
    }
}