package com.nastynick.billdivider.presentation.friends

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.nastynick.billdivider.R
import com.nastynick.billdivider.data.objects.Friend
import com.nastynick.billdivider.presentation.base.BaseFragment
import com.nastynick.billdivider.presentation.util.setVisibleElseGone
import kotlinx.android.synthetic.main.fragment_friends.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
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
    protected lateinit var navigatorHolder: NavigatorHolder

    @Inject
    protected lateinit var navigator: Navigator

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>

    @ProvidePresenter
    fun providePresenter(): FriendsPresenter {
        return presenter
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        getComponent().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_friends, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initListeners()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    private fun initViews() {
        fragmentFriendsRecyclerView.layoutManager = LinearLayoutManager(activity)
        fragmentFriendsRecyclerView.adapter = adapter

        bottomSheetBehavior = BottomSheetBehavior.from(fragmentFriendsLinearLayoutBottomSheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
    }

    private fun initListeners() {
        adapter.onFriendClick = presenter::onFriendClick
        fragmentFriendsMaterialButtonAddFriend.setOnClickListener { presenter.onAddFriendClick() }
        fragmentFriendsTextViewAddFriendFromContacts.setOnClickListener { presenter.onAddFriendFromContactsClick() }
        fragmentFriendsTextViewCreateFriend.setOnClickListener { presenter.onCreateFriendClick() }
    }

    override fun showFriends(friends: List<Friend>) {
        adapter.setFriends(friends)
        adapter.notifyDataSetChanged()
    }

    override fun openFriendAddingMenu() {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    override fun showEmptyView(show: Boolean) {
        fragmentFriendsFrameLayoutStub.setVisibleElseGone(show)
    }
}