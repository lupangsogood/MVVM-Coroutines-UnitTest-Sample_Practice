package com.lupin.myfirstmvvm.Data.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "todo")
data class Todo(
    @PrimaryKey @ColumnInfo(name = "id") val
    id: Int = -1,
    val title: String = "",
    val completed: Boolean = false
):Parcelable