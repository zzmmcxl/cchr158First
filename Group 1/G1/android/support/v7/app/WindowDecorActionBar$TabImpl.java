package android.support.v7.app;

import android.support.v7.widget.AppCompatDrawableManager;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.graphics.drawable.Drawable;
import android.view.View;

public class TabImpl extends Tab
{
    private TabListener mCallback;
    private CharSequence mContentDesc;
    private View mCustomView;
    private Drawable mIcon;
    private int mPosition;
    private Object mTag;
    private CharSequence mText;
    final /* synthetic */ WindowDecorActionBar this$0;
    
    public TabImpl(final WindowDecorActionBar this$0) {
        this$0 = this$0;
        super();
        mPosition = -1;
    }
    
    public TabListener getCallback() {
        return mCallback;
    }
    
    @Override
    public CharSequence getContentDescription() {
        return mContentDesc;
    }
    
    @Override
    public View getCustomView() {
        return mCustomView;
    }
    
    @Override
    public Drawable getIcon() {
        return mIcon;
    }
    
    @Override
    public int getPosition() {
        return mPosition;
    }
    
    @Override
    public Object getTag() {
        return mTag;
    }
    
    @Override
    public CharSequence getText() {
        return mText;
    }
    
    @Override
    public void select() {
        this$0.selectTab(this);
    }
    
    @Override
    public Tab setContentDescription(final int n) {
        return this.setContentDescription(WindowDecorActionBar.access$1000(this$0).getResources().getText(n));
    }
    
    @Override
    public Tab setContentDescription(final CharSequence mContentDesc) {
        this.mContentDesc = mContentDesc;
        if (mPosition >= 0) {
            WindowDecorActionBar.access$1100(this$0).updateTab(mPosition);
        }
        return this;
    }
    
    @Override
    public Tab setCustomView(final int n) {
        return this.setCustomView(LayoutInflater.from(this$0.getThemedContext()).inflate(n, (ViewGroup)null));
    }
    
    @Override
    public Tab setCustomView(final View mCustomView) {
        this.mCustomView = mCustomView;
        if (mPosition >= 0) {
            WindowDecorActionBar.access$1100(this$0).updateTab(mPosition);
        }
        return this;
    }
    
    @Override
    public Tab setIcon(final int n) {
        return this.setIcon(AppCompatDrawableManager.get().getDrawable(WindowDecorActionBar.access$1000(this$0), n));
    }
    
    @Override
    public Tab setIcon(final Drawable mIcon) {
        this.mIcon = mIcon;
        if (mPosition >= 0) {
            WindowDecorActionBar.access$1100(this$0).updateTab(mPosition);
        }
        return this;
    }
    
    public void setPosition(final int mPosition) {
        this.mPosition = mPosition;
    }
    
    @Override
    public Tab setTabListener(final TabListener mCallback) {
        this.mCallback = mCallback;
        return this;
    }
    
    @Override
    public Tab setTag(final Object mTag) {
        this.mTag = mTag;
        return this;
    }
    
    @Override
    public Tab setText(final int n) {
        return this.setText(WindowDecorActionBar.access$1000(this$0).getResources().getText(n));
    }
    
    @Override
    public Tab setText(final CharSequence mText) {
        this.mText = mText;
        if (mPosition >= 0) {
            WindowDecorActionBar.access$1100(this$0).updateTab(mPosition);
        }
        return this;
    }
}
