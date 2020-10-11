package fr.mastergime.boukarradhmoez.webviews

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.mastergime.boukarradhmoez.webview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var _binding: ActivityMainBinding
    val myWebView = MyWebView()
    lateinit  var link :String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        _binding = ActivityMainBinding.inflate(layoutInflater)
        _binding.webView1.webViewClient=myWebView
        _binding.webView1.settings.javaScriptEnabled=true
        _binding.webView2.settings.javaScriptEnabled=true



        myWebView.loadOutside.observe(this) { url ->
            if (url != Uri.EMPTY) {
                val intent = Intent(Intent.ACTION_VIEW, url)
                startActivity(intent)
            }
        }
        setContentView(_binding.root)
        _binding.webView1.loadUrl("http://mastersid.univ-rouen.fr")
        _binding.webView2.loadUrl("file:///android_asset/index.html")

        myWebView._myData.observe(this){
            value-> _binding.webView2.loadUrl("JavaScript:history('$value')")
        }
    }

    override fun onBackPressed() {

        if (_binding.webView1.canGoBack()){
            _binding.webView1.goBack()

        }

        else
            super.onBackPressed()
    }

}