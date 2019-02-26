package casboard.model

class Watched<T>(value: T) {
    private var value: T = value

    private val listeners = ArrayList<Listener<T>>()
    interface Listener<T> {
        fun onChange(old:T, new:T)
    }
}