package android.support.v7.widget;

static class UpdateOp
{
    static final int ADD = 1;
    static final int MOVE = 8;
    static final int POOL_SIZE = 30;
    static final int REMOVE = 2;
    static final int UPDATE = 4;
    int cmd;
    int itemCount;
    Object payload;
    int positionStart;
    
    UpdateOp(final int cmd, final int positionStart, final int itemCount, final Object payload) {
        super();
        this.cmd = cmd;
        this.positionStart = positionStart;
        this.itemCount = itemCount;
        this.payload = payload;
    }
    
    String cmdToString() {
        switch (cmd) {
            default:
                return "??";
            case 1:
                return "add";
            case 2:
                return "rm";
            case 4:
                return "up";
            case 8:
                return "mv";
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            final UpdateOp updateOp = (UpdateOp)o;
            if (cmd != cmd) {
                return false;
            }
            if (cmd != 8 || Math.abs(itemCount - positionStart) != 1 || itemCount != positionStart || positionStart != itemCount) {
                if (itemCount != itemCount) {
                    return false;
                }
                if (positionStart != positionStart) {
                    return false;
                }
                if (payload != null) {
                    if (!payload.equals(payload)) {
                        return false;
                    }
                }
                else if (payload != null) {
                    return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return 31 * (31 * cmd + positionStart) + itemCount;
    }
    
    @Override
    public String toString() {
        return Integer.toHexString(System.identityHashCode((Object)this)) + "[" + this.cmdToString() + ",s:" + positionStart + "c:" + itemCount + ",p:" + payload + "]";
    }
}
