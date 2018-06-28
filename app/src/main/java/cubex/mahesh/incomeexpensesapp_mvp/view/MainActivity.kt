package cubex.mahesh.incomeexpensesapp_mvp.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import cubex.mahesh.incomeexpensesapp_mvp.R
import cubex.mahesh.incomeexpensesapp_mvp.beans.IncExpBean
import cubex.mahesh.incomeexpensesapp_mvp.model.IncExpModel
import cubex.mahesh.incomeexpensesapp_mvp.presenter.IncExpPresenterAPI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : IncExpViewApi,AppCompatActivity() {
    override fun addIncResult(msg: String) {
            Toast.makeText(this,
                    msg,Toast.LENGTH_LONG).show()
    }

    override fun addExpResult(msg: String) {
        Toast.makeText(this,
                msg,Toast.LENGTH_LONG).show()
    }

    override fun viewExpResult(list: MutableList<IncExpBean>) {
        var temp_list = mutableListOf<String>()
        for(bean in list){
            temp_list.add("${bean._id}   ${bean.type} ${bean.money} ${bean.desc}")
        }
        var adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice,temp_list)
        lview.adapter = adapter

    }

    override fun viewIncResult(list: MutableList<IncExpBean>) {
        var temp_list = mutableListOf<String>()
        for(bean in list){
            temp_list.add("${bean._id}   ${bean.type} ${bean.money} ${bean.desc}")
        }
        var adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice,temp_list)
        lview.adapter = adapter
    }

    override fun viewIncExpResult(list: MutableList<IncExpBean>) {
        var temp_list = mutableListOf<String>()
        for(bean in list){
            temp_list.add("${bean._id}   ${bean.type} ${bean.money} ${bean.desc}")
        }
        var adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice,temp_list)
        lview.adapter = adapter
   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

var model:IncExpPresenterAPI = IncExpModel(this);
// IncExpPresenterAPI api = new IncExpModel( ); UpCasting

        add_inc.setOnClickListener({
           var ie_bean = IncExpBean(0,sp1.selectedItem.toString(),
                   money.text.toString().toInt(),desc.text.toString())
                model.addInc(ie_bean)
        })
        add_exp.setOnClickListener({
            var ie_bean = IncExpBean(0,sp1.selectedItem.toString(),
                    money.text.toString().toInt(),desc.text.toString())
            model.addExp(ie_bean)
        })
        view_inc.setOnClickListener({
            model.viewInc()
        })
        view_exp.setOnClickListener({
            model.viewExp()
        })
        inc_exp.setOnClickListener({
            model.viewIncExp()
        })
    }
}
