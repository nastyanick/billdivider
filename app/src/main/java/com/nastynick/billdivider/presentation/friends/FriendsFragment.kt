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
import com.nastynick.billdivider.presentation.Navigator
import com.nastynick.billdivider.presentation.Screens
import com.nastynick.billdivider.presentation.friend.FriendActivity
import com.nastynick.billdivider.presentation.navigation.NavigatorsHolder
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_friends.*
import ru.terrakok.cicerone.commands.Forward
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

    @Inject
    protected lateinit var navigatorsHolder: NavigatorsHolder

    private val navigator = FriendsNavigator();

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_friends, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initListeners()
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        navigatorsHolder.addNavigator(FriendsRouter.NAME, navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorsHolder.removeNavigator(FriendsRouter.NAME)
    }

    private fun initViews() {
        fragmentFriendsRecyclerView.layoutManager = LinearLayoutManager(context)
        fragmentFriendsRecyclerView.adapter = adapter
    }

    private fun initListeners() {
        adapter.onFriendClick = presenter::onFriendClick
    }

    override fun setFriends(friends: List<Friend>) {
        adapter.setFriends(friends)
        adapter.notifyDataSetChanged()
    }

    inner class FriendsNavigator : Navigator() {
        override fun applyCommand(command: Any) {
            if (command is Forward) {
                when (command.screenKey) {
                    Screens.FRIEND_DETAILS.name -> FriendActivity.getIntent(context, command.transitionData as String)
                            .let(this@FriendsFragment::startActivity)
                }
            }
        }
    }
}