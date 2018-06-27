package cubex.mahesh.incomeexpensesapp_mvp.view

import cubex.mahesh.incomeexpensesapp_mvp.beans.IncExpBean

interface IncExpViewApi
{
    fun  viewExpResult(list:MutableList<IncExpBean>)
    fun  viewIncResult(list:MutableList<IncExpBean>)
    fun  viewIncExpResult(list:MutableList<IncExpBean>)
    fun  addIncResult(msg:String)
    fun  addExpResult(msg:String)
}