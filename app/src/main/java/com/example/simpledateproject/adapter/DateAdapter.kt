package com.example.simpledateproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpledateproject.databinding.DateRecyclerviewBinding

class DateAdapter(var dateList: List<String>,
                  private val onClickListener: (Int) -> Unit) : RecyclerView.Adapter<DateAdapter.DateViewHolder>() {

    inner class DateViewHolder(val binding : DateRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): DateViewHolder {
        val binding = DateRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        with(holder){
                binding.dates.text = dateList[position]
                binding.dates.setOnClickListener {
                    onClickListener(position)
                }
        }
    }

    override fun getItemCount(): Int {
        return dateList.size
    }

}