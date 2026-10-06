package com.xcore.aicodestudio
import android.app.Activity
import android.os.Bundle
import android.widget.*
import android.view.LayoutInflater

class MainActivity: Activity() {
 companion object { init { System.loadLibrary("xcore") } }
 external fun nativeHealth(): Int
 override fun onCreate(state: Bundle?) {
  super.onCreate(state); setContentView(R.layout.activity_main)
  val list=findViewById<LinearLayout>(R.id.projectList)
  list.addView(project("MyFirstApp","/storage/emulated/0/X-Core/Projects/MyFirstApp","Last opened: Just now"))
  list.addView(project("CalculatorApp","/storage/emulated/0/X-Core/Projects/CalculatorApp","Last opened: 2 hours ago"))
  list.addView(project("NotesApp","/storage/emulated/0/X-Core/Projects/NotesApp","Last opened: Yesterday"))
  list.addView(project("TodoApp","/storage/emulated/0/X-Core/Projects/TodoApp","Last opened: 2 days ago"))
  findViewById<Button>(R.id.chatAi).setOnClickListener { Toast.makeText(this,"Chat AI ready",Toast.LENGTH_SHORT).show() }
  findViewById<TextView>(R.id.terminal).setOnClickListener { Toast.makeText(this,"Terminal ready • native="+nativeHealth(),Toast.LENGTH_SHORT).show() }
  findViewById<TextView>(R.id.menu).setOnClickListener { Toast.makeText(this,"X-Core Menu",Toast.LENGTH_SHORT).show() }
 }
 private fun project(n:String,p:String,l:String)=LayoutInflater.from(this).inflate(R.layout.item_project,null).apply {
  findViewById<TextView>(R.id.name).text=n; findViewById<TextView>(R.id.path).text=p; findViewById<TextView>(R.id.last).text=l
  setOnClickListener { Toast.makeText(this@MainActivity,"Opening $n",Toast.LENGTH_SHORT).show() }
 }
}