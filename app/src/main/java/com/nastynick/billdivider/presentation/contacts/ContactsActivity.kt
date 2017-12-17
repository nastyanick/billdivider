package com.nastynick.billdivider.presentation.contacts

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.nastynick.billdivider.R
import com.nastynick.billdivider.data.objects.Contact
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_contacts.*
import javax.inject.Inject

class ContactsActivity : AppCompatActivity(), ContactsContract.View {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, ContactsActivity::class.java)
        }
    }

    @Inject
    protected lateinit var presenter: ContactsContract.Presenter

    @Inject
    protected lateinit var adapter: ContactsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        setContentView(R.layout.activity_contacts)
        initViews()
        initListeners()

        presenter.onStart()
        super.onCreate(savedInstanceState)
    }

    private fun initListeners() {
        adapter.onContactSelected = presenter::contactSelected
        activityContactButtonSave.setOnClickListener { presenter.saveButtonClicked() }
    }


    override fun setContacts(contacts: List<Contact>) {
        adapter.setContacts(contacts)
        adapter.notifyDataSetChanged()
    }

    override fun setContactSelected(contactId: Long) {
        adapter.addSelectedContact(contactId)
    }

    override fun clearContactSelection(contactId: Long) {
        adapter.removeSelectedContact(contactId)
    }

    override fun updateContact(contact: Contact) {
        adapter.notifyContactChanged(contact)
    }

    override fun close() {
        finish()
    }

    private fun initViews() {
        activityContactsRecyclerView.layoutManager = LinearLayoutManager(this)
        activityContactsRecyclerView.adapter = adapter
    }

}