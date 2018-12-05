package com.example.cloudymous.footballclubcloud.presenter

import com.example.cloudymous.footballclubcloud.api.ApiRepository
import com.example.cloudymous.footballclubcloud.api.TheSportDBApi
import com.example.cloudymous.footballclubcloud.model.DetailMatch
import com.example.cloudymous.footballclubcloud.model.DetailMatchResponse
import com.example.cloudymous.footballclubcloud.view.matches.NextMatchView
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class NextMatchPresenterTest {

    @Mock
    private
    lateinit var view: NextMatchView

    @Mock
    private
    lateinit var apiRepository: ApiRepository

    @Mock
    private
    lateinit var gson: Gson

    private lateinit var presenter: NextMatchPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = NextMatchPresenter(view, apiRepository, gson)
    }

    @Test
    fun getNextMatch() {
        val nextmatch: MutableList<DetailMatch> = mutableListOf()
        val response = DetailMatchResponse(nextmatch)
        val leagueId = "4328"

        GlobalScope.launch {
            `when`(
                gson.fromJson(
                    apiRepository.doRequest(TheSportDBApi.getNextMatch(leagueId)).await(),
                    DetailMatchResponse::class.java
                )
            ).thenReturn(response)

            presenter.getNextMatch(leagueId)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showNextMatchList(nextmatch)
            Mockito.verify(view).hideLoading()
        }
    }
}