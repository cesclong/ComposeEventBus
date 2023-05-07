package com.cn.compose.core

import kotlinx.coroutines.flow.MutableSharedFlow

/**
 * <类说明 必填>
 *
 * @author  shilong
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2023/5/7]
 */
class Event<T>(
    private val key: String,
    private val isSticky: Boolean
) {
    private var _flow: MutableSharedFlow<T> = MutableSharedFlow(replay = if (isSticky) 1 else 0, extraBufferCapacity = Int.MAX_VALUE)

    val flow: MutableSharedFlow<T> = _flow


    fun post(){

    }
}