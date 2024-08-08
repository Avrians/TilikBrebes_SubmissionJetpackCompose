package com.avrians.tilikbrebes.data

import com.avrians.tilikbrebes.model.Wisata
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

class WisataRepository {
    private val dummyWisata = mutableListOf<Wisata>()

    init {
        if (dummyWisata.isEmpty()) {
            FakeWisataData.dummyWisata.forEach {
                dummyWisata.add(it)
            }
        }
    }

    fun getWisataById(wisataId: Int): Wisata {
        return dummyWisata.first {
            it.id == wisataId
        }
    }

    fun getFavoriteWisata(): Flow<List<Wisata>>{
        return flowOf(dummyWisata.filter { it.isFavorite })
    }

    fun searchWisata(query: String) = flow {
        val data = dummyWisata.filter {
            it.name.contains(query, ignoreCase = true)
        }
        emit(data)
    }

    fun updateWisata(wisataId: Int, newState: Boolean): Flow<Boolean> {
        val index = dummyWisata.indexOfFirst { it.id == wisataId }
        val result = if (index >= 0) {
            val wisata = dummyWisata[index]
            dummyWisata[index] = wisata.copy(isFavorite = newState)
            true
        } else {
            false
        }
        return flowOf(result)
    }

    companion object {
        @Volatile
        private var instance: WisataRepository? = null

        fun getInstance(): WisataRepository =
            instance ?: synchronized(this) {
                WisataRepository().apply {
                    instance = this
                }
            }
    }
}