@file:Suppress("EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE")

package utils

interface ILogger {

    fun log(message: String)

}

expect val platformLogger: ILogger