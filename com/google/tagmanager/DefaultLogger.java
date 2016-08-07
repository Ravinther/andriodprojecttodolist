package com.google.tagmanager;

import android.util.Log;
import com.google.tagmanager.Logger.LogLevel;

class DefaultLogger implements Logger {
    private static final String LOG_TAG = "GoogleTagManager";
    private LogLevel mLogLevel;

    DefaultLogger() {
        this.mLogLevel = LogLevel.WARNING;
    }

    public void m2384e(String message) {
        if (this.mLogLevel.ordinal() <= LogLevel.ERROR.ordinal()) {
            Log.e(LOG_TAG, message);
        }
    }

    public void m2385e(String message, Throwable t) {
        if (this.mLogLevel.ordinal() <= LogLevel.ERROR.ordinal()) {
            Log.e(LOG_TAG, message, t);
        }
    }

    public void m2390w(String message) {
        if (this.mLogLevel.ordinal() <= LogLevel.WARNING.ordinal()) {
            Log.w(LOG_TAG, message);
        }
    }

    public void m2391w(String message, Throwable t) {
        if (this.mLogLevel.ordinal() <= LogLevel.WARNING.ordinal()) {
            Log.w(LOG_TAG, message, t);
        }
    }

    public void m2386i(String message) {
        if (this.mLogLevel.ordinal() <= LogLevel.INFO.ordinal()) {
            Log.i(LOG_TAG, message);
        }
    }

    public void m2387i(String message, Throwable t) {
        if (this.mLogLevel.ordinal() <= LogLevel.INFO.ordinal()) {
            Log.i(LOG_TAG, message, t);
        }
    }

    public void m2382d(String message) {
        if (this.mLogLevel.ordinal() <= LogLevel.DEBUG.ordinal()) {
            Log.d(LOG_TAG, message);
        }
    }

    public void m2383d(String message, Throwable t) {
        if (this.mLogLevel.ordinal() <= LogLevel.DEBUG.ordinal()) {
            Log.d(LOG_TAG, message, t);
        }
    }

    public void m2388v(String message) {
        if (this.mLogLevel.ordinal() <= LogLevel.VERBOSE.ordinal()) {
            Log.v(LOG_TAG, message);
        }
    }

    public void m2389v(String message, Throwable t) {
        if (this.mLogLevel.ordinal() <= LogLevel.VERBOSE.ordinal()) {
            Log.v(LOG_TAG, message, t);
        }
    }

    public LogLevel getLogLevel() {
        return this.mLogLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.mLogLevel = logLevel;
    }
}
