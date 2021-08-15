package person

import memory.Memory
import memory.Secret
import memory.impl.SingletonMemory

abstract class Person(private val name: String) {

    protected val friends = mutableListOf<Person>()
    protected open val memory: Memory = SingletonMemory()

    fun propagate() {
        if (memory.isEmpty())
            return
        doPropagate()
    }

    protected abstract fun doPropagate()

    fun talksWith(friend: Person) = friends.add(friend)

    fun talksWith(vararg friendsToAdd: Person) = friends.addAll(friendsToAdd)

    fun ask() = memory.get()?.secret ?: ""

    fun tellSecret(secret: String) = tellSecret(Secret(secret, this))

    fun tellSecret(secret: Secret) = memory.put(secret)

    fun askHowMany() = memory.size()

    override fun toString(): String {
        var output = "${this.javaClass.simpleName} $name knows ${askHowMany()} secret/s."
        if (askHowMany() > 0) {
            output += " Thinking about \"${ask()}\"."
        }
        return output
    }

}