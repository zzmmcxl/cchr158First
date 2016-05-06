package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.graphics.Rect;
import java.util.Iterator;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import android.view.View;
import android.os.Build$VERSION;

public class AccessibilityNodeInfoCompat
{
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 524288;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_DISMISS = 1048576;
    public static final int ACTION_EXPAND = 262144;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int ACTION_SET_TEXT = 2097152;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    private static final AccessibilityNodeInfoImpl IMPL;
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    private final Object mInfo;
    
    static {
        if (Build$VERSION.SDK_INT >= 22) {
            IMPL = (AccessibilityNodeInfoImpl)new AccessibilityNodeInfoApi22Impl();
            return;
        }
        if (Build$VERSION.SDK_INT >= 21) {
            IMPL = (AccessibilityNodeInfoImpl)new AccessibilityNodeInfoApi21Impl();
            return;
        }
        if (Build$VERSION.SDK_INT >= 19) {
            IMPL = (AccessibilityNodeInfoImpl)new AccessibilityNodeInfoKitKatImpl();
            return;
        }
        if (Build$VERSION.SDK_INT >= 18) {
            IMPL = (AccessibilityNodeInfoImpl)new AccessibilityNodeInfoJellybeanMr2Impl();
            return;
        }
        if (Build$VERSION.SDK_INT >= 17) {
            IMPL = (AccessibilityNodeInfoImpl)new AccessibilityNodeInfoJellybeanMr1Impl();
            return;
        }
        if (Build$VERSION.SDK_INT >= 16) {
            IMPL = (AccessibilityNodeInfoImpl)new AccessibilityNodeInfoJellybeanImpl();
            return;
        }
        if (Build$VERSION.SDK_INT >= 14) {
            IMPL = (AccessibilityNodeInfoImpl)new AccessibilityNodeInfoIcsImpl();
            return;
        }
        IMPL = (AccessibilityNodeInfoImpl)new AccessibilityNodeInfoStubImpl();
    }
    
    public AccessibilityNodeInfoCompat(final Object mInfo) {
        super();
        mInfo = mInfo;
    }
    
    static /* synthetic */ AccessibilityNodeInfoImpl access$000() {
        return IMPL;
    }
    
    private static String getActionSymbolicName(final int n) {
        switch (n) {
            default:
                return "ACTION_UNKNOWN";
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 65536:
                return "ACTION_CUT";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 131072:
                return "ACTION_SET_SELECTION";
        }
    }
    
    public static AccessibilityNodeInfoCompat obtain() {
        return wrapNonNullInstance(IMPL.obtain());
    }
    
    public static AccessibilityNodeInfoCompat obtain(final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return wrapNonNullInstance(IMPL.obtain(accessibilityNodeInfoCompat.mInfo));
    }
    
    public static AccessibilityNodeInfoCompat obtain(final View view) {
        return wrapNonNullInstance(IMPL.obtain(view));
    }
    
    public static AccessibilityNodeInfoCompat obtain(final View view, final int n) {
        return wrapNonNullInstance(IMPL.obtain(view, n));
    }
    
    static AccessibilityNodeInfoCompat wrapNonNullInstance(final Object o) {
        if (o != null) {
            return new AccessibilityNodeInfoCompat(o);
        }
        return null;
    }
    
    public void addAction(final int n) {
        IMPL.addAction(mInfo, n);
    }
    
    public void addAction(final AccessibilityActionCompat accessibilityActionCompat) {
        IMPL.addAction(mInfo, accessibilityActionCompat.mAction);
    }
    
    public void addChild(final View view) {
        IMPL.addChild(mInfo, view);
    }
    
    public void addChild(final View view, final int n) {
        IMPL.addChild(mInfo, view, n);
    }
    
