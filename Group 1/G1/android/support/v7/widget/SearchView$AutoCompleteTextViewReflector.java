package android.support.v7.widget;

import android.view.View;
import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

private static class AutoCompleteTextViewReflector
{
    private Method doAfterTextChanged;
    private Method doBeforeTextChanged;
    private Method ensureImeVisible;
    private Method showSoftInputUnchecked;
    
    AutoCompleteTextViewReflector() {
        super();
        while (true) {
            try {
                (this.doBeforeTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", (Class<?>[])new Class[0])).setAccessible(true);
                try {
                    (this.doAfterTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", (Class<?>[])new Class[0])).setAccessible(true);
                    try {
                        (this.ensureImeVisible = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE)).setAccessible(true);
                        try {
                            (this.showSoftInputUnchecked = InputMethodManager.class.getMethod("showSoftInputUnchecked", Integer.TYPE, ResultReceiver.class)).setAccessible(true);
                        }
                        catch (NoSuchMethodException ex) {}
                    }
                    catch (NoSuchMethodException ex2) {}
                }
                catch (NoSuchMethodException ex3) {}
            }
            catch (NoSuchMethodException ex4) {
                continue;
            }
            break;
        }
    }
    
    void doAfterTextChanged(final AutoCompleteTextView autoCompleteTextView) {
        if (doAfterTextChanged == null) {
            return;
        }
        try {
            doAfterTextChanged.invoke(autoCompleteTextView, new Object[0]);
        }
        catch (Exception ex) {}
    }
    
    void doBeforeTextChanged(final AutoCompleteTextView autoCompleteTextView) {
        if (doBeforeTextChanged == null) {
            return;
        }
        try {
            doBeforeTextChanged.invoke(autoCompleteTextView, new Object[0]);
        }
        catch (Exception ex) {}
    }
    
    void ensureImeVisible(final AutoCompleteTextView autoCompleteTextView, final boolean b) {
        if (ensureImeVisible == null) {
            return;
        }
        try {
            ensureImeVisible.invoke(autoCompleteTextView, b);
        }
        catch (Exception ex) {}
    }
    
    void showSoftInputUnchecked(final InputMethodManager inputMethodManager, final View view, final int n) {
        if (showSoftInputUnchecked != null) {
            try {
                showSoftInputUnchecked.invoke(inputMethodManager, n, null);
                return;
            }
            catch (Exception ex) {}
        }
        inputMethodManager.showSoftInput(view, n);
    }
}
