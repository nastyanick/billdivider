package com.nastynick.billdivider.presentation.contacts

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.nastynick.billdivider.R
import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.presentation.base.BaseActivity
import com.nastynick.billdivider.presentation.util.StubUtil
import com.nastynick.billdivider.presentation.util.getSearchListener
import kotlinx.android.synthetic.main.activity_contacts.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class ContactsActivity : BaseActivity(), ContactsView {

    companion object {
        private const val REQUEST_CODE_GRANT_READ_CONTACTS_PERMISSION = 1

        fun getIntent(context: Context): Intent {
            return Intent(context, ContactsActivity::class.java)
        }
    }

    @Inject
    protected lateinit var adapter: ContactsAdapter

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var stubUtil: StubUtil

    @Inject
    @InjectPresenter
    lateinit var presenter: ContactsPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        getComponent().inject(this)

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_contacts)
        setSupportActionBar(activityContactsToolbar)

        initViews()
        initListeners()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_contacts_search, menu)
//        val searchView = getSearchView()
//        presenter.searchCreated(searchView.getSearchListener())
        return true
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_item_contacts_search -> {
                stubUtil.showUnderDevelopmentMessage()
                true
            }
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

    private fun getSearchView(): SearchView {
        val searchItem = activityContactsToolbar.menu.findItem(R.id.menu_item_contacts_search)
        return searchItem.actionView as SearchView
    }

    private fun initViews() {
        activityContactsRecyclerView.layoutManager = LinearLayoutManager(this)
        activityContactsRecyclerView.adapter = adapter
    }
}