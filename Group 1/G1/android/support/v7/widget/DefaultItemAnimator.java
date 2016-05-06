package android.support.v7.widget;

import java.util.Iterator;
import java.util.Collection;
import android.support.annotation.NonNull;
import android.support.v4.animation.AnimatorCompatHelper;
import java.util.List;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewCompat;
import java.util.ArrayList;

public class DefaultItemAnimator extends SimpleItemAnimator
{
    private static final boolean DEBUG;
    private ArrayList<ViewHolder> mAddAnimations;
    private ArrayList<ArrayList<ViewHolder>> mAdditionsList;
    private ArrayList<ViewHolder> mChangeAnimations;
    private ArrayList<ArrayList<ChangeInfo>> mChangesList;
    private ArrayList<ViewHolder> mMoveAnimations;
    private ArrayList<ArrayList<MoveInfo>> mMovesList;
    private ArrayList<ViewHolder> mPendingAdditions;
    private ArrayList<ChangeInfo> mPendingChanges;
    private ArrayList<MoveInfo> mPendingMoves;
    private ArrayList<ViewHolder> mPendingRemovals;
    private ArrayList<ViewHolder> mRemoveAnimations;
    
    public DefaultItemAnimator() {
        super();
        mPendingRemovals = new ArrayList<ViewHolder>();
        mPendingAdditions = new ArrayList<ViewHolder>();
        mPendingMoves = new ArrayList<MoveInfo>();
        mPendingChanges = new ArrayList<ChangeInfo>();
        mAdditionsList = new ArrayList<ArrayList<ViewHolder>>();
        mMovesList = new ArrayList<ArrayList<MoveInfo>>();
        mChangesList = new ArrayList<ArrayList<ChangeInfo>>();
        mAddAnimations = new ArrayList<ViewHolder>();
        mMoveAnimations = new ArrayList<ViewHolder>();
        mRemoveAnimations = new ArrayList<ViewHolder>();
        mChangeAnimations = new ArrayList<ViewHolder>();
    }
    
    static /* synthetic */ void access$000(final DefaultItemAnimator defaultItemAnimator, final ViewHolder viewHolder, final int n, final int n2, final int n3, final int n4) {
        defaultItemAnimator.animateMoveImpl(viewHolder, n, n2, n3, n4);
    }
    
    static /* synthetic */ ArrayList access$100(final DefaultItemAnimator defaultItemAnimator) {
        return defaultItemAnimator.mMovesList;
    }
    
    static /* synthetic */ ArrayList access$1100(final DefaultItemAnimator defaultItemAnimator) {
        return defaultItemAnimator.mMoveAnimations;
    }
    
    static /* synthetic */ ArrayList access$1300(final DefaultItemAnimator defaultItemAnimator) {
        return defaultItemAnimator.mChangeAnimations;
    }
    
    static /* synthetic */ void access$200(final DefaultItemAnimator defaultItemAnimator, final ChangeInfo changeInfo) {
        defaultItemAnimator.animateChangeImpl(changeInfo);
    }
    
    static /* synthetic */ ArrayList access$300(final DefaultItemAnimator defaultItemAnimator) {
        return defaultItemAnimator.mChangesList;
    }
    
    static /* synthetic */ void access$400(final DefaultItemAnimator defaultItemAnimator, final ViewHolder viewHolder) {
        defaultItemAnimator.animateAddImpl(viewHolder);
    }
    
    static /* synthetic */ ArrayList access$500(final DefaultItemAnimator defaultItemAnimator) {
        return defaultItemAnimator.mAdditionsList;
    }
    
    static /* synthetic */ ArrayList access$700(final DefaultItemAnimator defaultItemAnimator) {
        return defaultItemAnimator.mRemoveAnimations;
    }
    
    static /* synthetic */ void access$800(final DefaultItemAnimator defaultItemAnimator) {
        defaultItemAnimator.dispatchFinishedWhenDone();
    }
    
