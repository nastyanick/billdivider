package com.nastynick.billdivider.presentation.friends

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nastynick.billdivider.R
import com.nastynick.billdivider.data.objects.Friend
import kotlinx.android.synthetic.main.item_contact.view.*
import javax.inject.Inject

class FriendsAdapter @Inject constructor() : RecyclerView.Adapter<FriendsAdapter.ViewHolder>() {
    var onFriendClick: ((Friend) -> Unit)? = null

    private var friends = listOf<Friend>()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getFriend(position).let { contact ->
            with(holder) {
                bind(contact)
            }
        }
    }

    override fun getItemCount() = getFriends().size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent.context)
                .inflate(R.layout.item_contact, null)
                .let(this::ViewHolder)
    }

    fun setFriends(friends: List<Friend>) {
        this.friends = friends
    }


    private fun getFriends() = friends

    private fun getFriend(position: Int) = getFriends()[position]

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        init {
            view.setOnClickListener {
                getFriend(adapterPosition).let {
                    onFriendClick?.invoke(it)
                }
            }
        }

        fun bind(friend: Friend) {
            with(friend) {
                view.itemContactTextViewName.setText(name)
                view.itemContactTextViewPhone.setText(phone ?: email)
            }
        }
    }
}
