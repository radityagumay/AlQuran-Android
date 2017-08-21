package android.alquran.radityalabs.net.alquran

import android.alquran.radityalabs.net.alquran.base.FragmentTestRule
import android.alquran.radityalabs.net.alquran.presentation.ui.fragment.SurahFragment
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import android.support.test.espresso.Espresso.*
import android.support.test.espresso.assertion.ViewAssertions.*
import android.support.test.espresso.matcher.ViewMatchers.*

class SurahFragmentTest {
    @get:Rule
    var surahFragmentRule: FragmentTestRule<SurahFragment> = FragmentTestRule(SurahFragment::class.java)

    @Before
    fun setup() {
        surahFragmentRule.launchActivity(null)
    }

    @Test
    fun test_that_fragment_should_instantiated() {
        onView(withId(R.id.surah)).check(matches(isDisplayed()))
    }
}