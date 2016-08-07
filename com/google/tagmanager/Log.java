package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.Logger.LogLevel;

final class Log {
    @VisibleForTesting
    static Logger sLogger;

    Log() {
    }

    static {
        sLogger = new DefaultLogger();
    }

    public static void setLogger(Logger logger) {
        if (logger == null) {
            sLogger = new NoOpLogger();
        } else {
            sLogger = logger;
        }
    }

    public static Logger getLogger() {
        return sLogger.getClass() == NoOpLogger.class ? null : sLogger;
    }

    public static void m1389e(String message) {
        sLogger.m1399e(message);
    }

    public static void m1390e(String message, Throwable t) {
        sLogger.m1400e(message, t);
    }

    public static void m1395w(String message) {
        sLogger.m1405w(message);
    }

    public static void m1396w(String message, Throwable t) {
        sLogger.m1406w(message, t);
    }

    public static void m1391i(String message) {
        sLogger.m1401i(message);
    }

    public static void m1392i(String message, Throwable t) {
        sLogger.m1402i(message, t);
    }

    public static void m1387d(String message) {
        sLogger.m1397d(message);
    }

    public static void m1388d(String message, Throwable t) {
        sLogger.m1398d(message, t);
    }

    public static void m1393v(String message) {
        sLogger.m1403v(message);
    }

    public static void m1394v(String message, Throwable t) {
        sLogger.m1404v(message, t);
    }

    public static LogLevel getLogLevel() {
        return sLogger.getLogLevel();
    }
}
