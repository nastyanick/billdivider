package com.nastynick.billdivider.presentation.friends

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.nastynick.billdivider.R
import com.nastynick.billdivider.data.objects.Friend
import com.nastynick.billdivider.di.DependencyResolver
import com.nastynick.billdivider.presentation.Navigator
import com.nastynick.billdivider.presentation.Screens
import com.nastynick.billdivider.presentation.base.BaseFragment
import com.nastynick.billdivider.presentation.friend.FriendActivity
import com.nastynick.billdivider.presentation.navigation.NavigatorsHolder
import kotlinx.android.synthetic.main.fragment_friends.*
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Forward
import javax.inject.Inject

class FriendsFragment : BaseFragment(), FriendView {

    companion object {
        fun getInstance(): FriendsFragment {
            return FriendsFragment()
        }
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: FriendsPresenter

    @Inject
    protected lateinit var adapter: FriendsAdapter

    @Inject
    protected lateinit var navigatorsHolder: NavigatorsHolder

    @ProvidePresenter
    fun providePresenter(): FriendsPresenter {
        return presenter
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        DependencyResolver.presentationComponent().inject(this)
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
        fragmentFriendsRecyclerView.layoutManager = LinearLayoutManager(activity)
        fragmentFriendsRecyclerView.adapter = adapter
    }

    private fun initListeners() {
        adapter.onFriendClick = presenter::onFriendClick
    }

    override fun setFriends(friends: List<Friend>) {
        adapter.setFriends(friends)
        adapter.notifyDataSetChanged()
    }
}