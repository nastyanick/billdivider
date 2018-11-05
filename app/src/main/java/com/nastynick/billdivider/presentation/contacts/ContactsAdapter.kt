package com.nastynick.billdivider.presentation.contacts

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nastynick.billdivider.R
import com.nastynick.billdivider.data.objects.Contact
import kotlinx.android.synthetic.main.item_contact.view.*
import javax.inject.Inject

class ContactsAdapter @Inject constructor() : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {
    var onContactSelected: ((Contact) -> Unit)? = null


    private var contacts = listOf<Contact>()
    private val selectedContactsIds = mutableListOf<Long>()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getContact(position).let { contact ->
            with(holder) {
                bind(contact)
                isSelected(contact).let(this::setSelected)
            }
        }
    }

    override fun getItemCount() = getContacts().size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent.context).inflate(R.layout.item_contact, null)
                .let(this::ViewHolder)
    }


    fun setContacts(contacts: List<Contact>) {
        this.contacts = contacts
    }

    fun addSelectedContact(contactId: Long) {
        selectedContactsIds.add(contactId)
    }

    fun removeSelectedContact(contactId: Long) {
        selectedContactsIds.remove(contactId)
    }

    private fun isSelected(contact: Contact): Boolean {
        return selectedContactsIds.contains(contact.id)
    }

    fun notifyContactChanged(contact: Contact) {
        getContacts().indexOf(contact).let(this::notifyItemChanged)
    }

    private fun getContacts() = contacts

    private fun getContact(position: Int) = getContacts()[position]

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        init {
            view.setOnClickListener {
                getContact(adapterPosition).let {
                    onContactSelected?.invoke(it)
                }
            }
        }

        fun bind(contact: Contact) {
            with(contact) {
                view.itemContactTextViewName.setText(name)
                view.itemContactTextViewPhone.setText(phone ?: email)
                view.itemContactCircularImageView.setImage(contact.photoUri)
            }
        }

        fun setSelected(isSelected: Boolean) {
            view.isSelected = isSelected
            view.itemContactCircularImageView.isSelected = isSelected
        }
    }
}
