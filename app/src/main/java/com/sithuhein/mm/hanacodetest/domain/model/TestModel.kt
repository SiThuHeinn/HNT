package com.sithuhein.mm.hanacodetest.domain.model

import android.util.Log
import javax.inject.Inject

class TestModel @Inject constructor() {
    fun fromTestModel() {
        Log.d("HanaCodeTest", "From TestModel")
    }
}