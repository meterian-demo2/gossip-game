package person.impl

import person.Person

/**
 * Tells the secret to a new friend every turn, then forget about it. Can remember a single secret.
 */
open class Mister(name: String): Person(name) {

    private val alreadyTold = hashSetOf<Person>()

    override fun doPropagate() {
        val secret = memory.get()!!
        for (person in friends) {
            if (!alreadyTold.contains(person)) {
                person.tellSecret(secret)
                alreadyTold.add(person)
                if (alreadyTold.size < friends.size)
                    return
            }
        }
        alreadyTold.clear()
        memory.forget()
    }

}