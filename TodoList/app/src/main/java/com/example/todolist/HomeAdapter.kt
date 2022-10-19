package com.example.todolist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.HomeListBinding

class HomeAdapter(val context: Context) :
    RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
        var dataList = mutableListOf<TodoData>()

    inner class MyViewHolder(private val binding: HomeListBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(data: TodoData) {
            binding.title.text = data.title
            binding.write.text = data.write
            binding.writeLayout.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra("data", data)
                }.run { context.startActivity(this) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = HomeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
    interface HomeAction {

    }

}