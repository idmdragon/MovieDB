package com.idm.moviedb.utils

import java.util.concurrent.Executor

class TestExecutor : Executor {
    override fun execute(command: Runnable?) {
        command?.run()
    }
}