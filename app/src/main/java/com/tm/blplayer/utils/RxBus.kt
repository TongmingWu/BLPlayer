package com.tm.blplayer.utils

import rx.Observable
import rx.subjects.PublishSubject
import rx.subjects.SerializedSubject

/**
 * @author wutongming
 * *
 * @description 事件总线
 * *
 * @since 2017/4/17
 */

class RxBus private constructor() {

    /**
     * PublishSubject只会把订阅发生的地点之后来自原始Observable的数据发射观察者
     */
    private val mRxBusObserver = SerializedSubject(PublishSubject.create<Any>())

    fun post(o: Any) {
        if (hasObservers()) {
            mRxBusObserver.onNext(o)
        }
    }

    fun toObserverable(): Observable<Any> {
        return mRxBusObserver
    }

    /**
     * 判断是否有订阅者
     */
    fun hasObservers(): Boolean {
        return mRxBusObserver.hasObservers()
    }

    companion object {
        fun newInstance(): RxBus = RxBus()
    }

}
