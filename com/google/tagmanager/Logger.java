package com.google.tagmanager;

public interface Logger {

    public enum LogLevel {
        VERBOSE,
        DEBUG,
        INFO,
        WARNING,
        ERROR,
        NONE
    }

    void m1397d(String str);

    void m1398d(String str, Throwable th);

    void m1399e(String str);

    void m1400e(String str, Throwable th);

    LogLevel getLogLevel();

    void m1401i(String str);

    void m1402i(String str, Throwable th);

    void setLogLevel(LogLevel logLevel);

    void m1403v(String str);

    void m1404v(String str, Throwable th);

    void m1405w(String str);

    void m1406w(String str, Throwable th);
}
