package person

import memory.Memory
import memory.Secret
import memory.impl.SingletonMemory

abstract class Person(private val name: String) {

    companion object {
        var spreadOnReceiving: Boolean = false
    }

    protected val friends = mutableListOf<Person>()
    protected open val memory: Memory = SingletonMemory()

    fun propagate() {
        if (memory.isEmpty()) {
            println("${fullName()} knows nothing")
            return
        }
        doPropagate()
    }

    protected abstract fun doPropagate()

    fun talksWith(friend: Person) = friends.add(friend)

    fun talksWith(vararg friendsToAdd: Person) = friends.addAll(friendsToAdd)

    fun ask() = memory.get()?.secret ?: ""

    fun tellSecret(secret: String) = tellSecret(Secret(secret, this), false)

    private fun tellSecret(secret: Secret, propagate: Boolean = spreadOnReceiving) {
        memory.put(secret)
        if (propagate)
            propagate()
    }

    fun askHowManySecrets() = memory.size()

    private fun fullName() = "${this.javaClass.simpleName} $name"

    fun forget() {
        println("${fullName()} forgets \"${memory.get()!!.secret}\"")
        memory.forget()
    }

    fun spread(secret: Secret, to: Person) {
        println("${fullName()} tells \"${secret.secret}\" to ${to.fullName()}")
        to.tellSecret(secret)
    }

    override fun toString(): String {
        var output = "${this.fullName()} knows ${askHowManySecrets()} secret/s"
        if (askHowManySecrets() > 0) {
            output += " (thinking about \"${ask()}\" right now)"
        }
        output += ". Talks with: "
        if (friends.size > 0 ) {
            for (friend in friends) {
                output += "${friend.fullName()}, "
            }
        } else {
            output += "<none>"
        }
        return output
    }

}