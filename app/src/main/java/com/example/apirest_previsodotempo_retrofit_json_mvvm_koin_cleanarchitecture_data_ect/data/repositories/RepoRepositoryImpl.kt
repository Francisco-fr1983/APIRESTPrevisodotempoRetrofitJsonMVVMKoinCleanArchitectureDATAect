package com.example.apirest_previsodotempo_retrofit_json_mvvm_koin_cleanarchitecture_data_ect.data.repositories

import android.os.RemoteException
import com.example.apirest_previsodotempo_retrofit_json_mvvm_koin_cleanarchitecture_data_ect.data.services.HgBrasilService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RepoRepositoryImpl(private val service: HgBrasilService) : RepoRepository {

    override suspend fun listRepositories(forecast: String) = flow {
        try {
            val listRepositories = service.getApi(forecast)
            emit(listRepositories)

        } catch (ex: HttpException) {
            throw RemoteException(ex.message)

        }

    }

}


/*Apreender como funciona o fluxo do aplicativo, a nossa UI vai chamar o nosso ViewModel,
que vai chamar o nosso Domain, que vai pedir ao Repositorio, e que vai buscar no DataSource*/