package com.nastynick.billdivider.presentation.contacts

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nastynick.billdivider.R
import com.nastynick.billdivider.data.objects.Contact
import kotlinx.android.synthetic.main.item_contact.view.*
import javax.inject.Inject

class ContactsAdapter @Inject constructor() : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {
    private var contacts: List<Contact> = listOf()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getContact(position).let(holder::bind)
    }

    override fun getItemCount() = contacts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent.context).inflate(R.layout.item_contact, null)
                .let(this::ViewHolder)
    }


    fun setContacts(contacts: List<Contact>) {
        this.contacts = contacts
    }

    private fun getContact(position: Int) = contacts[position]

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(contact: Contact) {
            with(contact) {
                view.itemContactTextViewName.setText(name)
                view.itemContactTextViewPhone.setText(phone)
                view.itemContactCircularImageView.setImage(contact.photoUri)
            }
        }
    }
}
