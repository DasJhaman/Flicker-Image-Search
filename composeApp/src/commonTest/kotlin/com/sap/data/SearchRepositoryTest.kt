package com.sap.data

import com.sap.data.db.SearchHistoryDao
import com.sap.data.dto.PhotoDto
import com.sap.data.dto.PhotosDto
import com.sap.data.dto.SearchApiResponseDto
import com.sap.data.remote.SearchApi
import com.sap.data.repo.RepositoryResult
import com.sap.data.repo.SearchRepositoryImp
import dev.mokkery.answering.returns
import dev.mokkery.everySuspend
import dev.mokkery.mock
import kotlinx.coroutines.runBlocking
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SearchRepositoryTest {

    private val api = mock<SearchApi>()
    private val searchHistoryDao = mock<SearchHistoryDao>()
    private lateinit var repository: SearchRepositoryImp

    @BeforeTest
    fun beforeTest() {
        repository = SearchRepositoryImp(api, searchHistoryDao)
    }

    @Test
    fun searchPhotos_should_return_success_when_API_call_is_successful() = runBlocking {
        val mockPhoto = PhotoDto(
            photoId = "123",
            title = "example.jpg",
            isPublic = 1,
            isFriend = 1,
            isFamily = 1,
            secret = "abcdef",
            farm = 1,
            server = "server1",
            owner = "user123"
        )

        val mockResponse = SearchApiResponseDto(
            photos = PhotosDto(
                pages = 1, page = 1, perPage = 10, total = 100, photo = listOf(mockPhoto)
            )
        )

        everySuspend { api.search("test") } returns Result.success(mockResponse)
        everySuspend { searchHistoryDao.upsertSearchHistory("test") } returns Unit

        val result = repository.searchPhotos("test")

        assertTrue(result is RepositoryResult.Success)

        val photos = (result as RepositoryResult.Success).data.photos?.photo

        assertEquals(1, photos?.size)

        val expectedUrl = "https://farm1.static.flickr.com/server1/123_abcdef.jpg"
        assertEquals(expectedUrl, photos?.first()?.imageUrl)
    }

    @Test
    fun searchPhotos_should_return_error_when_API_call_fails() = runBlocking {
        everySuspend { api.search("test") } returns Result.failure(Exception("Network error"))
        everySuspend { searchHistoryDao.upsertSearchHistory("test") } returns Unit

        val result = repository.searchPhotos("test")

        assertTrue(result is RepositoryResult.Error)

        assertEquals("Network error", (result as RepositoryResult.Error).error)
    }
}