package android.support.design.widget;

import android.text.TextUtils;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.accessibility.AccessibilityEvent;
import android.view.View;
import android.support.v4.view.AccessibilityDelegateCompat;

private class TextInputAccessibilityDelegate extends AccessibilityDelegateCompat
{
    final /* synthetic */ TextInputLayout this$0;
    
    private TextInputAccessibilityDelegate(final TextInputLayout this$0) {
        this$0 = this$0;
        super();
    }
    
    TextInputAccessibilityDelegate(final TextInputLayout textInputLayout, final TextInputLayout$1 textWatcher) {
        this(textInputLayout);
    }
    
    @Override
    public void onInitializeAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)TextInputLayout.class.getSimpleName());
    }
    
    @Override
    public void onInitializeAccessibilityNodeInfo(final View view, final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(TextInputLayout.class.getSimpleName());
        final CharSequence text = TextInputLayout.access$500(this$0).getText();
        if (!TextUtils.isEmpty(text)) {
            accessibilityNodeInfoCompat.setText(text);
        }
        if (TextInputLayout.access$600(this$0) != null) {
            accessibilityNodeInfoCompat.setLabelFor((View)TextInputLayout.access$600(this$0));
        }
        CharSequence text2;
        if (TextInputLayout.access$400(this$0) != null) {
            text2 = TextInputLayout.access$400(this$0).getText();
        }
        else {
            text2 = null;
        }
        if (!TextUtils.isEmpty(text2)) {
            accessibilityNodeInfoCompat.setContentInvalid(true);
            accessibilityNodeInfoCompat.setError(text2);
        }
    }
    
    @Override
    public void onPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        final CharSequence text = TextInputLayout.access$500(this$0).getText();
        if (!TextUtils.isEmpty(text)) {
            accessibilityEvent.getText().add(text);
        }
    }
}
