package cubex.mahesh.incomeexpensesapp_mvp.presenter

import cubex.mahesh.incomeexpensesapp_mvp.beans.IncExpBean

interface  IncExpPresenterAPI
{

    fun  addInc(bean:IncExpBean)
    fun  addExp(bean:IncExpBean)
    fun  viewExp()
    fun  viewInc()
    fun  viewIncExp()

}