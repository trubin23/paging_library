package ru.trubin23.paging_library

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
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
        holder.bind(getItem(position))
    }

    class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Employee?) {
            val nameView = itemView.findViewById<TextView>(R.id.employee_name)
            val salaryView = itemView.findViewById<TextView>(R.id.employee_salary)

            if (item != null) {
                nameView.text = item.name
                salaryView.text = item.salary.toString()
            } else {
                nameView.setText(R.string.wait)
                salaryView.setText(R.string.wait)
            }
        }
    }
}