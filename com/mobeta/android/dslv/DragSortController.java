package com.mobeta.android.dslv;

import android.graphics.Point;
import android.support.v4.view.MotionEventCompat;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;

public class DragSortController extends SimpleFloatViewManager implements OnTouchListener, OnGestureListener {
    public static final int CLICK_REMOVE = 0;
    public static final int FLING_REMOVE = 1;
    public static final int MISS = -1;
    public static final int ON_DOWN = 0;
    public static final int ON_DRAG = 1;
    public static final int ON_LONG_PRESS = 2;
    private boolean mCanDrag;
    private int mClickRemoveHitPos;
    private int mClickRemoveId;
    private int mCurrX;
    private int mCurrY;
    private GestureDetector mDetector;
    private int mDragHandleId;
    private int mDragInitMode;
    private boolean mDragging;
    private DragSortListView mDslv;
    private int mFlingHandleId;
    private int mFlingHitPos;
    private GestureDetector mFlingRemoveDetector;
    private OnGestureListener mFlingRemoveListener;
    private float mFlingSpeed;
    private int mHitPos;
    private boolean mIsRemoving;
    private int mItemX;
    private int mItemY;
    private int mPositionX;
    private boolean mRemoveEnabled;
    private int mRemoveMode;
    private boolean mSortEnabled;
    private int[] mTempLoc;
    private int mTouchSlop;

    /* renamed from: com.mobeta.android.dslv.DragSortController.1 */
    class C04631 extends SimpleOnGestureListener {
        C04631() {
        }

