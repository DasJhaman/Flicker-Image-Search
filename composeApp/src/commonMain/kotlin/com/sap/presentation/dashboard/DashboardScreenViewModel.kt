package com.sap.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sap.data.repo.RepositoryResult
import com.sap.domain.usecase.GetAllSearchHistoryUseCase
import com.sap.domain.usecase.SearchPhotosUseCase
import com.sap.presentation.common.ContentState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class DashboardScreenViewModel(
    private val searchUseCase: SearchPhotosUseCase,
    private val getAllSearchHistoryUseCase: GetAllSearchHistoryUseCase
) : ViewModel() {

    private val _uiData = MutableStateFlow(DashboardScreenUIData())
    val uiData = _uiData.asStateFlow()


    init {
        getSearchHistory()
    }

    private fun getSearchHistory() {
        viewModelScope.launch {
            getAllSearchHistoryUseCase().collect { result ->
                _uiData.update { prev -> prev.copy(searchHistory = result) }

            }
        }
    }

    fun updateSearchQuery(query: String) = _uiData.update { it.copy(searchQuery = query) }

    fun search() {
        viewModelScope.launch {
            // TODO: we need to throw validation error
            val searchTerm = _uiData.value.searchQuery?.trim().takeIf { it?.isNotEmpty() == true }
                ?: return@launch
            _uiData.update { it.copy(contentState = ContentState.LOADING) }

            when (val result = searchUseCase(searchTerm)) {
                is RepositoryResult.Error -> _uiData.update { it.copy(contentState = ContentState.ERROR) }
                is RepositoryResult.Success -> _uiData.update {
                    it.copy(
                        contentState = ContentState.SUCCESS,
                        photo = result.data.photos?.photo.orEmpty()
                    )
                }
            }
        }
    }

    fun onSearchExpandedChange(expanded: Boolean) =
        _uiData.update { it.copy(searchExpanded = expanded) }
}