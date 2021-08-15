package engine

import persons.Person

class GossipGame(private val players: List<Person>) {

    fun propagate() {
        println("*** PROPAGATE ***")
        print("Order: ")
        for (player in players) {
            print("${player.name} ")
            player.propagate()
        }
        println("\n")
        render()
    }

    fun render() {
        println("This is the situation right now:")
        for (player in players) {
            println(" * $player")
        }
        println("")
    }

}