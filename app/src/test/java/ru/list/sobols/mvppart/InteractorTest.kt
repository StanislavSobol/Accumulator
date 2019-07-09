package ru.list.sobols.mvppart

import io.reactivex.Single
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner
import ru.list.sobols.api.Api
import ru.list.sobols.interactor.IInteractor
import ru.list.sobols.interactor.Interactor
import ru.list.sobols.model.HouseModel

/**
 * Test for {@link IInteractor}
 *
 * https://medium.com/@fabioCollini/testing-asynchronous-rxjava-code-using-mockito-8ad831a16877
 */
@RunWith(MockitoJUnitRunner::class)
class InteractorTest {

    @Mock
    lateinit var api: Api

    lateinit var interactor: IInteractor //? = null
    var houses = mutableListOf<HouseModel>()

    @Before
    fun setup() {
        interactor = Interactor(api)

        houses.clear()
        houses.add(mock(HouseModel::class.java))
        houses.add(mock(HouseModel::class.java))
        houses.add(mock(HouseModel::class.java))

        `when`(api.getHouses()).thenAnswer { Single.just(houses) }
    }

    @Test
    fun getHouses_testObserver() {
        val testObserver = api.getHouses().test()
        testObserver.awaitTerminalEvent()
        testObserver
                .assertNoErrors()
                .assertValue { result -> result.size == houses.size }
    }

    @Test
    fun getHouses_compareWithApiResult() {
        val apiResult = api.getHouses().blockingGet()
        val interactorResult = interactor.getHouses().blockingGet()
        assertTrue(apiResult == interactorResult)
    }
}