package com.example.apirest_previsodotempo_retrofit_json_mvvm_koin_cleanarchitecture_data_ect.data.di

import android.util.Log
import com.example.apirest_previsodotempo_retrofit_json_mvvm_koin_cleanarchitecture_data_ect.data.repositories.RepoRepository
import com.example.apirest_previsodotempo_retrofit_json_mvvm_koin_cleanarchitecture_data_ect.data.repositories.RepoRepositoryImpl
import com.example.apirest_previsodotempo_retrofit_json_mvvm_koin_cleanarchitecture_data_ect.data.services.HgBrasilService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModule {
    private const val OK_HTTP = "okhttp"
    /*função networkModules : => vou devolver um Module, este modulo é do Koin.*/

    fun load() {
        loadKoinModules(networkModules() + repositoriesModule())
    }

    private fun networkModules() : Module {
        return module {
            single {
                val interceptor = HttpLoggingInterceptor {
                    Log.e(OK_HTTP, it)
                }
                interceptor.level = HttpLoggingInterceptor.Level.BODY

                OkHttpClient.Builder()
                        .addInterceptor(interceptor)
                        .build()

            }
            /*Instancia, de como o meu Retrofit converter o meu Gson ou saída, o que foi devolvido da URL*/
            single {
                GsonConverterFactory.create(GsonBuilder().create())
            }
            single {
                createService<HgBrasilService>(get(), get())
            }
        }
        /*Toda vez que pedi o metodo single, ele vai devolver a mesma instancia*/

    }
    private fun repositoriesModule() : Module {
        return module {
            single<RepoRepository> { RepoRepositoryImpl(get())

            }
        }
    }

    private inline fun<reified T> createService(client: OkHttpClient, factory: GsonConverterFactory) : T {
        return Retrofit.Builder()
                .baseUrl("https://api.hgbrasil.com/weather")
                .client(client)
                .addConverterFactory(factory)
                .build().create(T::class.java)

    }
}