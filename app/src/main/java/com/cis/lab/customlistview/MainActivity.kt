package com.cis.lab.customlistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = arrayOf(
            "Junior","JAVA","OIL"
        )

        val student_name = resources.getStringArray(R.array.student_name)

        val mylistview = findViewById<ListView>(R.id.mylistview)

        val arrayAdapter : ArrayAdapter<*>
        arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,student_name)
        mylistview.adapter = arrayAdapter

        mylistview.setOnItemClickListener { parent, view, position, id ->
            Log.i("listview item", position.toString())
            val itemText= parent.getItemAtPosition(position) as String
            //Toast.makeText(this,itemText,Toast.LENGTH_SHORT).show()

            val i = Intent(this,ProfileActivity::class.java)
            i.putExtra("selectedname",itemText)
            startActivity(i)
        }
    }


}
