package com.nastynick.billdivider.presentation.contacts

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.nastynick.billdivider.R
import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.di.DependencyResolver
import com.nastynick.billdivider.presentation.base.BaseActivity
import com.nastynick.billdivider.presentation.navigation.NavigatorsHolder
import kotlinx.android.synthetic.main.activity_contacts.*
import javax.inject.Inject

class ContactsActivity : BaseActivity(), ContactsView {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, ContactsActivity::class.java)
        }
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: ContactsPresenter

    @Inject
    protected lateinit var adapter: ContactsAdapter

    @Inject
    lateinit var navigatorsHolder: NavigatorsHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        DependencyResolver.presentationComponent().inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_contacts)
        setSupportActionBar(activityContactsToolbar)

        initViews()
        initListeners()

        presenter.onStart()
    }

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_contacts_search, menu)
        getSearchView()
                ?.also { setTextColor(it) }
                ?.let(presenter::searchCreated)

        return true
    }

    override fun onResume() {
        super.onResume()
        navigatorsHolder.addNavigator(ContactsRouter.NAME, navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorsHolder.removeNavigator(ContactsRouter.NAME)
    }

    private fun setTextColor(searchView: SearchView) {
        val searchEditText = searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
        searchEditText.setTextColor(ContextCompat.getColor(this, R.color.colorWhite))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_item_contacts_search -> true
            else -> super.onOptionsItemSelected(item)
        }
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

    private fun getSearchView(): SearchView? {
        val searchItem = activityContactsToolbar.menu.findItem(R.id.menu_item_contacts_search)
        return searchItem.actionView as? SearchView
    }

    private fun initViews() {
        activityContactsRecyclerView.layoutManager = LinearLayoutManager(this)
        activityContactsRecyclerView.adapter = adapter
    }
}