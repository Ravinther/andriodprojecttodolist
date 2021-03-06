package com.google.android.gms.tagmanager;

import com.google.android.gms.wallet.WalletConstants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

class av implements bl {
    private HttpClient Vi;

    av() {
    }

    private InputStream m2264a(HttpClient httpClient, HttpResponse httpResponse) throws IOException {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            bh.m1268v("Success response");
            return httpResponse.getEntity().getContent();
        }
        String str = "Bad response: " + statusCode;
        if (statusCode == WalletConstants.ERROR_CODE_INVALID_PARAMETERS) {
            throw new FileNotFoundException(str);
        }
        throw new IOException(str);
    }

    private void m2265a(HttpClient httpClient) {
        if (httpClient != null && httpClient.getConnectionManager() != null) {
            httpClient.getConnectionManager().shutdown();
        }
    }

    public InputStream bo(String str) throws IOException {
        this.Vi = jg();
        return m2264a(this.Vi, this.Vi.execute(new HttpGet(str)));
    }

    public void close() {
        m2265a(this.Vi);
    }

    HttpClient jg() {
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, NetworkClient.DEFAULT_SOCKET_TIMEOUT_MILLIS);
        HttpConnectionParams.setSoTimeout(basicHttpParams, NetworkClient.DEFAULT_SOCKET_TIMEOUT_MILLIS);
        return new DefaultHttpClient(basicHttpParams);
    }
}
