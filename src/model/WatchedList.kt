package casboard.model

class WatchedList<T> {
    private val list = ArrayList<T>()

    private val listeners = ArrayList<Listener<T>>()
    interface Listener<T> {
        fun onAdd(added:T)
        fun onRemove(removed:T)
    }

    fun add(value: T) {
        list.add(value)
        for(l in listeners)
            l.onAdd(value)
    }

    fun remove(value: T) {
        list.remove(value)
    }
}