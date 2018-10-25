//package com.example.cloudymous.footballclubcloud
//
//import android.graphics.Color
//import android.view.Gravity
//import android.view.View
//import org.jetbrains.anko.*
//
//class ListClubUI : AnkoComponent<MainMenu> {
//
//    override fun createView(ui: AnkoContext<MainMenu>) = with(ui) {
//        linearLayout {
//            lparams(width = matchParent, height = wrapContent)
//            padding = dip(16)
//            id = R.id.list_club
//
//            imageView {
//                id = R.id.gambar_club
//                //setImageResource(R.drawable.img_madrid)
//            }.lparams(width = dip(50), height = dip(50))
//
//            textView() {
//                id = R.id.nama_club
//                textSize = 18f
//                textColor = Color.BLACK
//                textAlignment = View.TEXT_ALIGNMENT_CENTER
//            }.lparams {
//                gravity = Gravity.CENTER_VERTICAL
//                marginStart = dip(16)
//            }
//        }
//    }
//}