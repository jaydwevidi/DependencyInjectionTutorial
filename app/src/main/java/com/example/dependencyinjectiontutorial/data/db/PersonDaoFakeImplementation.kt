package com.example.dependencyinjectiontutorial.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dependencyinjectiontutorial.data.model.Person

class PersonDaoFakeImplementation : PersonDao{

    private var list = mutableListOf<Person>()
    private var liveList = MutableLiveData<List<Person>>()

    override fun addPerson(person: Person) {
        list.add(person)
    }

    override fun getPersons(): LiveData<List<Person>> {
        var liveList = MutableLiveData<List<Person>>()
        liveList.value = list
        return liveList
    }

    override fun clearPersons() {
        list.clear()
    }

}