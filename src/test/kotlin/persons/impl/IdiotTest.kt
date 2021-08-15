package persons.impl

import org.junit.Assert
import org.junit.Test

class IdiotTest {

    private val redIdiot = Idiot("Red")
    private val ladyViolet = Lady("Violet")

    @Test
    fun should_tell_the_secret_to_the_same_person_who_told_him_and_then_forget_it() {
        ladyViolet.talksWith(redIdiot)
        ladyViolet.tellSecret("Gossip9")
        ladyViolet.propagate()
        Assert.assertEquals("Gossip9", redIdiot.ask())
        Assert.assertEquals("", ladyViolet.ask())
        redIdiot.propagate()
        Assert.assertEquals("Gossip9", ladyViolet.ask())
        Assert.assertEquals("", redIdiot.ask())
    }
}