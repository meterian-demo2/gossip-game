import person.impl.*
import propagation.impl.ListPropagationStrategy

fun main() {

    val mrBlue = Mister("Blue")
    val mrPink = Mister("Pink")
    val mrBrown = Mister("Brown")
    val ladyViolet = Lady("Violet")
    val drBlack = Doctor("Black")
    val sirGray = Sir("Gray")
    val redIdiot = Idiot("Red")

    mrBlue.talksWith(mrPink, mrBrown)
    ladyViolet.talksWith(mrBlue, mrPink, mrBrown, drBlack, sirGray, redIdiot)
    drBlack.talksWith(sirGray, ladyViolet, mrPink)

    mrBlue.tellSecret("First gossip")
    ladyViolet.tellSecret("Second gossip")
    drBlack.tellSecret("Third gossip")

    val game = GossipGame(
        listOf(mrBlue, mrPink, mrBrown, ladyViolet, drBlack, sirGray, redIdiot),
        ListPropagationStrategy()
    )

    game.summary()
    game.propagate()
    game.propagate()
    game.propagate()

}