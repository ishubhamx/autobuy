package in.citbit.autobuy3;

import android.os.Build.VERSION;
import android.os.Bundle;

import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

import in.citbit.autobuy3.R;

public class WebViewActivity extends AppCompatActivity {
    WebView n;
    String o;
    String p;
    Snackbar q;
    Toolbar toolbar;
    Boolean isRunning = true;
    Button startStopBtn;

    private void signinAmazonContentSetup() {
        if (VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        this.n.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (str.toLowerCase().contains("https://www.amazon.in/ap/signin?")) {
                    WebViewActivity.this.q = Snackbar.make(WebViewActivity.this.n, WebViewActivity.this.getString(R.string.sigin), Snackbar.LENGTH_INDEFINITE);
                    WebViewActivity.this.q.show();
                } else if (str.toLowerCase().contains("https://www.amazon.in/gp/your-account/order-history")) {
                    WebViewActivity.this.n.loadUrl(WebViewActivity.this.p);
                    WebViewActivity.this.q = Snackbar.make(WebViewActivity.this.n, WebViewActivity.this.getString(R.string.redirect), Snackbar.LENGTH_INDEFINITE);
                    WebViewActivity.this.q.show();
                } else if (WebViewActivity.this.isRunning) {
                    WebViewActivity.this.q = Snackbar.make(WebViewActivity.this.n, "Script Working", Snackbar.LENGTH_INDEFINITE);
                    WebViewActivity.this.q.show();
                    WebViewActivity.this.n.loadUrl("javascript: var time = setInterval(function() {      if ((document.getElementsByClassName('_2AkmmA _2Npkh4 _2MWPVK RpigiU')             .length > 0) || (document.getElementsByClassName('_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c')             .length > 0)) {          var listId = document.getElementsByClassName(\"niH0FQ _36Fcw_\")[0].childNodes[0].getAttribute(\"id\")             .split('_')[1];           var hiddenEids = document.createElement(\"input\");         hiddenEids.setAttribute(\"type\", \"hidden\");         hiddenEids.setAttribute(\"name\", \"eids\");         hiddenEids.setAttribute(\"value\", listId);         var hiddenOtracker = document.createElement(\"input\");         hiddenOtracker.setAttribute(\"type\", \"hidden\");         hiddenOtracker.setAttribute(\"name\", \"otracker\");         hiddenOtracker.setAttribute(\"value\", \"\");         var hiddenDomain = document.createElement(\"input\");         hiddenDomain.setAttribute(\"type\", \"hidden\");         hiddenDomain.setAttribute(\"name\", \"domain\");         hiddenDomain.setAttribute(\"value\", \"physical\");          var formtag = document.createElement(\"form\");         formtag.setAttribute(\"action\", \"/checkout/init\");         formtag.setAttribute(\"class\", \"buyform\");         formtag.setAttribute(\"method\", \"post\");          formtag.appendChild(hiddenDomain);         formtag.appendChild(hiddenOtracker);         formtag.appendChild(hiddenEids);           document.body.appendChild(formtag);         formtag.submit();           clearInterval(time);         console.log(\"Script Activated\");      }  }, 10);");
                    try {
                        Thread.sleep(1000);
                        WebViewActivity.this.n.loadUrl("javascript: setInterval(function(){ document.getElementsByTagName('button')[0].click() }, 200);");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //WebViewActivity.this.q.dismiss();
                } else {
                    WebViewActivity.this.q = Snackbar.make(WebViewActivity.this.n, "No script running ", Snackbar.LENGTH_INDEFINITE);
                }
            }
        });
        this.n.loadUrl("https://www.amazon.in/gp/your-account/order-history");
        this.q = Snackbar.make(this.n, getString(R.string.please_signin), Snackbar.LENGTH_INDEFINITE);
        this.q.show();
    }

    private void signinFlipKartContentSetup() {
        if (VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        this.n.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (str.toLowerCase().equals("https://www.flipkart.com/account/login?ret=https%3A%2F%2Fwww.flipkart.com%2Faccount")) {
                    WebViewActivity.this.q = Snackbar.make(WebViewActivity.this.n, WebViewActivity.this.getString(R.string.sigin), Snackbar.LENGTH_INDEFINITE);
                    WebViewActivity.this.q.show();
                } else if (str.toLowerCase().equals("https://www.flipkart.com/account/")) {
                    WebViewActivity.this.n.loadUrl(WebViewActivity.this.p);
                    WebViewActivity.this.q = Snackbar.make(WebViewActivity.this.n, WebViewActivity.this.getString(R.string.redirect), Snackbar.LENGTH_INDEFINITE);
                    WebViewActivity.this.q.show();
                } else if (str.toLowerCase().contains("/p/")) {
                    WebViewActivity.this.n.loadUrl("javascript: if ((document.getElementsByClassName('_2AkmmA _2Npkh4 _2MWPVK RpigiU') .length > 0) || (document.getElementsByClassName('_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c') .length > 0)) { var listId = document.getElementsByClassName(\"niH0FQ _36Fcw_\")[0].childNodes[0].getAttribute(\"id\") .split('_')[1]; var hiddenEids = document.createElement(\"input\"); hiddenEids.setAttribute(\"type\", \"hidden\"); hiddenEids.setAttribute(\"name\", \"eids\"); hiddenEids.setAttribute(\"value\", listId); var hiddenOtracker = document.createElement(\"input\"); hiddenOtracker.setAttribute(\"type\", \"hidden\"); hiddenOtracker.setAttribute(\"name\", \"otracker\"); hiddenOtracker.setAttribute(\"value\", \"\"); var hiddenDomain = document.createElement(\"input\"); hiddenDomain.setAttribute(\"type\", \"hidden\"); hiddenDomain.setAttribute(\"name\", \"domain\"); hiddenDomain.setAttribute(\"value\", \"physical\"); var formtag = document.createElement(\"form\"); formtag.setAttribute(\"action\", \"/checkout/init\"); formtag.setAttribute(\"class\", \"buyform\"); formtag.setAttribute(\"method\", \"post\"); formtag.appendChild(hiddenDomain); formtag.appendChild(hiddenOtracker); formtag.appendChild(hiddenEids); document.body.appendChild(formtag); formtag.submit(); clearInterval(time); console.log(\"Script Activated\"); } else { console.log('button not found'); location.reload(); }");
                    WebViewActivity.this.q = Snackbar.make(WebViewActivity.this.n, WebViewActivity.this.getString(R.string.trying), Snackbar.LENGTH_INDEFINITE);
                    WebViewActivity.this.q.show();
                } else if (str.toLowerCase().contains("/checkout/init")) {
                    WebViewActivity.this.n.loadUrl("javascript:setInterval(function() {   if ((document.getElementsByClassName('_2AkmmA _7UHT_c').length > 0)) {     document.getElementsByClassName('_2AkmmA _7UHT_c')[0].click()   }   if (document.getElementsByClassName('_3pZBmm _3C6tOa _1syowc').length == 0) {     if (document.getElementsByClassName('_3uUUD5').length > 0) {       document.getElementsByClassName('_3uUUD5')[0].click()     }   } }, 100)");
                } else {
                    WebViewActivity.this.q.dismiss();
                }
            }
        });
        this.n.loadUrl("https://www.flipkart.com/account/");
        this.q = Snackbar.make(this.n, getString(R.string.please_signin), Snackbar.LENGTH_INDEFINITE);
        this.q.show();
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        setContentView(R.layout.activity_web_view);
        this.n = (WebView) findViewById(R.id.webView);
        this.toolbar = findViewById(R.id.toolbar_web);
        Button refreshbtn = findViewById(R.id.refreshbtn);
        startStopBtn = findViewById(R.id.scriptbtn);
        WebViewActivity.this.startStopBtn.setText("Stop");
        this.o = getIntent().getStringExtra(getString(R.string.site_name));
        this.p = getIntent().getStringExtra(getString(R.string.variant_link));
        this.n.setWebViewClient(new WebViewClient());
        this.n.getSettings().setAppCacheEnabled(true);
        this.n.getSettings().setUserAgentString("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
        this.n.getSettings().setJavaScriptEnabled(true);
        this.n.getSettings().setBuiltInZoomControls(true);
        this.n.getSettings().setUseWideViewPort(true);
        this.n.setScrollbarFadingEnabled(false);
        if (VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        CookieManager.getInstance().setAcceptCookie(true);
        if (this.o.equalsIgnoreCase(getString(R.string.flipkart))) {
            signinFlipKartContentSetup();
        } else {
            signinAmazonContentSetup();
        }
        super.onCreate(bundle);
        refreshbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebViewActivity.this.n.reload();
            }
        });

        startStopBtn.findViewById(R.id.scriptbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebViewActivity.this.isRunning = !WebViewActivity.this.isRunning;
                WebViewActivity.this.n.reload();
                if (WebViewActivity.this.isRunning) {
                    WebViewActivity.this.startStopBtn.setText("Stop");
                    WebViewActivity.this.q = Snackbar.make(WebViewActivity.this.n, "Script running", Snackbar.LENGTH_INDEFINITE);
                } else {
                    WebViewActivity.this.startStopBtn.setText("Start");
                    WebViewActivity.this.q = Snackbar.make(WebViewActivity.this.n, "Script not running", Snackbar.LENGTH_INDEFINITE);
                }
            }
        });
    }
}
