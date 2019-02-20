package  casboard

import java.util.logging.Level
import java.util.logging.Logger

private val logger = Logger.getLogger(CASBOARD_NAME)
private fun log(level:Level, text:String) = logger.log(level, text)

fun info(text:String) = log(Level.INFO, text)

fun warning(text:String) = log(Level.WARNING, text)

fun error(text:String) = log(Level.SEVERE, text)

fun fatal_error(text:String) {
    log(Level.SEVERE, "FATAL: $text")
    System.exit(1)
}