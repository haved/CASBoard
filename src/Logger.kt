package  casboard

import java.util.logging.Level
import java.util.logging.Logger

private val logger = Logger.getLogger(CASBOARD_NAME)
private fun log(level:Level, text:String) = logger.log(level, text)

fun logInfo(text:String) = log(Level.INFO, text)

fun logWarning(text:String) = log(Level.WARNING, text)

fun logError(text:String) = log(Level.SEVERE, text)

fun logFatalError(text:String) {
    log(Level.SEVERE, "FATAL: $text")
    System.exit(1)
}