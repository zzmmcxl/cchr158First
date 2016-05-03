package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

class DrawableCompatEclair
{
  public static Drawable wrapForTinting(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (!(paramDrawable instanceof DrawableWrapperEclair)) {
      localObject = new DrawableWrapperEclair(paramDrawable);
    }
    return (Drawable)localObject;
  }
}


/* Location:              C:\Users\colin\Documents\GitHub\cchr158First\G7.jar!\android\support\v4\graphics\drawable\DrawableCompatEclair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */