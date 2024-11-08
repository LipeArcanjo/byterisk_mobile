package com.example.byterisk_mobile_2tdpr.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.byterisk_mobile_2tdpr.R
import com.example.byterisk_mobile_2tdpr.adapters.EmployeeAdapter
import com.example.byterisk_mobile_2tdpr.models.Employee
import com.example.byterisk_mobile_2tdpr.utils.MenuNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class EmployeesActivity : AppCompatActivity() {

    private lateinit var employeeRecyclerView: RecyclerView
    private lateinit var employeeAdapter: EmployeeAdapter
    private lateinit var employeeList: MutableList<Employee>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employees)

        employeeRecyclerView = findViewById(R.id.employeeRecyclerView)
        employeeList = mutableListOf()
        employeeAdapter = EmployeeAdapter(employeeList)
        employeeRecyclerView.adapter = employeeAdapter

        // Configurar RecyclerView com Adapter
        val database = FirebaseDatabase.getInstance()
        val employeesRef = database.getReference("employees")

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        // Configurar a navegação no menu inferior e marcar o ícone correto
        bottomNavigationView.selectedItemId = R.id.nav_employees
        MenuNavigation.setupBottomNavigation(this, bottomNavigationView)

        employeesRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                employeeList.clear()
                for (employeeSnapshot in snapshot.children) {
                    val employee = employeeSnapshot.getValue(Employee::class.java)
                    employee?.let { employeeList.add(it) }
                }
                employeeAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("EmployeesActivity", "loadEmployee:onCancelled", error.toException())
            }
        })
    }
}
