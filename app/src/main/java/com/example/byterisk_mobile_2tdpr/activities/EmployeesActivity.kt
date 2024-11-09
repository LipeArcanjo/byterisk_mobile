package com.example.byterisk_mobile_2tdpr.activities
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.byterisk_mobile_2tdpr.R
import com.example.byterisk_mobile_2tdpr.adapters.EmployeeAdapter
import com.example.byterisk_mobile_2tdpr.models.Employee
import com.example.byterisk_mobile_2tdpr.utils.MenuNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView
class EmployeesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employees)
        // Inicializando a lista de funcionários com dados reais
        val employeeList = listOf(
            Employee(
                profileImageRes = R.drawable.arcanjo, // Substitua por suas imagens reais
                name = "Felipe Arcanjo Matos dos Santos",
                rm = "RM: 554018",
                location = "São Paulo",
                institution = "FIAP",
                username = "LipeArcanjo"
            ),
            Employee(
                profileImageRes = R.drawable.rabelo,
                name = "Gustavo Rabelo Frere",
                rm = "RM: 553326",
                location = "São Paulo",
                institution = "FIAP",
                username = "GustaFrere"
            ),
            Employee(
                profileImageRes = R.drawable.celo,
                name = "Marcelo Vieira Junior",
                rm = "RM: 553640",
                location = "São Paulo",
                institution = "FIAP",
                username = "MarceloJunior"
            )
        )
        // Configurar RecyclerView com Adapter
        val recyclerView = findViewById<RecyclerView>(R.id.employeeRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EmployeeAdapter(employeeList)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        // Configurar a navegação no menu inferior e marcar o ícone correto
        bottomNavigationView.selectedItemId = R.id.nav_employees
        MenuNavigation.setupBottomNavigation(this, bottomNavigationView)
    }
}