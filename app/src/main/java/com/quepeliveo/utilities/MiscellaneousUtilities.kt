package com.quepeliveo.utilities

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log

fun compartirContenido(context: Context, contenido: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, contenido)
        putExtra(Intent.EXTRA_TITLE, "Compartir película")
    }
    val chooser = Intent.createChooser(intent, "Compartir con")
    context.startActivity(chooser)
}

fun Context.abreIMDB(imdbUrl: String) {

    Log.d("IMDB", imdbUrl)
    val intent = Intent(Intent.ACTION_MAIN)
    intent.data = Uri.parse(imdbUrl)

    val packageManager = this.packageManager
    val resolveInfo = packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY)

    if (resolveInfo != null) {
        this.startActivity(intent)
    } else {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(imdbUrl))
        this.startActivity(browserIntent)
    }
}