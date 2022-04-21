package com.example.gamingpower.ViewModel

import com.example.gamingpower.DataBase.DatabaseRepository
import com.example.gamingpower.Rest.GiveawaysRepository
import com.example.gamingpower.Utils.SortType
import io.mockk.clearAllMocks
import io.mockk.mockk
import junit.framework.TestCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After

@ExperimentalCoroutinesApi
class GiveawaysViewModelTest : TestCase() {
    private val mockKRest  = mockk<GiveawaysRepository>(relaxed = true)
    private val mockkdatabaseRepository = mockk<DatabaseRepository>(relaxed = true)
    private val mockkioDispatcher =mockk<CoroutineDispatcher>(relaxed = true)
    public override fun setUp() {
        super.setUp()
    }

    public override fun tearDown() {}

    fun testGetPlatform() {
        Dispatchers.Main
        var target: GiveawaysViewModel =
            GiveawaysViewModel(mockKRest,mockkdatabaseRepository,mockkioDispatcher,)
        target.getSortedGiveaways(sortBy = SortType.DATE)

    }

    fun testSetPlatform() {
        Dispatchers.Main
        var target: GiveawaysViewModel =
            GiveawaysViewModel(
                mockKRest,
                mockkdatabaseRepository,
                mockkioDispatcher,)
        target.platform

    }

    fun testGetGiveAway() {
        Dispatchers.Main
        var target: GiveawaysViewModel =
            GiveawaysViewModel(
                mockKRest,
                mockkdatabaseRepository,
                mockkioDispatcher,)
        runTest()
    }

    fun testGetSortedGiveaways() {
        Dispatchers.Main
        var target: GiveawaysViewModel =
            GiveawaysViewModel(
                mockKRest,
                mockkdatabaseRepository,
                mockkioDispatcher,)
        runTest()
    }

     fun testGetGiveawaysByPlatform() {
        Dispatchers.Main

        var target: GiveawaysViewModel =
            GiveawaysViewModel(
                mockKRest,
                mockkdatabaseRepository,
                mockkioDispatcher,)
         runTest()
    }


    fun testOnCleared() {
        Dispatchers.Main

        var target: GiveawaysViewModel =
            GiveawaysViewModel(
                mockKRest,
                mockkdatabaseRepository,
                mockkioDispatcher,

            )
        runTest()
    }

        @After
        fun shutdown() {
            clearAllMocks(true)
        }
        }


