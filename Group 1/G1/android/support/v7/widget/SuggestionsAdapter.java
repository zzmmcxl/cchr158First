package android.support.v7.widget;

import android.view.ViewGroup;
import android.net.Uri$Builder;
import java.util.List;
import android.content.res.Resources;
import java.io.FileNotFoundException;
import android.view.View;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.res.Resources$NotFoundException;
import android.support.v4.content.ContextCompat;
import android.net.Uri;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import android.content.ComponentName;
import android.text.style.TextAppearanceSpan;
import android.text.SpannableString;
import android.support.v7.appcompat.R;
import android.util.TypedValue;
import android.graphics.drawable.Drawable;
import android.database.Cursor;
import android.content.res.ColorStateList;
import android.app.SearchableInfo;
import android.app.SearchManager;
import android.content.Context;
import android.graphics.drawable.Drawable$ConstantState;
import java.util.WeakHashMap;
import android.view.View$OnClickListener;
import android.support.v4.widget.ResourceCursorAdapter;

class SuggestionsAdapter extends ResourceCursorAdapter implements View$OnClickListener
{
    private static final boolean DBG = false;
    static final int INVALID_INDEX = -1;
    private static final String LOG_TAG = "SuggestionsAdapter";
    private static final int QUERY_LIMIT = 50;
    static final int REFINE_ALL = 2;
    static final int REFINE_BY_ENTRY = 1;
    static final int REFINE_NONE;
    private boolean mClosed;
    private final int mCommitIconResId;
    private int mFlagsCol;
    private int mIconName1Col;
    private int mIconName2Col;
    private final WeakHashMap<String, Drawable$ConstantState> mOutsideDrawablesCache;
    private final Context mProviderContext;
    private int mQueryRefinement;
    private final SearchManager mSearchManager;
    private final SearchView mSearchView;
    private final SearchableInfo mSearchable;
    private int mText1Col;
    private int mText2Col;
    private int mText2UrlCol;
    private ColorStateList mUrlColor;
    
    public SuggestionsAdapter(final Context mProviderContext, final SearchView mSearchView, final SearchableInfo mSearchable, final WeakHashMap<String, Drawable$ConstantState> mOutsideDrawablesCache) {
        super(mProviderContext, mSearchView.getSuggestionRowLayout(), null, true);
        mClosed = false;
        mQueryRefinement = 1;
        mText1Col = -1;
        mText2Col = -1;
        mText2UrlCol = -1;
        mIconName1Col = -1;
        mIconName2Col = -1;
        mFlagsCol = -1;
        mSearchManager = (SearchManager)this.mContext.getSystemService("search");
        mSearchView = mSearchView;
        mSearchable = mSearchable;
        mCommitIconResId = mSearchView.getSuggestionCommitIconResId();
        mProviderContext = mProviderContext;
        mOutsideDrawablesCache = mOutsideDrawablesCache;
    }
    
    private Drawable checkIconCache(final String s) {
        final Drawable$ConstantState drawable$ConstantState = (Drawable$ConstantState)mOutsideDrawablesCache.get(s);
        if (drawable$ConstantState == null) {
            return null;
        }
        return drawable$ConstantState.newDrawable();
    }
    
