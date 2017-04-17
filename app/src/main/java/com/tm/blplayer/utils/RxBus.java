package com.tm.blplayer.utils;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * @author wutongming
 * @description 事件总线
 * @since 2017/4/17
 */

public class RxBus {

    private static volatile RxBus mRxBus = null;

    /**
     * PublishSubject只会把订阅发生的地点之后来自原始Observable的数据发射观察者
     */
    private Subject<Object, Object> mRxBusObserver = new SerializedSubject<>(PublishSubject.create());

    private RxBus() {
    }

    public static RxBus getInstance() {
        if (mRxBus == null) {
            synchronized (RxBus.class) {
                if (mRxBus == null) {
                    mRxBus = new RxBus();
                }
            }
        }
        return mRxBus;
    }

    public void post(Object o) {
        if (hasObservers()) {
            mRxBusObserver.onNext(o);
        }
    }

    public Observable<Object> toObserverable() {
        return mRxBusObserver;
    }

    /**
     * 判断是否有订阅者
     */
    public boolean hasObservers() {
        return mRxBusObserver.hasObservers();
    }

}
