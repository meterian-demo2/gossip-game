package person.impl

import person.Person
import memory.impl.StackMemory

/**
 * Never tell secrets to anyone and never forgets them.
 */
class Sir(name: String): Person(name) {

    override val memory = StackMemory()

    override fun doPropagate() {}

}