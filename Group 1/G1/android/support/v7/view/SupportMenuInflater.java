package android.support.v7.view;

import android.content.res.XmlResourceParser;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R;
import android.view.SubMenu;
import android.view.View;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v4.view.MenuItemCompat;
import java.lang.reflect.Constructor;
import android.util.Log;
import android.support.v4.view.ActionProvider;
import android.view.MenuItem;
import java.lang.reflect.Method;
import android.view.MenuItem$OnMenuItemClickListener;
import android.view.InflateException;
import android.util.Xml;
import android.support.v4.internal.view.SupportMenu;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import android.view.Menu;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import android.content.ContextWrapper;
import android.app.Activity;
import android.content.Context;
import android.view.MenuInflater;

public class SupportMenuInflater extends MenuInflater
{
    private static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE;
    private static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    private static final String LOG_TAG = "SupportMenuInflater";
    private static final int NO_ID = 0;
    private static final String XML_GROUP = "group";
    private static final String XML_ITEM = "item";
    private static final String XML_MENU = "menu";
    private final Object[] mActionProviderConstructorArguments;
    private final Object[] mActionViewConstructorArguments;
    private Context mContext;
    private Object mRealOwner;
    
    static {
        ACTION_VIEW_CONSTRUCTOR_SIGNATURE = new Class[] { Context.class };
        ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    }
    
    public SupportMenuInflater(final Context mContext) {
        super(mContext);
        mContext = mContext;
        mActionViewConstructorArguments = new Object[] { mContext };
        mActionProviderConstructorArguments = mActionViewConstructorArguments;
    }
    
    static /* synthetic */ Context access$100(final SupportMenuInflater supportMenuInflater) {
        return supportMenuInflater.mContext;
    }
    
    static /* synthetic */ Class[] access$200() {
        return ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE;
    }
    
    static /* synthetic */ Object[] access$300(final SupportMenuInflater supportMenuInflater) {
        return supportMenuInflater.mActionProviderConstructorArguments;
    }
    
    static /* synthetic */ Object access$400(final SupportMenuInflater supportMenuInflater) {
        return supportMenuInflater.getRealOwner();
    }
    
    static /* synthetic */ Class[] access$500() {
        return ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    }
    
    static /* synthetic */ Object[] access$600(final SupportMenuInflater supportMenuInflater) {
        return supportMenuInflater.mActionViewConstructorArguments;
    }
    
    private Object findRealOwner(final Object o) {
        if (!(o instanceof Activity) && o instanceof ContextWrapper) {
            return this.findRealOwner(((ContextWrapper)o).getBaseContext());
        }
        return o;
    }
    
    private Object getRealOwner() {
        if (mRealOwner == null) {
            mRealOwner = this.findRealOwner(mContext);
        }
        return mRealOwner;
    }
    
    private void parseMenu(final XmlPullParser xmlPullParser, final AttributeSet set, final Menu menu) throws XmlPullParserException, IOException {
        final MenuState menuState = new MenuState(menu);
        int i = xmlPullParser.getEventType();
        int n = 0;
        Object o = null;
        String name3;
        while (true) {
            while (i != 2) {
                i = xmlPullParser.next();
                if (i == 1) {
                    int j = 0;
                    while (j == 0) {
                        switch (i) {
                            case 2: {
                                if (n != 0) {
                                    break;
                                }
                                final String name = xmlPullParser.getName();
                                if (name.equals("group")) {
                                    menuState.readGroup(set);
                                    break;
                                }
                                if (name.equals("item")) {
                                    menuState.readItem(set);
                                    break;
                                }
                                if (name.equals("menu")) {
                                    this.parseMenu(xmlPullParser, set, (Menu)menuState.addSubMenuItem());
                                    break;
                                }
                                n = 1;
                                o = name;
                                break;
                            }
                            case 3: {
                                final String name2 = xmlPullParser.getName();
                                if (n != 0 && name2.equals(o)) {
                                    n = 0;
                                    o = null;
                                    break;
                                }
                                if (name2.equals("group")) {
                                    menuState.resetGroup();
                                    break;
                                }
                                if (name2.equals("item")) {
                                    if (menuState.hasAddedItem()) {
                                        break;
                                    }
                                    if (menuState.itemActionProvider != null && menuState.itemActionProvider.hasSubMenu()) {
                                        menuState.addSubMenuItem();
                                        break;
                                    }
                                    menuState.addItem();
                                    break;
                                }
                                else {
                                    if (name2.equals("menu")) {
                                        j = 1;
                                        break;
                                    }
                                    break;
                                }
                                break;
                            }
                            case 1:
                                throw new RuntimeException("Unexpected end of document");
                        }
                        i = xmlPullParser.next();
                    }
                    return;
                }
            }
            name3 = xmlPullParser.getName();
            if (name3.equals("menu")) {
                i = xmlPullParser.next();
                continue;
            }
            break;
        }
        throw new RuntimeException("Expecting menu, got " + name3);
    }
    
    public void inflate(final int n, final Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(n, menu);
            return;
        }
        Object layout = null;
        try {
            layout = mContext.getResources().getLayout(n);
            this.parseMenu((XmlPullParser)layout, Xml.asAttributeSet((XmlPullParser)layout), menu);
        }
        catch (XmlPullParserException ex) {
            throw new InflateException("Error inflating menu XML", (Throwable)ex);
        }
        catch (IOException ex2) {
            throw new InflateException("Error inflating menu XML", (Throwable)ex2);
        }
        finally {
            if (layout != null) {
                ((XmlResourceParser)layout).close();
            }
        }
    }
}
