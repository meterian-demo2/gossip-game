package persons.impl

import org.junit.Assert
import org.junit.Test

class SirTest {

    private val sirGray = Sir("Gray")
    private val mrOrange = Mister("Orange")

    @Test
    fun should_not_tell_the_secret_nor_forget_it() {
        sirGray.talksWith(mrOrange);
        sirGray.tellSecret("Gossip8")
        sirGray.propagate()
        Assert.assertEquals("", mrOrange.ask())
        Assert.assertEquals("Gossip8", sirGray.ask())
    }

    @Test
    fun should_answer_the_last_secret() {
        sirGray.tellSecret("Gossip8")
        Assert.assertEquals("Gossip8", sirGray.ask())
        sirGray.tellSecret("Gossip9")
        Assert.assertEquals("Gossip9", sirGray.ask())
        sirGray.tellSecret("Gossip10")
        Assert.assertEquals("Gossip10", sirGray.ask())
    }

    @Test
    fun should_never_forget_a_secret() {
        sirGray.tellSecret("Gossip8")
        sirGray.tellSecret("Gossip9")
        sirGray.tellSecret("Gossip10")
        sirGray.tellSecret("Gossip11")
        Assert.assertEquals(4, sirGray.askHowMany())
    }

}