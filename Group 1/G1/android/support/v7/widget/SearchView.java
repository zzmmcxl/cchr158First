package android.support.v7.widget;

import android.view.KeyEvent$DispatcherState;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import android.os.ResultReceiver;
import java.lang.reflect.Method;
import android.view.View$MeasureSpec;
import android.widget.ListAdapter;
import android.content.ActivityNotFoundException;
import android.text.TextUtils;
import android.content.pm.ResolveInfo;
import android.text.style.ImageSpan;
import android.text.SpannableStringBuilder;
import android.widget.AutoCompleteTextView;
import android.content.ComponentName;
import android.os.Parcelable;
import android.app.PendingIntent;
import android.util.Log;
import android.net.Uri;
import android.content.res.Resources;
import android.graphics.Rect;
import android.annotation.TargetApi;
import android.view.View$OnLayoutChangeListener;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.text.Editable;
import android.widget.AdapterView;
import android.widget.TextView;
import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.database.Cursor;
import android.view.inputmethod.InputMethodManager;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import android.content.Intent;
import android.text.TextWatcher;
import android.view.View$OnKeyListener;
import android.support.v4.widget.CursorAdapter;
import android.app.SearchableInfo;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$ConstantState;
import java.util.WeakHashMap;
import android.view.View$OnFocusChangeListener;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.TextView$OnEditorActionListener;
import android.view.View$OnClickListener;
import android.view.View;
import android.widget.ImageView;
import android.os.Bundle;
import android.support.v7.view.CollapsibleActionView;

public class SearchView extends LinearLayoutCompat implements CollapsibleActionView
{
    private static final boolean DBG = false;
    static final AutoCompleteTextViewReflector HIDDEN_METHOD_INVOKER;
    private static final String IME_OPTION_NO_MICROPHONE = "nm";
    private static final boolean IS_AT_LEAST_FROYO = false;
    private static final String LOG_TAG = "SearchView";
    private Bundle mAppSearchData;
    private boolean mClearingFocus;
    private final ImageView mCloseButton;
    private final ImageView mCollapsedIcon;
    private int mCollapsedImeOptions;
    private final CharSequence mDefaultQueryHint;
    private final AppCompatDrawableManager mDrawableManager;
    private final View mDropDownAnchor;
    private boolean mExpandedInActionView;
    private final ImageView mGoButton;
    private boolean mIconified;
    private boolean mIconifiedByDefault;
    private int mMaxWidth;
    private CharSequence mOldQueryText;
    private final View$OnClickListener mOnClickListener;
    private OnCloseListener mOnCloseListener;
    private final TextView$OnEditorActionListener mOnEditorActionListener;
    private final AdapterView$OnItemClickListener mOnItemClickListener;
    private final AdapterView$OnItemSelectedListener mOnItemSelectedListener;
    private OnQueryTextListener mOnQueryChangeListener;
    private View$OnFocusChangeListener mOnQueryTextFocusChangeListener;
    private View$OnClickListener mOnSearchClickListener;
    private OnSuggestionListener mOnSuggestionListener;
    private final WeakHashMap<String, Drawable$ConstantState> mOutsideDrawablesCache;
    private CharSequence mQueryHint;
    private boolean mQueryRefinement;
    private Runnable mReleaseCursorRunnable;
    private final ImageView mSearchButton;
    private final View mSearchEditFrame;
    private final Drawable mSearchHintIcon;
    private final View mSearchPlate;
    private final SearchAutoComplete mSearchSrcTextView;
    private SearchableInfo mSearchable;
    private Runnable mShowImeRunnable;
    private final View mSubmitArea;
    private boolean mSubmitButtonEnabled;
    private final int mSuggestionCommitIconResId;
    private final int mSuggestionRowLayout;
    private CursorAdapter mSuggestionsAdapter;
    View$OnKeyListener mTextKeyListener;
    private TextWatcher mTextWatcher;
    private final Runnable mUpdateDrawableStateRunnable;
    private CharSequence mUserQuery;
    private final Intent mVoiceAppSearchIntent;
    private final ImageView mVoiceButton;
    private boolean mVoiceButtonEnabled;
    private final Intent mVoiceWebSearchIntent;
    
    static {
        HIDDEN_METHOD_INVOKER = new AutoCompleteTextViewReflector();
    }
    
    public SearchView(final Context context) {
        this(context, null);
    }
    
    public SearchView(final Context context, final AttributeSet set) {
        this(context, set, R.attr.searchViewStyle);
    }
    
