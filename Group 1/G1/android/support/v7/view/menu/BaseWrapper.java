package android.support.v7.view.menu;

class BaseWrapper<T>
{
    final T mWrappedObject;
    
    BaseWrapper(final T mWrappedObject) {
        super();
        if (mWrappedObject == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        mWrappedObject = mWrappedObject;
    }
    
    public T getWrappedObject() {
        return mWrappedObject;
    }
}
