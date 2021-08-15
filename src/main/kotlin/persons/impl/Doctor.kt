package persons.impl

import memory.impl.FIFOMemory

/**
 * Tells the secret to a friend every turn, then forget about it. Can remember multiple secrets.
 */
class Doctor(name: String): Mister(name) {
    override val memory = FIFOMemory()
}