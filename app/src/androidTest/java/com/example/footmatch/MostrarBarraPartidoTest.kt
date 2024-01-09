package com.example.footmatch


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.footmatch.presentacion.MainRecycler
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MostrarBarraPartidoTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainRecycler::class.java)

    @Test
    fun mostrarBarraPartido() {
        val bottomNavigationItemView = onView(
            allOf(
                withId(R.id.navigation_all), withContentDescription("Todos"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_view_matches_dates),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView.perform(click())

        Thread.sleep(2000)

        val recyclerView = onView(
            allOf(
                withId(R.id.recyclerViewPartidos),
                childAtPosition(
                    withId(R.id.swiperefresh),
                    0
                )
            )
        )
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(0, click()))

        Thread.sleep(2000)

        val textView = onView(
            allOf(
                withId(com.google.android.material.R.id.navigation_bar_item_large_label_view),
                withText("ESTADISTICAS"),
                withParent(
                    allOf(
                        withId(com.google.android.material.R.id.navigation_bar_item_labels_group),
                        withParent(
                            allOf(
                                withId(R.id.navigation_stats),
                                withContentDescription("ESTADISTICAS")
                            )
                        )
                    )
                ),
                isDisplayed()
            )
        )
        textView.check(matches(withText("ESTADISTICAS")))

        val textView2 = onView(
            allOf(
                withId(com.google.android.material.R.id.navigation_bar_item_small_label_view),
                withText("PLANTILLAS"),
                withParent(
                    allOf(
                        withId(com.google.android.material.R.id.navigation_bar_item_labels_group),
                        withParent(
                            allOf(
                                withId(R.id.navigation_alineations),
                                withContentDescription("PLANTILLAS")
                            )
                        )
                    )
                ),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("PLANTILLAS")))

        val textView3 = onView(
            allOf(
                withId(com.google.android.material.R.id.navigation_bar_item_small_label_view),
                withText("ARBITROS"),
                withParent(
                    allOf(
                        withId(com.google.android.material.R.id.navigation_bar_item_labels_group),
                        withParent(
                            allOf(
                                withId(R.id.navigation_referees),
                                withContentDescription("ARBITROS")
                            )
                        )
                    )
                ),
                isDisplayed()
            )
        )
        textView3.check(matches(withText("ARBITROS")))
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
