package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.google.android.gms.analytics.k */
abstract class C0105k<T extends C0103j> {
    Context mContext;
    C0104a<T> rb;

    /* renamed from: com.google.android.gms.analytics.k.a */
    public interface C0104a<U extends C0103j> {
        void m66a(String str, int i);

        void m67a(String str, String str2);

        void m68b(String str, String str2);

        U bz();

        void m69c(String str, boolean z);
    }

    public C0105k(Context context, C0104a<T> c0104a) {
        this.mContext = context;
        this.rb = c0104a;
    }

    private T m70a(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String toLowerCase = xmlResourceParser.getName().toLowerCase();
                    String trim;
                    if (toLowerCase.equals("screenname")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            this.rb.m67a(toLowerCase, trim);
                        }
                    } else if (toLowerCase.equals("string")) {
                        r0 = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(r0) || trim == null)) {
                            this.rb.m68b(r0, trim);
                        }
                    } else if (toLowerCase.equals("bool")) {
                        r0 = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(r0) || TextUtils.isEmpty(trim))) {
                            try {
                                this.rb.m69c(r0, Boolean.parseBoolean(trim));
                            } catch (NumberFormatException e) {
                                aa.m44t("Error parsing bool configuration value: " + trim);
                            }
                        }
                    } else if (toLowerCase.equals("integer")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            try {
                                this.rb.m66a(toLowerCase, Integer.parseInt(trim));
                            } catch (NumberFormatException e2) {
                                aa.m44t("Error parsing int configuration value: " + trim);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e3) {
            aa.m44t("Error parsing tracker configuration file: " + e3);
        } catch (IOException e4) {
            aa.m44t("Error parsing tracker configuration file: " + e4);
        }
        return this.rb.bz();
    }

    public T m71p(int i) {
        try {
            return m70a(this.mContext.getResources().getXml(i));
        } catch (NotFoundException e) {
            aa.m47w("inflate() called with unknown resourceId: " + e);
            return null;
        }
    }
}
