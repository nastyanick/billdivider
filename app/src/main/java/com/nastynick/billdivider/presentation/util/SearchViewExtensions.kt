package com.nastynick.billdivider.presentation.util

import androidx.appcompat.widget.SearchView
import io.reactivex.Observable

fun SearchView.getSearchListener(): Observable<String> {
    return Observable.create<String> { source ->
        setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                source.onNext(query)
                source.onComplete()
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                source.onNext(newText)
                return true
            }
        })
    }
}