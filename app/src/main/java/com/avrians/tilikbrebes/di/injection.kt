package com.avrians.tilikbrebes.di

import com.avrians.tilikbrebes.data.WisataRepository

object Injection {
    fun provideRepository(): WisataRepository {
        return WisataRepository.getInstance()
    }
}