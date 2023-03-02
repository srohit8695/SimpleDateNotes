package com.example.simpledateproject.util

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import com.example.simpledateproject.R

object Util {

    fun getAllYears() : ArrayList<String>{
        val yearArrayList = ArrayList<String>()

        for(i in 2023..2040){
            yearArrayList.add(i.toString())
        }

        return yearArrayList
    }


    fun getAllMonth(context : Context) : ArrayList<String>{
        var monthArrayList = ArrayList<String>()

        monthArrayList.add(context.getString(R.string.january))
        monthArrayList.add(context.getString(R.string.february))
        monthArrayList.add(context.getString(R.string.march))
        monthArrayList.add(context.getString(R.string.april))
        monthArrayList.add(context.getString(R.string.may))
        monthArrayList.add(context.getString(R.string.june))
        monthArrayList.add(context.getString(R.string.july))
        monthArrayList.add(context.getString(R.string.august))
        monthArrayList.add(context.getString(R.string.september))
        monthArrayList.add(context.getString(R.string.october))
        monthArrayList.add(context.getString(R.string.november))
        monthArrayList.add(context.getString(R.string.december))

        return monthArrayList
    }

    fun getNumberOfDaysInMonth( year : String, month : String, context : Context) : Int{
        var days = 0

        if( month == context.getString(R.string.january) ||
            month == context.getString(R.string.march) ||
            month == context.getString(R.string.may) ||
            month == context.getString(R.string.july) ||
            month == context.getString(R.string.august) ||
            month == context.getString(R.string.october) ||
            month == context.getString(R.string.december)
        ){
            days = 31
        }else if(month == context.getString(R.string.february) ){
            if(year.toInt()%4 == 0){
                days = 29
            }
            else{
                days = 28
            }
        }
        else{
            days = 30
        }

        return days
    }

    fun calculateFirstDayInMonth( month : Int, year : String) : Int{
        var y = year.toInt()
        var m = month + 1
        val d = 1
        val t = arrayOf( 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4)
        if (m < 3) y--
        return ((y + y / 4 - y / 100 + y / 400 + t[m - 1] + d) % 7)
    }

    /*
    If AdapterView.OnItemSelectedListener is used directly then
    app is crashed on rotating the screen and if I use extension
    function the app is not getting crash on rotating the screen
    */
    fun Spinner.selectedFromSpinner(action: (position:Int) -> Unit) {
        this.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                action(position)
            }
        }
    }

}