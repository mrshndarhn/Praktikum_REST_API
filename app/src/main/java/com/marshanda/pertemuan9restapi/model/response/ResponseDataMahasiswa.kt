package com.marshanda.pertemuan9restapi.model.response


import com.google.gson.annotations.SerializedName
import com.marshanda.pertemuan9restapi.model.request.DataMahasiswa

data class ResponseDataMahasiswa(
    @SerializedName("data")
    val data: List<DataMahasiswa>,
    @SerializedName("status")
    val status: String
)