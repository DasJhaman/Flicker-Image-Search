package com.sap.data.repo

sealed class RepositoryResult<T> {
    data class Success<T>(val data: T & Any) : RepositoryResult<T>()
    data class Error<T>(val lastKnownData: T?, val error: String) : RepositoryResult<T>()
}