    static /* synthetic */ ArrayList access$900(final DefaultItemAnimator defaultItemAnimator) {
        return defaultItemAnimator.mAddAnimations;
    }
    
    private void animateAddImpl(final ViewHolder viewHolder) {
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate(viewHolder.itemView);
        mAddAnimations.add(viewHolder);
        animate.alpha(1.0f).setDuration(((RecyclerView.ItemAnimator)this).getAddDuration()).setListener(new VpaListenerAdapter() {
            final /* synthetic */ DefaultItemAnimator this$0;
            final /* synthetic */ ViewPropertyAnimatorCompat val$animation;
            final /* synthetic */ ViewHolder val$holder;
            
            DefaultItemAnimator$5() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onAnimationCancel(final View view) {
                ViewCompat.setAlpha(view, 1.0f);
            }
            
            @Override
            public void onAnimationEnd(final View view) {
                animate.setListener(null);
                this$0.dispatchAddFinished(viewHolder);
                mAddAnimations.remove(viewHolder);
                this$0.dispatchFinishedWhenDone();
            }
            
            @Override
            public void onAnimationStart(final View view) {
                this$0.dispatchAddStarting(viewHolder);
            }
        }).start();
    }
    
    private void animateChangeImpl(final ChangeInfo changeInfo) {
        final ViewHolder oldHolder = changeInfo.oldHolder;
        View itemView;
        if (oldHolder == null) {
            itemView = null;
        }
        else {
            itemView = oldHolder.itemView;
        }
        final ViewHolder newHolder = changeInfo.newHolder;
        View itemView2;
        if (newHolder != null) {
            itemView2 = newHolder.itemView;
        }
        else {
            itemView2 = null;
        }
        if (itemView != null) {
            final ViewPropertyAnimatorCompat setDuration = ViewCompat.animate(itemView).setDuration(((RecyclerView.ItemAnimator)this).getChangeDuration());
            mChangeAnimations.add(changeInfo.oldHolder);
            setDuration.translationX(changeInfo.toX - changeInfo.fromX);
            setDuration.translationY(changeInfo.toY - changeInfo.fromY);
            setDuration.alpha(0.0f).setListener(new VpaListenerAdapter() {
                final /* synthetic */ DefaultItemAnimator this$0;
                final /* synthetic */ ChangeInfo val$changeInfo;
                final /* synthetic */ ViewPropertyAnimatorCompat val$oldViewAnim;
                
                DefaultItemAnimator$7() {
                    this$0 = this$0;
                    super();
                }
                
                @Override
                public void onAnimationEnd(final View view) {
                    setDuration.setListener(null);
                    ViewCompat.setAlpha(view, 1.0f);
                    ViewCompat.setTranslationX(view, 0.0f);
                    ViewCompat.setTranslationY(view, 0.0f);
                    this$0.dispatchChangeFinished(changeInfo.oldHolder, true);
                    mChangeAnimations.remove(changeInfo.oldHolder);
                    this$0.dispatchFinishedWhenDone();
                }
                
                @Override
                public void onAnimationStart(final View view) {
                    this$0.dispatchChangeStarting(changeInfo.oldHolder, true);
                }
            }).start();
        }
        if (itemView2 != null) {
            final ViewPropertyAnimatorCompat animate = ViewCompat.animate(itemView2);
            mChangeAnimations.add(changeInfo.newHolder);
            animate.translationX(0.0f).translationY(0.0f).setDuration(((RecyclerView.ItemAnimator)this).getChangeDuration()).alpha(1.0f).setListener(new VpaListenerAdapter() {
                final /* synthetic */ DefaultItemAnimator this$0;
                final /* synthetic */ ChangeInfo val$changeInfo;
                final /* synthetic */ View val$newView;
                final /* synthetic */ ViewPropertyAnimatorCompat val$newViewAnimation;
                
                DefaultItemAnimator$8() {
                    this$0 = this$0;
                    super();
                }
                
                @Override
                public void onAnimationEnd(final View view) {
                    animate.setListener(null);
                    ViewCompat.setAlpha(itemView2, 1.0f);
                    ViewCompat.setTranslationX(itemView2, 0.0f);
                    ViewCompat.setTranslationY(itemView2, 0.0f);
                    this$0.dispatchChangeFinished(changeInfo.newHolder, false);
                    mChangeAnimations.remove(changeInfo.newHolder);
                    this$0.dispatchFinishedWhenDone();
                }
                
                @Override
                public void onAnimationStart(final View view) {
                    this$0.dispatchChangeStarting(changeInfo.newHolder, false);
                }
            }).start();
        }
    }
    