        public final boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (DragSortController.this.mRemoveEnabled && DragSortController.this.mIsRemoving) {
                int minPos = DragSortController.this.mDslv.getWidth() / 5;
                if (velocityX > DragSortController.this.mFlingSpeed) {
                    if (DragSortController.this.mPositionX > (-minPos)) {
                        DragSortController.this.mDslv.stopDragWithVelocity(true, velocityX);
                    }
                } else if (velocityX < (-DragSortController.this.mFlingSpeed) && DragSortController.this.mPositionX < minPos) {
                    DragSortController.this.mDslv.stopDragWithVelocity(true, velocityX);
                }
                DragSortController.this.mIsRemoving = false;
            }
            return false;
        }
    }

    public DragSortController(DragSortListView dslv) {
        this(dslv, ON_DOWN, ON_DOWN, ON_DRAG);
    }

    public DragSortController(DragSortListView dslv, int dragHandleId, int dragInitMode, int removeMode) {
        this(dslv, dragHandleId, dragInitMode, removeMode, ON_DOWN);
    }

    public DragSortController(DragSortListView dslv, int dragHandleId, int dragInitMode, int removeMode, int clickRemoveId) {
        this(dslv, dragHandleId, dragInitMode, removeMode, clickRemoveId, ON_DOWN);
    }

    public DragSortController(DragSortListView dslv, int dragHandleId, int dragInitMode, int removeMode, int clickRemoveId, int flingHandleId) {
        super(dslv);
        this.mDragInitMode = ON_DOWN;
        this.mSortEnabled = true;
        this.mRemoveEnabled = false;
        this.mIsRemoving = false;
        this.mHitPos = MISS;
        this.mFlingHitPos = MISS;
        this.mClickRemoveHitPos = MISS;
        this.mTempLoc = new int[ON_LONG_PRESS];
        this.mDragging = false;
        this.mFlingSpeed = 500.0f;
        this.mFlingRemoveListener = new C04631();
        this.mDslv = dslv;
        this.mDetector = new GestureDetector(dslv.getContext(), this);
        this.mFlingRemoveDetector = new GestureDetector(dslv.getContext(), this.mFlingRemoveListener);
        this.mFlingRemoveDetector.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(dslv.getContext()).getScaledTouchSlop();
        this.mDragHandleId = dragHandleId;
        this.mClickRemoveId = clickRemoveId;
        this.mFlingHandleId = flingHandleId;
        setRemoveMode(removeMode);
        setDragInitMode(dragInitMode);
    }

    public int getDragInitMode() {
        return this.mDragInitMode;
    }

    public void setDragInitMode(int mode) {
        this.mDragInitMode = mode;
    }

    public void setSortEnabled(boolean enabled) {
        this.mSortEnabled = enabled;
    }

    public boolean isSortEnabled() {
        return this.mSortEnabled;
    }

    public void setRemoveMode(int mode) {
        this.mRemoveMode = mode;
    }

    public int getRemoveMode() {
        return this.mRemoveMode;
    }

    public void setRemoveEnabled(boolean enabled) {
        this.mRemoveEnabled = enabled;
    }

    public boolean isRemoveEnabled() {
        return this.mRemoveEnabled;
    }

    public void setDragHandleId(int id) {
        this.mDragHandleId = id;
    }

    public void setFlingHandleId(int id) {
        this.mFlingHandleId = id;
    }

    public void setClickRemoveId(int id) {
        this.mClickRemoveId = id;
    }

    public boolean startDrag(int position, int deltaX, int deltaY) {
        int dragFlags = ON_DOWN;
        if (this.mSortEnabled && !this.mIsRemoving) {
            dragFlags = ON_DOWN | 12;
        }
        if (this.mRemoveEnabled && this.mIsRemoving) {
            dragFlags = (dragFlags | ON_DRAG) | ON_LONG_PRESS;
        }
        this.mDragging = this.mDslv.startDrag(position - this.mDslv.getHeaderViewsCount(), dragFlags, deltaX, deltaY);
        return this.mDragging;
    }

    public boolean onTouch(View v, MotionEvent ev) {
        if (this.mDslv.isDragEnabled() && !this.mDslv.listViewIntercepted()) {
            this.mDetector.onTouchEvent(ev);
            if (this.mRemoveEnabled && this.mDragging && this.mRemoveMode == ON_DRAG) {
                this.mFlingRemoveDetector.onTouchEvent(ev);
            }
            switch (ev.getAction() & MotionEventCompat.ACTION_MASK) {
                case ON_DOWN /*0*/:
                    this.mCurrX = (int) ev.getX();
                    this.mCurrY = (int) ev.getY();
                    break;
                case ON_DRAG /*1*/:
                    if (this.mRemoveEnabled && this.mIsRemoving) {
                        int x;
                        if (this.mPositionX >= 0) {
                            x = this.mPositionX;
                        } else {
                            x = -this.mPositionX;
                        }
                        if (x > this.mDslv.getWidth() / ON_LONG_PRESS) {
                            this.mDslv.stopDragWithVelocity(true, 0.0f);
                            break;
                        }
                    }
                    break;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    break;
                default:
                    break;
            }
            this.mIsRemoving = false;
            this.mDragging = false;
        }
        return false;
    }

    public void onDragFloatView(View floatView, Point position, Point touch) {
        if (this.mRemoveEnabled && this.mIsRemoving) {
            this.mPositionX = position.x;
        }
    }

    public int startDragPosition(MotionEvent ev) {
        return dragHandleHitPosition(ev);
    }

    public int startFlingPosition(MotionEvent ev) {
        return this.mRemoveMode == ON_DRAG ? flingHandleHitPosition(ev) : MISS;
    }

    public int dragHandleHitPosition(MotionEvent ev) {
        return viewIdHitPosition(ev, this.mDragHandleId);
    }

    public int flingHandleHitPosition(MotionEvent ev) {
        return viewIdHitPosition(ev, this.mFlingHandleId);
    }

    public int viewIdHitPosition(MotionEvent ev, int id) {
        int touchPos = this.mDslv.pointToPosition((int) ev.getX(), (int) ev.getY());
        int numHeaders = this.mDslv.getHeaderViewsCount();
        int numFooters = this.mDslv.getFooterViewsCount();
        int count = this.mDslv.getCount();
        if (touchPos != MISS && touchPos >= numHeaders && touchPos < count - numFooters) {
            View item = this.mDslv.getChildAt(touchPos - this.mDslv.getFirstVisiblePosition());
            int rawX = (int) ev.getRawX();
            int rawY = (int) ev.getRawY();
            View dragBox = id == 0 ? item : item.findViewById(id);
            if (dragBox != null) {
                dragBox.getLocationOnScreen(this.mTempLoc);
                if (rawX > this.mTempLoc[ON_DOWN] && rawY > this.mTempLoc[ON_DRAG] && rawX < this.mTempLoc[ON_DOWN] + dragBox.getWidth() && rawY < this.mTempLoc[ON_DRAG] + dragBox.getHeight()) {
                    this.mItemX = item.getLeft();
                    this.mItemY = item.getTop();
                    return touchPos;
                }
            }
        }
        return MISS;
    }

    public boolean onDown(MotionEvent ev) {
        if (this.mRemoveEnabled && this.mRemoveMode == 0) {
            this.mClickRemoveHitPos = viewIdHitPosition(ev, this.mClickRemoveId);
        }
        this.mHitPos = startDragPosition(ev);
        if (this.mHitPos != MISS && this.mDragInitMode == 0) {
            startDrag(this.mHitPos, ((int) ev.getX()) - this.mItemX, ((int) ev.getY()) - this.mItemY);
        }
        this.mIsRemoving = false;
        this.mCanDrag = true;
        this.mPositionX = ON_DOWN;
        this.mFlingHitPos = startFlingPosition(ev);
        return true;
    }

    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        int x1 = (int) e1.getX();
        int y1 = (int) e1.getY();
        int x2 = (int) e2.getX();
        int y2 = (int) e2.getY();
        int deltaX = x2 - this.mItemX;
        int deltaY = y2 - this.mItemY;
        if (!(!this.mCanDrag || this.mDragging || (this.mHitPos == MISS && this.mFlingHitPos == MISS))) {
            if (this.mHitPos != MISS) {
                if (this.mDragInitMode == ON_DRAG && Math.abs(y2 - y1) > this.mTouchSlop && this.mSortEnabled) {
                    startDrag(this.mHitPos, deltaX, deltaY);
                } else if (this.mDragInitMode != 0 && Math.abs(x2 - x1) > this.mTouchSlop && this.mRemoveEnabled) {
                    this.mIsRemoving = true;
                    startDrag(this.mFlingHitPos, deltaX, deltaY);
                }
            } else if (this.mFlingHitPos != MISS) {
                if (Math.abs(x2 - x1) > this.mTouchSlop && this.mRemoveEnabled) {
                    this.mIsRemoving = true;
                    startDrag(this.mFlingHitPos, deltaX, deltaY);
                } else if (Math.abs(y2 - y1) > this.mTouchSlop) {
                    this.mCanDrag = false;
                }
            }
        }
        return false;
    }

    public void onLongPress(MotionEvent e) {
        if (this.mHitPos != MISS && this.mDragInitMode == ON_LONG_PRESS) {
            this.mDslv.performHapticFeedback(ON_DOWN);
            startDrag(this.mHitPos, this.mCurrX - this.mItemX, this.mCurrY - this.mItemY);
        }
    }

    public final boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    public boolean onSingleTapUp(MotionEvent ev) {
        if (this.mRemoveEnabled && this.mRemoveMode == 0 && this.mClickRemoveHitPos != MISS) {
            this.mDslv.removeItem(this.mClickRemoveHitPos - this.mDslv.getHeaderViewsCount());
        }
        return true;
    }

    public void onShowPress(MotionEvent ev) {
    }
}
