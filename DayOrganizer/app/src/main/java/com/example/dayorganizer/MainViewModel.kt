package com.example.dayorganizer

import androidx.lifecycle.ViewModel

private var day1 = Day()
private var day2 = Day()
private var day3 = Day()
public fun createDays(){
    day1.date = "dzisiaj"
    //var t = Task(taskName = "zad 1 ", taskStatus = "zrobione")
    //day1.taskList.add(t)
    day2.date = "wczoraj"
    //day2.taskList.add(t)
    //day2.taskList.add(t)
    day3.date = "jutro"
    //day3.taskList.add(t)
    //day3.taskList.add(t)
   // day3.taskList.add(t)
}
private val list = listOf(day1, day2, day3)

interface Server{
    fun loadDataFromDB(): List<Day>
}

class MainViewModel: ViewModel(), Server {
    private var day: Day? = null
    //private var task: Task? = null

    override fun loadDataFromDB(): List<Day> {
        //select  days from data base
        //select tasks from data base
        //compose them
        //return
        createDays()
        return list
    }

    fun setDay(day: Day){
        this.day = day
    }

    fun getDay()= day

//    fun setTask(task: Task){
//        this.task = task
//    }
//
//    fun getTask()= task
}