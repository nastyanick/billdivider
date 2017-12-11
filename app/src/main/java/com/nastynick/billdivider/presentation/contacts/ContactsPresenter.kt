package com.nastynick.billdivider.presentation.contacts

import com.nastynick.billdivider.domain.usecase.contact.GetContactsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ContactsPresenter @Inject constructor(
        private val view: ContactsContract.View,
        private val getContactsUseCase: GetContactsUseCase
) : ContactsContract.Presenter {

    override fun onStart() {
        getContactsUseCase.getContacts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { contacts -> view.setContacts(contacts) }
    }
}