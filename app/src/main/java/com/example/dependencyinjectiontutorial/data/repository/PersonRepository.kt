package com.example.dependencyinjectiontutorial.data.repository


import androidx.lifecycle.LiveData
import com.example.dependencyinjectiontutorial.data.model.Person

interface PersonRepository {
    fun addPerson(person: Person)
    fun clearPersons()
    fun getPersons(): LiveData<List<Person>>
}