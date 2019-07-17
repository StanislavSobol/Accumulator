package ru.list.sobols.mvppart

import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import ru.list.sobols.TrampolineSchedulerRule
import ru.list.sobols.interactor.IInteractor
import ru.list.sobols.model.HouseModel

/**
 * Test for {@link MvpPartMainPresenter}
 */
@RunWith(MockitoJUnitRunner::class)
class MvpPartMainPresenterTest {

    @get:Rule
    val trampolineSchedulerRule = TrampolineSchedulerRule()

    @Mock
    lateinit var interactor: IInteractor
    @Mock
    lateinit var viewState: `IMvpPartMainView$$State`

    var houses = mutableListOf<HouseModel>()

    lateinit var presenter: MvpPartMainPresenter

    @Before
    fun setup() {
        presenter = MvpPartMainPresenter(interactor)

        houses.clear()
        houses.add(mock(HouseModel::class.java))
        houses.add(mock(HouseModel::class.java))
        houses.add(mock(HouseModel::class.java))

        presenter.setViewState(viewState)
    }

    @Test
    fun onFirstViewAttach_showItems() {
        `when`(interactor.getHouses()).thenAnswer { Single.just(houses) }

        presenter.onFirstViewAttach()
        verify(viewState).showItems(houses)
        verifyNoMoreInteractions(viewState)
    }

    @Test
    fun onFirstViewAttach_showError() {
        val expectedException = Exception()

        `when`(interactor.getHouses()).thenReturn(Single.error(expectedException))

        presenter.onFirstViewAttach()

        verify(viewState).showError(expectedException)
        verifyNoMoreInteractions(viewState)
    }
}