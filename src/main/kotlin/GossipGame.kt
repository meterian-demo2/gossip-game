import person.Person
import propagation.PropagationStrategy

class GossipGame(
    private val players: List<Person>,
    private val propagationStrategy: PropagationStrategy
) {

    fun propagate() {
        println("*** PROPAGATE ***")
        propagationStrategy.propagate(players)
        summary()
    }

    fun summary() {
        println("\nThis is the situation:")
        for (player in players) {
            println(" * $player")
        }
        println("")
    }

}