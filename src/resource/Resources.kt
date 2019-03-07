package casboard.resource

import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStream
import java.io.InputStreamReader

private val inJarFile = false

class Resources {
    companion object {
        fun getStream(fileName: String): InputStream {
            if (inJarFile)
                return javaClass.getResourceAsStream(fileName)
            return FileInputStream(fileName)
        }

        fun getBufferedReader(fileName: String) = BufferedReader(InputStreamReader(getStream(fileName)))
    }
}