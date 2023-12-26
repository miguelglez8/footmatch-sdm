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
class MostrarLigaTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainRecycler::class.java)

    @Test
    fun mostrarLigaTest() {
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

        val appCompatImageButton = onView(
            allOf(
                withId(R.id.ligaEASports),
                childAtPosition(
                    allOf(
                        withId(R.id.linearLayoutLigas),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatImageButton.perform(click())

        Thread.sleep(2000)

        val textView = onView(
            allOf(
                withId(R.id.nombreLiga), withText("Primera Division"),
                withParent(withParent(withId(R.id.linear2))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Primera Division")))

        val imageView = onView(
            allOf(
                withId(R.id.logoLiga),
                withParent(
                    allOf(
                        withId(R.id.linear2),
                        withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageView.check(matches(isDisplayed()))

        val textView2 = onView(
            allOf(
                withText("Champions"),
                withParent(withParent(withId(R.id.paletaLayout))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Champions")))

        val textView3 = onView(
            allOf(
                withText("Europa"),
                withParent(withParent(withId(R.id.paletaLayout))),
                isDisplayed()
            )
        )
        textView3.check(matches(withText("Europa")))

        val textView4 = onView(
            allOf(
                withText("Conference"),
                withParent(withParent(withId(R.id.paletaLayout))),
                isDisplayed()
            )
        )
        textView4.check(matches(withText("Conference")))

        val textView5 = onView(
            allOf(
                withText("Descenso"),
                withParent(withParent(withId(R.id.paletaLayout))),
                isDisplayed()
            )
        )
        textView5.check(matches(withText("Descenso")))

        val textView6 = onView(
            allOf(
                withText("POS"),
                withParent(withParent(withId(R.id.tableLayout))),
                isDisplayed()
            )
        )
        textView6.check(matches(withText("POS")))

        val textView7 = onView(
            allOf(
                withText("EQUIPO"),
                withParent(withParent(withId(R.id.tableLayout))),
                isDisplayed()
            )
        )
        textView7.check(matches(withText("EQUIPO")))

        val textView8 = onView(
            allOf(
                withText("PG"),
                withParent(withParent(withId(R.id.tableLayout))),
                isDisplayed()
            )
        )
        textView8.check(matches(withText("PG")))

        val textView9 = onView(
            allOf(
                withText("PE"),
                withParent(withParent(withId(R.id.tableLayout))),
                isDisplayed()
            )
        )
        textView9.check(matches(withText("PE")))

        val textView10 = onView(
            allOf(
                withText("PP"),
                withParent(withParent(withId(R.id.tableLayout))),
                isDisplayed()
            )
        )
        textView10.check(matches(withText("PP")))

        val textView11 = onView(
            allOf(
                withText("GF"),
                withParent(withParent(withId(R.id.tableLayout))),
                isDisplayed()
            )
        )
        textView11.check(matches(withText("GF")))

        val textView12 = onView(
            allOf(
                withText("GC"),
                withParent(withParent(withId(R.id.tableLayout))),
                isDisplayed()
            )
        )
        textView12.check(matches(withText("GC")))

        val textView13 = onView(
            allOf(
                withText("DG"),
                withParent(withParent(withId(R.id.tableLayout))),
                isDisplayed()
            )
        )
        textView13.check(matches(withText("DG")))

        val textView14 = onView(
            allOf(
                withText("PT"),
                withParent(withParent(withId(R.id.tableLayout))),
                isDisplayed()
            )
        )
        textView14.check(matches(withText("PT")))

        val textView15 = onView(
            allOf(
                withId(R.id.posClasificacion), withText("1"),
                withParent(
                    allOf(
                        withId(R.id.tuTableRow),
                        withParent(withId(R.id.tableLayout))
                    )
                ),
                isDisplayed()
            )
        )
        textView15.check(matches(withText("1")))

        val textView16 = onView(
            allOf(
                withId(R.id.posClasificacion), withText("2"),
                withParent(
                    allOf(
                        withId(R.id.tuTableRow),
                        withParent(withId(R.id.tableLayout))
                    )
                ),
                isDisplayed()
            )
        )
        textView16.check(matches(withText("2")))
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