    private CharSequence formatUrl(final CharSequence charSequence) {
        if (mUrlColor == null) {
            final TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R.attr.textColorSearchUrl, typedValue, true);
            mUrlColor = this.mContext.getResources().getColorStateList(typedValue.resourceId);
        }
        final SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan((Object)new TextAppearanceSpan((String)null, 0, 0, mUrlColor, (ColorStateList)null), 0, charSequence.length(), 33);
        return (CharSequence)spannableString;
    }
    
    private Drawable getActivityIcon(final ComponentName componentName) {
        int iconResource;
        while (true) {
            final PackageManager packageManager = this.mContext.getPackageManager();
            ActivityInfo activityInfo;
            try {
                activityInfo = packageManager.getActivityInfo(componentName, 128);
                iconResource = activityInfo.getIconResource();
                if (iconResource == 0) {
                    return null;
                }
            }
            catch (PackageManager$NameNotFoundException ex) {
                Log.w("SuggestionsAdapter", ex.toString());
                return null;
            }
            final Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable == null) {
                break;
            }
            return drawable;
        }
        Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
        return null;
    }
    
    private Drawable getActivityIconWithCache(final ComponentName componentName) {
        final String flattenToShortString = componentName.flattenToShortString();
        if (!mOutsideDrawablesCache.containsKey(flattenToShortString)) {
            final Drawable activityIcon = this.getActivityIcon(componentName);
            Drawable$ConstantState constantState;
            if (activityIcon == null) {
                constantState = null;
            }
            else {
                constantState = activityIcon.getConstantState();
            }
            mOutsideDrawablesCache.put(flattenToShortString, constantState);
            return activityIcon;
        }
        final Drawable$ConstantState drawable$ConstantState = (Drawable$ConstantState)mOutsideDrawablesCache.get(flattenToShortString);
        if (drawable$ConstantState == null) {
            return null;
        }
        return drawable$ConstantState.newDrawable(mProviderContext.getResources());
    }
    
    public static String getColumnString(final Cursor cursor, final String s) {
        return getStringOrNull(cursor, cursor.getColumnIndex(s));
    }
    
    private Drawable getDefaultIcon1(final Cursor cursor) {
        final Drawable activityIconWithCache = this.getActivityIconWithCache(mSearchable.getSearchActivity());
        if (activityIconWithCache != null) {
            return activityIconWithCache;
        }
        return this.mContext.getPackageManager().getDefaultActivityIcon();
    }
    
    private Drawable getDrawable(final Uri p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: ldc_w           "android.resource"
        //     3: aload_1        
        //     4: invokevirtual   android/net/Uri.getScheme:()Ljava/lang/String;
        //     7: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    10: istore          4
        //    12: iload           4
        //    14: ifeq            99
        //    17: aload_0        
        //    18: aload_1        
        //    19: invokevirtual   android/support/v7/widget/SuggestionsAdapter.getDrawableFromResourceUri:(Landroid/net/Uri;)Landroid/graphics/drawable/Drawable;
        //    22: astore          13
        //    24: aload           13
        //    26: areturn        
        //    27: astore          12
        //    29: new             Ljava/io/FileNotFoundException;
        //    32: dup            
        //    33: new             Ljava/lang/StringBuilder;
        //    36: dup            
        //    37: invokespecial   java/lang/StringBuilder.<init>:()V
        //    40: ldc_w           "Resource does not exist: "
        //    43: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    46: aload_1        
        //    47: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    50: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    53: invokespecial   java/io/FileNotFoundException.<init>:(Ljava/lang/String;)V
        //    56: athrow         
        //    57: astore_2       
        //    58: ldc             "SuggestionsAdapter"
        //    60: new             Ljava/lang/StringBuilder;
        //    63: dup            
        //    64: invokespecial   java/lang/StringBuilder.<init>:()V
        //    67: ldc_w           "Icon not found: "
        //    70: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    73: aload_1        
        //    74: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    77: ldc_w           ", "
        //    80: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    83: aload_2        
        //    84: invokevirtual   java/io/FileNotFoundException.getMessage:()Ljava/lang/String;
        //    87: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    90: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    93: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //    96: pop            
        //    97: aconst_null    
        //    98: areturn        
        //    99: aload_0        
        //   100: getfield        android/support/v7/widget/SuggestionsAdapter.mProviderContext:Landroid/content/Context;
        //   103: invokevirtual   android/content/Context.getContentResolver:()Landroid/content/ContentResolver;
        //   106: aload_1        
        //   107: invokevirtual   android/content/ContentResolver.openInputStream:(Landroid/net/Uri;)Ljava/io/InputStream;
        //   110: astore          5
        //   112: aload           5
        //   114: ifnonnull       145
        //   117: new             Ljava/io/FileNotFoundException;
        //   120: dup            
        //   121: new             Ljava/lang/StringBuilder;
        //   124: dup            
        //   125: invokespecial   java/lang/StringBuilder.<init>:()V
        //   128: ldc_w           "Failed to open "
        //   131: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   134: aload_1        
        //   135: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   138: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   141: invokespecial   java/io/FileNotFoundException.<init>:(Ljava/lang/String;)V
        //   144: athrow         
        //   145: aload           5
        //   147: aconst_null    
        //   148: invokestatic    android/graphics/drawable/Drawable.createFromStream:(Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
        //   151: astore          9
        //   153: aload           5
        //   155: invokevirtual   java/io/InputStream.close:()V
        //   158: aload           9
        //   160: areturn        
        //   161: astore          10
        //   163: ldc             "SuggestionsAdapter"
        //   165: new             Ljava/lang/StringBuilder;
        //   168: dup            
        //   169: invokespecial   java/lang/StringBuilder.<init>:()V
        //   172: ldc_w           "Error closing icon stream for "
        //   175: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   178: aload_1        
        //   179: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   182: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   185: aload           10
        //   187: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   190: pop            
        //   191: aload           9
        //   193: areturn        
        //   194: astore          6
        //   196: aload           5
        //   198: invokevirtual   java/io/InputStream.close:()V
        //   201: aload           6
        //   203: athrow         
        //   204: astore          7
        //   206: ldc             "SuggestionsAdapter"
        //   208: new             Ljava/lang/StringBuilder;
        //   211: dup            
        //   212: invokespecial   java/lang/StringBuilder.<init>:()V
        //   215: ldc_w           "Error closing icon stream for "
        //   218: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   221: aload_1        
        //   222: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   225: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   228: aload           7
        //   230: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   233: pop            
        //   234: goto            201
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                             
        //  -----  -----  -----  -----  -------------------------------------------------
        //  0      12     57     99     Ljava/io/FileNotFoundException;
        //  17     24     27     57     Landroid/content/res/Resources$NotFoundException;
        //  17     24     57     99     Ljava/io/FileNotFoundException;
        //  29     57     57     99     Ljava/io/FileNotFoundException;
        //  99     112    57     99     Ljava/io/FileNotFoundException;
        //  117    145    57     99     Ljava/io/FileNotFoundException;
        //  145    153    194    237    Any
        //  153    158    161    194    Ljava/io/IOException;
        //  153    158    57     99     Ljava/io/FileNotFoundException;
        //  163    191    57     99     Ljava/io/FileNotFoundException;
        //  196    201    204    237    Ljava/io/IOException;
        //  196    201    57     99     Ljava/io/FileNotFoundException;
        //  201    204    57     99     Ljava/io/FileNotFoundException;
        //  206    234    57     99     Ljava/io/FileNotFoundException;
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private Drawable getDrawableFromResourceValue(final String s) {
        Drawable drawable;
        if (s == null || s.length() == 0 || "0".equals(s)) {
            drawable = null;
        }
        else {
            try {
                final int int1 = Integer.parseInt(s);
                final String string = "android.resource://" + mProviderContext.getPackageName() + "/" + int1;
                drawable = this.checkIconCache(string);
                if (drawable == null) {
                    final Drawable drawable2 = ContextCompat.getDrawable(mProviderContext, int1);
                    this.storeInIconCache(string, drawable2);
                    return drawable2;
                }
            }
            catch (NumberFormatException ex) {
                drawable = this.checkIconCache(s);
                if (drawable == null) {
                    final Drawable drawable3 = this.getDrawable(Uri.parse(s));
                    this.storeInIconCache(s, drawable3);
                    return drawable3;
                }
            }
            catch (Resources$NotFoundException ex2) {
                Log.w("SuggestionsAdapter", "Icon resource not found: " + s);
                return null;
            }
        }
        return drawable;
    }
    
    private Drawable getIcon1(final Cursor cursor) {
        Drawable drawableFromResourceValue;
        if (mIconName1Col == -1) {
            drawableFromResourceValue = null;
        }
        else {
            drawableFromResourceValue = this.getDrawableFromResourceValue(cursor.getString(mIconName1Col));
            if (drawableFromResourceValue == null) {
                return this.getDefaultIcon1(cursor);
            }
        }
        return drawableFromResourceValue;
    }
    
    private Drawable getIcon2(final Cursor cursor) {
        if (mIconName2Col == -1) {
            return null;
        }
        return this.getDrawableFromResourceValue(cursor.getString(mIconName2Col));
    }
    
    private static String getStringOrNull(final Cursor cursor, final int n) {
        if (n == -1) {
            return null;
        }
        try {
            return cursor.getString(n);
        }
        catch (Exception ex) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", (Throwable)ex);
            return null;
        }
    }
    
    private void setViewDrawable(final ImageView imageView, final Drawable imageDrawable, final int visibility) {
        imageView.setImageDrawable(imageDrawable);
        if (imageDrawable == null) {
            imageView.setVisibility(visibility);
            return;
        }
        imageView.setVisibility(0);
        imageDrawable.setVisible(false, false);
        imageDrawable.setVisible(true, false);
    }
    
    private void setViewText(final TextView textView, final CharSequence text) {
        textView.setText(text);
        if (TextUtils.isEmpty(text)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
    }
    
    private void storeInIconCache(final String s, final Drawable drawable) {
        if (drawable != null) {
            mOutsideDrawablesCache.put(s, drawable.getConstantState());
        }
    }
    
    private void updateSpinnerState(final Cursor cursor) {
        Bundle extras;
        if (cursor != null) {
            extras = cursor.getExtras();
        }
        else {
            extras = null;
        }
        if (extras == null || extras.getBoolean("in_progress")) {}
    }
    
    public void bindView(final View view, final Context context, final Cursor cursor) {
        final ChildViewCache childViewCache = (ChildViewCache)view.getTag();
        final int mFlagsCol = this.mFlagsCol;
        int int1 = 0;
        if (mFlagsCol != -1) {
            int1 = cursor.getInt(this.mFlagsCol);
        }
        if (childViewCache.mText1 != null) {
            this.setViewText(childViewCache.mText1, getStringOrNull(cursor, mText1Col));
        }
        if (childViewCache.mText2 != null) {
            final String stringOrNull = getStringOrNull(cursor, mText2UrlCol);
            CharSequence charSequence;
            if (stringOrNull != null) {
                charSequence = this.formatUrl(stringOrNull);
            }
            else {
                charSequence = getStringOrNull(cursor, mText2Col);
            }
            if (TextUtils.isEmpty(charSequence)) {
                if (childViewCache.mText1 != null) {
                    childViewCache.mText1.setSingleLine(false);
                    childViewCache.mText1.setMaxLines(2);
                }
            }
            else if (childViewCache.mText1 != null) {
                childViewCache.mText1.setSingleLine(true);
                childViewCache.mText1.setMaxLines(1);
            }
            this.setViewText(childViewCache.mText2, charSequence);
        }
        if (childViewCache.mIcon1 != null) {
            this.setViewDrawable(childViewCache.mIcon1, this.getIcon1(cursor), 4);
        }
        if (childViewCache.mIcon2 != null) {
            this.setViewDrawable(childViewCache.mIcon2, this.getIcon2(cursor), 8);
        }
        if (mQueryRefinement == 2 || (mQueryRefinement == 1 && (int1 & 0x1) != 0x0)) {
            childViewCache.mIconRefine.setVisibility(0);
            childViewCache.mIconRefine.setTag((Object)childViewCache.mText1.getText());
            childViewCache.mIconRefine.setOnClickListener((View$OnClickListener)this);
            return;
        }
        childViewCache.mIconRefine.setVisibility(8);
    }
    
    public void changeCursor(final Cursor cursor) {
        if (mClosed) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
            }
        }
        else {
            try {
                super.changeCursor(cursor);
                if (cursor != null) {
                    mText1Col = cursor.getColumnIndex("suggest_text_1");
                    mText2Col = cursor.getColumnIndex("suggest_text_2");
                    mText2UrlCol = cursor.getColumnIndex("suggest_text_2_url");
                    mIconName1Col = cursor.getColumnIndex("suggest_icon_1");
                    mIconName2Col = cursor.getColumnIndex("suggest_icon_2");
                    mFlagsCol = cursor.getColumnIndex("suggest_flags");
                }
            }
            catch (Exception ex) {
                Log.e("SuggestionsAdapter", "error changing cursor and caching columns", (Throwable)ex);
            }
        }
    }
    
    public void close() {
        this.changeCursor(null);
        mClosed = true;
    }
    
    public CharSequence convertToString(final Cursor cursor) {
        CharSequence columnString;
        if (cursor == null) {
            columnString = null;
        }
        else {
            columnString = getColumnString(cursor, "suggest_intent_query");
            if (columnString == null) {
                if (mSearchable.shouldRewriteQueryFromData()) {
                    final String columnString2 = getColumnString(cursor, "suggest_intent_data");
                    if (columnString2 != null) {
                        return columnString2;
                    }
                }
                if (mSearchable.shouldRewriteQueryFromText()) {
                    final String columnString3 = getColumnString(cursor, "suggest_text_1");
                    if (columnString3 != null) {
                        return columnString3;
                    }
                }
                return null;
            }
        }
        return columnString;
    }
    
    Drawable getDrawableFromResourceUri(final Uri uri) throws FileNotFoundException {
        final String authority = uri.getAuthority();
        if (TextUtils.isEmpty((CharSequence)authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        Resources resourcesForApplication;
        List pathSegments;
        try {
            resourcesForApplication = this.mContext.getPackageManager().getResourcesForApplication(authority);
            pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
        }
        catch (PackageManager$NameNotFoundException ex) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
        final int size = pathSegments.size();
        while (true) {
            Label_0219: {
                if (size != 1) {
                    break Label_0219;
                }
                try {
                    final int n = Integer.parseInt(pathSegments.get(0));
                    if (n == 0) {
                        throw new FileNotFoundException("No resource found for: " + uri);
                    }
                    return resourcesForApplication.getDrawable(n);
                }
                catch (NumberFormatException ex2) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            }
            if (size == 2) {
                final int n = resourcesForApplication.getIdentifier((String)pathSegments.get(1), (String)pathSegments.get(0), authority);
                continue;
            }
            break;
        }
        throw new FileNotFoundException("More than two path segments: " + uri);
    }
    
    public int getQueryRefinement() {
        return mQueryRefinement;
    }
    
    Cursor getSearchManagerSuggestions(final SearchableInfo searchableInfo, final String s, final int n) {
        if (searchableInfo != null) {
            final String suggestAuthority = searchableInfo.getSuggestAuthority();
            if (suggestAuthority != null) {
                final Uri$Builder fragment = new Uri$Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
                final String suggestPath = searchableInfo.getSuggestPath();
                if (suggestPath != null) {
                    fragment.appendEncodedPath(suggestPath);
                }
                fragment.appendPath("search_suggest_query");
                final String suggestSelection = searchableInfo.getSuggestSelection();
                String[] array;
                if (suggestSelection != null) {
                    array = new String[] { s };
                }
                else {
                    fragment.appendPath(s);
                    array = null;
                }
                if (n > 0) {
                    fragment.appendQueryParameter("limit", String.valueOf(n));
                }
                return this.mContext.getContentResolver().query(fragment.build(), (String[])null, suggestSelection, array, (String)null);
            }
        }
        return null;
    }
    
    public View getView(final int n, final View view, final ViewGroup viewGroup) {
        try {
            return super.getView(n, view, viewGroup);
        }
        catch (RuntimeException ex) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", (Throwable)ex);
            final View view2 = this.newView(this.mContext, this.mCursor, viewGroup);
            if (view2 != null) {
                ((ChildViewCache)view2.getTag()).mText1.setText((CharSequence)ex.toString());
                return view2;
            }
            return view2;
        }
    }
    
    public boolean hasStableIds() {
        return false;
    }
    
    @Override
    public View newView(final Context context, final Cursor cursor, final ViewGroup viewGroup) {
        final View view = super.newView(context, cursor, viewGroup);
        view.setTag((Object)new ChildViewCache(view));
        ((ImageView)view.findViewById(R.id.edit_query)).setImageResource(mCommitIconResId);
        return view;
    }
    
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.updateSpinnerState(this.getCursor());
    }
    
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        this.updateSpinnerState(this.getCursor());
    }
    
    public void onClick(final View view) {
        final Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            mSearchView.onQueryRefine((CharSequence)tag);
        }
    }
    
    public Cursor runQueryOnBackgroundThread(final CharSequence charSequence) {
        String string;
        if (charSequence == null) {
            string = "";
        }
        else {
            string = charSequence.toString();
        }
        if (mSearchView.getVisibility() == 0 && mSearchView.getWindowVisibility() == 0) {
            try {
                final Cursor searchManagerSuggestions = this.getSearchManagerSuggestions(mSearchable, string, 50);
                if (searchManagerSuggestions != null) {
                    searchManagerSuggestions.getCount();
                    return searchManagerSuggestions;
                }
            }
            catch (RuntimeException ex) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", (Throwable)ex);
                return null;
            }
        }
        return null;
    }
    
    public void setQueryRefinement(final int mQueryRefinement) {
        this.mQueryRefinement = mQueryRefinement;
    }
}
