package persons.impl

import persons.Person

/**
 * Broadcast the secret to every friend in a single propagation, then forget about it.
 */
class Lady(name: String): Person(name) {

    override fun doPropagate() {
        for (friend in friends) {
            friend.tellSecret(memory.get()!!)
        }
        memory.forget()
    }

}