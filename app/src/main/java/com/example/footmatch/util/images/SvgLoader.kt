package com.example.footmatch.util.images

import android.widget.ImageView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest

class SvgLoader {
    companion object {
        fun ImageView.loadUrl(url: String) {

            val imageLoader = ImageLoader.Builder(this.context)
                .componentRegistry { add(SvgDecoder(this@loadUrl.context)) }
                .build()

            val request = ImageRequest.Builder(this.context)
                .data(url)
                .target(this)
                .build()

            imageLoader.enqueue(request)
        }
    }

}