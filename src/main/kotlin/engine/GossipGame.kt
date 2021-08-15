package engine

import persons.Person

class GossipGame(private val players: List<Person>) {

    fun propagate() {
        println("*** PROPAGATE ***\n")
        for (player in players) {
            player.propagate()
        }
        render()
    }

    fun render() {
        println("This is the situation right now:")
        for (player in players) {
            println(player)
        }
        println("")
    }

}