    private void animateMoveImpl(final ViewHolder viewHolder, final int n, final int n2, final int n3, final int n4) {
        final View itemView = viewHolder.itemView;
        final int n5 = n3 - n;
        final int n6 = n4 - n2;
        if (n5 != 0) {
            ViewCompat.animate(itemView).translationX(0.0f);
        }
        if (n6 != 0) {
            ViewCompat.animate(itemView).translationY(0.0f);
        }
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate(itemView);
        mMoveAnimations.add(viewHolder);
        animate.setDuration(((RecyclerView.ItemAnimator)this).getMoveDuration()).setListener(new VpaListenerAdapter() {
            final /* synthetic */ DefaultItemAnimator this$0;
            final /* synthetic */ ViewPropertyAnimatorCompat val$animation;
            final /* synthetic */ int val$deltaX;
            final /* synthetic */ int val$deltaY;
            final /* synthetic */ ViewHolder val$holder;
            
            DefaultItemAnimator$6() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onAnimationCancel(final View view) {
                if (n5 != 0) {
                    ViewCompat.setTranslationX(view, 0.0f);
                }
                if (n6 != 0) {
                    ViewCompat.setTranslationY(view, 0.0f);
                }
            }
            
            @Override
            public void onAnimationEnd(final View view) {
                animate.setListener(null);
                this$0.dispatchMoveFinished(viewHolder);
                mMoveAnimations.remove(viewHolder);
                this$0.dispatchFinishedWhenDone();
            }
            
            @Override
            public void onAnimationStart(final View view) {
                this$0.dispatchMoveStarting(viewHolder);
            }
        }).start();
    }
    
    private void animateRemoveImpl(final ViewHolder viewHolder) {
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate(viewHolder.itemView);
        mRemoveAnimations.add(viewHolder);
        animate.setDuration(((RecyclerView.ItemAnimator)this).getRemoveDuration()).alpha(0.0f).setListener(new VpaListenerAdapter() {
            final /* synthetic */ DefaultItemAnimator this$0;
            final /* synthetic */ ViewPropertyAnimatorCompat val$animation;
            final /* synthetic */ ViewHolder val$holder;
            
            DefaultItemAnimator$4() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onAnimationEnd(final View view) {
                animate.setListener(null);
                ViewCompat.setAlpha(view, 1.0f);
                this$0.dispatchRemoveFinished(viewHolder);
                mRemoveAnimations.remove(viewHolder);
                this$0.dispatchFinishedWhenDone();
            }
            
            @Override
            public void onAnimationStart(final View view) {
                this$0.dispatchRemoveStarting(viewHolder);
            }
        }).start();
    }
    
    private void dispatchFinishedWhenDone() {
        if (!this.isRunning()) {
            ((RecyclerView.ItemAnimator)this).dispatchAnimationsFinished();
        }
    }
    
    private void endChangeAnimation(final List<ChangeInfo> list, final ViewHolder viewHolder) {
        for (int i = -1 + list.size(); i >= 0; --i) {
            final ChangeInfo changeInfo = (ChangeInfo)list.get(i);
            if (this.endChangeAnimationIfNecessary(changeInfo, viewHolder) && changeInfo.oldHolder == null && changeInfo.newHolder == null) {
                list.remove(changeInfo);
            }
        }
    }
    
