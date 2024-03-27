package com.butas_butchnino.midtermexam.adapters

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.butas_butchnino.midtermexam.R

class ArchiveAdapter(private val archivedContacts: MutableList<String>) :
    RecyclerView.Adapter<ArchiveAdapter.ArchiveViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArchiveViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_archive, parent, false)
        return ArchiveViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ArchiveViewHolder, position: Int) {
        val currentContact = archivedContacts[position]
        holder.textViewArchivedContactName.text = currentContact
    }

    override fun getItemCount() = archivedContacts.size

    inner class ArchiveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewArchivedContactName: TextView = itemView.findViewById(R.id.text_archived_contact_name)
    }
}
