package com.example.dependencyinjectiontutorial.ui

import androidx.lifecycle.ViewModel
import com.example.dependencyinjectiontutorial.data.db.PersonDaoFakeImplementation
import com.example.dependencyinjectiontutorial.data.model.Person
import com.example.dependencyinjectiontutorial.data.repository.PersonRepository
import com.example.dependencyinjectiontutorial.data.repository.PersonRepositoryImplementation

class PersonViewModel : ViewModel() {

    private var personRepository: PersonRepository
            = PersonRepositoryImplementation(PersonDaoFakeImplementation())

    fun addPerson(person: Person) = personRepository.addPerson(person)
    fun clearAll() = personRepository.clearPersons()
    fun getPersons() = personRepository.getPersons()

}