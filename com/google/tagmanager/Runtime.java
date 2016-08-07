package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.CacheFactory.CacheSizeManager;
import com.google.tagmanager.CustomFunctionCall.CustomEvaluator;
import com.google.tagmanager.ResourceUtil.ExpandedFunctionCall;
import com.google.tagmanager.ResourceUtil.ExpandedResource;
import com.google.tagmanager.ResourceUtil.ExpandedRule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Runtime {
    static final String DEFAULT_RULE_NAME = "Unknown";
    private static final ObjectAndStatic<Value> DEFAULT_VALUE_AND_STATIC;
    private static final int MAX_CACHE_SIZE = 1048576;
    private final EventInfoDistributor eventInfoDistributor;
    private volatile String mCurrentEventName;
    private final Cache<ExpandedFunctionCall, ObjectAndStatic<Value>> mFunctionCallCache;
    private final Cache<String, ObjectAndStatic<Value>> mMacroEvaluationCache;
    private final Map<String, MacroInfo> mMacroLookup;
    private final Map<String, FunctionCallImplementation> mMacroMap;
    private final Map<String, FunctionCallImplementation> mPredicateMap;
    private final ExpandedResource mResource;
    private final Set<ExpandedRule> mRules;
    private final Map<String, FunctionCallImplementation> mTrackingTagMap;

    /* renamed from: com.google.tagmanager.Runtime.5 */
    static /* synthetic */ class C04405 {
        static final /* synthetic */ int[] f51xa390a19;

        static {
            f51xa390a19 = new int[Type.values().length];
            try {
                f51xa390a19[Type.LIST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f51xa390a19[Type.MAP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f51xa390a19[Type.MACRO_REFERENCE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f51xa390a19[Type.TEMPLATE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    interface AddRemoveSetPopulator {
        void rulePassed(ExpandedRule expandedRule, Set<ExpandedFunctionCall> set, Set<ExpandedFunctionCall> set2, ResolvedRuleBuilder resolvedRuleBuilder);
    }

    private static class MacroInfo {
        private final Map<ExpandedRule, List<String>> mAddMacroNames;
        private final Map<ExpandedRule, List<ExpandedFunctionCall>> mAddMacros;
        private ExpandedFunctionCall mDefault;
        private final Map<ExpandedRule, List<String>> mRemoveMacroNames;
        private final Map<ExpandedRule, List<ExpandedFunctionCall>> mRemoveMacros;
        private final Set<ExpandedRule> mRules;

        public MacroInfo() {
            this.mRules = new HashSet();
            this.mAddMacros = new HashMap();
            this.mAddMacroNames = new HashMap();
            this.mRemoveMacros = new HashMap();
            this.mRemoveMacroNames = new HashMap();
        }

        public Set<ExpandedRule> getRules() {
            return this.mRules;
        }

        public void addRule(ExpandedRule rule) {
            this.mRules.add(rule);
        }

        public Map<ExpandedRule, List<ExpandedFunctionCall>> getAddMacros() {
            return this.mAddMacros;
        }

        public Map<ExpandedRule, List<String>> getAddMacroRuleNames() {
            return this.mAddMacroNames;
        }

        public Map<ExpandedRule, List<String>> getRemoveMacroRuleNames() {
            return this.mRemoveMacroNames;
        }

        public void addAddMacroForRule(ExpandedRule rule, ExpandedFunctionCall function) {
            List<ExpandedFunctionCall> result = (List) this.mAddMacros.get(rule);
            if (result == null) {
                result = new ArrayList();
                this.mAddMacros.put(rule, result);
            }
            result.add(function);
        }

        public void addAddMacroRuleNameForRule(ExpandedRule rule, String ruleName) {
            List<String> result = (List) this.mAddMacroNames.get(rule);
            if (result == null) {
                result = new ArrayList();
                this.mAddMacroNames.put(rule, result);
            }
            result.add(ruleName);
        }

        public Map<ExpandedRule, List<ExpandedFunctionCall>> getRemoveMacros() {
            return this.mRemoveMacros;
        }

        public void addRemoveMacroForRule(ExpandedRule rule, ExpandedFunctionCall function) {
            List<ExpandedFunctionCall> result = (List) this.mRemoveMacros.get(rule);
            if (result == null) {
                result = new ArrayList();
                this.mRemoveMacros.put(rule, result);
            }
            result.add(function);
        }

        public void addRemoveMacroRuleNameForRule(ExpandedRule rule, String ruleName) {
            List<String> result = (List) this.mRemoveMacroNames.get(rule);
            if (result == null) {
                result = new ArrayList();
                this.mRemoveMacroNames.put(rule, result);
            }
            result.add(ruleName);
        }

        public ExpandedFunctionCall getDefault() {
            return this.mDefault;
        }

        public void setDefault(ExpandedFunctionCall def) {
            this.mDefault = def;
        }
    }

    /* renamed from: com.google.tagmanager.Runtime.1 */
    class C08191 implements CacheSizeManager<ExpandedFunctionCall, ObjectAndStatic<Value>> {
        C08191() {
        }

        public int sizeOf(ExpandedFunctionCall key, ObjectAndStatic<Value> value) {
            return ((Value) value.getObject()).toByteArray().length;
        }
    }

    /* renamed from: com.google.tagmanager.Runtime.2 */
    class C08202 implements CacheSizeManager<String, ObjectAndStatic<Value>> {
        C08202() {
        }

        public int sizeOf(String key, ObjectAndStatic<Value> value) {
            return ((Value) value.getObject()).toByteArray().length + key.length();
        }
    }

    /* renamed from: com.google.tagmanager.Runtime.3 */
    class C08213 implements AddRemoveSetPopulator {
        final /* synthetic */ Map val$addMacroRuleNames;
        final /* synthetic */ Map val$addMacros;
        final /* synthetic */ Map val$removeMacroRuleNames;
        final /* synthetic */ Map val$removeMacros;

        C08213(Map map, Map map2, Map map3, Map map4) {
            this.val$addMacros = map;
            this.val$addMacroRuleNames = map2;
            this.val$removeMacros = map3;
            this.val$removeMacroRuleNames = map4;
        }

        public void rulePassed(ExpandedRule rule, Set<ExpandedFunctionCall> add, Set<ExpandedFunctionCall> remove, ResolvedRuleBuilder debugRuleBuilder) {
            List<ExpandedFunctionCall> thisAddMacro = (List) this.val$addMacros.get(rule);
            List<String> thisMacroEnablingRuleNames = (List) this.val$addMacroRuleNames.get(rule);
            if (thisAddMacro != null) {
                add.addAll(thisAddMacro);
                debugRuleBuilder.getAddedMacroFunctions().translateAndAddAll(thisAddMacro, thisMacroEnablingRuleNames);
            }
            List<ExpandedFunctionCall> thisRemoveMacro = (List) this.val$removeMacros.get(rule);
            List<String> thisRemoveMacroRuleNames = (List) this.val$removeMacroRuleNames.get(rule);
            if (thisRemoveMacro != null) {
                remove.addAll(thisRemoveMacro);
                debugRuleBuilder.getRemovedMacroFunctions().translateAndAddAll(thisRemoveMacro, thisRemoveMacroRuleNames);
            }
        }
    }

    /* renamed from: com.google.tagmanager.Runtime.4 */
    class C08224 implements AddRemoveSetPopulator {
        C08224() {
        }

        public void rulePassed(ExpandedRule rule, Set<ExpandedFunctionCall> add, Set<ExpandedFunctionCall> remove, ResolvedRuleBuilder debugRuleBuilder) {
            add.addAll(rule.getAddTags());
            remove.addAll(rule.getRemoveTags());
            debugRuleBuilder.getAddedTagFunctions().translateAndAddAll(rule.getAddTags(), rule.getAddTagRuleNames());
            debugRuleBuilder.getRemovedTagFunctions().translateAndAddAll(rule.getRemoveTags(), rule.getRemoveTagRuleNames());
        }
    }

    static {
        DEFAULT_VALUE_AND_STATIC = new ObjectAndStatic(Types.getDefaultValue(), true);
    }

    public Runtime(Context context, ExpandedResource resource, DataLayer dataLayer, CustomEvaluator functionCallMacroEvaluator, CustomEvaluator functionCallTagEvaluator, EventInfoDistributor eventInfoDistributor) {
        if (resource == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.mResource = resource;
        this.mRules = new HashSet(resource.getRules());
        this.eventInfoDistributor = eventInfoDistributor;
        this.mFunctionCallCache = new CacheFactory().createCache(MAX_CACHE_SIZE, new C08191());
        this.mMacroEvaluationCache = new CacheFactory().createCache(MAX_CACHE_SIZE, new C08202());
        this.mTrackingTagMap = new HashMap();
        addTrackingTag(new ArbitraryPixelTag(context));
        addTrackingTag(new CustomFunctionCall(functionCallTagEvaluator));
        addTrackingTag(new UniversalAnalyticsTag(context, dataLayer));
        this.mPredicateMap = new HashMap();
        addPredicate(new ContainsPredicate());
        addPredicate(new EndsWithPredicate());
        addPredicate(new EqualsPredicate());
        addPredicate(new GreaterEqualsPredicate());
        addPredicate(new GreaterThanPredicate());
        addPredicate(new LessEqualsPredicate());
        addPredicate(new LessThanPredicate());
        addPredicate(new RegexPredicate());
        addPredicate(new StartsWithPredicate());
        this.mMacroMap = new HashMap();
        addMacro(new AdvertiserIdMacro(context));
        addMacro(new AdvertisingTrackingEnabledMacro());
        addMacro(new AdwordsClickReferrerMacro(context));
        addMacro(new AppIdMacro(context));
        addMacro(new AppNameMacro(context));
        addMacro(new AppVersionMacro(context));
        addMacro(new ConstantMacro());
        addMacro(new CustomFunctionCall(functionCallMacroEvaluator));
        addMacro(new DataLayerMacro(dataLayer));
        addMacro(new DeviceIdMacro(context));
        addMacro(new DeviceNameMacro());
        addMacro(new EncodeMacro());
        addMacro(new EventMacro(this));
        addMacro(new GtmVersionMacro());
        addMacro(new HashMacro());
        addMacro(new InstallReferrerMacro(context));
        addMacro(new JoinerMacro());
        addMacro(new LanguageMacro());
        addMacro(new MobileAdwordsUniqueIdMacro(context));
        addMacro(new OsVersionMacro());
        addMacro(new PlatformMacro());
        addMacro(new RandomMacro());
        addMacro(new RegexGroupMacro());
        addMacro(new ResolutionMacro(context));
        addMacro(new RuntimeVersionMacro());
        addMacro(new SdkVersionMacro());
        addMacro(new TimeMacro());
        this.mMacroLookup = new HashMap();
        for (ExpandedRule rule : this.mRules) {
            if (eventInfoDistributor.debugMode()) {
                verifyFunctionAndNameListSizes(rule.getAddMacros(), rule.getAddMacroRuleNames(), "add macro");
                verifyFunctionAndNameListSizes(rule.getRemoveMacros(), rule.getRemoveMacroRuleNames(), "remove macro");
                verifyFunctionAndNameListSizes(rule.getAddTags(), rule.getAddTagRuleNames(), "add tag");
                verifyFunctionAndNameListSizes(rule.getRemoveTags(), rule.getRemoveTagRuleNames(), "remove tag");
            }
            int i = 0;
            while (i < rule.getAddMacros().size()) {
                ExpandedFunctionCall function = (ExpandedFunctionCall) rule.getAddMacros().get(i);
                String ruleName = DEFAULT_RULE_NAME;
                if (eventInfoDistributor.debugMode() && i < rule.getAddMacroRuleNames().size()) {
                    ruleName = (String) rule.getAddMacroRuleNames().get(i);
                }
                MacroInfo info = getOrAddMacroInfo(this.mMacroLookup, getFunctionName(function));
                info.addRule(rule);
                info.addAddMacroForRule(rule, function);
                info.addAddMacroRuleNameForRule(rule, ruleName);
                i++;
            }
            i = 0;
            while (i < rule.getRemoveMacros().size()) {
                function = (ExpandedFunctionCall) rule.getRemoveMacros().get(i);
                ruleName = DEFAULT_RULE_NAME;
                if (eventInfoDistributor.debugMode() && i < rule.getRemoveMacroRuleNames().size()) {
                    ruleName = (String) rule.getRemoveMacroRuleNames().get(i);
                }
                info = getOrAddMacroInfo(this.mMacroLookup, getFunctionName(function));
                info.addRule(rule);
                info.addRemoveMacroForRule(rule, function);
                info.addRemoveMacroRuleNameForRule(rule, ruleName);
                i++;
            }
        }
        for (Entry<String, List<ExpandedFunctionCall>> ent : this.mResource.getAllMacros().entrySet()) {
            for (ExpandedFunctionCall function2 : (List) ent.getValue()) {
                if (!Types.valueToBoolean((Value) function2.getProperties().get(Key.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    getOrAddMacroInfo(this.mMacroLookup, (String) ent.getKey()).setDefault(function2);
                }
            }
        }
    }

    public Runtime(Context context, ExpandedResource resource, DataLayer dataLayer, CustomEvaluator functionCallMacroEvaluator, CustomEvaluator functionCallTagEvaluator) {
        this(context, resource, dataLayer, functionCallMacroEvaluator, functionCallTagEvaluator, new NoopEventInfoDistributor());
    }

    public ExpandedResource getResource() {
        return this.mResource;
    }

    public synchronized void evaluateTags(String currentEventName) {
        setCurrentEventName(currentEventName);
        EventInfoBuilder eventInfoBuilder = this.eventInfoDistributor.createDataLayerEventEvaluationEventInfo(currentEventName);
        DataLayerEventEvaluationInfoBuilder debugDataLayerBuilder = eventInfoBuilder.createDataLayerEventEvaluationInfoBuilder();
        for (ExpandedFunctionCall tag : (Set) calculateTagsToRun(this.mRules, debugDataLayerBuilder.createRulesEvaluation()).getObject()) {
            executeFunction(this.mTrackingTagMap, tag, new HashSet(), debugDataLayerBuilder.createAndAddResult());
        }
        eventInfoBuilder.processEventInfo();
        setCurrentEventName(null);
    }

    public ObjectAndStatic<Value> evaluateMacroReference(String macroName) {
        EventInfoBuilder eventInfoBuilder = this.eventInfoDistributor.createMacroEvalutionEventInfo(macroName);
        ObjectAndStatic<Value> result = evaluateMacroReferenceCycleDetection(macroName, new HashSet(), eventInfoBuilder.createMacroEvaluationInfoBuilder());
        eventInfoBuilder.processEventInfo();
        return result;
    }

    @VisibleForTesting
    synchronized void setCurrentEventName(String currentEventName) {
        this.mCurrentEventName = currentEventName;
    }

    synchronized String getCurrentEventName() {
        return this.mCurrentEventName;
    }

    @VisibleForTesting
    ObjectAndStatic<Set<ExpandedFunctionCall>> calculateMacrosToRun(String macroName, Set<ExpandedRule> rules, Map<ExpandedRule, List<ExpandedFunctionCall>> addMacros, Map<ExpandedRule, List<String>> addMacroRuleNames, Map<ExpandedRule, List<ExpandedFunctionCall>> removeMacros, Map<ExpandedRule, List<String>> removeMacroRuleNames, Set<String> pendingMacroExpansions, RuleEvaluationStepInfoBuilder debugRulesEvaluation) {
        return calculateGenericToRun(rules, pendingMacroExpansions, new C08213(addMacros, addMacroRuleNames, removeMacros, removeMacroRuleNames), debugRulesEvaluation);
    }

    @VisibleForTesting
    ObjectAndStatic<Set<ExpandedFunctionCall>> calculateTagsToRun(Set<ExpandedRule> rules, RuleEvaluationStepInfoBuilder debugRulesEvaluation) {
        return calculateGenericToRun(rules, new HashSet(), new C08224(), debugRulesEvaluation);
    }

    private static MacroInfo getOrAddMacroInfo(Map<String, MacroInfo> macroLookup, String key) {
        MacroInfo result = (MacroInfo) macroLookup.get(key);
        if (result != null) {
            return result;
        }
        result = new MacroInfo();
        macroLookup.put(key, result);
        return result;
    }

    private ObjectAndStatic<Set<ExpandedFunctionCall>> calculateGenericToRun(Set<ExpandedRule> rules, Set<String> pendingMacroExpansions, AddRemoveSetPopulator setPopulator, RuleEvaluationStepInfoBuilder debugRulesEvaluation) {
        Set<ExpandedFunctionCall> add = new HashSet();
        Set<ExpandedFunctionCall> remove = new HashSet();
        boolean allStatic = true;
        for (ExpandedRule rule : rules) {
            ResolvedRuleBuilder debugRuleBuilder = debugRulesEvaluation.createResolvedRuleBuilder();
            ObjectAndStatic<Boolean> result = evaluatePredicatesInRule(rule, pendingMacroExpansions, debugRuleBuilder);
            if (((Boolean) result.getObject()).booleanValue()) {
                setPopulator.rulePassed(rule, add, remove, debugRuleBuilder);
            }
            allStatic = allStatic && result.isStatic();
        }
        add.removeAll(remove);
        debugRulesEvaluation.setEnabledFunctions(add);
        return new ObjectAndStatic(add, allStatic);
    }

    private static String getFunctionName(ExpandedFunctionCall functionCall) {
        return Types.valueToString((Value) functionCall.getProperties().get(Key.INSTANCE_NAME.toString()));
    }

    private static void addFunctionImplToMap(Map<String, FunctionCallImplementation> addTo, FunctionCallImplementation impl) {
        if (addTo.containsKey(impl.getInstanceFunctionId())) {
            throw new IllegalArgumentException("Duplicate function type name: " + impl.getInstanceFunctionId());
        }
        addTo.put(impl.getInstanceFunctionId(), impl);
    }

    @VisibleForTesting
    void addMacro(FunctionCallImplementation macro) {
        addFunctionImplToMap(this.mMacroMap, macro);
    }

    @VisibleForTesting
    void addTrackingTag(FunctionCallImplementation tag) {
        addFunctionImplToMap(this.mTrackingTagMap, tag);
    }

    @VisibleForTesting
    void addPredicate(FunctionCallImplementation predicate) {
        addFunctionImplToMap(this.mPredicateMap, predicate);
    }

    @VisibleForTesting
    ObjectAndStatic<Boolean> evaluatePredicate(ExpandedFunctionCall predicate, Set<String> pendingMacroExpansions, ResolvedFunctionCallBuilder debugFunctionCall) {
        ObjectAndStatic<Value> result = executeFunction(this.mPredicateMap, predicate, pendingMacroExpansions, debugFunctionCall);
        Boolean predicateResult = Types.valueToBoolean((Value) result.getObject());
        debugFunctionCall.setFunctionResult(Types.objectToValue(predicateResult));
        return new ObjectAndStatic(predicateResult, result.isStatic());
    }

    @VisibleForTesting
    ObjectAndStatic<Boolean> evaluatePredicatesInRule(ExpandedRule rule, Set<String> pendingMacroExpansions, ResolvedRuleBuilder debugRuleBuilder) {
        boolean allStatic = true;
        for (ExpandedFunctionCall f : rule.getNegativePredicates()) {
            ObjectAndStatic<Boolean> result = evaluatePredicate(f, pendingMacroExpansions, debugRuleBuilder.createNegativePredicate());
            if (((Boolean) result.getObject()).booleanValue()) {
                debugRuleBuilder.setValue(Types.objectToValue(Boolean.valueOf(false)));
                return new ObjectAndStatic(Boolean.valueOf(false), result.isStatic());
            } else if (allStatic && result.isStatic()) {
                allStatic = true;
            } else {
                allStatic = false;
            }
        }
        for (ExpandedFunctionCall f2 : rule.getPositivePredicates()) {
            result = evaluatePredicate(f2, pendingMacroExpansions, debugRuleBuilder.createPositivePredicate());
            if (!((Boolean) result.getObject()).booleanValue()) {
                debugRuleBuilder.setValue(Types.objectToValue(Boolean.valueOf(false)));
                return new ObjectAndStatic(Boolean.valueOf(false), result.isStatic());
            } else if (allStatic && result.isStatic()) {
                allStatic = true;
            } else {
                allStatic = false;
            }
        }
        debugRuleBuilder.setValue(Types.objectToValue(Boolean.valueOf(true)));
        return new ObjectAndStatic(Boolean.valueOf(true), allStatic);
    }

    private ObjectAndStatic<Value> evaluateMacroReferenceCycleDetection(String macroName, Set<String> pendingMacroExpansions, MacroEvaluationInfoBuilder debugMacroEvaluation) {
        ObjectAndStatic<Value> cachedResult = (ObjectAndStatic) this.mMacroEvaluationCache.get(macroName);
        if (cachedResult != null && !this.eventInfoDistributor.debugMode()) {
            return cachedResult;
        }
        MacroInfo macroInfo = (MacroInfo) this.mMacroLookup.get(macroName);
        if (macroInfo == null) {
            Log.m1389e("Invalid macro: " + macroName);
            return DEFAULT_VALUE_AND_STATIC;
        }
        ExpandedFunctionCall macro;
        ObjectAndStatic<Set<ExpandedFunctionCall>> macrosToRun = calculateMacrosToRun(macroName, macroInfo.getRules(), macroInfo.getAddMacros(), macroInfo.getAddMacroRuleNames(), macroInfo.getRemoveMacros(), macroInfo.getRemoveMacroRuleNames(), pendingMacroExpansions, debugMacroEvaluation.createRulesEvaluation());
        if (((Set) macrosToRun.getObject()).isEmpty()) {
            macro = macroInfo.getDefault();
        } else {
            if (((Set) macrosToRun.getObject()).size() > 1) {
                Log.m1395w("Multiple macros active for macroName " + macroName);
            }
            macro = (ExpandedFunctionCall) ((Set) macrosToRun.getObject()).iterator().next();
        }
        if (macro == null) {
            return DEFAULT_VALUE_AND_STATIC;
        }
        ObjectAndStatic<Value> toReturn;
        ObjectAndStatic<Value> macroResult = executeFunction(this.mMacroMap, macro, pendingMacroExpansions, debugMacroEvaluation.createResult());
        boolean isStatic = macrosToRun.isStatic() && macroResult.isStatic();
        if (macroResult == DEFAULT_VALUE_AND_STATIC) {
            toReturn = DEFAULT_VALUE_AND_STATIC;
        } else {
            ObjectAndStatic<Value> objectAndStatic = new ObjectAndStatic(macroResult.getObject(), isStatic);
        }
        if (toReturn.isStatic()) {
            this.mMacroEvaluationCache.put(macroName, toReturn);
        }
        return toReturn;
    }

    private ObjectAndStatic<Value> macroExpandValue(Value value, Set<String> pendingMacroExpansions, ValueBuilder debugValueBuilder) {
        if (!value.getContainsReferences()) {
            return new ObjectAndStatic(value, true);
        }
        Builder builder;
        int i;
        ObjectAndStatic<Value> macroExpand;
        switch (C04405.f51xa390a19[value.getType().ordinal()]) {
            case MutableTypeSystem.Value.TYPE_FIELD_NUMBER /*1*/:
                builder = ResourceUtil.newValueBuilderBasedOnValue(value);
                for (i = 0; i < value.getListItemCount(); i++) {
                    macroExpand = macroExpandValue(value.getListItem(i), pendingMacroExpansions, debugValueBuilder.getListItem(i));
                    if (macroExpand == DEFAULT_VALUE_AND_STATIC) {
                        return DEFAULT_VALUE_AND_STATIC;
                    }
                    builder.addListItem((Value) macroExpand.getObject());
                }
                return new ObjectAndStatic(builder.build(), false);
            case MutableTypeSystem.Value.STRING_FIELD_NUMBER /*2*/:
                builder = ResourceUtil.newValueBuilderBasedOnValue(value);
                if (value.getMapKeyCount() != value.getMapValueCount()) {
                    Log.m1389e("Invalid serving value: " + value.toString());
                    return DEFAULT_VALUE_AND_STATIC;
                }
                for (i = 0; i < value.getMapKeyCount(); i++) {
                    ObjectAndStatic<Value> macroExpandKey = macroExpandValue(value.getMapKey(i), pendingMacroExpansions, debugValueBuilder.getMapKey(i));
                    ObjectAndStatic<Value> macroExpandValue = macroExpandValue(value.getMapValue(i), pendingMacroExpansions, debugValueBuilder.getMapValue(i));
                    if (macroExpandKey == DEFAULT_VALUE_AND_STATIC || macroExpandValue == DEFAULT_VALUE_AND_STATIC) {
                        return DEFAULT_VALUE_AND_STATIC;
                    }
                    builder.addMapKey((Value) macroExpandKey.getObject());
                    builder.addMapValue((Value) macroExpandValue.getObject());
                }
                return new ObjectAndStatic(builder.build(), false);
            case MutableTypeSystem.Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                if (pendingMacroExpansions.contains(value.getMacroReference())) {
                    Log.m1389e("Macro cycle detected.  Current macro reference: " + value.getMacroReference() + "." + "  Previous macro references: " + pendingMacroExpansions.toString() + ".");
                    return DEFAULT_VALUE_AND_STATIC;
                }
                pendingMacroExpansions.add(value.getMacroReference());
                ObjectAndStatic<Value> result = ValueEscapeUtil.applyEscapings(evaluateMacroReferenceCycleDetection(value.getMacroReference(), pendingMacroExpansions, debugValueBuilder.createValueMacroEvaluationInfoExtension()), value.getEscapingList());
                pendingMacroExpansions.remove(value.getMacroReference());
                return result;
            case MutableTypeSystem.Value.MAP_KEY_FIELD_NUMBER /*4*/:
                builder = ResourceUtil.newValueBuilderBasedOnValue(value);
                for (i = 0; i < value.getTemplateTokenCount(); i++) {
                    macroExpand = macroExpandValue(value.getTemplateToken(i), pendingMacroExpansions, debugValueBuilder.getTemplateToken(i));
                    if (macroExpand == DEFAULT_VALUE_AND_STATIC) {
                        return DEFAULT_VALUE_AND_STATIC;
                    }
                    builder.addTemplateToken((Value) macroExpand.getObject());
                }
                return new ObjectAndStatic(builder.build(), false);
            default:
                Log.m1389e("Unknown type: " + value.getType());
                return DEFAULT_VALUE_AND_STATIC;
        }
    }

    private ObjectAndStatic<Value> executeFunction(Map<String, FunctionCallImplementation> implMap, ExpandedFunctionCall functionCall, Set<String> pendingMacroExpansions, ResolvedFunctionCallBuilder debugFunctionCall) {
        Value functionIdValue = (Value) functionCall.getProperties().get(Key.FUNCTION.toString());
        if (functionIdValue == null) {
            Log.m1389e("No function id in properties");
            return DEFAULT_VALUE_AND_STATIC;
        }
        String functionId = functionIdValue.getFunctionId();
        FunctionCallImplementation impl = (FunctionCallImplementation) implMap.get(functionId);
        if (impl == null) {
            Log.m1389e(functionId + " has no backing implementation.");
            return DEFAULT_VALUE_AND_STATIC;
        }
        ObjectAndStatic<Value> cachedResult = (ObjectAndStatic) this.mFunctionCallCache.get(functionCall);
        if (cachedResult != null && !this.eventInfoDistributor.debugMode()) {
            return cachedResult;
        }
        Map<String, Value> expandedParams = new HashMap();
        boolean allParamsStatic = true;
        for (Entry<String, Value> originalParam : functionCall.getProperties().entrySet()) {
            ObjectAndStatic<Value> result = macroExpandValue((Value) originalParam.getValue(), pendingMacroExpansions, debugFunctionCall.createResolvedPropertyBuilder((String) originalParam.getKey()).createPropertyValueBuilder((Value) originalParam.getValue()));
            if (result == DEFAULT_VALUE_AND_STATIC) {
                return DEFAULT_VALUE_AND_STATIC;
            }
            if (result.isStatic()) {
                functionCall.updateCacheableProperty((String) originalParam.getKey(), (Value) result.getObject());
            } else {
                allParamsStatic = false;
            }
            expandedParams.put(originalParam.getKey(), result.getObject());
        }
        if (impl.hasRequiredKeys(expandedParams.keySet())) {
            boolean cacheable = allParamsStatic && impl.isCacheable();
            result = new ObjectAndStatic(impl.evaluate(expandedParams), cacheable);
            if (cacheable) {
                this.mFunctionCallCache.put(functionCall, result);
            }
            debugFunctionCall.setFunctionResult((Value) result.getObject());
            return result;
        }
        Log.m1389e("Incorrect keys for function " + functionId + " required " + impl.getRequiredKeys() + " had " + expandedParams.keySet());
        return DEFAULT_VALUE_AND_STATIC;
    }

    private static void verifyFunctionAndNameListSizes(List<ExpandedFunctionCall> functionList, List<String> ruleNameList, String operation) {
        if (functionList.size() != ruleNameList.size()) {
            Log.m1391i("Invalid resource: imbalance of rule names of functions for " + operation + " operation. Using default rule name instead");
        }
    }
}
