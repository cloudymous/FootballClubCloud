package com.example.cloudymous.footballclubcloud.Presenter

import com.example.cloudymous.footballclubcloud.Api.ApiRepository
import com.example.cloudymous.footballclubcloud.View.MainView
import com.google.gson.Gson

class MainPresenter (private val view: MainView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson){

}