    private void endChangeAnimationIfNecessary(final ChangeInfo changeInfo) {
        if (changeInfo.oldHolder != null) {
            this.endChangeAnimationIfNecessary(changeInfo, changeInfo.oldHolder);
        }
        if (changeInfo.newHolder != null) {
            this.endChangeAnimationIfNecessary(changeInfo, changeInfo.newHolder);
        }
    }
    
    private boolean endChangeAnimationIfNecessary(final ChangeInfo changeInfo, final ViewHolder viewHolder) {
        boolean b = false;
        if (changeInfo.newHolder == viewHolder) {
            changeInfo.newHolder = null;
        }
        else {
            if (changeInfo.oldHolder != viewHolder) {
                return false;
            }
            changeInfo.oldHolder = null;
            b = true;
        }
        ViewCompat.setAlpha(viewHolder.itemView, 1.0f);
        ViewCompat.setTranslationX(viewHolder.itemView, 0.0f);
        ViewCompat.setTranslationY(viewHolder.itemView, 0.0f);
        this.dispatchChangeFinished(viewHolder, b);
        return true;
    }
    
    private void resetAnimation(final ViewHolder viewHolder) {
        AnimatorCompatHelper.clearInterpolator(viewHolder.itemView);
        this.endAnimation(viewHolder);
    }
    
    @Override
    public boolean animateAdd(final ViewHolder viewHolder) {
        this.resetAnimation(viewHolder);
        ViewCompat.setAlpha(viewHolder.itemView, 0.0f);
        mPendingAdditions.add(viewHolder);
        return true;
    }
    
    @Override
    public boolean animateChange(final ViewHolder viewHolder, final ViewHolder viewHolder2, final int n, final int n2, final int n3, final int n4) {
        if (viewHolder == viewHolder2) {
            return this.animateMove(viewHolder, n, n2, n3, n4);
        }
        final float translationX = ViewCompat.getTranslationX(viewHolder.itemView);
        final float translationY = ViewCompat.getTranslationY(viewHolder.itemView);
        final float alpha = ViewCompat.getAlpha(viewHolder.itemView);
        this.resetAnimation(viewHolder);
        final int n5 = (int)(n3 - n - translationX);
        final int n6 = (int)(n4 - n2 - translationY);
        ViewCompat.setTranslationX(viewHolder.itemView, translationX);
        ViewCompat.setTranslationY(viewHolder.itemView, translationY);
        ViewCompat.setAlpha(viewHolder.itemView, alpha);
        if (viewHolder2 != null) {
            this.resetAnimation(viewHolder2);
            ViewCompat.setTranslationX(viewHolder2.itemView, -n5);
            ViewCompat.setTranslationY(viewHolder2.itemView, -n6);
            ViewCompat.setAlpha(viewHolder2.itemView, 0.0f);
        }
        mPendingChanges.add(new ChangeInfo(viewHolder, viewHolder2, n, n2, n3, n4));
        return true;
    }
    
    @Override
    public boolean animateMove(final ViewHolder viewHolder, final int n, final int n2, final int n3, final int n4) {
        final View itemView = viewHolder.itemView;
        final int n5 = (int)(n + ViewCompat.getTranslationX(viewHolder.itemView));
        final int n6 = (int)(n2 + ViewCompat.getTranslationY(viewHolder.itemView));
        this.resetAnimation(viewHolder);
        final int n7 = n3 - n5;
        final int n8 = n4 - n6;
        if (n7 == 0 && n8 == 0) {
            this.dispatchMoveFinished(viewHolder);
            return false;
        }
        if (n7 != 0) {
            ViewCompat.setTranslationX(itemView, -n7);
        }
        if (n8 != 0) {
            ViewCompat.setTranslationY(itemView, -n8);
        }
        mPendingMoves.add(new MoveInfo(viewHolder, n5, n6, n3, n4));
        return true;
    }
    
    @Override
    public boolean animateRemove(final ViewHolder viewHolder) {
        this.resetAnimation(viewHolder);
        mPendingRemovals.add(viewHolder);
        return true;
    }
    
