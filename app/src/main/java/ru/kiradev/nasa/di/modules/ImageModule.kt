package ru.kiradev.nasa.di.modules

import android.widget.ImageView
import dagger.Module
import dagger.Provides
import ru.kiradev.nasa.mvp.model.image.IImageLoader
import ru.kiradev.nasa.mvp.model.network.INetworkStatus
import ru.kiradev.nasa.ui.image.GlideImageLoader
import javax.inject.Singleton

@Module
class ImageModule {

    @Singleton
    @Provides
    fun  glideImageLoader(networkStatus: INetworkStatus): IImageLoader<ImageView> = GlideImageLoader(networkStatus)
}