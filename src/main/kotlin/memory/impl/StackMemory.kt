package memory.impl

import memory.Memory
import memory.Secret
import java.util.*

class StackMemory: Memory {

    private val secrets = ArrayDeque<Secret>()

    override fun get(): Secret? = secrets.peek()

    override fun put(secret: Secret) {
        secrets.push(secret)
    }

    override fun forget() {
        secrets.poll()
    }

    override fun isEmpty(): Boolean = secrets.isEmpty()

    override fun size(): Int = secrets.size

}