    @Override
    public boolean canReuseUpdatedViewHolder(@NonNull final ViewHolder viewHolder, @NonNull final List<Object> list) {
        return !list.isEmpty() || super.canReuseUpdatedViewHolder(viewHolder, list);
    }
    
    void cancelAll(final List<ViewHolder> list) {
        for (int i = -1 + list.size(); i >= 0; --i) {
            ViewCompat.animate(((ViewHolder)list.get(i)).itemView).cancel();
        }
    }
    
    @Override
    public void endAnimation(final ViewHolder viewHolder) {
        final View itemView = viewHolder.itemView;
        ViewCompat.animate(itemView).cancel();
        for (int i = -1 + mPendingMoves.size(); i >= 0; --i) {
            if (((MoveInfo)mPendingMoves.get(i)).holder == viewHolder) {
                ViewCompat.setTranslationY(itemView, 0.0f);
                ViewCompat.setTranslationX(itemView, 0.0f);
                this.dispatchMoveFinished(viewHolder);
                mPendingMoves.remove(i);
            }
        }
        this.endChangeAnimation(mPendingChanges, viewHolder);
        if (mPendingRemovals.remove(viewHolder)) {
            ViewCompat.setAlpha(itemView, 1.0f);
            this.dispatchRemoveFinished(viewHolder);
        }
        if (mPendingAdditions.remove(viewHolder)) {
            ViewCompat.setAlpha(itemView, 1.0f);
            this.dispatchAddFinished(viewHolder);
        }
        for (int j = -1 + mChangesList.size(); j >= 0; --j) {
            final ArrayList<ChangeInfo> list = (ArrayList<ChangeInfo>)mChangesList.get(j);
            this.endChangeAnimation(list, viewHolder);
            if (list.isEmpty()) {
                mChangesList.remove(j);
            }
        }
        for (int k = -1 + mMovesList.size(); k >= 0; --k) {
            final ArrayList<MoveInfo> list2 = (ArrayList<MoveInfo>)mMovesList.get(k);
            int l = -1 + list2.size();
            while (l >= 0) {
                if (((MoveInfo)list2.get(l)).holder == viewHolder) {
                    ViewCompat.setTranslationY(itemView, 0.0f);
                    ViewCompat.setTranslationX(itemView, 0.0f);
                    this.dispatchMoveFinished(viewHolder);
                    list2.remove(l);
                    if (list2.isEmpty()) {
                        mMovesList.remove(k);
                        break;
                    }
                    break;
                }
                else {
                    --l;
                }
            }
        }
        for (int n = -1 + mAdditionsList.size(); n >= 0; --n) {
            final ArrayList<ViewHolder> list3 = (ArrayList<ViewHolder>)mAdditionsList.get(n);
            if (list3.remove(viewHolder)) {
                ViewCompat.setAlpha(itemView, 1.0f);
                this.dispatchAddFinished(viewHolder);
                if (list3.isEmpty()) {
                    mAdditionsList.remove(n);
                }
            }
        }
        if (mRemoveAnimations.remove(viewHolder)) {}
        if (mAddAnimations.remove(viewHolder)) {}
        if (mChangeAnimations.remove(viewHolder)) {}
        if (mMoveAnimations.remove(viewHolder)) {}
        this.dispatchFinishedWhenDone();
    }
    
