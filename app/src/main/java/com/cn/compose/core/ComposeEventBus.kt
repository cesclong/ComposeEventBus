package com.cn.compose.core

import kotlinx.coroutines.flow.MutableSharedFlow
import java.util.Objects

/**
 * <类说明 必填>
 *
 * @author  shilong
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2023/5/7]
 */

/**
 * public synchronized <T> Observable<T> with(String key, Class<T> type) {
if (!bus.containsKey(key)) {
bus.put(key, new BusLiveEvent<>(key));
}
return (Observable<T>) bus.get(key);
}

public Observable<Object> with(String key) {
return with(key, Object.class);
}
 */

object ComposeEventBus {
    //Kotlin 中有等效的写法：* 号，相当于 out Any
    private val events: HashMap<String, Event<out Any>> = HashMap()

    fun <T : Any> with(key: String, isSticky: Boolean): Event<out Any> {
        if (!events.containsKey(key)) {
            events[key] = Event<T>(key = key, isSticky = isSticky)
        }
        return events[key]!!
    }


    // fun getFlow(clazz: Class<*>) {
    //     events.getOrPut(clazz) {
    //         MutableSharedFlow(
    //             replay = 0,
    //             extraBufferCapacity = Int.MAX_VALUE
    //         )
    //     }
    // }

    // fun test() {
    //     getFlow(User::class.java)
    // }
    //
    // fun <T> postEvent(value: T) {
    //     val clazz = value!!::class.java
    //     getFlow(clazz)
    //
    // }
}

data class User(val name: String)
