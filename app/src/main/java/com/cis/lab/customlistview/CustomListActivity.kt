package com.cis.lab.customlistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.cis.lab.customlistview.Adapter.StudentAdapter
import com.cis.lab.customlistview.model.Student

class CustomListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list)

        var student: Student =
            Student("นายเมธาวี สารีผล", "603410057-3", R.drawable.m)

        var students = mutableListOf<Student>()

        students.add(student)
        students.add(Student("นายรุ่งโรจน์ พลเยี่ยม", "603410060-4", R.drawable.m))
        students.add(Student("นายกฤษฎา  ท่าสะอาด", "603410032-9", R.drawable.m))
        students.add(Student("นางสาวพัชรี  แอแป", "603410155-3", R.drawable.w))
        students.add(Student("นายสุรเดช บัวแดง", "603410309-2", R.drawable.m))


        var listview: ListView = findViewById(R.id.customlistview)

        listview.adapter = StudentAdapter(
            this,
            R.layout.listitem_student, students
        )

        listview.setOnItemClickListener { parent, view, position, id ->
            //Toast.makeText(this,position.toString(),Toast.LENGTH_SHORT).show()
            if (position == 0) {
                var i = Intent(this, junior::class.java)
                startActivity(i)
            }
            else if (position == 1)
            {
                var i = Intent(this, o::class.java)
                startActivity(i)
            }
            else if (position == 2)
            {
                var i = Intent(this, oil::class.java)
                startActivity(i)
            }
            else if (position == 3)
            {
                var i = Intent(this, peet::class.java)
                startActivity(i)
            }
            else if (position == 4)
            {
                var i = Intent(this, france::class.java)
                startActivity(i)
            }
        }
    }
}
