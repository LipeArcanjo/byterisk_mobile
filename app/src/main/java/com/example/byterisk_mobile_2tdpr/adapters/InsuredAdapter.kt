package com.example.byterisk_mobile_2tdpr.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.byterisk_mobile_2tdpr.R
import com.example.byterisk_mobile_2tdpr.models.Insured
class InsuredAdapter(private val insuredList: List<Insured>) :
    RecyclerView.Adapter<InsuredAdapter.InsuredViewHolder>() {
    class InsuredViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.textInsuredName)
        val age: TextView = itemView.findViewById(R.id.textInsuredAge)
        val cpf: TextView = itemView.findViewById(R.id.textInsuredCpf)
        val ranking: TextView = itemView.findViewById(R.id.textInsuredRanking)
        val category: TextView = itemView.findViewById(R.id.textInsuredCategory)
        val status: TextView = itemView.findViewById(R.id.textInsuredStatus)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsuredViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_insured, parent, false)
        return InsuredViewHolder(view)
    }
    override fun onBindViewHolder(holder: InsuredViewHolder, position: Int) {
        val insured = insuredList[position]
        holder.name.text = insured.name
        holder.age.text = "${insured.age} Anos"
        holder.cpf.text = insured.cpf
        holder.ranking.text = insured.ranking
        holder.category.text = insured.category
        holder.status.text = insured.status
    }
    override fun getItemCount(): Int {
        return insuredList.size
    }
}