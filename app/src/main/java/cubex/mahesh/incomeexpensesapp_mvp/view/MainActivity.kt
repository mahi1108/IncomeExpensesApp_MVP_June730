package cubex.mahesh.incomeexpensesapp_mvp.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cubex.mahesh.incomeexpensesapp_mvp.R
import cubex.mahesh.incomeexpensesapp_mvp.beans.IncExpBean

class MainActivity : IncExpViewApi,AppCompatActivity() {
    override fun addIncResult(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addExpResult(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun viewExpResult(list: MutableList<IncExpBean>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun viewIncResult(list: MutableList<IncExpBean>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun viewIncExpResult(list: MutableList<IncExpBean>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
