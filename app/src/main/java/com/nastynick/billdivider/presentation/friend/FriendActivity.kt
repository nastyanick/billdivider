package com.nastynick.billdivider.presentation.friend

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nastynick.billdivider.R
import com.nastynick.billdivider.data.objects.Friend
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_friend.*
import javax.inject.Inject

class FriendActivity : AppCompatActivity(), FriendContact.View {

    companion object {
        private const val ARGUMENT_FRIEND_ID = "friend_id_arg"

        fun getIntent(context: Context?, friendId: String): Intent {
            return Intent(context, FriendActivity::class.java).putExtra(ARGUMENT_FRIEND_ID, friendId)
        }
    }

    @Inject
    protected lateinit var presenter: FriendContact.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friend)
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun setFriend(friend: Friend) {
        with(friend) {
            activityFriendTextViewName.setText(name)
            activityFriendTextViewEmail.setText(email)
            activityFriendTextViewPhone.setText(phone)
        }
    }

    fun getFriendId() = intent.getStringExtra(ARGUMENT_FRIEND_ID)

}