package android.support.v4.content;

public enum Status
{
    private static final /* synthetic */ Status[] $VALUES;
    
    FINISHED, 
    PENDING, 
    RUNNING;
    
    static {
        $VALUES = new Status[] { PENDING, RUNNING, FINISHED };
    }
    
    public static Status valueOf(final String s) {
        return Enum.<Status>valueOf(Status.class, s);
    }
    
    public static Status[] values() {
        return $VALUES.clone();
    }
}
