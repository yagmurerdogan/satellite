package com.yagmurerdogan.satellite.util

import android.text.Html
import android.widget.TextView
import androidx.core.text.HtmlCompat

@SuppressWarnings("deprecation")
fun TextView.partialBold(boldString: String, regularText: String?) {
    this.text =
        Html.fromHtml(
            "<b>".plus(boldString).plus("</b>".plus(regularText)),
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )
}