package ru.alexkubrick.neco_lesson_26_recyclerview_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.alexkubrick.neco_lesson_26_recyclerview_2.databinding.PrincessItemBinding

class PrincessAdapter: RecyclerView.Adapter<PrincessAdapter.PrincessHolder>() {
    val princessList = ArrayList<Princess>()
    class PrincessHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = PrincessItemBinding.bind(item)
        fun bind(princess: Princess) = with(binding) {
            im.setImageResource(princess.imageId)
            tvTitle.text = princess.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrincessHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.princess_item, parent, false)
        return PrincessHolder(view)
    }

    override fun getItemCount(): Int {
        return princessList.size
    }

    override fun onBindViewHolder(holder: PrincessHolder, position: Int) {
        holder.bind(princessList[position])
    }

    fun addPrincess(princess: Princess) {
        princessList.add(princess)
        notifyDataSetChanged()
    }
}