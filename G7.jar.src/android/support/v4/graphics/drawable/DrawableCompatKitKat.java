package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

class DrawableCompatKitKat
{
  public static int getAlpha(Drawable paramDrawable)
  {
    return paramDrawable.getAlpha();
  }
  
  public static boolean isAutoMirrored(Drawable paramDrawable)
  {
    return paramDrawable.isAutoMirrored();
  }
  
  public static void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean)
  {
    paramDrawable.setAutoMirrored(paramBoolean);
  }
  
  public static Drawable wrapForTinting(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (!(paramDrawable instanceof DrawableWrapperKitKat)) {
      localObject = new DrawableWrapperKitKat(paramDrawable);
    }
    return (Drawable)localObject;
  }
}


/* Location:              C:\Users\colin\Documents\GitHub\cchr158First\G7.jar!\android\support\v4\graphics\drawable\DrawableCompatKitKat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */