import person.Person
import propagation.PropagationStrategy

class GossipGame(
    private val players: List<Person>,
    private val propagationStrategy: PropagationStrategy
) {

    fun propagate() {
        println("*** PROPAGATE ***")
        propagationStrategy.propagate(players)
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