package com.avrians.tilikbrebes.di

import com.avrians.tilikbrebes.data.WisataRepository

object injection {
    fun provideRepository(): WisataRepository {
        return WisataRepository.getInstance()
    }
}