package com.nastynick.billdivider.presentation.friends

import com.nastynick.billdivider.domain.usecase.friends.FriendsInteractor
import com.nastynick.billdivider.presentation.util.StubUtil
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import ru.terrakok.cicerone.Router

class FriendsPresenterTest {

    private val interactor: FriendsInteractor = mock()
    private val view: FriendView = mock()

    private lateinit var presenter: FriendsPresenter

    @Before
    fun setUp() {
        val router: Router = mock()
        val stubUtil: StubUtil = mock()

        presenter = FriendsPresenter(interactor, router, stubUtil)
    }

    @Test
    fun `attach view show empty stub`() {
        whenever(interactor.getFriends()).thenReturn(Single.just(listOf()))

        presenter.attachView(view)

        verify(view).showEmptyView(true)
        verifyNoMoreInteractions(view)
    }
}