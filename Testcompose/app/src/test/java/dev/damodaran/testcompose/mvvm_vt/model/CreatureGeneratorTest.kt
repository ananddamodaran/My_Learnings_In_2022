package dev.damodaran.testcompose.mvvm_vt.model

import dev.damodaran.testcompose.mvvm_vt.model.Creature
import dev.damodaran.testcompose.mvvm_vt.model.CreatureAttributes
import dev.damodaran.testcompose.mvvm_vt.model.CreatureGenerator
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CreatureGeneratorTest {
    private lateinit var creatureGenerator: CreatureGenerator

    @Before
    fun setup() {
        creatureGenerator = CreatureGenerator()
    }

    @Test
    fun testGenerateHitPoints() {
        val attributes = CreatureAttributes(
            intelligence = 7,
            strength = 3,
            endurance = 10
        )
        val name = "Anand"
        val expectedCreature = Creature(attributes, 84, name)
        assertEquals(expectedCreature, creatureGenerator.generateCreature(attributes, name))
    }
}