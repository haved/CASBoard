package casboard.model

class Watched<T>(value: T) {
    private var value: T = value

    private val listeners = ArrayList<Listener<T>>()
    interface Listener<T> {
        fun onChanged(old:T?, new:T?)
    }

    fun set(new_val:T) {
        val old_val = value
        value = new_val
        for(l in listeners)
            l.onChanged(old_val, new_val)
    }

    fun get() = value

    fun addListener(l:Listener<T>, retroactive:Boolean) {
        listeners.add(l)
        if(retroactive)
            l.onChanged(null, value)
    }

    fun removeListener(l:Listener<T>, retroactive:Boolean) {
        if(retroactive)
            l.onChanged(value, null)
        listeners.remove(l)
    }
}