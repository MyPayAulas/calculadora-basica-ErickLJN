package com.example.mycalculator.ui.main

import android.os.Parcelable
import com.example.mycalculator.Calculo
import kotlinx.android.parcel.Parcelize

@Parcelize
class HistoricoCalculos(var listaCalculos: MutableList<Calculo>): Parcelable