    public boolean canOpenPopup() {
        return IMPL.canOpenPopup(mInfo);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o == null) {
                return false;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }
            final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat)o;
            if (mInfo == null) {
                if (mInfo != null) {
                    return false;
                }
            }
            else if (!mInfo.equals(mInfo)) {
                return false;
            }
        }
        return true;
    }
    
    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(final String s) {
        final ArrayList<AccessibilityNodeInfoCompat> list = new ArrayList<AccessibilityNodeInfoCompat>();
        final List<Object> accessibilityNodeInfosByText = IMPL.findAccessibilityNodeInfosByText(mInfo, s);
        for (int size = accessibilityNodeInfosByText.size(), i = 0; i < size; ++i) {
            list.add(new AccessibilityNodeInfoCompat(accessibilityNodeInfosByText.get(i)));
        }
        return list;
    }
    
    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(final String s) {
        final List<Object> accessibilityNodeInfosByViewId = IMPL.findAccessibilityNodeInfosByViewId(mInfo, s);
        List<AccessibilityNodeInfoCompat> emptyList;
        if (accessibilityNodeInfosByViewId != null) {
            emptyList = new ArrayList<AccessibilityNodeInfoCompat>();
            final Iterator<Object> iterator = accessibilityNodeInfosByViewId.iterator();
            while (iterator.hasNext()) {
                emptyList.add(new AccessibilityNodeInfoCompat(iterator.next()));
            }
        }
        else {
            emptyList = Collections.<AccessibilityNodeInfoCompat>emptyList();
        }
        return emptyList;
    }
    
    public AccessibilityNodeInfoCompat findFocus(final int n) {
        return wrapNonNullInstance(IMPL.findFocus(mInfo, n));
    }
    
    public AccessibilityNodeInfoCompat focusSearch(final int n) {
        return wrapNonNullInstance(IMPL.focusSearch(mInfo, n));
    }
    
    public List<AccessibilityActionCompat> getActionList() {
        final List<Object> actionList = IMPL.getActionList(mInfo);
        List<AccessibilityActionCompat> emptyList;
        if (actionList != null) {
            emptyList = new ArrayList<AccessibilityActionCompat>();
            for (int size = actionList.size(), i = 0; i < size; ++i) {
                emptyList.add(new AccessibilityActionCompat(actionList.get(i)));
            }
        }
        else {
            emptyList = Collections.<AccessibilityActionCompat>emptyList();
        }
        return emptyList;
    }
    
    public int getActions() {
        return IMPL.getActions(mInfo);
    }
    
    public void getBoundsInParent(final Rect rect) {
        IMPL.getBoundsInParent(mInfo, rect);
    }
    
    public void getBoundsInScreen(final Rect rect) {
        IMPL.getBoundsInScreen(mInfo, rect);
    }
    
    public AccessibilityNodeInfoCompat getChild(final int n) {
        return wrapNonNullInstance(IMPL.getChild(mInfo, n));
    }
    
    public int getChildCount() {
        return IMPL.getChildCount(mInfo);
    }
    
    public CharSequence getClassName() {
        return IMPL.getClassName(mInfo);
    }
    
    public CollectionInfoCompat getCollectionInfo() {
        final Object collectionInfo = IMPL.getCollectionInfo(mInfo);
        if (collectionInfo == null) {
            return null;
        }
        return new CollectionInfoCompat(collectionInfo);
    }
    
    public CollectionItemInfoCompat getCollectionItemInfo() {
        final Object collectionItemInfo = IMPL.getCollectionItemInfo(mInfo);
        if (collectionItemInfo == null) {
            return null;
        }
        return new CollectionItemInfoCompat(collectionItemInfo);
    }
    
    public CharSequence getContentDescription() {
        return IMPL.getContentDescription(mInfo);
    }
    
    public CharSequence getError() {
        return IMPL.getError(mInfo);
    }
    
    public Bundle getExtras() {
        return IMPL.getExtras(mInfo);
    }
    
    public Object getInfo() {
        return mInfo;
    }
    
    public int getInputType() {
        return IMPL.getInputType(mInfo);
    }
    
    public AccessibilityNodeInfoCompat getLabelFor() {
        return wrapNonNullInstance(IMPL.getLabelFor(mInfo));
    }
    
    public AccessibilityNodeInfoCompat getLabeledBy() {
        return wrapNonNullInstance(IMPL.getLabeledBy(mInfo));
    }
    
    public int getLiveRegion() {
        return IMPL.getLiveRegion(mInfo);
    }
    
    public int getMaxTextLength() {
        return IMPL.getMaxTextLength(mInfo);
    }
    
    public int getMovementGranularities() {
        return IMPL.getMovementGranularities(mInfo);
    }
    
    public CharSequence getPackageName() {
        return IMPL.getPackageName(mInfo);
    }
    
    public AccessibilityNodeInfoCompat getParent() {
        return wrapNonNullInstance(IMPL.getParent(mInfo));
    }
    
    public RangeInfoCompat getRangeInfo() {
        final Object rangeInfo = IMPL.getRangeInfo(mInfo);
        if (rangeInfo == null) {
            return null;
        }
        return new RangeInfoCompat(rangeInfo);
    }
    
    public CharSequence getText() {
        return IMPL.getText(mInfo);
    }
    
    public int getTextSelectionEnd() {
        return IMPL.getTextSelectionEnd(mInfo);
    }
    
    public int getTextSelectionStart() {
        return IMPL.getTextSelectionStart(mInfo);
    }
    
    public AccessibilityNodeInfoCompat getTraversalAfter() {
        return wrapNonNullInstance(IMPL.getTraversalAfter(mInfo));
    }
    
    public AccessibilityNodeInfoCompat getTraversalBefore() {
        return wrapNonNullInstance(IMPL.getTraversalBefore(mInfo));
    }
    
    public String getViewIdResourceName() {
        return IMPL.getViewIdResourceName(mInfo);
    }
    
    public AccessibilityWindowInfoCompat getWindow() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(IMPL.getWindow(mInfo));
    }
    
    public int getWindowId() {
        return IMPL.getWindowId(mInfo);
    }
    
    @Override
    public int hashCode() {
        if (mInfo == null) {
            return 0;
        }
        return mInfo.hashCode();
    }
    
    public boolean isAccessibilityFocused() {
        return IMPL.isAccessibilityFocused(mInfo);
    }
    
    public boolean isCheckable() {
        return IMPL.isCheckable(mInfo);
    }
    
    public boolean isChecked() {
        return IMPL.isChecked(mInfo);
    }
    
    public boolean isClickable() {
        return IMPL.isClickable(mInfo);
    }
    
    public boolean isContentInvalid() {
        return IMPL.isContentInvalid(mInfo);
    }
    
    public boolean isDismissable() {
        return IMPL.isDismissable(mInfo);
    }
    
    public boolean isEditable() {
        return IMPL.isEditable(mInfo);
    }
    
    public boolean isEnabled() {
        return IMPL.isEnabled(mInfo);
    }
    
    public boolean isFocusable() {
        return IMPL.isFocusable(mInfo);
    }
    
    public boolean isFocused() {
        return IMPL.isFocused(mInfo);
    }
    
    public boolean isLongClickable() {
        return IMPL.isLongClickable(mInfo);
    }
    
    public boolean isMultiLine() {
        return IMPL.isMultiLine(mInfo);
    }
    
    public boolean isPassword() {
        return IMPL.isPassword(mInfo);
    }
    
    public boolean isScrollable() {
        return IMPL.isScrollable(mInfo);
    }
    
    public boolean isSelected() {
        return IMPL.isSelected(mInfo);
    }
    
    public boolean isVisibleToUser() {
        return IMPL.isVisibleToUser(mInfo);
    }
    
    public boolean performAction(final int n) {
        return IMPL.performAction(mInfo, n);
    }
    
    public boolean performAction(final int n, final Bundle bundle) {
        return IMPL.performAction(mInfo, n, bundle);
    }
    
    public void recycle() {
        IMPL.recycle(mInfo);
    }
    
    public boolean refresh() {
        return IMPL.refresh(mInfo);
    }
    
    public boolean removeAction(final AccessibilityActionCompat accessibilityActionCompat) {
        return IMPL.removeAction(mInfo, accessibilityActionCompat.mAction);
    }
    
    public boolean removeChild(final View view) {
        return IMPL.removeChild(mInfo, view);
    }
    
    public boolean removeChild(final View view, final int n) {
        return IMPL.removeChild(mInfo, view, n);
    }
    
    public void setAccessibilityFocused(final boolean b) {
        IMPL.setAccessibilityFocused(mInfo, b);
    }
    
    public void setBoundsInParent(final Rect rect) {
        IMPL.setBoundsInParent(mInfo, rect);
    }
    
    public void setBoundsInScreen(final Rect rect) {
        IMPL.setBoundsInScreen(mInfo, rect);
    }
    
    public void setCanOpenPopup(final boolean b) {
        IMPL.setCanOpenPopup(mInfo, b);
    }
    
    public void setCheckable(final boolean b) {
        IMPL.setCheckable(mInfo, b);
    }
    
    public void setChecked(final boolean b) {
        IMPL.setChecked(mInfo, b);
    }
    
    public void setClassName(final CharSequence charSequence) {
        IMPL.setClassName(mInfo, charSequence);
    }
    
    public void setClickable(final boolean b) {
        IMPL.setClickable(mInfo, b);
    }
    
    public void setCollectionInfo(final Object o) {
        IMPL.setCollectionInfo(mInfo, ((CollectionInfoCompat)o).mInfo);
    }
    
    public void setCollectionItemInfo(final Object o) {
        IMPL.setCollectionItemInfo(mInfo, ((CollectionItemInfoCompat)o).mInfo);
    }
    
    public void setContentDescription(final CharSequence charSequence) {
        IMPL.setContentDescription(mInfo, charSequence);
    }
    
    public void setContentInvalid(final boolean b) {
        IMPL.setContentInvalid(mInfo, b);
    }
    
    public void setDismissable(final boolean b) {
        IMPL.setDismissable(mInfo, b);
    }
    
    public void setEditable(final boolean b) {
        IMPL.setEditable(mInfo, b);
    }
    
    public void setEnabled(final boolean b) {
        IMPL.setEnabled(mInfo, b);
    }
    
    public void setError(final CharSequence charSequence) {
        IMPL.setError(mInfo, charSequence);
    }
    
    public void setFocusable(final boolean b) {
        IMPL.setFocusable(mInfo, b);
    }
    
    public void setFocused(final boolean b) {
        IMPL.setFocused(mInfo, b);
    }
    
    public void setInputType(final int n) {
        IMPL.setInputType(mInfo, n);
    }
    
    public void setLabelFor(final View view) {
        IMPL.setLabelFor(mInfo, view);
    }
    
    public void setLabelFor(final View view, final int n) {
        IMPL.setLabelFor(mInfo, view, n);
    }
    
    public void setLabeledBy(final View view) {
        IMPL.setLabeledBy(mInfo, view);
    }
    
    public void setLabeledBy(final View view, final int n) {
        IMPL.setLabeledBy(mInfo, view, n);
    }
    
    public void setLiveRegion(final int n) {
        IMPL.setLiveRegion(mInfo, n);
    }
    
    public void setLongClickable(final boolean b) {
        IMPL.setLongClickable(mInfo, b);
    }
    
    public void setMaxTextLength(final int n) {
        IMPL.setMaxTextLength(mInfo, n);
    }
    
    public void setMovementGranularities(final int n) {
        IMPL.setMovementGranularities(mInfo, n);
    }
    
    public void setMultiLine(final boolean b) {
        IMPL.setMultiLine(mInfo, b);
    }
    
    public void setPackageName(final CharSequence charSequence) {
        IMPL.setPackageName(mInfo, charSequence);
    }
    
    public void setParent(final View view) {
        IMPL.setParent(mInfo, view);
    }
    
    public void setParent(final View view, final int n) {
        IMPL.setParent(mInfo, view, n);
    }
    
    public void setPassword(final boolean b) {
        IMPL.setPassword(mInfo, b);
    }
    
    public void setRangeInfo(final RangeInfoCompat rangeInfoCompat) {
        IMPL.setRangeInfo(mInfo, rangeInfoCompat.mInfo);
    }
    
    public void setScrollable(final boolean b) {
        IMPL.setScrollable(mInfo, b);
    }
    
    public void setSelected(final boolean b) {
        IMPL.setSelected(mInfo, b);
    }
    
    public void setSource(final View view) {
        IMPL.setSource(mInfo, view);
    }
    
    public void setSource(final View view, final int n) {
        IMPL.setSource(mInfo, view, n);
    }
    
    public void setText(final CharSequence charSequence) {
        IMPL.setText(mInfo, charSequence);
    }
    
    public void setTextSelection(final int n, final int n2) {
        IMPL.setTextSelection(mInfo, n, n2);
    }
    
    public void setTraversalAfter(final View view) {
        IMPL.setTraversalAfter(mInfo, view);
    }
    
    public void setTraversalAfter(final View view, final int n) {
        IMPL.setTraversalAfter(mInfo, view, n);
    }
    
    public void setTraversalBefore(final View view) {
        IMPL.setTraversalBefore(mInfo, view);
    }
    
    public void setTraversalBefore(final View view, final int n) {
        IMPL.setTraversalBefore(mInfo, view, n);
    }
    
    public void setViewIdResourceName(final String s) {
        IMPL.setViewIdResourceName(mInfo, s);
    }
    
    public void setVisibleToUser(final boolean b) {
        IMPL.setVisibleToUser(mInfo, b);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        final Rect rect = new Rect();
        this.getBoundsInParent(rect);
        sb.append("; boundsInParent: " + rect);
        this.getBoundsInScreen(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ").append(this.getPackageName());
        sb.append("; className: ").append(this.getClassName());
        sb.append("; text: ").append(this.getText());
        sb.append("; contentDescription: ").append(this.getContentDescription());
        sb.append("; viewId: ").append(this.getViewIdResourceName());
        sb.append("; checkable: ").append(this.isCheckable());
        sb.append("; checked: ").append(this.isChecked());
        sb.append("; focusable: ").append(this.isFocusable());
        sb.append("; focused: ").append(this.isFocused());
        sb.append("; selected: ").append(this.isSelected());
        sb.append("; clickable: ").append(this.isClickable());
        sb.append("; longClickable: ").append(this.isLongClickable());
        sb.append("; enabled: ").append(this.isEnabled());
        sb.append("; password: ").append(this.isPassword());
        sb.append("; scrollable: " + this.isScrollable());
        sb.append("; [");
        int i = this.getActions();
        while (i != 0) {
            final int n = 1 << Integer.numberOfTrailingZeros(i);
            i &= ~n;
            sb.append(getActionSymbolicName(n));
            if (i != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
