package com.example.apirest_previsodotempo_retrofit_json_mvvm_koin_cleanarchitecture_data_ect.domain.di

import com.example.apirest_previsodotempo_retrofit_json_mvvm_koin_cleanarchitecture_data_ect.domain.ListRepositoriesUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {
    fun load() {
        loadKoinModules(useCaseModule())
    }
    private fun useCaseModule(): Module {
        return module {
            factory { ListRepositoriesUseCase(get()) }
        }
    }
}