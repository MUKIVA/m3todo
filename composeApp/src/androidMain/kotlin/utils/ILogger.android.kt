package utils

import android.util.Log

object Logger : ILogger {

    private const val DEFAULT_TAG = "M3ToDo"

    override fun log(message: String) {
        Log.d(DEFAULT_TAG, message)
    }
}

actual val platformLogger: ILogger
    get() = Logger