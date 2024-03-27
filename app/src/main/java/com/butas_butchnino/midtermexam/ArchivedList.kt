package com.butas_butchnino.midtermexam

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.butas_butchnino.midtermexam.adapters.ArchiveAdapter

class ArchivedList : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var archivedContacts: MutableList<String>
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_archived_list)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("ContactData", Context.MODE_PRIVATE)

        // Load archived contacts from SharedPreferences
        loadArchivedContacts()

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_archives)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Create adapter for archived contacts and set it to RecyclerView
        val adapter = ArchiveAdapter(archivedContacts)
        recyclerView.adapter = adapter
    }

    private fun loadArchivedContacts() {
        val archivedContactsString = sharedPreferences.getString("archived_contacts", null)
        archivedContacts = if (archivedContactsString != null) {
            deserializeArchivedContacts(archivedContactsString)
        } else {
            mutableListOf()
        }
    }

    private fun deserializeArchivedContacts(archivedContactsString: String): MutableList<String> {
        return archivedContactsString.split("|").toMutableList()
    }
}
