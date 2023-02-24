package com.example.simpledateproject.UI

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.simpledateproject.adapter.DateAdapter
import com.example.simpledateproject.databinding.ActivityMainBinding
import com.example.simpledateproject.util.Util

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var yearArrayList = ArrayList<String>()
    private var monthArrayList = ArrayList<String>()
    private lateinit var dateAdapter: DateAdapter
    private var selectMonth = "January"
    private var selectYear = "1980"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUIs()
        listener()
    }

    private fun initUIs() {
        initYearSpinner()
        initMonthSpinner()
    }

    private fun listener() {

        binding.yearSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                selectYear = yearArrayList[position]
                initRecyclerView(selectYear, selectMonth)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }


        binding.monthSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                selectMonth = monthArrayList[position]
                initRecyclerView(selectYear, selectMonth)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

    }

    private fun initYearSpinner(){

        yearArrayList = Util.getAllYears()
        val yearAdapter = ArrayAdapter(this, R.layout.simple_spinner_item, yearArrayList)
        binding.yearSpinner.adapter = yearAdapter

    }

    private fun initMonthSpinner(){

        monthArrayList = Util.getAllMonth(this)
        val monthAdapter = ArrayAdapter(this, R.layout.simple_spinner_item, monthArrayList)
        binding.monthSpinner.adapter = monthAdapter

    }

    private fun initRecyclerView( year: String, month: String){

        var dateArrayList = ArrayList<String>()
        var days = Util.getDates(year,month,this)

        for(i in 1..days){
            dateArrayList.add(i.toString())
        }

        dateAdapter = DateAdapter(
            dateArrayList,
            { position ->
                val date = "${dateArrayList[position]}-${month}-${year}"
                val intent = Intent(this, InsertActivity::class.java)
                intent.putExtra("date", date)
                startActivity(intent)
            },
        )
        binding.recyclerViewDate.adapter = dateAdapter
    }


}