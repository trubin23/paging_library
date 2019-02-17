package ru.trubin23.paging_library

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor

class MainThreadExecutor : Executor {

    private final val handler = Handler(Looper.getMainLooper())

    override fun execute(command: Runnable?) {
        handler.post(command)
    }
}