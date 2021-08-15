package persons.impl

import org.junit.Assert
import org.junit.Test

class DoctorTest {

    private val drBlack = Doctor("Black")
    private val mrPink = Mister("Pink")
    private val mrBrown = Mister("Brown")

    @Test
    fun should_tell_the_secret_to_a_single_friend_every_propagation_then_forget_it() {

        drBlack.talksWith(mrPink)
        drBlack.talksWith(mrBrown)
        drBlack.tellSecret("Gossip1")
        Assert.assertEquals("Gossip1", drBlack.ask())
        Assert.assertEquals("", mrPink.ask())
        Assert.assertEquals("", mrBrown.ask())
        drBlack.propagate()
        Assert.assertEquals("Gossip1", drBlack.ask())
        Assert.assertEquals("Gossip1", mrPink.ask())
        Assert.assertEquals("", mrBrown.ask())
        drBlack.propagate()
        Assert.assertEquals("", drBlack.ask())
        Assert.assertEquals("Gossip1", mrPink.ask())
        Assert.assertEquals("Gossip1", mrBrown.ask())

    }

    @Test
    fun should_remember_multiple_secrets() {
        drBlack.talksWith(mrPink)
        drBlack.talksWith(mrBrown)
        drBlack.tellSecret("Gossip1")
        drBlack.tellSecret("Gossip2")
        Assert.assertEquals("Gossip1", drBlack.ask())
        Assert.assertEquals("", mrPink.ask())
        Assert.assertEquals("", mrBrown.ask())
        drBlack.propagate()
        Assert.assertEquals("Gossip1", drBlack.ask())
        Assert.assertEquals("Gossip1", mrPink.ask())
        Assert.assertEquals("", mrBrown.ask())
        drBlack.propagate()
        Assert.assertEquals("Gossip2", drBlack.ask())
        Assert.assertEquals("Gossip1", mrPink.ask())
        Assert.assertEquals("Gossip1", mrBrown.ask())
        drBlack.propagate()
        Assert.assertEquals("Gossip2", drBlack.ask())
        Assert.assertEquals("Gossip2", mrPink.ask())
        Assert.assertEquals("Gossip1", mrBrown.ask())
        drBlack.propagate()
        Assert.assertEquals("", drBlack.ask())
        Assert.assertEquals("Gossip2", mrPink.ask())
        Assert.assertEquals("Gossip2", mrBrown.ask())
    }

}