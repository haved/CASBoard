package casboard.resource

import casboard.logWarning

class Strings(private val fileName:String) {

    private val map = HashMap<String, String>()

    init {

    }

    fun getString(name: String, vararg args: Any):String {
        map[name]?.let {
            return java.lang.String.format(it, *args)
        }
        logWarning("String not found in language ${fileName}: ${name}")
        return name
    }

}