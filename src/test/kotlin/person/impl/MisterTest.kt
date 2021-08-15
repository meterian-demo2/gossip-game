package person.impl

import org.junit.Assert
import org.junit.Test

class MisterTest {

    private val mrBlue = Mister("Blue")
    private val mrPink = Mister("Pink")
    private val mrBrown = Mister("Brown")

    @Test
    fun should_tell_the_secret_to_a_single_friend_every_propagation_then_forget_it() {

        mrBlue.talksWith(mrPink)
        mrBlue.talksWith(mrBrown)
        mrBlue.tellSecret("Gossip1")
        Assert.assertEquals("Gossip1", mrBlue.ask())
        Assert.assertEquals("", mrPink.ask())
        Assert.assertEquals("", mrBrown.ask())
        mrBlue.propagate()
        Assert.assertEquals("Gossip1", mrBlue.ask())
        Assert.assertEquals("Gossip1", mrPink.ask())
        Assert.assertEquals("", mrBrown.ask())
        mrBlue.propagate()
        Assert.assertEquals("", mrBlue.ask())
        Assert.assertEquals("Gossip1", mrPink.ask())
        Assert.assertEquals("Gossip1", mrBrown.ask())

    }
}