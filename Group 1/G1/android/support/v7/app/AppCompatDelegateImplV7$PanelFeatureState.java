package android.support.v7.app;

import android.support.v4.os.ParcelableCompat;
import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.os.Parcelable$Creator;
import android.content.res.TypedArray;
import android.content.res.Resources$Theme;
import android.support.v7.view.ContextThemeWrapper;
import android.util.TypedValue;
import android.os.Parcelable;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.content.Context;
import android.support.v7.view.menu.ListMenuPresenter;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.View;

private static final class PanelFeatureState
{
    int background;
    View createdPanelView;
    ViewGroup decorView;
    int featureId;
    Bundle frozenActionViewState;
    Bundle frozenMenuState;
    int gravity;
    boolean isHandled;
    boolean isOpen;
    boolean isPrepared;
    ListMenuPresenter listMenuPresenter;
    Context listPresenterContext;
    MenuBuilder menu;
    public boolean qwertyMode;
    boolean refreshDecorView;
    boolean refreshMenuContent;
    View shownPanelView;
    boolean wasLastOpen;
    int windowAnimations;
    int x;
    int y;
    
    PanelFeatureState(final int featureId) {
        super();
        this.featureId = featureId;
        this.refreshDecorView = false;
    }
    
    void applyFrozenState() {
        if (menu != null && frozenMenuState != null) {
            menu.restorePresenterStates(frozenMenuState);
            frozenMenuState = null;
        }
    }
    
    public void clearMenuPresenters() {
        if (menu != null) {
            menu.removeMenuPresenter(listMenuPresenter);
        }
        listMenuPresenter = null;
    }
    
    MenuView getListMenuView(final MenuPresenter.Callback callback) {
        if (menu == null) {
            return null;
        }
        if (listMenuPresenter == null) {
            (listMenuPresenter = new ListMenuPresenter(listPresenterContext, R.layout.abc_list_menu_item_layout)).setCallback(callback);
            menu.addMenuPresenter(listMenuPresenter);
        }
        return listMenuPresenter.getMenuView(decorView);
    }
    
    public boolean hasPanelItems() {
        boolean b = true;
        if (shownPanelView == null) {
            b = false;
        }
        else if (createdPanelView == null && listMenuPresenter.getAdapter().getCount() <= 0) {
            return false;
        }
        return b;
    }
    
    void onRestoreInstanceState(final Parcelable parcelable) {
        final SavedState savedState = (SavedState)parcelable;
        featureId = savedState.featureId;
        wasLastOpen = savedState.isOpen;
        frozenMenuState = savedState.menuState;
        shownPanelView = null;
        decorView = null;
    }
    
    Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState();
        savedState.featureId = featureId;
        savedState.isOpen = isOpen;
        if (menu != null) {
            savedState.menuState = new Bundle();
            menu.savePresenterStates(savedState.menuState);
        }
        return (Parcelable)savedState;
    }
    
    void setMenu(final MenuBuilder menu) {
        if (menu != this.menu) {
            if (this.menu != null) {
                this.menu.removeMenuPresenter(listMenuPresenter);
            }
            this.menu = menu;
            if (menu != null && listMenuPresenter != null) {
                menu.addMenuPresenter(listMenuPresenter);
            }
        }
    }
    
    void setStyle(final Context context) {
        final TypedValue typedValue = new TypedValue();
        final Resources$Theme theme = context.getResources().newTheme();
        theme.setTo(context.getTheme());
        theme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
        if (typedValue.resourceId != 0) {
            theme.applyStyle(typedValue.resourceId, true);
        }
        theme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
        if (typedValue.resourceId != 0) {
            theme.applyStyle(typedValue.resourceId, true);
        }
        else {
            theme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
        }
        final ContextThemeWrapper listPresenterContext = new ContextThemeWrapper(context, 0);
        ((Context)listPresenterContext).getTheme().setTo(theme);
        this.listPresenterContext = (Context)listPresenterContext;
        final TypedArray obtainStyledAttributes = ((Context)listPresenterContext).obtainStyledAttributes(R.styleable.AppCompatTheme);
        background = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
        windowAnimations = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
        obtainStyledAttributes.recycle();
    }
}
