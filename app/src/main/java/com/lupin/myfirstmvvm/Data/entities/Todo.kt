package com.lupin.myfirstmvvm.Data.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Todo(
    val id: Int = 0,
    val title: String = "",
    val completed: Boolean = false
):Parcelable