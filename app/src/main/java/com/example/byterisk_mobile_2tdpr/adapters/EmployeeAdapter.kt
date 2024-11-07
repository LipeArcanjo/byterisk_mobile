package com.example.byterisk_mobile_2tdpr.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.byterisk_mobile_2tdpr.R
import com.example.byterisk_mobile_2tdpr.models.Employee

class EmployeeAdapter(private val employeeList: List<Employee>) :
    RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: ImageView = itemView.findViewById(R.id.imageProfile)
        val employeeName: TextView = itemView.findViewById(R.id.textEmployeeName)
        val employeeRM: TextView = itemView.findViewById(R.id.textEmployeeRM)
        val employeeLocation: TextView = itemView.findViewById(R.id.textEmployeeLocation)
        val employeeInstitution: TextView = itemView.findViewById(R.id.textEmployeeInstitution)
        val employeeUsername: TextView = itemView.findViewById(R.id.textEmployeeUsername)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_employee, parent, false)
        return EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = employeeList[position]
        holder.profileImage.setImageResource(employee.profileImageRes)
        holder.employeeName.text = employee.name
        holder.employeeRM.text = employee.rm
        holder.employeeLocation.text = employee.location
        holder.employeeInstitution.text = employee.institution
        holder.employeeUsername.text = employee.username
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }
}
