package com.nastynick.billdivider.presentation.friend

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.nastynick.billdivider.R
import com.nastynick.billdivider.data.objects.Friend
import com.nastynick.billdivider.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_friend.*
import javax.inject.Inject

class FriendActivity : BaseActivity(), FriendView {

    companion object {
        private const val ARGUMENT_FRIEND_ID = "friend_id_arg"

        fun getIntent(context: Context?, friendId: Long): Intent {
            return Intent(context, FriendActivity::class.java).putExtra(ARGUMENT_FRIEND_ID, friendId)
        }
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: FriendPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        getComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friend)
    }

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun setFriend(friend: Friend) {
        with(friend) {
            activityFriendTextViewName.setText(name)
            activityFriendTextViewEmail.setText(email)
            activityFriendTextViewPhone.setText(phone)
        }
    }

    fun getFriendId() = intent.getLongExtra(ARGUMENT_FRIEND_ID, 0)
}