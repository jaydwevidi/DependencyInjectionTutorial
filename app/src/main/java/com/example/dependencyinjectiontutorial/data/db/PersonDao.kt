package com.example.dependencyinjectiontutorial.data.db

import androidx.lifecycle.LiveData
import com.example.dependencyinjectiontutorial.data.model.Person
interface PersonDao {

    fun addPerson(person: Person)
    fun getPersons(): LiveData<List<Person>>
    fun clearPersons()
}