package com.example.footmatch


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.footmatch.presentacion.MainRecycler
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.`is`
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ClickarBotonInicioTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainRecycler::class.java)

    @Test
    fun clickarBotonInicioTest() {
        val appCompatImageButton = onView(
            allOf(
                withId(R.id.ligaPremier),
                childAtPosition(
                    allOf(
                        withId(R.id.linearLayoutLigas),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageButton.perform(click())

        Thread.sleep(2000)
        val bottomNavigationItemView = onView(
            allOf(
                withId(R.id.nav_home),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottomNavigationView),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView.perform(click())

        Thread.sleep(2000)
        val textView = onView(
            allOf(
                withText("FootMatch"),
                withParent(
                    allOf(
                        withId(androidx.appcompat.R.id.action_bar),
                        withParent(withId(androidx.appcompat.R.id.action_bar_container))
                    )
                ),
                isDisplayed()
            )
        )
        textView.check(matches(withText("FootMatch")))

        Thread.sleep(2000)

        val imageButton = onView(
            allOf(
                withId(R.id.ligaEASports),
                withParent(
                    allOf(
                        withId(R.id.linearLayoutLigas),
                        withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageButton.check(matches(isDisplayed()))

        Thread.sleep(2000)

        val imageButton2 = onView(
            allOf(
                withId(R.id.ligaPremier),
                withParent(
                    allOf(
                        withId(R.id.linearLayoutLigas),
                        withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageButton2.check(matches(isDisplayed()))

        Thread.sleep(2000)

        val imageButton3 = onView(
            allOf(
                withId(R.id.ligaSerieA),
                withParent(
                    allOf(
                        withId(R.id.linearLayoutLigas),
                        withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageButton3.check(matches(isDisplayed()))

        Thread.sleep(2000)

        val imageButton4 = onView(
            allOf(
                withId(R.id.ligaBundesliga),
                withParent(
                    allOf(
                        withId(R.id.linearLayoutLigas),
                        withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageButton4.check(matches(isDisplayed()))

        Thread.sleep(2000)

        val frameLayout = onView(
            allOf(
                withId(R.id.navigation_today), withContentDescription("Hoy"),
                withParent(withParent(withId(R.id.nav_view_matches_dates))),
                isDisplayed()
            )
        )
        frameLayout.check(matches(isDisplayed()))

        Thread.sleep(2000)

        val frameLayout2 = onView(
            allOf(
                withId(R.id.navigation_yesterday), withContentDescription("Ayer"),
                withParent(withParent(withId(R.id.nav_view_matches_dates))),
                isDisplayed()
            )
        )
        frameLayout2.check(matches(isDisplayed()))

        Thread.sleep(2000)

        val frameLayout3 = onView(
            allOf(
                withId(R.id.navigation_all), withContentDescription("Todos"),
                withParent(withParent(withId(R.id.nav_view_matches_dates))),
                isDisplayed()
            )
        )
        frameLayout3.check(matches(isDisplayed()))

        Thread.sleep(2000)

        val frameLayout4 = onView(
            allOf(
                withId(R.id.navigation_all), withContentDescription("Todos"),
                withParent(withParent(withId(R.id.nav_view_matches_dates))),
                isDisplayed()
            )
        )
        frameLayout4.check(matches(isDisplayed()))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
