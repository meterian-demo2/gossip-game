package propagation

import person.Person

interface PropagationStrategy {
    fun propagate(players: List<Person>)
}
