package dev.damodaran.testcompose.mvvm_vt.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import dev.damodaran.testcompose.mvvm_vt.model.Creature
import dev.damodaran.testcompose.mvvm_vt.model.CreatureAttributes
import dev.damodaran.testcompose.mvvm_vt.model.CreatureGenerator
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import junit.framework.Assert.assertEquals
import junit.framework.TestCase.assertNotNull

class CreatureViewModelTest{
    private lateinit var creatureViewModel: CreatureViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var mockGenerator: CreatureGenerator

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        creatureViewModel = CreatureViewModel(mockGenerator)
    }

    @Test
    fun testSetupCreature() {
        assertNotNull(mockGenerator);
        val attributes = CreatureAttributes(10, 3, 7)
        val stubCreature = Creature(attributes, 87, "Test Creature")
        `when`(mockGenerator.generateCreature(attributes)).thenReturn(stubCreature)

        creatureViewModel.intelligence = 10
        creatureViewModel.strength = 3
        creatureViewModel.endurance = 7

        creatureViewModel.updateCreature()

        assertEquals(stubCreature, creatureViewModel.creature)
    }
}