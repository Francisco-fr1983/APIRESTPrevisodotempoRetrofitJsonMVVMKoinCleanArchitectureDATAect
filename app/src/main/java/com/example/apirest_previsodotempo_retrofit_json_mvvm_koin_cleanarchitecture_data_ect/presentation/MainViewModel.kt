package com.example.apirest_previsodotempo_retrofit_json_mvvm_koin_cleanarchitecture_data_ect.presentation

import androidx.lifecycle.*
import com.example.apirest_previsodotempo_retrofit_json_mvvm_koin_cleanarchitecture_data_ect.data.model.Repo
import com.example.apirest_previsodotempo_retrofit_json_mvvm_koin_cleanarchitecture_data_ect.domain.ListRepositoriesUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

/*Para criar um ViewModel precisamos estender de ViewModel do Lifecycle,
agora vamos injetar o ListRepositoriesUseCase direto no viewmodel para ter a instancia do usecase=domain*/

class MainViewModel(
        private val listRepositoriesUseCase: ListRepositoriesUseCase
        ) : ViewModel() {

    private val _repos = MutableLiveData<State>()
    val repos : LiveData<State> = _repos

    fun getRepoList(forecast: String) {
        viewModelScope.launch {
            listRepositoriesUseCase.execute(forecast)
                    .onStart {
                        _repos.postValue(State.Loading)

                    }
                    .catch {
                        _repos.postValue(State.Error(it))

                    }
                    .collect {
                        _repos.postValue(State.Success(it))
                    }
        }

    }
    sealed class State {
        object Loading : State()
        data class Success(val list: List<Repo>) : State()
        data class Error(val error: Throwable) : State()
    }
}
