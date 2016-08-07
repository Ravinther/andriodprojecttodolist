package com.google.android.gms.tagmanager;

import com.google.android.gms.wallet.WalletConstants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class aw implements bl {
    private HttpURLConnection Vj;

    aw() {
    }

    private InputStream m2266a(HttpURLConnection httpURLConnection) throws IOException {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            return httpURLConnection.getInputStream();
        }
        String str = "Bad response: " + responseCode;
        if (responseCode == WalletConstants.ERROR_CODE_INVALID_PARAMETERS) {
            throw new FileNotFoundException(str);
        }
        throw new IOException(str);
    }

    private void m2267b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public InputStream bo(String str) throws IOException {
        this.Vj = bp(str);
        return m2266a(this.Vj);
    }

    HttpURLConnection bp(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(NetworkClient.DEFAULT_SOCKET_TIMEOUT_MILLIS);
        httpURLConnection.setConnectTimeout(NetworkClient.DEFAULT_SOCKET_TIMEOUT_MILLIS);
        return httpURLConnection;
    }

    public void close() {
        m2267b(this.Vj);
    }
}
