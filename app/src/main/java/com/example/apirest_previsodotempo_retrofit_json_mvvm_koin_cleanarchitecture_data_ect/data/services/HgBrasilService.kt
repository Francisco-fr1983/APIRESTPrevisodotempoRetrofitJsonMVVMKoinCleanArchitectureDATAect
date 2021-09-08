package com.example.apirest_previsodotempo_retrofit_json_mvvm_koin_cleanarchitecture_data_ect.data.services

import com.example.apirest_previsodotempo_retrofit_json_mvvm_koin_cleanarchitecture_data_ect.data.model.Repo
import retrofit2.http.GET
import retrofit2.http.Query


interface HgBrasilService {
    @GET("Url.URL")
    suspend fun getApi(@Query("forecast") forecast: String): List<Repo>

}
/*O suspend significa que enquanto o executável externo async coroutine está esperando (await) para que a co-rotina
computation interna termine, ele (o externo async coroutine) fica ocioso (daí o nome suspender)
e retorna o thread ao pool de threads e quando a criança computation coroutine terminar ,
ele (o externo async coroutine) acorda, leva outro segmento do pool e continua?*/
//Ela vai rodar em outra thread, em background//


/*Usaremos a ferramenta https://app.quicktype.io/ para transformar a API em objeto*/