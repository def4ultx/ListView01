package com.example.bally.listview01

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_listview.adapter = myCustomAdapter(this)
        main_listview.setOnItemClickListener { adapterView, view, i, l ->
            val item = adapterView.getItemAtPosition(i) as String
            Log.d("Result", "$item at position $i")
            var intent = Intent(this, DetailActivity::class.java)

            intent.putExtra("name", item)
            intent.putExtra("id", i.toString())
            if (i % 2 == 0)
                intent.putExtra("picture", "ic_launcher_round")
            else
                intent.putExtra("picture", "ic_launcher")
            startActivity(intent)
        }
    }

    private class myCustomAdapter(context: Context): BaseAdapter() {
        private val mContext: Context
        private val names = arrayListOf<String>("Luke Skywalker", "Han Solo", "Wookie", "Master Yoda", "Darth Vader" )
        init {
            mContext = context
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return names[position]
        }

        override fun getCount(): Int {
            return names.size
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val grayColor = Color.GRAY
            val whiteColor = Color.WHITE
            val rowMain: View
            if(convertView == null) {
                val layoutInflator = LayoutInflater.from(viewGroup!!.context) //mContext
                rowMain = layoutInflator.inflate(R.layout.row_main, viewGroup, false)
                val viewHolder = ViewHolder(rowMain.name_textView, rowMain.position_textView, rowMain.imageView)
                rowMain.tag = viewHolder
//            Log.d("context result", "load context")
            } else rowMain = convertView

            val viewHolder = rowMain.tag as ViewHolder
//            Log.d("result", "load name_textView")
            viewHolder.nameTextView.text = names.get(position)

//            Log.d("result", "load position_textView")
            viewHolder.positionTextView.text = "Row Number: $position"
//            Log.d("result", "load name_textView")
//            rowMain.name_textView.text = names.get(position)
//            Log.d("result", "load position_textView")
//            rowMain.position_textView.text = "Row Number: $position"
            if (position % 2 == 0) {
                rowMain.setBackgroundColor(whiteColor)
                viewHolder.rowImageView!!.setImageResource(R.mipmap.ic_launcher_round)
            } else {
                rowMain.setBackgroundColor(grayColor)
                viewHolder.rowImageView!!.setImageResource(R.mipmap.ic_launcher)
            }
            return rowMain
        }

        private class ViewHolder(val nameTextView: TextView, val positionTextView: TextView, val rowImageView: ImageView) {

        }
    }
}
