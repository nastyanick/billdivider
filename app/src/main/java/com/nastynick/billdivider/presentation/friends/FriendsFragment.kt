package com.nastynick.billdivider.presentation.friends

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nastynick.billdivider.R
import com.nastynick.billdivider.data.objects.Friend
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_friends.*
import javax.inject.Inject

class FriendsFragment : Fragment(), FriendsContract.View {

    companion object {
        fun getInstance(): Fragment {
            return FriendsFragment()
        }
    }

    @Inject
    protected lateinit var presenter: FriendsContract.Presenter

    @Inject
    protected lateinit var adapter: FriendsAdapter

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_friends, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentFriendsRecyclerView.layoutManager = LinearLayoutManager(context)
        fragmentFriendsRecyclerView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun setFriends(friends: List<Friend>) {
        adapter.setFriends(friends)
        adapter.notifyDataSetChanged()
    }
}