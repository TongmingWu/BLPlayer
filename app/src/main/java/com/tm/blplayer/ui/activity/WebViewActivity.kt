package com.tm.blplayer.ui.activity

import android.os.Build
import android.view.View
import com.orhanobut.logger.Logger
import com.tencent.smtt.export.external.interfaces.WebResourceError
import com.tencent.smtt.export.external.interfaces.WebResourceRequest
import com.tencent.smtt.sdk.WebChromeClient
import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient
import com.tm.blplayer.R
import com.tm.blplayer.base.BaseActivity
import kotlinx.android.synthetic.main.activity_webview.*
import kotlinx.android.synthetic.main.include_common_toolbar.*


/**
 * Created by tongming on 2017/8/2.
 * WebView
 */
class WebViewActivity : BaseActivity() {

    override val layoutId: Int
        get() = R.layout.activity_webview

    override fun initView() {
        ll_back.visibility = View.VISIBLE
        tv_back_title.text = getString(R.string.web_view_loading)

        web_view.settings.defaultTextEncodingName = "utf-8"
        web_view.settings.javaScriptCanOpenWindowsAutomatically = true
        web_view.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }

            override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
                tv_back_title.text = getString(R.string.web_view_load_error)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (error.description == "net::ERR_CONNECTION_REFUSED") {
                        return
                    }
                }
            }
        })
        web_view.setWebChromeClient(object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                pb_loading.progress = newProgress
                if (newProgress >= 100) {
                    pb_loading.visibility = View.GONE
                }
                Logger.d("progress = " + newProgress)
            }

            override fun onReceivedTitle(view: WebView, title: String) {
                super.onReceivedTitle(view, title)
                tv_back_title.text = title
            }
        })

        web_view.settings.javaScriptEnabled = true
        web_view.settings.javaScriptCanOpenWindowsAutomatically = true
        web_view.settings.allowContentAccess = true
        web_view.settings.setAllowUniversalAccessFromFileURLs(true)
        web_view.settings.mixedContentMode = android.webkit.WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        web_view.settings.useWideViewPort = true
        web_view.settings.loadWithOverviewMode = true
        WebView.setWebContentsDebuggingEnabled(true)
    }

    override fun initData() {
        val url = intent.extras.getString("url")
        url?.let {
            web_view.loadUrl(url)
        }
    }

}