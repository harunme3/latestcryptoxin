package com.example.myapplication.uistate

import com.example.myapplication.data.models.specificpostm.SpecificPostM
import com.example.myapplication.data.models.trxhistorym.TrxHistoryM


sealed class TrxHistoryS {
    object Empty : TrxHistoryS()
    object Loading : TrxHistoryS()
    class Loaded(val data: TrxHistoryM) : TrxHistoryS()
    class Error(val message: String) : TrxHistoryS()
}