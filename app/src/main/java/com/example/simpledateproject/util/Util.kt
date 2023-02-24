package com.example.simpledateproject.util

import android.content.Context
import com.example.simpledateproject.R

object Util {

    fun getAllYears() : ArrayList<String>{
        val yearArrayList = ArrayList<String>()

        for(i in 1980..2040){
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

    fun getDates( year : String, month : String, context : Context) : Int{
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


}