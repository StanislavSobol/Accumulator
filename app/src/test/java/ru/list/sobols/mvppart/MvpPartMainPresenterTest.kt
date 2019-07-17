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
import ru.list.sobols.mvppart.houses.MvpPartHousesPresenter

@RunWith(MockitoJUnitRunner::class)
class MvpPartMainPresenterTest {

    @get:Rule
    val trampolineSchedulerRule = TrampolineSchedulerRule()

    @Mock
    lateinit var interactor: IInteractor
    @Mock
    lateinit var viewState: `IMvpPartMainView$$State`

    var houses = mutableListOf<HouseModel>()

    lateinit var presenterHousesPresenter: MvpPartHousesPresenter

    @Before
    fun setup() {
        presenterHousesPresenter = MvpPartHousesPresenter(interactor)

        houses.clear()
        houses.add(mock(HouseModel::class.java))
        houses.add(mock(HouseModel::class.java))
        houses.add(mock(HouseModel::class.java))

        presenterHousesPresenter.setViewState(viewState)
    }

    @Test
    fun onFirstViewAttach_showItems() {
        `when`(interactor.getHouses()).thenAnswer { Single.just(houses) }

        presenterHousesPresenter.onFirstViewAttach()
        verify(viewState).showItems(houses)
        verifyNoMoreInteractions(viewState)
    }

    @Test
    fun onFirstViewAttach_showError() {
        val expectedException = Exception()

        `when`(interactor.getHouses()).thenReturn(Single.error(expectedException))

        presenterHousesPresenter.onFirstViewAttach()

        verify(viewState).showError(expectedException)
        verifyNoMoreInteractions(viewState)
    }
}