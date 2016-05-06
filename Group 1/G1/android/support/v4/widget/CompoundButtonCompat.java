package android.support.v4.widget;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.support.annotation.Nullable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.widget.CompoundButton;
import android.os.Build$VERSION;

public final class CompoundButtonCompat
{
    private static final CompoundButtonCompatImpl IMPL;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 23) {
            IMPL = (CompoundButtonCompatImpl)new Api23CompoundButtonImpl();
            return;
        }
        if (sdk_INT >= 21) {
            IMPL = (CompoundButtonCompatImpl)new LollipopCompoundButtonImpl();
            return;
        }
        IMPL = (CompoundButtonCompatImpl)new BaseCompoundButtonCompat();
    }
    
    private CompoundButtonCompat() {
        super();
    }
    
    @Nullable
    public static Drawable getButtonDrawable(@NonNull final CompoundButton compoundButton) {
        return IMPL.getButtonDrawable(compoundButton);
    }
    
    @Nullable
    public static ColorStateList getButtonTintList(@NonNull final CompoundButton compoundButton) {
        return IMPL.getButtonTintList(compoundButton);
    }
    
    @Nullable
    public static PorterDuff$Mode getButtonTintMode(@NonNull final CompoundButton compoundButton) {
        return IMPL.getButtonTintMode(compoundButton);
    }
    
    public static void setButtonTintList(@NonNull final CompoundButton compoundButton, @Nullable final ColorStateList list) {
        IMPL.setButtonTintList(compoundButton, list);
    }
    
    public static void setButtonTintMode(@NonNull final CompoundButton compoundButton, @Nullable final PorterDuff$Mode porterDuff$Mode) {
        IMPL.setButtonTintMode(compoundButton, porterDuff$Mode);
    }
}
