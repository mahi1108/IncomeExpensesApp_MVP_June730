package cubex.mahesh.incomeexpensesapp_mvp.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import cubex.mahesh.incomeexpensesapp_mvp.beans.IncExpBean
import cubex.mahesh.incomeexpensesapp_mvp.presenter.IncExpPresenterAPI
import cubex.mahesh.incomeexpensesapp_mvp.view.IncExpViewApi
import cubex.mahesh.incomeexpensesapp_mvp.view.MainActivity

class IncExpModel : IncExpPresenterAPI
{
    lateinit  var dBase:SQLiteDatabase

    lateinit  var mActivity : MainActivity

    constructor(view_api:IncExpViewApi)
    {
        /* IncExpViewApi view_api = new MainActivity( );
            MainActivity   mActivity = (MainActivity)view_api */
         mActivity= view_api as MainActivity
            dBase = mActivity.openOrCreateDatabase("incexp_db",
                    Context.MODE_PRIVATE,null)
        dBase.execSQL("create table if not exists incexp(_id integer primary key autoincrement,type varchar(15),money integer,description varchar(1000)) ")
    }

    override fun addInc(bean: IncExpBean) {
        var cv = ContentValues( )
        cv.put("type",bean.type)
        cv.put("money",bean.money)
        cv.put("description",bean.desc)

   var status =  dBase.insert("incexp",null,
           cv)
   lateinit var msg:String
        if(status==-1.toLong()){
            msg = "Record Insertion Failed"
        }else{
            msg = "Record Insertion Success"
        }
        mActivity.addIncResult(msg)
    }

    override fun addExp(bean: IncExpBean) {
        var cv = ContentValues( )
        cv.put("type",bean.type)
        cv.put("money",bean.money)
        cv.put("description",bean.desc)

        var status =  dBase.insert("incexp",null,
                cv)
        lateinit var msg:String
        if(status==-1.toLong()){
            msg = "Record Insertion Failed"
        }else{
            msg = "Record Insertion Success"
        }
        mActivity.addExpResult(msg)
    }

    override fun viewExp() {
   var c = dBase.query("incexp",null,
                    "type=?",
                    arrayOf("Expense"),null,
                    null,null)
        var list = mutableListOf<IncExpBean>()
        while (c.moveToNext()){
            var bean = IncExpBean(c.getInt(0),
                    c.getString(1),c.getInt(2),
                    c.getString(3))
            list.add(bean)
        }
        mActivity.viewExpResult(list)
    }

    override fun viewInc() {
        var c = dBase.query("incexp",null,
                "type=?",
                arrayOf("Income"),null,
                null,null)
        var list = mutableListOf<IncExpBean>()
        while (c.moveToNext()){
            var bean = IncExpBean(c.getInt(0),
                    c.getString(1),c.getInt(2),
                    c.getString(3))
            list.add(bean)
        }
        mActivity.viewIncResult(list)
    }

    override fun viewIncExp() {
        var c = dBase.query("incexp",null,
                null,
                null,null,
                null,null)
        var list = mutableListOf<IncExpBean>()
        while (c.moveToNext()){
            var bean = IncExpBean(c.getInt(0),
                    c.getString(1),c.getInt(2),
                    c.getString(3))
            list.add(bean)
        }
        mActivity.viewIncExpResult(list)
    }

}