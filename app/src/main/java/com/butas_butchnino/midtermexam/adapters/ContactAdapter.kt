package com.butas_butchnino.midtermexam.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.butas_butchnino.midtermexam.R
import com.butas_butchnino.midtermexam.model.Contact

class ContactAdapter(private val contacts: MutableList<Contact>, private val onArchiveButtonClick: (Int) -> Unit) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentContact = contacts[position]
        holder.textViewContactName.text = currentContact.name
        holder.archiveButton.setOnClickListener {
            onArchiveButtonClick(position)
            // Notify adapter that item has been removed
            notifyItemRemoved(position)
        }
    }



    override fun getItemCount() = contacts.size

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewContactName: TextView = itemView.findViewById(R.id.text_contact_name)
        val archiveButton: Button = itemView.findViewById(R.id.btn_archive)
    }
}
