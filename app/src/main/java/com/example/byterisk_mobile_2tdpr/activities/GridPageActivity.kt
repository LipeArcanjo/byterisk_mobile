package com.example.byterisk_mobile_2tdpr.activities
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.byterisk_mobile_2tdpr.R
import com.example.byterisk_mobile_2tdpr.adapters.InsuredAdapter
import com.example.byterisk_mobile_2tdpr.models.Insured
import com.example.byterisk_mobile_2tdpr.utils.MenuNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView
class GridPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        // Configurar a navegação no menu inferior e marcar o ícone correto
        bottomNavigationView.selectedItemId = R.id.nav_grid
        MenuNavigation.setupBottomNavigation(this, bottomNavigationView)
        // Configurar RecyclerView para listar os segurados
        val insuredRecyclerView = findViewById<RecyclerView>(R.id.insuredRecyclerView)
        insuredRecyclerView.layoutManager = LinearLayoutManager(this)
        val insuredList = listOf(
            Insured("Felipe A. M. S.", 20, "XXX.XXX.XXX-XX", "99,94", "Nota F", "Ativo"),
            Insured("Gustavo R. F.", 20, "XXX.XXX.XXX-XX", "97,12", "Nota F", "Ativo"),
            Insured("Marcelo V. J.", 21, "XXX.XXX.XXX-XX", "95,87", "Nota E", "Ativo"),
            Insured("Lucas M. T.", 19, "XXX.XXX.XXX-XX", "92,45", "Nota S", "Inativo"),
            Insured("Ana C. L.", 22, "XXX.XXX.XXX-XX", "89,34", "Nota F", "Ativo"),
            Insured("Maria P. S.", 23, "XXX.XXX.XXX-XX", "87,99", "Nota E", "Ativo")
        )
        insuredRecyclerView.adapter = InsuredAdapter(insuredList)
    }
}