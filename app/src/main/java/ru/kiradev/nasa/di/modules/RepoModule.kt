package ru.kiradev.nasa.di.modules

import dagger.Module
import dagger.Provides
import ru.kiradev.nasa.mvp.model.api.IDataSource
import ru.kiradev.nasa.mvp.model.repo.picture.IPictureOfTheDayRepo
import ru.kiradev.nasa.mvp.model.repo.picture.RetrofitPictureOfTheDayRepo
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun pictureRepo(
        api: IDataSource
    ): IPictureOfTheDayRepo = RetrofitPictureOfTheDayRepo(api)

}