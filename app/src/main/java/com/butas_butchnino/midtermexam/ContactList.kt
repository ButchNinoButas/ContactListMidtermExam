package com.butas_butchnino.midtermexam

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.butas_butchnino.midtermexam.adapters.ContactAdapter
import com.butas_butchnino.midtermexam.model.Contact

class ContactList : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var contacts: MutableList<Contact>
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("ContactData", Context.MODE_PRIVATE)

        // Load contacts from SharedPreferences or initialize with predefined values
        loadContacts()

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_contact_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ContactAdapter(contacts, this::onArchiveButtonClick)
        recyclerView.adapter = adapter
    }

    private fun loadContacts() {
        val contactsString = sharedPreferences.getString("contacts", null)
        contacts = if (!contactsString.isNullOrBlank()) {
            deserializeContacts(contactsString)
        } else {
            // Initialize with predefined values if SharedPreferences is empty
            mutableListOf(
                Contact("John Doe"),
                Contact("Jane Smith"),
                Contact("Michael Johnson"),
                // Add more predefined contacts here if needed
                Contact("Emily Davis"),
                Contact("Robert Brown"),
                Contact("Olivia Wilson"),
                Contact("William Martinez"),
                Contact("Sophia Anderson"),
                Contact("James Taylor"),
                Contact("Isabella Thomas"),
                Contact("David Garcia"),
                Contact("Charlotte Harris"),
                Contact("Daniel Clark"),
                Contact("Amelia Lee"),
                Contact("Joseph Walker"),
                Contact("Grace Rodriguez"),
                Contact("Samuel White"),
                Contact("Ava Martinez"),
                Contact("Benjamin Young"),
                Contact("Mia Scott")
            )
        }
    }

    private fun onArchiveButtonClick(position: Int) {
        val contact = contacts[position]
        if (contact.name.isNotBlank()) {
            addArchivedContact(contact.name)
            contacts.removeAt(position)
            recyclerView.adapter?.notifyItemRemoved(position)

            // Save updated contact list to SharedPreferences
            saveContacts()
        }
    }


    private fun saveContacts() {
        val editor = sharedPreferences.edit()
        val contactsString = serializeContacts(contacts)
        editor.putString("contacts", contactsString)
        editor.apply()
    }

    private fun serializeContacts(contacts: List<Contact>): String {
        val stringBuilder = StringBuilder()
        for (contact in contacts) {
            stringBuilder.append("${contact.name}|")
        }
        return stringBuilder.toString()
    }

    private fun deserializeContacts(contactsString: String): MutableList<Contact> {
        val contactsList = mutableListOf<Contact>()
        val contactStrings = contactsString.split("|")
        for (contactString in contactStrings) {
            contactsList.add(Contact(contactString))
        }
        return contactsList
    }

    private fun addArchivedContact(name: String) {
        val archivedContactsString = sharedPreferences.getString("archived_contacts", null)
        val editor = sharedPreferences.edit()
        val newArchivedContactsString = if (!archivedContactsString.isNullOrBlank()) {
            archivedContactsString + "|$name"
        } else {
            name
        }
        editor.putString("archived_contacts", newArchivedContactsString)
        editor.apply()
    }
}
