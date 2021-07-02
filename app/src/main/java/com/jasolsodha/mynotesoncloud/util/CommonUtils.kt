package com.jasolsodha.mynotesoncloud.util

import android.app.Dialog
import android.content.Context
import com.jasolsodha.mynotesoncloud.R

class  CommonUtils {

    companion object {
        fun showLoadingDialog(context: Context): Dialog {
            val dialog = Dialog(context, R.style.AppDialogTheme)
            dialog.setContentView(R.layout.progress_dialog)
            dialog.setCanceledOnTouchOutside(false)
            dialog.setCancelable(false)
            return dialog
        }
    }
}