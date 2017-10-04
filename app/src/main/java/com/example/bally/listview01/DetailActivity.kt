package com.example.bally.listview01

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_detail2.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail2)
        val data = intent.extras
        if (data != null) {
            var name: String = data.getString("name")
            var id: String = data.getString("id")
            val picture: String = data.getString("picture")
            textView.setText("$name")
            textView2.setText("$id")
            val resID = resources.getIdentifier(picture, "mipmap", "com.example.bally.listview01")
            imageView2.setImageResource(resID)
        }
    }

//    fun actionClickHandler(item: MenuItem) {
//        finish()
//
//    }
//
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        val id = item!!.itemId
//        if (id == R.id.action_home) {
//            return true
//        }
//        return super.onOptionsItemSelected(item)
        finish()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)

        return super.onCreateOptionsMenu(menu)
    }

    //    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        val id = item?.itemId
//
//        if(id == R.id.backArrow)      return true;
//
//        return super.onOptionsItemSelected(item)
//    }
//
//    fun backHome(item: MenuItem?) {
//        this.finish()
//    }
//    public override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            android.R.id.home -> {
//                // todo: goto back activity from here
//
//                val intent = Intent(this@DetailActivity, MainActivity::class.java)
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
//                startActivity(intent)
//                finish()
//                return true
//            }
//
//            else -> return super.onOptionsItemSelected(item)
//        }
//    }
}
