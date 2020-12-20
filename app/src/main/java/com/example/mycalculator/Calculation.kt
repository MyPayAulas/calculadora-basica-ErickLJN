package com.example.mycalculator

import android.os.Parcel
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class Calculation(val express: String, val results: String): Parcelable