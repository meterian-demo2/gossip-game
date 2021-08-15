package memory

interface Memory {
    fun get(): Secret?
    fun put(secret: Secret)
    fun forget()
    fun isEmpty(): Boolean
    fun size(): Int
}