package persons.impl

import persons.Person

/**
 * Tells the secret to the same person who told him, then forget.
 */
class Idiot(name: String): Person(name) {

    override fun doPropagate() {
        val secret = memory.get()!!
        secret.origin.tellSecret(secret)
        memory.forget()
    }

}