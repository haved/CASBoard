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
        for(l in listeners)
            l.onRemove(value)
    }

    fun addListener(l:Listener<T>, retroactive:Boolean) {
        listeners.add(l)
        if(retroactive)
            for(i in list)
                l.onAdd(i)
    }


    fun removeListener(l:Listener<T>, retroactive:Boolean) {
        if(retroactive)
            for(i in list)
                l.onRemove(i)
        listeners.remove(l)
    }
}