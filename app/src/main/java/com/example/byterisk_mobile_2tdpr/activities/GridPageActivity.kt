package com.example.byterisk_mobile_2tdpr.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.byterisk_mobile_2tdpr.R
import com.example.byterisk_mobile_2tdpr.adapters.InsuredAdapter
import com.example.byterisk_mobile_2tdpr.models.Insured
import com.example.byterisk_mobile_2tdpr.utils.MenuNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class GridPageActivity : AppCompatActivity() {

    private lateinit var insuredRecyclerView: RecyclerView
    private lateinit var insuredAdapter: InsuredAdapter
    private lateinit var insuredList: MutableList<Insured>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        // Configurar a navegação no menu inferior e marcar o ícone correto
        bottomNavigationView.selectedItemId = R.id.nav_grid
        MenuNavigation.setupBottomNavigation(this, bottomNavigationView)

        insuredRecyclerView = findViewById(R.id.insuredRecyclerView)
        insuredList = mutableListOf()
        insuredAdapter = InsuredAdapter(insuredList)
        insuredRecyclerView.adapter = insuredAdapter

        // Referência ao Firebase Database
        val database = FirebaseDatabase.getInstance()
        val insuredsRef = database.getReference("insureds")

        // Obtém dados dos segurados do Firebase
        insuredsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                insuredList.clear()
                for (insuredSnapshot in snapshot.children) {
                    val insured = insuredSnapshot.getValue(Insured::class.java)
                    insured?.let { insuredList.add(it) }
                }
                insuredAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("GridActivity", "loadInsured:onCancelled", error.toException())
            }
        })
    }
}
