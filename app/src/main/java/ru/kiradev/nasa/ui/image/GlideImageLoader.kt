package ru.kiradev.nasa.ui.image

import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import ru.kiradev.nasa.mvp.model.image.IImageLoader
import ru.kiradev.nasa.mvp.model.network.INetworkStatus

class GlideImageLoader(val networkStatus: INetworkStatus) : IImageLoader<ImageView> {

    override fun loadInto(url: String?, container: ImageView) {
        GlideApp.with(container.context)
            .asBitmap()
            .load(url)
            .transition(withCrossFade())
            .listener(object : RequestListener<Bitmap> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Bitmap>?,
                    isFirstResource: Boolean
                ): Boolean {
                    e?.printStackTrace()
                    return false
                }

                override fun onResourceReady(
                    resource: Bitmap?,
                    model: Any?,
                    target: Target<Bitmap>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }
            })
            .into(container)
    }

}