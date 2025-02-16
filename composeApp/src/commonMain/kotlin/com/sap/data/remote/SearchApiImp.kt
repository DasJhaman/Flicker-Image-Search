package com.sap.data.remote

import com.sap.data.dto.SearchApiResponseDto
import com.sap.flickerimagesearch.BuildKonfig
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class SearchApiImp(private val httpClient: HttpClient) : SearchApi {

    override suspend fun search(searchTerm: String): Result<SearchApiResponseDto> = runCatching {
        httpClient.get {
            url {
                parameters.append("method", BuildKonfig.SEARCH_METHOD)
                parameters.append("api_key", BuildKonfig.API_KEY)
                parameters.append("format", "json")
                parameters.append("nojsoncallback", "1")
                parameters.append("safe_search", "1")
                parameters.append("text", searchTerm)
            }
        }.body()
    }
}