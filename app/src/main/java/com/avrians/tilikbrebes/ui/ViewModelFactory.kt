package com.avrians.tilikbrebes.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.avrians.tilikbrebes.data.WisataRepository
import com.avrians.tilikbrebes.ui.screen.detail.DetailViewModel
import com.avrians.tilikbrebes.ui.screen.favorit.FavoriteViewModel
import com.avrians.tilikbrebes.ui.screen.home.HomeViewModel

class ViewModelFactory(private val repository: WisataRepository) :
    ViewModelProvider.NewInstanceFactory()  {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if(modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository) as T
        } else if(modelClass.isAssignableFrom(FavoriteViewModel::class.java)) {
            return FavoriteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}