package com.example.mycalculator

import android.os.Parcel
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class Calculo(val expr: String, val res: String): Parcelable{
    override fun toString(): String {
        return "$expr  =  $res"
    }
}