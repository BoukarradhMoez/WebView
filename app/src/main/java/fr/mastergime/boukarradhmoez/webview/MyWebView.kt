package fr.mastergime.boukarradhmoez.webviews


import android.net.Uri
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MyWebView : WebViewClient() {
     val _myData: MutableLiveData<Uri> = MutableLiveData(Uri.EMPTY)

    val loadOutside: LiveData<Uri>
        get() = _myData


    override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {

        if (request.url.host == "www.univ-rouen.fr" || request.url.host == "www.insa-rouen.fr") {
            return false

        }
        _myData.value = request.url
        return true


    }

}