package com.example.apirest_previsodotempo_retrofit_json_mvvm_koin_cleanarchitecture_data_ect.data.repositories

import com.example.apirest_previsodotempo_retrofit_json_mvvm_koin_cleanarchitecture_data_ect.data.model.Repo

interface RepoRepository {
   suspend fun listRepositories(forecast: String): kotlinx.coroutines.flow.Flow<List<Repo>>
}