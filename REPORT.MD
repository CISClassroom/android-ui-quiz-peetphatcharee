# รายงานผลการทดลอง

นายเมธาวี สารีผล       603410057-3
นายรุ่งโรจน์ พลเยี่ยม  603410060-4
นายกฤษฎา  ท่าสะอาด  603410032-9
นางสาวพัชรี  แอแป    603410155-3
นายสุรเดช บัวแดง       603410309-2

## Custom Listview

แสดงคำสั่งสำหรับแสดงข้อมูลชื่อนักศึกษาภายในกลุ่ม กลุ่มละไม่เกิน 4 คน รายละเอียดข้อมูลประกอบด้วย

- ชื่อ-นามสกุล
- รหัสนักศึกษา
- รูปภาพ

เมื่อทำการเลือกรายชื่อนักศึกษาจะทำการเปิดไปยังหน้าที่แสดงข้อมูลนักศึกษาเพิ่มเติม ข้อมูลนักศึกษาประกอบด้วย

- ชื่อ-นามสกุล
- รหัสนักศึกษา
- รูปภาพ
- สาขาวิชา
- อีเมล
- เบอร์โทรศัพท์
- Github

ให้นักศึกษาออกแบบ layout ได้ตามความเหมาสม

## Custom Listview Report

### ข้อมูล Array

```xml
var student: Student =Student("นายเมธาวี สารีผล", "603410057-3", R.drawable.junior)
var students = mutableListOf<Student>()
students.add(student)
students.add(Student("นายรุ่งโรจน์ พลเยี่ยม", "603410060-4", R.drawable.o))
students.add(Student("นายกฤษฎา  ท่าสะอาด", "603410032-9", R.drawable.oil))
students.add(Student("นางสาวพัชรี  แอแป", "603410155-3", R.drawable.peet))
students.add(Student("นายสุรเดช บัวแดง", "603410309-2", R.drawable.f))
```

### Custom Listview Layout

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".CustomListActivity">

    <ListView
        android:id="@+id/customlistview"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
</LinearLayout>

```

### setOnItemClickListener และการส่งข้อมูลไปอีก Activity

```kotlin
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
```

### การรับข้อมูลจากอีก Activity

```kotlin
package com.cis.lab.customlistview.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.cis.lab.customlistview.R
import com.cis.lab.customlistview.model.Student
import kotlinx.android.synthetic.main.listitem_student.view.*

public class StudentAdapter (
    var mCtx: Context,
    var resource:Int,
    var item:List<Student>
): ArrayAdapter<Student> (mCtx,resource,item){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //return super.getView(position, convertView, parent)

        val layout:LayoutInflater = LayoutInflater.from(mCtx)

        val v: View = layout.inflate(resource, null)
        val icon: ImageView = v.findViewById(R.id.imageView)
        val name: TextView = v.findViewById(R.id.textView)
        val id: TextView = v.findViewById(R.id.textView2)

        val student:Student = item[position]

        name.text = student.name
        id.text = student.id
        icon.setImageDrawable(mCtx.getDrawable(student.icon))
        return v
    }

}

```
