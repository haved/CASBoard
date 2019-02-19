import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.InputStream

fun getStreamToOpt(path: String) : InputStream? {
    try {
        return FileInputStream("res/$path")
    } catch(e: FileNotFoundException) {
        warning("Failed to load resource: ${e.message}")
    }
    return null
}
//fun getStreamTo(url:String) : InputStream = object {}.javaClass.getResourceAsStream(url)