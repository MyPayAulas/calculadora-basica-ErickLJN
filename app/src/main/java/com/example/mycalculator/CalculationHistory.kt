package com.example.mycalculator

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import android.os.Parcel

@Parcelize
class CalculationHistory(var calculationList: MutableList<Calculation>): Parcelable