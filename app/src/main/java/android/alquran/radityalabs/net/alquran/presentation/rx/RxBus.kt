package android.alquran.radityalabs.net.alquran.presentation.rx

import io.reactivex.disposables.Disposable
import io.reactivex.Flowable
import io.reactivex.functions.Consumer
import io.reactivex.processors.PublishProcessor

/**
 * Created by radityagumay on 8/12/17.
 */
class RxBus : RxExtension {
    companion object {
        val default: RxBus
            get() = RxBusHolder.sInstance
    }

    private val bus: PublishProcessor<Any> = PublishProcessor.create<Any>()

    private object RxBusHolder {
        val sInstance = RxBus()
    }

    fun post(o: Any) {
        bus.onNext(o)
    }

    fun <T> toObservable(eventType: Class<T>): Flowable<T> {
        return bus.ofType(eventType)
    }

    fun <T> toDefaultObservable(eventType: Class<T>, act: Consumer<T>): Disposable {
        return bus.ofType(eventType).compose(flowableNewThread()).subscribe(act)
    }
}
