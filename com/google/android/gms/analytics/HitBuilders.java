package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.analytics.tracking.android.Fields;
import com.google.analytics.tracking.android.HitTypes;
import com.google.android.gms.analytics.C0124u.C0123a;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.HashMap;
import java.util.Map;

public class HitBuilders {

    protected static class HitBuilder<T extends HitBuilder> {
        private Map<String, String> tO;

        protected HitBuilder() {
            this.tO = new HashMap();
        }

        public Map<String, String> build() {
            return this.tO;
        }

        protected String get(String paramName) {
            return (String) this.tO.get(paramName);
        }

        public final T set(String paramName, String paramValue) {
            C0124u.bR().m80a(C0123a.MAP_BUILDER_SET);
            if (paramName != null) {
                this.tO.put(paramName, paramValue);
            } else {
                aa.m47w(" HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        public final T setAll(Map<String, String> params) {
            C0124u.bR().m80a(C0123a.MAP_BUILDER_SET_ALL);
            if (params != null) {
                this.tO.putAll(new HashMap(params));
            }
            return this;
        }

        public T setCampaignParamsFromUrl(String utmParams) {
            C0124u.bR().m80a(C0123a.MAP_BUILDER_SET_CAMPAIGN_PARAMS);
            Object J = ak.m54J(utmParams);
            if (!TextUtils.isEmpty(J)) {
                Map I = ak.m53I(J);
                set(Fields.CAMPAIGN_CONTENT, (String) I.get("utm_content"));
                set(Fields.CAMPAIGN_MEDIUM, (String) I.get("utm_medium"));
                set(Fields.CAMPAIGN_NAME, (String) I.get("utm_campaign"));
                set(Fields.CAMPAIGN_SOURCE, (String) I.get("utm_source"));
                set(Fields.CAMPAIGN_KEYWORD, (String) I.get("utm_term"));
                set(Fields.CAMPAIGN_ID, (String) I.get("utm_id"));
                set("&gclid", (String) I.get("gclid"));
                set("&dclid", (String) I.get("dclid"));
                set("&gmob_t", (String) I.get("gmob_t"));
            }
            return this;
        }

        public T setCustomDimension(int index, String dimension) {
            set(C0108o.m75q(index), dimension);
            return this;
        }

        public T setCustomMetric(int index, float metric) {
            set(C0108o.m76r(index), Float.toString(metric));
            return this;
        }

        protected T setHitType(String hitType) {
            set(Fields.HIT_TYPE, hitType);
            return this;
        }

        public T setNewSession() {
            set(Fields.SESSION_CONTROL, "start");
            return this;
        }

        public T setNonInteraction(boolean nonInteraction) {
            set(Fields.NON_INTERACTION, ak.m59s(nonInteraction));
            return this;
        }
    }

    public static class AppViewBuilder extends HitBuilder<AppViewBuilder> {
        public AppViewBuilder() {
            C0124u.bR().m80a(C0123a.CONSTRUCT_APP_VIEW);
            set(Fields.HIT_TYPE, HitTypes.APP_VIEW);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class EventBuilder extends HitBuilder<EventBuilder> {
        public EventBuilder() {
            C0124u.bR().m80a(C0123a.CONSTRUCT_EVENT);
            set(Fields.HIT_TYPE, DataLayer.EVENT_KEY);
        }

        public EventBuilder(String category, String action) {
            this();
            setCategory(category);
            setAction(action);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public EventBuilder setAction(String action) {
            set(Fields.EVENT_ACTION, action);
            return this;
        }

        public EventBuilder setCategory(String category) {
            set(Fields.EVENT_CATEGORY, category);
            return this;
        }

        public EventBuilder setLabel(String label) {
            set(Fields.EVENT_LABEL, label);
            return this;
        }

        public EventBuilder setValue(long value) {
            set(Fields.EVENT_VALUE, Long.toString(value));
            return this;
        }
    }

    public static class ExceptionBuilder extends HitBuilder<ExceptionBuilder> {
        public ExceptionBuilder() {
            C0124u.bR().m80a(C0123a.CONSTRUCT_EXCEPTION);
            set(Fields.HIT_TYPE, HitTypes.EXCEPTION);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ExceptionBuilder setDescription(String description) {
            set(Fields.EX_DESCRIPTION, description);
            return this;
        }

        public ExceptionBuilder setFatal(boolean fatal) {
            set(Fields.EX_FATAL, ak.m59s(fatal));
            return this;
        }
    }

    public static class ItemBuilder extends HitBuilder<ItemBuilder> {
        public ItemBuilder() {
            C0124u.bR().m80a(C0123a.CONSTRUCT_ITEM);
            set(Fields.HIT_TYPE, HitTypes.ITEM);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ItemBuilder setCategory(String category) {
            set(Fields.ITEM_CATEGORY, category);
            return this;
        }

        public ItemBuilder setCurrencyCode(String currencyCode) {
            set(Fields.CURRENCY_CODE, currencyCode);
            return this;
        }

        public ItemBuilder setName(String name) {
            set(Fields.ITEM_NAME, name);
            return this;
        }

        public ItemBuilder setPrice(double price) {
            set(Fields.ITEM_PRICE, Double.toString(price));
            return this;
        }

        public ItemBuilder setQuantity(long quantity) {
            set(Fields.ITEM_QUANTITY, Long.toString(quantity));
            return this;
        }

        public ItemBuilder setSku(String sku) {
            set(Fields.ITEM_SKU, sku);
            return this;
        }

        public ItemBuilder setTransactionId(String transactionid) {
            set(Fields.TRANSACTION_ID, transactionid);
            return this;
        }
    }

    public static class SocialBuilder extends HitBuilder<SocialBuilder> {
        public SocialBuilder() {
            C0124u.bR().m80a(C0123a.CONSTRUCT_SOCIAL);
            set(Fields.HIT_TYPE, HitTypes.SOCIAL);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public SocialBuilder setAction(String action) {
            set(Fields.SOCIAL_ACTION, action);
            return this;
        }

        public SocialBuilder setNetwork(String network) {
            set(Fields.SOCIAL_NETWORK, network);
            return this;
        }

        public SocialBuilder setTarget(String target) {
            set(Fields.SOCIAL_TARGET, target);
            return this;
        }
    }

    public static class TimingBuilder extends HitBuilder<TimingBuilder> {
        public TimingBuilder() {
            C0124u.bR().m80a(C0123a.CONSTRUCT_TIMING);
            set(Fields.HIT_TYPE, HitTypes.TIMING);
        }

        public TimingBuilder(String category, String variable, long value) {
            this();
            setVariable(variable);
            setValue(value);
            setCategory(category);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TimingBuilder setCategory(String category) {
            set(Fields.TIMING_CATEGORY, category);
            return this;
        }

        public TimingBuilder setLabel(String label) {
            set(Fields.TIMING_LABEL, label);
            return this;
        }

        public TimingBuilder setValue(long value) {
            set(Fields.TIMING_VALUE, Long.toString(value));
            return this;
        }

        public TimingBuilder setVariable(String variable) {
            set(Fields.TIMING_VAR, variable);
            return this;
        }
    }

    public static class TransactionBuilder extends HitBuilder<TransactionBuilder> {
        public TransactionBuilder() {
            C0124u.bR().m80a(C0123a.CONSTRUCT_TRANSACTION);
            set(Fields.HIT_TYPE, HitTypes.TRANSACTION);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TransactionBuilder setAffiliation(String affiliation) {
            set(Fields.TRANSACTION_AFFILIATION, affiliation);
            return this;
        }

        public TransactionBuilder setCurrencyCode(String currencyCode) {
            set(Fields.CURRENCY_CODE, currencyCode);
            return this;
        }

        public TransactionBuilder setRevenue(double revenue) {
            set(Fields.TRANSACTION_REVENUE, Double.toString(revenue));
            return this;
        }

        public TransactionBuilder setShipping(double shipping) {
            set(Fields.TRANSACTION_SHIPPING, Double.toString(shipping));
            return this;
        }

        public TransactionBuilder setTax(double tax) {
            set(Fields.TRANSACTION_TAX, Double.toString(tax));
            return this;
        }

        public TransactionBuilder setTransactionId(String transactionid) {
            set(Fields.TRANSACTION_ID, transactionid);
            return this;
        }
    }
}
