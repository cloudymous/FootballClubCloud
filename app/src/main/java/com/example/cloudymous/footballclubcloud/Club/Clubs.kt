package com.example.cloudymous.footballclubcloud.Club

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Clubs (val namaClub: String,
                  val deskripsiClub: String,
                  val imageClub: Int): Parcelable