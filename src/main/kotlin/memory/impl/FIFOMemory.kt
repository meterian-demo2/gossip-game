package memory.impl

import memory.Memory
import memory.Secret
import java.util.*

class FIFOMemory: Memory {

    private val secrets: Queue<Secret> = LinkedList()

    override fun get(): Secret? = secrets.peek()

    override fun put(secret: Secret) {
        secrets.add(secret)
    }

    override fun forget() {
        secrets.poll()
    }

    override fun isEmpty(): Boolean = secrets.isEmpty()

    override fun size(): Int = secrets.size

}