    public SearchView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        mShowImeRunnable = new Runnable() {
            final /* synthetic */ SearchView this$0;
            
            SearchView$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                final InputMethodManager inputMethodManager = (InputMethodManager)this$0.getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    HIDDEN_METHOD_INVOKER.showSoftInputUnchecked(inputMethodManager, (View)this$0, 0);
                }
            }
        };
        mUpdateDrawableStateRunnable = new Runnable() {
            final /* synthetic */ SearchView this$0;
            
            SearchView$2() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                this$0.updateFocusedState();
            }
        };
        mReleaseCursorRunnable = new Runnable() {
            final /* synthetic */ SearchView this$0;
            
            SearchView$3() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                if (mSuggestionsAdapter != null && mSuggestionsAdapter instanceof SuggestionsAdapter) {
                    mSuggestionsAdapter.changeCursor(null);
                }
            }
        };
        mOutsideDrawablesCache = new WeakHashMap<String, Drawable$ConstantState>();
        mOnClickListener = (View$OnClickListener)new View$OnClickListener() {
            final /* synthetic */ SearchView this$0;
            
            SearchView$7() {
                this$0 = this$0;
                super();
            }
            
            public void onClick(final View view) {
                if (view == mSearchButton) {
                    this$0.onSearchClicked();
                }
                else {
                    if (view == mCloseButton) {
                        this$0.onCloseClicked();
                        return;
                    }
                    if (view == mGoButton) {
                        this$0.onSubmitQuery();
                        return;
                    }
                    if (view == mVoiceButton) {
                        this$0.onVoiceClicked();
                        return;
                    }
                    if (view == mSearchSrcTextView) {
                        this$0.forceSuggestionQuery();
                    }
                }
            }
        };
        mTextKeyListener = (View$OnKeyListener)new View$OnKeyListener() {
            final /* synthetic */ SearchView this$0;
            
            SearchView$8() {
                this$0 = this$0;
                super();
            }
            
            public boolean onKey(final View view, final int n, final KeyEvent keyEvent) {
                if (mSearchable != null) {
                    if (mSearchSrcTextView.isPopupShowing() && mSearchSrcTextView.getListSelection() != -1) {
                        return this$0.onSuggestionsKey(view, n, keyEvent);
                    }
                    if (!mSearchSrcTextView.isEmpty() && KeyEventCompat.hasNoModifiers(keyEvent) && keyEvent.getAction() == 1 && n == 66) {
                        view.cancelLongPress();
                        this$0.launchQuerySearch(0, null, mSearchSrcTextView.getText().toString());
                        return true;
                    }
                }
                return false;
            }
        };
        mOnEditorActionListener = (TextView$OnEditorActionListener)new TextView$OnEditorActionListener() {
            final /* synthetic */ SearchView this$0;
            
            SearchView$9() {
                this$0 = this$0;
                super();
            }
            
            public boolean onEditorAction(final TextView textView, final int n, final KeyEvent keyEvent) {
                this$0.onSubmitQuery();
                return true;
            }
        };
        mOnItemClickListener = (AdapterView$OnItemClickListener)new AdapterView$OnItemClickListener() {
            final /* synthetic */ SearchView this$0;
            
            SearchView$10() {
                this$0 = this$0;
                super();
            }
            
            public void onItemClick(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
                this$0.onItemClicked(n, 0, null);
            }
        };
        mOnItemSelectedListener = (AdapterView$OnItemSelectedListener)new AdapterView$OnItemSelectedListener() {
            final /* synthetic */ SearchView this$0;
            
            SearchView$11() {
                this$0 = this$0;
                super();
            }
            
            public void onItemSelected(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
                this$0.onItemSelected(n);
            }
            
            public void onNothingSelected(final AdapterView<?> adapterView) {
            }
        };
        mTextWatcher = (TextWatcher)new TextWatcher() {
            final /* synthetic */ SearchView this$0;
            
            SearchView$12() {
                this$0 = this$0;
                super();
            }
            
            public void afterTextChanged(final Editable editable) {
            }
            
            public void beforeTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
            }
            
            public void onTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
                this$0.onTextChanged(charSequence);
            }
        };
        mDrawableManager = AppCompatDrawableManager.get();
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, set, R.styleable.SearchView, n, 0);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(R.styleable.SearchView_layout, R.layout.abc_search_view), (ViewGroup)this, true);
        (mSearchSrcTextView = (SearchAutoComplete)this.findViewById(R.id.search_src_text)).setSearchView(this);
        mSearchEditFrame = this.findViewById(R.id.search_edit_frame);
        mSearchPlate = this.findViewById(R.id.search_plate);
        mSubmitArea = this.findViewById(R.id.submit_area);
        mSearchButton = (ImageView)this.findViewById(R.id.search_button);
        mGoButton = (ImageView)this.findViewById(R.id.search_go_btn);
        mCloseButton = (ImageView)this.findViewById(R.id.search_close_btn);
        mVoiceButton = (ImageView)this.findViewById(R.id.search_voice_btn);
        mCollapsedIcon = (ImageView)this.findViewById(R.id.search_mag_icon);
        mSearchPlate.setBackgroundDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_queryBackground));
        mSubmitArea.setBackgroundDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_submitBackground));
        mSearchButton.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_searchIcon));
        mGoButton.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_goIcon));
        mCloseButton.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_closeIcon));
        mVoiceButton.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_voiceIcon));
        mCollapsedIcon.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_searchIcon));
        mSearchHintIcon = obtainStyledAttributes.getDrawable(R.styleable.SearchView_searchHintIcon);
        mSuggestionRowLayout = obtainStyledAttributes.getResourceId(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
        mSuggestionCommitIconResId = obtainStyledAttributes.getResourceId(R.styleable.SearchView_commitIcon, 0);
        mSearchButton.setOnClickListener(mOnClickListener);
        mCloseButton.setOnClickListener(mOnClickListener);
        mGoButton.setOnClickListener(mOnClickListener);
        mVoiceButton.setOnClickListener(mOnClickListener);
        mSearchSrcTextView.setOnClickListener(mOnClickListener);
        mSearchSrcTextView.addTextChangedListener(mTextWatcher);
        mSearchSrcTextView.setOnEditorActionListener(mOnEditorActionListener);
        mSearchSrcTextView.setOnItemClickListener(mOnItemClickListener);
        mSearchSrcTextView.setOnItemSelectedListener(mOnItemSelectedListener);
        mSearchSrcTextView.setOnKeyListener(mTextKeyListener);
        mSearchSrcTextView.setOnFocusChangeListener((View$OnFocusChangeListener)new View$OnFocusChangeListener() {
            final /* synthetic */ SearchView this$0;
            
            SearchView$4() {
                this$0 = this$0;
                super();
            }
            
            public void onFocusChange(final View view, final boolean b) {
                if (mOnQueryTextFocusChangeListener != null) {
                    mOnQueryTextFocusChangeListener.onFocusChange((View)this$0, b);
                }
            }
        });
        this.setIconifiedByDefault(obtainStyledAttributes.getBoolean(R.styleable.SearchView_iconifiedByDefault, true));
        final int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            this.setMaxWidth(dimensionPixelSize);
        }
        mDefaultQueryHint = obtainStyledAttributes.getText(R.styleable.SearchView_defaultQueryHint);
        mQueryHint = obtainStyledAttributes.getText(R.styleable.SearchView_queryHint);
        final int int1 = obtainStyledAttributes.getInt(R.styleable.SearchView_android_imeOptions, -1);
        if (int1 != -1) {
            this.setImeOptions(int1);
        }
        final int int2 = obtainStyledAttributes.getInt(R.styleable.SearchView_android_inputType, -1);
        if (int2 != -1) {
            this.setInputType(int2);
        }
        this.setFocusable(obtainStyledAttributes.getBoolean(R.styleable.SearchView_android_focusable, true));
        obtainStyledAttributes.recycle();
        (mVoiceWebSearchIntent = new Intent("android.speech.action.WEB_SEARCH")).addFlags(268435456);
        mVoiceWebSearchIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        (mVoiceAppSearchIntent = new Intent("android.speech.action.RECOGNIZE_SPEECH")).addFlags(268435456);
        mDropDownAnchor = this.findViewById(mSearchSrcTextView.getDropDownAnchor());
        if (mDropDownAnchor != null) {
            if (Build$VERSION.SDK_INT >= 11) {
                this.addOnLayoutChangeListenerToDropDownAnchorSDK11();
            }
            else {
                this.addOnLayoutChangeListenerToDropDownAnchorBase();
            }
        }
        this.updateViewsVisibility(mIconifiedByDefault);
        this.updateQueryHint();
    }
    
    static /* synthetic */ void access$000(final SearchView searchView) {
        searchView.updateFocusedState();
    }
    
    static /* synthetic */ CursorAdapter access$100(final SearchView searchView) {
        return searchView.mSuggestionsAdapter;
    }
    
    static /* synthetic */ ImageView access$1000(final SearchView searchView) {
        return searchView.mVoiceButton;
    }
    
    static /* synthetic */ void access$1100(final SearchView searchView) {
        searchView.onVoiceClicked();
    }
    
    static /* synthetic */ SearchAutoComplete access$1200(final SearchView searchView) {
        return searchView.mSearchSrcTextView;
    }
    
    static /* synthetic */ void access$1300(final SearchView searchView) {
        searchView.forceSuggestionQuery();
    }
    
    static /* synthetic */ SearchableInfo access$1400(final SearchView searchView) {
        return searchView.mSearchable;
    }
    
    static /* synthetic */ boolean access$1500(final SearchView searchView, final View view, final int n, final KeyEvent keyEvent) {
        return searchView.onSuggestionsKey(view, n, keyEvent);
    }
    
    static /* synthetic */ void access$1700(final SearchView searchView, final int n, final String s, final String s2) {
        searchView.launchQuerySearch(n, s, s2);
    }
    
    static /* synthetic */ boolean access$1800(final SearchView searchView, final int n, final int n2, final String s) {
        return searchView.onItemClicked(n, n2, s);
    }
    
    static /* synthetic */ boolean access$1900(final SearchView searchView, final int n) {
        return searchView.onItemSelected(n);
    }
    
    static /* synthetic */ View$OnFocusChangeListener access$200(final SearchView searchView) {
        return searchView.mOnQueryTextFocusChangeListener;
    }
    
    static /* synthetic */ void access$2000(final SearchView searchView, final CharSequence charSequence) {
        searchView.onTextChanged(charSequence);
    }
    
    static /* synthetic */ void access$2100(final SearchView searchView, final boolean imeVisibility) {
        searchView.setImeVisibility(imeVisibility);
    }
    
    static /* synthetic */ void access$300(final SearchView searchView) {
        searchView.adjustDropDownSizeAndPosition();
    }
    
    static /* synthetic */ ImageView access$400(final SearchView searchView) {
        return searchView.mSearchButton;
    }
    
    static /* synthetic */ void access$500(final SearchView searchView) {
        searchView.onSearchClicked();
    }
    
    static /* synthetic */ ImageView access$600(final SearchView searchView) {
        return searchView.mCloseButton;
    }
    
    static /* synthetic */ void access$700(final SearchView searchView) {
        searchView.onCloseClicked();
    }
    
    static /* synthetic */ ImageView access$800(final SearchView searchView) {
        return searchView.mGoButton;
    }
    
    static /* synthetic */ void access$900(final SearchView searchView) {
        searchView.onSubmitQuery();
    }
    
    private void addOnLayoutChangeListenerToDropDownAnchorBase() {
        mDropDownAnchor.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)new ViewTreeObserver$OnGlobalLayoutListener() {
            final /* synthetic */ SearchView this$0;
            
            SearchView$6() {
                this$0 = this$0;
                super();
            }
            
            public void onGlobalLayout() {
                this$0.adjustDropDownSizeAndPosition();
            }
        });
    }
    
    @TargetApi(11)
    private void addOnLayoutChangeListenerToDropDownAnchorSDK11() {
        mDropDownAnchor.addOnLayoutChangeListener((View$OnLayoutChangeListener)new View$OnLayoutChangeListener() {
            final /* synthetic */ SearchView this$0;
            
            SearchView$5() {
                this$0 = this$0;
                super();
            }
            
            public void onLayoutChange(final View view, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
                this$0.adjustDropDownSizeAndPosition();
            }
        });
    }
    
    private void adjustDropDownSizeAndPosition() {
        if (mDropDownAnchor.getWidth() > 1) {
            final Resources resources = this.getContext().getResources();
            final int paddingLeft = mSearchPlate.getPaddingLeft();
            final Rect rect = new Rect();
            final boolean layoutRtl = ViewUtils.isLayoutRtl((View)this);
            int n;
            if (mIconifiedByDefault) {
                n = resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left);
            }
            else {
                n = 0;
            }
            mSearchSrcTextView.getDropDownBackground().getPadding(rect);
            int dropDownHorizontalOffset;
            if (layoutRtl) {
                dropDownHorizontalOffset = -rect.left;
            }
            else {
                dropDownHorizontalOffset = paddingLeft - (n + rect.left);
            }
            mSearchSrcTextView.setDropDownHorizontalOffset(dropDownHorizontalOffset);
            mSearchSrcTextView.setDropDownWidth(n + (mDropDownAnchor.getWidth() + rect.left + rect.right) - paddingLeft);
        }
    }
    
    private Intent createIntent(final String s, final Uri data, final String s2, final String s3, final int n, final String s4) {
        final Intent intent = new Intent(s);
        intent.addFlags(268435456);
        if (data != null) {
            intent.setData(data);
        }
        intent.putExtra("user_query", mUserQuery);
        if (s3 != null) {
            intent.putExtra("query", s3);
        }
        if (s2 != null) {
            intent.putExtra("intent_extra_data_key", s2);
        }
        if (mAppSearchData != null) {
            intent.putExtra("app_data", mAppSearchData);
        }
        if (n != 0) {
            intent.putExtra("action_key", n);
            intent.putExtra("action_msg", s4);
        }
        if (IS_AT_LEAST_FROYO) {
            intent.setComponent(mSearchable.getSearchActivity());
        }
        return intent;
    }
    
    private Intent createIntentFromSuggestion(final Cursor cursor, final int n, final String s) {
        String s2 = null;
        String columnString;
        String s3 = null;
        Uri parse;
        int position;
        Label_0063_Outer:Label_0145_Outer:
        while (true) {
        Label_0116_Outer:
            while (true) {
                while (true) {
                    Label_0231: {
                        while (true) {
                            Label_0218: {
                                try {
                                    s2 = SuggestionsAdapter.getColumnString(cursor, "suggest_intent_action");
                                    if (s2 == null && Build$VERSION.SDK_INT >= 8) {
                                        s2 = mSearchable.getSuggestIntentAction();
                                    }
                                    break Label_0218;
                                    // iftrue(Label_0231:, columnString == null)
                                    // iftrue(Label_0231:, s3 == null)
                                    while (true) {
                                        while (true) {
                                            Block_9: {
                                                while (true) {
                                                    columnString = SuggestionsAdapter.getColumnString(cursor, "suggest_intent_data_id");
                                                    break Block_9;
                                                    continue Label_0063_Outer;
                                                }
                                                parse = Uri.parse(s3);
                                                return this.createIntent(s2, parse, SuggestionsAdapter.getColumnString(cursor, "suggest_intent_extra_data"), SuggestionsAdapter.getColumnString(cursor, "suggest_intent_query"), n, s);
                                            }
                                            s3 = s3 + "/" + Uri.encode(columnString);
                                            break Label_0231;
                                            s3 = mSearchable.getSuggestIntentData();
                                            continue Label_0145_Outer;
                                        }
                                        return this.createIntent(s2, parse, SuggestionsAdapter.getColumnString(cursor, "suggest_intent_extra_data"), SuggestionsAdapter.getColumnString(cursor, "suggest_intent_query"), n, s);
                                        s3 = SuggestionsAdapter.getColumnString(cursor, "suggest_intent_data");
                                        continue Label_0116_Outer;
                                    }
                                }
                                // iftrue(Label_0063:, !SearchView.IS_AT_LEAST_FROYO || s3 != null)
                                catch (RuntimeException ex) {
                                    try {
                                        position = cursor.getPosition();
                                        Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", (Throwable)ex);
                                        return null;
                                    }
                                    catch (RuntimeException ex2) {
                                        position = -1;
                                    }
                                }
                            }
                            if (s2 == null) {
                                s2 = "android.intent.action.SEARCH";
                                continue;
                            }
                            continue;
                        }
                    }
                    if (s3 == null) {
                        parse = null;
                        continue;
                    }
                    break;
                }
                continue Label_0116_Outer;
            }
        }
    }
    
    @TargetApi(8)
    private Intent createVoiceAppSearchIntent(final Intent intent, final SearchableInfo searchableInfo) {
        final ComponentName searchActivity = searchableInfo.getSearchActivity();
        final Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        final PendingIntent activity = PendingIntent.getActivity(this.getContext(), 0, intent2, 1073741824);
        final Bundle bundle = new Bundle();
        if (mAppSearchData != null) {
            bundle.putParcelable("app_data", (Parcelable)mAppSearchData);
        }
        final Intent intent3 = new Intent(intent);
        String string = "free_form";
        int voiceMaxResults = 1;
        final int sdk_INT = Build$VERSION.SDK_INT;
        String string2 = null;
        String string3 = null;
        if (sdk_INT >= 8) {
            final Resources resources = this.getResources();
            if (searchableInfo.getVoiceLanguageModeId() != 0) {
                string = resources.getString(searchableInfo.getVoiceLanguageModeId());
            }
            final int voicePromptTextId = searchableInfo.getVoicePromptTextId();
            string3 = null;
            if (voicePromptTextId != 0) {
                string3 = resources.getString(searchableInfo.getVoicePromptTextId());
            }
            final int voiceLanguageId = searchableInfo.getVoiceLanguageId();
            string2 = null;
            if (voiceLanguageId != 0) {
                string2 = resources.getString(searchableInfo.getVoiceLanguageId());
            }
            if (searchableInfo.getVoiceMaxResults() != 0) {
                voiceMaxResults = searchableInfo.getVoiceMaxResults();
            }
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string3);
        intent3.putExtra("android.speech.extra.LANGUAGE", string2);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        String flattenToShortString;
        if (searchActivity == null) {
            flattenToShortString = null;
        }
        else {
            flattenToShortString = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", flattenToShortString);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", (Parcelable)activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }
    
    @TargetApi(8)
    private Intent createVoiceWebSearchIntent(final Intent intent, final SearchableInfo searchableInfo) {
        final Intent intent2 = new Intent(intent);
        final ComponentName searchActivity = searchableInfo.getSearchActivity();
        String flattenToShortString;
        if (searchActivity == null) {
            flattenToShortString = null;
        }
        else {
            flattenToShortString = searchActivity.flattenToShortString();
        }
        intent2.putExtra("calling_package", flattenToShortString);
        return intent2;
    }
    
    private void dismissSuggestions() {
        mSearchSrcTextView.dismissDropDown();
    }
    
    private void forceSuggestionQuery() {
        HIDDEN_METHOD_INVOKER.doBeforeTextChanged(mSearchSrcTextView);
        HIDDEN_METHOD_INVOKER.doAfterTextChanged(mSearchSrcTextView);
    }
    
    private CharSequence getDecoratedHint(final CharSequence charSequence) {
        if (!mIconifiedByDefault || mSearchHintIcon == null) {
            return charSequence;
        }
        final int n = (int)(1.25 * mSearchSrcTextView.getTextSize());
        mSearchHintIcon.setBounds(0, 0, n, n);
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)"   ");
        spannableStringBuilder.setSpan((Object)new ImageSpan(mSearchHintIcon), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return (CharSequence)spannableStringBuilder;
    }
    
    private int getPreferredWidth() {
        return this.getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }
    
    @TargetApi(8)
    private boolean hasVoiceSearch() {
        final SearchableInfo mSearchable = this.mSearchable;
        boolean b = false;
        if (mSearchable != null) {
            final boolean voiceSearchEnabled = this.mSearchable.getVoiceSearchEnabled();
            b = false;
            if (voiceSearchEnabled) {
                Intent intent;
                if (this.mSearchable.getVoiceSearchLaunchWebSearch()) {
                    intent = mVoiceWebSearchIntent;
                }
                else {
                    final boolean voiceSearchLaunchRecognizer = this.mSearchable.getVoiceSearchLaunchRecognizer();
                    intent = null;
                    if (voiceSearchLaunchRecognizer) {
                        intent = mVoiceAppSearchIntent;
                    }
                }
                b = false;
                if (intent != null) {
                    final ResolveInfo resolveActivity = this.getContext().getPackageManager().resolveActivity(intent, 65536);
                    b = false;
                    if (resolveActivity != null) {
                        b = true;
                    }
                }
            }
        }
        return b;
    }
    
    static boolean isLandscapeMode(final Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
    
    private boolean isSubmitAreaEnabled() {
        return (mSubmitButtonEnabled || mVoiceButtonEnabled) && !this.isIconified();
    }
    
    private void launchIntent(final Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            this.getContext().startActivity(intent);
        }
        catch (RuntimeException ex) {
            Log.e("SearchView", "Failed launch activity: " + intent, (Throwable)ex);
        }
    }
    
    private void launchQuerySearch(final int n, final String s, final String s2) {
        this.getContext().startActivity(this.createIntent("android.intent.action.SEARCH", (Uri)null, (String)null, s2, n, s));
    }
    
    private boolean launchSuggestion(final int n, final int n2, final String s) {
        final Cursor cursor = mSuggestionsAdapter.getCursor();
        if (cursor != null && cursor.moveToPosition(n)) {
            this.launchIntent(this.createIntentFromSuggestion(cursor, n2, s));
            return true;
        }
        return false;
    }
    
    private void onCloseClicked() {
        if (TextUtils.isEmpty((CharSequence)mSearchSrcTextView.getText())) {
            if (mIconifiedByDefault && (mOnCloseListener == null || !mOnCloseListener.onClose())) {
                this.clearFocus();
                this.updateViewsVisibility(true);
            }
            return;
        }
        mSearchSrcTextView.setText((CharSequence)"");
        mSearchSrcTextView.requestFocus();
        this.setImeVisibility(true);
    }
    
    private boolean onItemClicked(final int n, final int n2, final String s) {
        if (mOnSuggestionListener != null) {
            final boolean onSuggestionClick = mOnSuggestionListener.onSuggestionClick(n);
            final boolean b = false;
            if (onSuggestionClick) {
                return b;
            }
        }
        this.launchSuggestion(n, 0, null);
        this.setImeVisibility(false);
        this.dismissSuggestions();
        return true;
    }
    
    private boolean onItemSelected(final int n) {
        if (mOnSuggestionListener == null || !mOnSuggestionListener.onSuggestionSelect(n)) {
            this.rewriteQueryFromSuggestion(n);
            return true;
        }
        return false;
    }
    
    private void onSearchClicked() {
        this.updateViewsVisibility(false);
        mSearchSrcTextView.requestFocus();
        this.setImeVisibility(true);
        if (mOnSearchClickListener != null) {
            mOnSearchClickListener.onClick((View)this);
        }
    }
    
    private void onSubmitQuery() {
        final Editable text = mSearchSrcTextView.getText();
        if (text != null && TextUtils.getTrimmedLength((CharSequence)text) > 0 && (mOnQueryChangeListener == null || !mOnQueryChangeListener.onQueryTextSubmit(((CharSequence)text).toString()))) {
            if (mSearchable != null) {
                this.launchQuerySearch(0, null, ((CharSequence)text).toString());
            }
            this.setImeVisibility(false);
            this.dismissSuggestions();
        }
    }
    
    private boolean onSuggestionsKey(final View view, final int n, final KeyEvent keyEvent) {
        if (mSearchable != null && mSuggestionsAdapter != null && keyEvent.getAction() == 0 && KeyEventCompat.hasNoModifiers(keyEvent)) {
            if (n == 66 || n == 84 || n == 61) {
                return this.onItemClicked(mSearchSrcTextView.getListSelection(), 0, null);
            }
            if (n == 21 || n == 22) {
                int length;
                if (n == 21) {
                    length = 0;
                }
                else {
                    length = mSearchSrcTextView.length();
                }
                mSearchSrcTextView.setSelection(length);
                mSearchSrcTextView.setListSelection(0);
                mSearchSrcTextView.clearListSelection();
                HIDDEN_METHOD_INVOKER.ensureImeVisible(mSearchSrcTextView, true);
                return true;
            }
            if (n == 19 && mSearchSrcTextView.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }
    
    private void onTextChanged(final CharSequence charSequence) {
        boolean b = true;
        final Editable text = mSearchSrcTextView.getText();
        mUserQuery = (CharSequence)text;
        final boolean b2 = !TextUtils.isEmpty((CharSequence)text) && b;
        this.updateSubmitButton(b2);
        if (b2) {
            b = false;
        }
        this.updateVoiceButton(b);
        this.updateCloseButton();
        this.updateSubmitArea();
        if (mOnQueryChangeListener != null && !TextUtils.equals(charSequence, mOldQueryText)) {
            mOnQueryChangeListener.onQueryTextChange(charSequence.toString());
        }
        mOldQueryText = charSequence.toString();
    }
    
    @TargetApi(8)
    private void onVoiceClicked() {
        if (mSearchable != null) {
            final SearchableInfo mSearchable = this.mSearchable;
            try {
                if (mSearchable.getVoiceSearchLaunchWebSearch()) {
                    this.getContext().startActivity(this.createVoiceWebSearchIntent(mVoiceWebSearchIntent, mSearchable));
                    return;
                }
            }
            catch (ActivityNotFoundException ex) {
                Log.w("SearchView", "Could not find voice search activity");
                return;
            }
            if (mSearchable.getVoiceSearchLaunchRecognizer()) {
                this.getContext().startActivity(this.createVoiceAppSearchIntent(mVoiceAppSearchIntent, mSearchable));
            }
        }
    }
    
    private void postUpdateFocusedState() {
        this.post(mUpdateDrawableStateRunnable);
    }
    
    private void rewriteQueryFromSuggestion(final int n) {
        final Editable text = mSearchSrcTextView.getText();
        final Cursor cursor = mSuggestionsAdapter.getCursor();
        if (cursor == null) {
            return;
        }
        if (!cursor.moveToPosition(n)) {
            this.setQuery((CharSequence)text);
            return;
        }
        final CharSequence convertToString = mSuggestionsAdapter.convertToString(cursor);
        if (convertToString != null) {
            this.setQuery(convertToString);
            return;
        }
        this.setQuery((CharSequence)text);
    }
    
    private void setImeVisibility(final boolean b) {
        if (b) {
            this.post(mShowImeRunnable);
        }
        else {
            this.removeCallbacks(mShowImeRunnable);
            final InputMethodManager inputMethodManager = (InputMethodManager)this.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.getWindowToken(), 0);
            }
        }
    }
    
    private void setQuery(final CharSequence text) {
        mSearchSrcTextView.setText(text);
        final SearchAutoComplete mSearchSrcTextView = this.mSearchSrcTextView;
        int length;
        if (TextUtils.isEmpty(text)) {
            length = 0;
        }
        else {
            length = text.length();
        }
        mSearchSrcTextView.setSelection(length);
    }
    
    private void updateCloseButton() {
        int n = 1;
        int n2;
        if (!TextUtils.isEmpty((CharSequence)mSearchSrcTextView.getText())) {
            n2 = n;
        }
        else {
            n2 = 0;
        }
        if (n2 == 0 && (!mIconifiedByDefault || mExpandedInActionView)) {
            n = 0;
        }
        final ImageView mCloseButton = this.mCloseButton;
        int visibility = 0;
        if (n == 0) {
            visibility = 8;
        }
        mCloseButton.setVisibility(visibility);
        final Drawable drawable = this.mCloseButton.getDrawable();
        if (drawable != null) {
            int[] state;
            if (n2 != 0) {
                state = SearchView.ENABLED_STATE_SET;
            }
            else {
                state = SearchView.EMPTY_STATE_SET;
            }
            drawable.setState(state);
        }
    }
    
    private void updateFocusedState() {
        int[] array;
        if (mSearchSrcTextView.hasFocus()) {
            array = SearchView.FOCUSED_STATE_SET;
        }
        else {
            array = SearchView.EMPTY_STATE_SET;
        }
        final Drawable background = mSearchPlate.getBackground();
        if (background != null) {
            background.setState(array);
        }
        final Drawable background2 = mSubmitArea.getBackground();
        if (background2 != null) {
            background2.setState(array);
        }
        this.invalidate();
    }
    
    private void updateQueryHint() {
        CharSequence queryHint = this.getQueryHint();
        final SearchAutoComplete mSearchSrcTextView = this.mSearchSrcTextView;
        if (queryHint == null) {
            queryHint = "";
        }
        mSearchSrcTextView.setHint(this.getDecoratedHint(queryHint));
    }
    
    @TargetApi(8)
    private void updateSearchAutoComplete() {
        int queryRefinement = 1;
        mSearchSrcTextView.setThreshold(mSearchable.getSuggestThreshold());
        mSearchSrcTextView.setImeOptions(mSearchable.getImeOptions());
        int inputType = mSearchable.getInputType();
        if ((inputType & 0xF) == queryRefinement) {
            inputType &= 0xFFFEFFFF;
            if (mSearchable.getSuggestAuthority() != null) {
                inputType = (0x80000 | (inputType | 0x10000));
            }
        }
        mSearchSrcTextView.setInputType(inputType);
        if (mSuggestionsAdapter != null) {
            mSuggestionsAdapter.changeCursor(null);
        }
        if (mSearchable.getSuggestAuthority() != null) {
            mSuggestionsAdapter = new SuggestionsAdapter(this.getContext(), this, mSearchable, mOutsideDrawablesCache);
            mSearchSrcTextView.setAdapter((ListAdapter)mSuggestionsAdapter);
            final SuggestionsAdapter suggestionsAdapter = (SuggestionsAdapter)mSuggestionsAdapter;
            if (mQueryRefinement) {
                queryRefinement = 2;
            }
            suggestionsAdapter.setQueryRefinement(queryRefinement);
        }
    }
    
    private void updateSubmitArea() {
        int visibility = 8;
        if (this.isSubmitAreaEnabled() && (mGoButton.getVisibility() == 0 || mVoiceButton.getVisibility() == 0)) {
            visibility = 0;
        }
        mSubmitArea.setVisibility(visibility);
    }
    
    private void updateSubmitButton(final boolean b) {
        int visibility = 8;
        if (mSubmitButtonEnabled && this.isSubmitAreaEnabled() && this.hasFocus() && (b || !mVoiceButtonEnabled)) {
            visibility = 0;
        }
        mGoButton.setVisibility(visibility);
    }
    
    private void updateViewsVisibility(final boolean mIconified) {
        int visibility = 8;
        boolean b = true;
        this.mIconified = mIconified;
        int visibility2;
        if (mIconified) {
            visibility2 = 0;
        }
        else {
            visibility2 = visibility;
        }
        final boolean b2 = !TextUtils.isEmpty((CharSequence)mSearchSrcTextView.getText()) && b;
        mSearchButton.setVisibility(visibility2);
        this.updateSubmitButton(b2);
        final View mSearchEditFrame = this.mSearchEditFrame;
        if (!mIconified) {
            visibility = 0;
        }
        mSearchEditFrame.setVisibility(visibility);
        int visibility3;
        if (mCollapsedIcon.getDrawable() == null || mIconifiedByDefault) {
            visibility3 = 8;
        }
        else {
            visibility3 = 0;
        }
        mCollapsedIcon.setVisibility(visibility3);
        this.updateCloseButton();
        if (b2) {
            b = false;
        }
        this.updateVoiceButton(b);
        this.updateSubmitArea();
    }
    
    private void updateVoiceButton(final boolean b) {
        int visibility = 8;
        if (mVoiceButtonEnabled && !this.isIconified() && b) {
            visibility = 0;
            mGoButton.setVisibility(8);
        }
        mVoiceButton.setVisibility(visibility);
    }
    
    public void clearFocus() {
        mClearingFocus = true;
        this.setImeVisibility(false);
        super.clearFocus();
        mSearchSrcTextView.clearFocus();
        mClearingFocus = false;
    }
    
    public int getImeOptions() {
        return mSearchSrcTextView.getImeOptions();
    }
    
    public int getInputType() {
        return mSearchSrcTextView.getInputType();
    }
    
    public int getMaxWidth() {
        return mMaxWidth;
    }
    
    public CharSequence getQuery() {
        return (CharSequence)mSearchSrcTextView.getText();
    }
    
    public CharSequence getQueryHint() {
        if (mQueryHint != null) {
            return mQueryHint;
        }
        if (IS_AT_LEAST_FROYO && mSearchable != null && mSearchable.getHintId() != 0) {
            return this.getContext().getText(mSearchable.getHintId());
        }
        return mDefaultQueryHint;
    }
    
    int getSuggestionCommitIconResId() {
        return mSuggestionCommitIconResId;
    }
    
    int getSuggestionRowLayout() {
        return mSuggestionRowLayout;
    }
    
    public CursorAdapter getSuggestionsAdapter() {
        return mSuggestionsAdapter;
    }
    
    public boolean isIconfiedByDefault() {
        return mIconifiedByDefault;
    }
    
    public boolean isIconified() {
        return mIconified;
    }
    
    public boolean isQueryRefinementEnabled() {
        return mQueryRefinement;
    }
    
    public boolean isSubmitButtonEnabled() {
        return mSubmitButtonEnabled;
    }
    
    @Override
    public void onActionViewCollapsed() {
        this.setQuery("", false);
        this.clearFocus();
        this.updateViewsVisibility(true);
        mSearchSrcTextView.setImeOptions(mCollapsedImeOptions);
        mExpandedInActionView = false;
    }
    
    @Override
    public void onActionViewExpanded() {
        if (mExpandedInActionView) {
            return;
        }
        mExpandedInActionView = true;
        mCollapsedImeOptions = mSearchSrcTextView.getImeOptions();
        mSearchSrcTextView.setImeOptions(0x2000000 | mCollapsedImeOptions);
        mSearchSrcTextView.setText((CharSequence)"");
        this.setIconified(false);
    }
    
    protected void onDetachedFromWindow() {
        this.removeCallbacks(mUpdateDrawableStateRunnable);
        this.post(mReleaseCursorRunnable);
        super.onDetachedFromWindow();
    }
    
    @Override
    protected void onMeasure(final int n, final int n2) {
        if (this.isIconified()) {
            super.onMeasure(n, n2);
            return;
        }
        final int mode = View$MeasureSpec.getMode(n);
        int n3 = View$MeasureSpec.getSize(n);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (mMaxWidth > 0) {
                    n3 = Math.min(mMaxWidth, n3);
                    break;
                }
                n3 = Math.min(this.getPreferredWidth(), n3);
                break;
            case 1073741824:
                if (mMaxWidth > 0) {
                    n3 = Math.min(mMaxWidth, n3);
                    break;
                }
                break;
            case 0:
                if (mMaxWidth > 0) {
                    n3 = mMaxWidth;
                }
                else {
                    n3 = this.getPreferredWidth();
                }
                break;
        }
        super.onMeasure(View$MeasureSpec.makeMeasureSpec(n3, 1073741824), n2);
    }
    
    void onQueryRefine(final CharSequence query) {
        this.setQuery(query);
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        final SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.updateViewsVisibility(savedState.isIconified);
        this.requestLayout();
    }
    
    protected Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.isIconified = this.isIconified();
        return (Parcelable)savedState;
    }
    
    void onTextFocusChanged() {
        this.updateViewsVisibility(this.isIconified());
        this.postUpdateFocusedState();
        if (mSearchSrcTextView.hasFocus()) {
            this.forceSuggestionQuery();
        }
    }
    
    public void onWindowFocusChanged(final boolean b) {
        super.onWindowFocusChanged(b);
        this.postUpdateFocusedState();
    }
    
    public boolean requestFocus(final int n, final Rect rect) {
        boolean requestFocus;
        if (mClearingFocus) {
            requestFocus = false;
        }
        else {
            if (!this.isFocusable()) {
                return false;
            }
            if (this.isIconified()) {
                return super.requestFocus(n, rect);
            }
            requestFocus = mSearchSrcTextView.requestFocus(n, rect);
            if (requestFocus) {
                this.updateViewsVisibility(false);
                return requestFocus;
            }
        }
        return requestFocus;
    }
    
    public void setAppSearchData(final Bundle mAppSearchData) {
        this.mAppSearchData = mAppSearchData;
    }
    
    public void setIconified(final boolean b) {
        if (b) {
            this.onCloseClicked();
            return;
        }
        this.onSearchClicked();
    }
    
    public void setIconifiedByDefault(final boolean mIconifiedByDefault) {
        if (this.mIconifiedByDefault == mIconifiedByDefault) {
            return;
        }
        this.updateViewsVisibility(this.mIconifiedByDefault = mIconifiedByDefault);
        this.updateQueryHint();
    }
    
    public void setImeOptions(final int imeOptions) {
        mSearchSrcTextView.setImeOptions(imeOptions);
    }
    
    public void setInputType(final int inputType) {
        mSearchSrcTextView.setInputType(inputType);
    }
    
    public void setMaxWidth(final int mMaxWidth) {
        this.mMaxWidth = mMaxWidth;
        this.requestLayout();
    }
    
    public void setOnCloseListener(final OnCloseListener mOnCloseListener) {
        this.mOnCloseListener = mOnCloseListener;
    }
    
    public void setOnQueryTextFocusChangeListener(final View$OnFocusChangeListener mOnQueryTextFocusChangeListener) {
        this.mOnQueryTextFocusChangeListener = mOnQueryTextFocusChangeListener;
    }
    
    public void setOnQueryTextListener(final OnQueryTextListener mOnQueryChangeListener) {
        this.mOnQueryChangeListener = mOnQueryChangeListener;
    }
    
    public void setOnSearchClickListener(final View$OnClickListener mOnSearchClickListener) {
        this.mOnSearchClickListener = mOnSearchClickListener;
    }
    
    public void setOnSuggestionListener(final OnSuggestionListener mOnSuggestionListener) {
        this.mOnSuggestionListener = mOnSuggestionListener;
    }
    
    public void setQuery(final CharSequence charSequence, final boolean b) {
        mSearchSrcTextView.setText(charSequence);
        if (charSequence != null) {
            mSearchSrcTextView.setSelection(mSearchSrcTextView.length());
            mUserQuery = charSequence;
        }
        if (b && !TextUtils.isEmpty(charSequence)) {
            this.onSubmitQuery();
        }
    }
    
    public void setQueryHint(final CharSequence mQueryHint) {
        this.mQueryHint = mQueryHint;
        this.updateQueryHint();
    }
    
    public void setQueryRefinementEnabled(final boolean mQueryRefinement) {
        this.mQueryRefinement = mQueryRefinement;
        if (mSuggestionsAdapter instanceof SuggestionsAdapter) {
            final SuggestionsAdapter suggestionsAdapter = (SuggestionsAdapter)mSuggestionsAdapter;
            int queryRefinement;
            if (mQueryRefinement) {
                queryRefinement = 2;
            }
            else {
                queryRefinement = 1;
            }
            suggestionsAdapter.setQueryRefinement(queryRefinement);
        }
    }
    
    public void setSearchableInfo(final SearchableInfo mSearchable) {
        this.mSearchable = mSearchable;
        if (this.mSearchable != null) {
            if (IS_AT_LEAST_FROYO) {
                this.updateSearchAutoComplete();
            }
            this.updateQueryHint();
        }
        mVoiceButtonEnabled = (IS_AT_LEAST_FROYO && this.hasVoiceSearch());
        if (mVoiceButtonEnabled) {
            mSearchSrcTextView.setPrivateImeOptions("nm");
        }
        this.updateViewsVisibility(this.isIconified());
    }
    
    public void setSubmitButtonEnabled(final boolean mSubmitButtonEnabled) {
        this.mSubmitButtonEnabled = mSubmitButtonEnabled;
        this.updateViewsVisibility(this.isIconified());
    }
    
    public void setSuggestionsAdapter(final CursorAdapter mSuggestionsAdapter) {
        this.mSuggestionsAdapter = mSuggestionsAdapter;
        mSearchSrcTextView.setAdapter((ListAdapter)this.mSuggestionsAdapter);
    }
}
