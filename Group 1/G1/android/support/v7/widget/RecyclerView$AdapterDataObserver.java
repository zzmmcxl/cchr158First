package android.support.v7.widget;

public abstract static class AdapterDataObserver
{
    public AdapterDataObserver() {
        super();
    }
    
    public void onChanged() {
    }
    
    public void onItemRangeChanged(final int n, final int n2) {
    }
    
    public void onItemRangeChanged(final int n, final int n2, final Object o) {
        this.onItemRangeChanged(n, n2);
    }
    
    public void onItemRangeInserted(final int n, final int n2) {
    }
    
    public void onItemRangeMoved(final int n, final int n2, final int n3) {
    }
    
    public void onItemRangeRemoved(final int n, final int n2) {
    }
}
