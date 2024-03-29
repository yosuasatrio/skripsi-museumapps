package app.andropath.com.moodroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AccountFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_account, container, false);
        String strtext = "";
        if(getArguments()!=null) {
            strtext = getArguments().getString("edttext");
        }

        Log.e("data = ",""+strtext);

        WebView mWebView = (WebView) v.findViewById(R.id.webview);
        mWebView.loadUrl("http://103.4.165.137/yosua/mooview/index.php?detail/post_qr/" + strtext);

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());

        return v;
    }
}