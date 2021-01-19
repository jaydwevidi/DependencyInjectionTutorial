package com.example.dependencyinjectiontutorial.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dependencyinjectiontutorial.MyRecyclerAdapter
import com.example.dependencyinjectiontutorial.R
import com.example.dependencyinjectiontutorial.data.model.Person
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sampleDataSet = listOf<Person>()


        val viewModel = ViewModelProvider(this).get(PersonViewModel::class.java)
        viewModel.getPersons().observe(this, Observer<List<Person>> { it ->
            Log.e(TAG, "new data $it")
            //this log.d message don't show every time for some reason,
            //but sampleDataSet is updated whenever viewModel is changed
            sampleDataSet = it
        })

        val myAdapter = MyRecyclerAdapter(sampleDataSet)
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        insertButton.setOnClickListener {
            val name = editTextTextPersonName.text.toString()
            viewModel.addPerson(Person(324,name))
            /*myAdapter.notifyDataSetChanged()*/
            myAdapter.dataList = sampleDataSet
            editTextTextPersonName.setText("")
            myAdapter.notifyDataSetChanged()
        }

        clearButton.setOnClickListener {
            viewModel.clearAll()
            myAdapter.notifyDataSetChanged()
        }


    }
}