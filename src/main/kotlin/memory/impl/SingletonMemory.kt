package memory.impl

import memory.Memory
import memory.Secret

class SingletonMemory: Memory {

    private var secret: Secret? = null

    override fun get(): Secret? = secret

    override fun put(secret: Secret) {
        this.secret = secret
    }

    override fun forget() {
        this.secret = null
    }

    override fun isEmpty(): Boolean {
        return secret == null
    }

    override fun size(): Int = if (secret == null) { 0 } else { 1 }

}