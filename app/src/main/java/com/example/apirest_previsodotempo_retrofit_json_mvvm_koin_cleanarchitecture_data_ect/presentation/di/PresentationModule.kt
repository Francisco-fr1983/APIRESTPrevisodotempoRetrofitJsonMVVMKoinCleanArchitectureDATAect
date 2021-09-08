package com.example.apirest_previsodotempo_retrofit_json_mvvm_koin_cleanarchitecture_data_ect.presentation.di

import com.example.apirest_previsodotempo_retrofit_json_mvvm_koin_cleanarchitecture_data_ect.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object PresentationModule  {
    fun load() {
        loadKoinModules(viewModelModule())
    }
    private fun viewModelModule(): Module {
        return module {
            viewModel { MainViewModel(get()) }
        }
    }
}
