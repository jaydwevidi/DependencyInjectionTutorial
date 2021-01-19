package com.example.dependencyinjectiontutorial.data.repository

import androidx.lifecycle.LiveData
import com.example.dependencyinjectiontutorial.data.db.PersonDao
import com.example.dependencyinjectiontutorial.data.model.Person

class PersonRepositoryImplementation(private val personDao: PersonDao) : PersonRepository{

    override fun addPerson(person: Person) {
        personDao.addPerson(person)
    }

    override fun clearPersons() {
        personDao.clearPersons()
    }

    override fun getPersons(): LiveData<List<Person>> {
        return personDao.getPersons()
    }
}