    @Override
    public void endAnimations() {
        for (int i = -1 + mPendingMoves.size(); i >= 0; --i) {
            final MoveInfo moveInfo = (MoveInfo)mPendingMoves.get(i);
            final View itemView = moveInfo.holder.itemView;
            ViewCompat.setTranslationY(itemView, 0.0f);
            ViewCompat.setTranslationX(itemView, 0.0f);
            this.dispatchMoveFinished(moveInfo.holder);
            mPendingMoves.remove(i);
        }
        for (int j = -1 + mPendingRemovals.size(); j >= 0; --j) {
            this.dispatchRemoveFinished(mPendingRemovals.get(j));
            mPendingRemovals.remove(j);
        }
        for (int k = -1 + mPendingAdditions.size(); k >= 0; --k) {
            final ViewHolder viewHolder = (ViewHolder)mPendingAdditions.get(k);
            ViewCompat.setAlpha(viewHolder.itemView, 1.0f);
            this.dispatchAddFinished(viewHolder);
            mPendingAdditions.remove(k);
        }
        for (int l = -1 + mPendingChanges.size(); l >= 0; --l) {
            this.endChangeAnimationIfNecessary(mPendingChanges.get(l));
        }
        mPendingChanges.clear();
        if (!this.isRunning()) {
            return;
        }
        for (int n = -1 + mMovesList.size(); n >= 0; --n) {
            final ArrayList<MoveInfo> list = (ArrayList<MoveInfo>)mMovesList.get(n);
            for (int n2 = -1 + list.size(); n2 >= 0; --n2) {
                final MoveInfo moveInfo2 = (MoveInfo)list.get(n2);
                final View itemView2 = moveInfo2.holder.itemView;
                ViewCompat.setTranslationY(itemView2, 0.0f);
                ViewCompat.setTranslationX(itemView2, 0.0f);
                this.dispatchMoveFinished(moveInfo2.holder);
                list.remove(n2);
                if (list.isEmpty()) {
                    mMovesList.remove(list);
                }
            }
        }
        for (int n3 = -1 + mAdditionsList.size(); n3 >= 0; --n3) {
            final ArrayList<ViewHolder> list2 = (ArrayList<ViewHolder>)mAdditionsList.get(n3);
            for (int n4 = -1 + list2.size(); n4 >= 0; --n4) {
                final ViewHolder viewHolder2 = (ViewHolder)list2.get(n4);
                ViewCompat.setAlpha(viewHolder2.itemView, 1.0f);
                this.dispatchAddFinished(viewHolder2);
                list2.remove(n4);
                if (list2.isEmpty()) {
                    mAdditionsList.remove(list2);
                }
            }
        }
        for (int n5 = -1 + mChangesList.size(); n5 >= 0; --n5) {
            final ArrayList<ChangeInfo> list3 = (ArrayList<ChangeInfo>)mChangesList.get(n5);
            for (int n6 = -1 + list3.size(); n6 >= 0; --n6) {
                this.endChangeAnimationIfNecessary(list3.get(n6));
                if (list3.isEmpty()) {
                    mChangesList.remove(list3);
                }
            }
        }
        this.cancelAll(mRemoveAnimations);
        this.cancelAll(mMoveAnimations);
        this.cancelAll(mAddAnimations);
        this.cancelAll(mChangeAnimations);
        ((RecyclerView.ItemAnimator)this).dispatchAnimationsFinished();
    }
    
    @Override
    public boolean isRunning() {
        return !mPendingAdditions.isEmpty() || !mPendingChanges.isEmpty() || !mPendingMoves.isEmpty() || !mPendingRemovals.isEmpty() || !mMoveAnimations.isEmpty() || !mRemoveAnimations.isEmpty() || !mAddAnimations.isEmpty() || !mChangeAnimations.isEmpty() || !mMovesList.isEmpty() || !mAdditionsList.isEmpty() || !mChangesList.isEmpty();
    }
    
