package persons.impl

import org.junit.Assert
import org.junit.Test

import persons.impl.Lady
import persons.impl.Mister

class LadyTest {

    private val ladyViolet = Lady("Violet")
    private val mrBlue = Mister("Blue")
    private val mrBrown = Mister("Brown")

    @Test
    fun should_tell_the_secret_to_everyone_in_the_same_turn_and_then_forget_it() {
        ladyViolet.talksWith(mrBlue)
        ladyViolet.talksWith(mrBrown)
        ladyViolet.tellSecret("Gossip5")
        ladyViolet.propagate()
        Assert.assertEquals("Gossip5", mrBlue.ask())
        Assert.assertEquals("Gossip5", mrBrown.ask())
        Assert.assertEquals("", ladyViolet.ask())
    }
}