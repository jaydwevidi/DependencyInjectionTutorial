package com.example.dependencyinjectiontutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sampleDataSet = mutableListOf<Person>()

        sampleDataSet.add(Person(43,"Lex Luther"))
        sampleDataSet.add(Person(43,"Clark Kent"))
        sampleDataSet.add(Person(43,"Diana Prince"))
        sampleDataSet.add(Person(43,"Bruce Wayne"))
        sampleDataSet.add(Person(43,"Bruce Wayne"))

        val myAdapter = MyRecyclerAdapter(sampleDataSet)
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        insertButton.setOnClickListener {
            val name = editTextTextPersonName.text.toString()
            myAdapter.add(Person(45, name))
        }

        clearButton.setOnClickListener {
            myAdapter.clear()
        }
    }
}