    @Override
    public void runPendingAnimations() {
        boolean b;
        if (!mPendingRemovals.isEmpty()) {
            b = true;
        }
        else {
            b = false;
        }
        boolean b2;
        if (!mPendingMoves.isEmpty()) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        boolean b3;
        if (!mPendingChanges.isEmpty()) {
            b3 = true;
        }
        else {
            b3 = false;
        }
        boolean b4;
        if (!mPendingAdditions.isEmpty()) {
            b4 = true;
        }
        else {
            b4 = false;
        }
        if (b || b2 || b4 || b3) {
            final Iterator<ViewHolder> iterator = mPendingRemovals.iterator();
            while (iterator.hasNext()) {
                this.animateRemoveImpl(iterator.next());
            }
            mPendingRemovals.clear();
            if (b2) {
                final ArrayList<MoveInfo> list = new ArrayList<MoveInfo>();
                list.addAll(mPendingMoves);
                mMovesList.add(list);
                mPendingMoves.clear();
                final Runnable runnable = new Runnable() {
                    final /* synthetic */ DefaultItemAnimator this$0;
                    final /* synthetic */ ArrayList val$moves;
                    
                    DefaultItemAnimator$1() {
                        this$0 = this$0;
                        super();
                    }
                    
                    @Override
                    public void run() {
                        for (final MoveInfo moveInfo : list) {
                            this$0.animateMoveImpl(moveInfo.holder, moveInfo.fromX, moveInfo.fromY, moveInfo.toX, moveInfo.toY);
                        }
                        list.clear();
                        mMovesList.remove(list);
                    }
                };
                if (b) {
                    ViewCompat.postOnAnimationDelayed(((MoveInfo)list.get(0)).holder.itemView, runnable, ((RecyclerView.ItemAnimator)this).getRemoveDuration());
                }
                else {
                    runnable.run();
                }
            }
            if (b3) {
                final ArrayList<ChangeInfo> list2 = new ArrayList<ChangeInfo>();
                list2.addAll(mPendingChanges);
                mChangesList.add(list2);
                mPendingChanges.clear();
                final Runnable runnable2 = new Runnable() {
                    final /* synthetic */ DefaultItemAnimator this$0;
                    final /* synthetic */ ArrayList val$changes;
                    
                    DefaultItemAnimator$2() {
                        this$0 = this$0;
                        super();
                    }
                    
                    @Override
                    public void run() {
                        final Iterator<ChangeInfo> iterator = list2.iterator();
                        while (iterator.hasNext()) {
                            this$0.animateChangeImpl((ChangeInfo)iterator.next());
                        }
                        list2.clear();
                        mChangesList.remove(list2);
                    }
                };
                if (b) {
                    ViewCompat.postOnAnimationDelayed(((ChangeInfo)list2.get(0)).oldHolder.itemView, runnable2, ((RecyclerView.ItemAnimator)this).getRemoveDuration());
                }
                else {
                    runnable2.run();
                }
            }
            if (b4) {
                final ArrayList<ViewHolder> list3 = new ArrayList<ViewHolder>();
                list3.addAll(mPendingAdditions);
                mAdditionsList.add(list3);
                mPendingAdditions.clear();
                final Runnable runnable3 = new Runnable() {
                    final /* synthetic */ DefaultItemAnimator this$0;
                    final /* synthetic */ ArrayList val$additions;
                    
                    DefaultItemAnimator$3() {
                        this$0 = this$0;
                        super();
                    }
                    
                    @Override
                    public void run() {
                        final Iterator<ViewHolder> iterator = list3.iterator();
                        while (iterator.hasNext()) {
                            this$0.animateAddImpl(iterator.next());
                        }
                        list3.clear();
                        mAdditionsList.remove(list3);
                    }
                };
                if (b || b2 || b3) {
                    long removeDuration;
                    if (b) {
                        removeDuration = ((RecyclerView.ItemAnimator)this).getRemoveDuration();
                    }
                    else {
                        removeDuration = 0L;
                    }
                    long moveDuration;
                    if (b2) {
                        moveDuration = ((RecyclerView.ItemAnimator)this).getMoveDuration();
                    }
                    else {
                        moveDuration = 0L;
                    }
                    long changeDuration;
                    if (b3) {
                        changeDuration = ((RecyclerView.ItemAnimator)this).getChangeDuration();
                    }
                    else {
                        changeDuration = 0L;
                    }
                    ViewCompat.postOnAnimationDelayed(list3.get(0).itemView, runnable3, removeDuration + Math.max(moveDuration, changeDuration));
                    return;
                }
                runnable3.run();
            }
        }
    }
}
