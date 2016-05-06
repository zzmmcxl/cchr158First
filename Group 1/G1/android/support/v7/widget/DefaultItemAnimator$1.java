package android.support.v7.widget;

import java.util.Iterator;
import java.util.ArrayList;

class DefaultItemAnimator$1 implements Runnable {
    final /* synthetic */ DefaultItemAnimator this$0;
    final /* synthetic */ ArrayList val$moves;
    
    DefaultItemAnimator$1(final DefaultItemAnimator this$0, final ArrayList val$moves) {
        this$0 = this$0;
        val$moves = val$moves;
        super();
    }
    
    @Override
    public void run() {
        for (final MoveInfo moveInfo : val$moves) {
            DefaultItemAnimator.access$000(this$0, moveInfo.holder, moveInfo.fromX, moveInfo.fromY, moveInfo.toX, moveInfo.toY);
        }
        val$moves.clear();
        DefaultItemAnimator.access$100(this$0).remove(val$moves);
    }
}