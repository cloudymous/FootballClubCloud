package com.example.cloudymous.footballclubcloud.view.favorite

import android.content.Context
import com.example.cloudymous.footballclubcloud.model.DetailMatch

class FavoriteMatchAdapter(
    private val context: Context,
    private val favorites: List<DetailMatch>,
    private val listener: (DetailMatch) -> Unit
)