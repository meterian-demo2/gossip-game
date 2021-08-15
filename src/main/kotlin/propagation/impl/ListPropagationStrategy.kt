package propagation.impl

import propagation.PropagationStrategy
import person.Person

class ListPropagationStrategy: PropagationStrategy {

    override fun propagate(players: List<Person>) {
        for (player in players) {
            player.propagate()
        }
    }

}