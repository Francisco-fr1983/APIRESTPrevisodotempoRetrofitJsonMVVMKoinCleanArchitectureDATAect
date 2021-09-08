package com.example.apirest_previsodotempo_retrofit_json_mvvm_koin_cleanarchitecture_data_ect.data.model

import com.google.gson.annotations.SerializedName

data class Repo (
        val by: String,
        val validKey: Boolean,
        val results: String,
        val date: String,
        val time: String,
        val conditionCode: String,
        val descrição: String,
        val atualmente: String,
        val cid: String,
        val cidade: String,
        val imgID: String,
        val umidade: Long,
        val windSpeedy: String,
        val sunrise: String,
        val sunset: String,
        val conditionSlug: String,
        val cityName: String,
        @SerializedName("previsao")
        val previsão: List<Previsão>
)

data class Previsão (
        val data: String? = null,
        val diaDaSemana: String? = null,
        val max: Long? = null,
        val min: Long? = null,
        val descrição: String? = null,
        val purpleCondição: String? = null,
        val date: String? = null,
        val weekday: String? = null,
        val description: String? = null,
        val condition: String? = null,
        val condição: String? = null,
        val previsãoData: String? = null,
        val previsãoDiaDaSemana: String? = null,
        val previsãoMax: Long? = null,
        val previsãoMin: Long? = null,
        val previsãoDescrição: String? = null,
        val previsãoCondição: String? = null,
        val previsãoDate: String? = null,
        val previsãoWeekday: String? = null,
        val previsãoDescription: String? = null,
        val previsãoCondition: String? = null,
        val purpleDiaDaSemana: String? = null
)
