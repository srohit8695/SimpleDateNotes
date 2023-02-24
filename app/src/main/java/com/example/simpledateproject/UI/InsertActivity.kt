package com.example.simpledateproject.UI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.simpledateproject.databinding.ActivitySecondBinding
import com.example.simpledateproject.viewModel.InsertActivityViewModel

class InsertActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var viewModel: InsertActivityViewModel
    private var date = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[InsertActivityViewModel::class.java]
        initUi()
        listener()
    }

    private fun listener() {
        binding.save.setOnClickListener {
            viewModel.insertData(date, binding.dateText.text.toString())
        }

        viewModel.notes.observe(this, Observer {
            binding.dateText.setText(it)
        })
    }

    private fun initUi() {
        if(intent.hasExtra("date")){
            date = intent.getStringExtra("date").toString()
            binding.date.text = date
        }

        if(viewModel.checkData(date)){
            viewModel.getDataOfDate(date)
        }

    }


}