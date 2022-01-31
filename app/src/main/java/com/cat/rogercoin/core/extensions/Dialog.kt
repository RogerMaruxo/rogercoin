package com.cat.rogercoin.core.extensions

import android.content.Context
import android.widget.ProgressBar
import com.google.android.material.dialog.MaterialAlertDialogBuilder

fun Context.createDialog(block: MaterialAlertDialogBuilder.() -> Unit = {}): androidx.appcompat.app.AlertDialog {
    val builder = MaterialAlertDialogBuilder(this)
    builder.setPositiveButton(android.R.string.ok,null)
    block(builder)
    return builder.create()
}

fun Context.createProgressDialog(): androidx.appcompat.app.AlertDialog {
    return createDialog {
       val padding = 16
       val progressBar = ProgressBar (this@createProgressDialog)
        progressBar.setPadding(padding, padding, padding, padding)
        setView(progressBar)

        setPositiveButton(null,null)
        setCancelable(false)
    }
}