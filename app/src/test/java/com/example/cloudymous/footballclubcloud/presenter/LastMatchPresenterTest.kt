package com.example.cloudymous.footballclubcloud.presenter

import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.api.TheSportDBApi
import com.example.cloudymous.footballclubcloud.model.DetailMatch
import com.example.cloudymous.footballclubcloud.model.DetailMatchResponse
import com.example.cloudymous.footballclubcloud.view.lastmatch.LastMatchView
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class LastMatchPresenterTest {

    @Mock
    private
    lateinit var view: LastMatchView

    @Mock
    private
    lateinit var apiRepository: ApiRepository

    @Mock
    private
    lateinit var gson: Gson

    private lateinit var presenter: LastMatchPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = LastMatchPresenter(view, apiRepository, gson)
    }

    @Test
    fun getLastMatch() {
        val lastmatch: MutableList<DetailMatch> = mutableListOf()
        val response = DetailMatchResponse(lastmatch)
        val leagueId = "4328"

        GlobalScope.launch {
            `when`(
                gson.fromJson(
                    apiRepository
                        .doRequest(TheSportDBApi.getTeams(leagueId)).await(),
                    DetailMatchResponse::class.java
                )
            ).thenReturn(response)

            presenter.getLastMatch(leagueId)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showLastMatchList(lastmatch)
            Mockito.verify(view).hideLoading()
        }
    }
}