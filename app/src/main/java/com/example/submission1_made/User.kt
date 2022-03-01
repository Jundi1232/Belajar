package com.example.submission1_made

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var name:String,
    var username:String,
    var img:Int
):Parcelable
