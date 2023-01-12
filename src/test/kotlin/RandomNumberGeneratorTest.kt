import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RandomNumberGeneratorTest {

    @Test
    fun `getRandom returns value between 0 and 100`() {
        val random = getRandom(100)
        assert(random in 0..100)
    }

    @Test
    fun `getRandom throws exception when negative value is passed`() {
        assertThrows<IllegalArgumentException> { getRandom(-1) }
    }

}