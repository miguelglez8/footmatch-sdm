package com.example.footmatch


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.contrib.RecyclerViewActions
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
class MostrarGoleadoresTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainRecycler::class.java)

    @Test
    fun mostrarGoleadoresTest2() {
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
                withId(R.id.goleadores),
                withParent(withParent(withId(R.id.linear2))),
                isDisplayed()
            )
        )
        imageView.check(matches(isDisplayed()))

        val appCompatImageView = onView(
            allOf(
                withId(R.id.goleadores),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.linear2),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageView.perform(click())

        Thread.sleep(2000)

        val textView2 = onView(
            allOf(
                withId(R.id.textView1_1), withText("GOLEADORES"),
                withParent(withParent(withId(R.id.equipo1Layout))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("GOLEADORES")))

        val imageView2 = onView(
            allOf(
                withId(R.id.imageView1_1),
                withParent(withParent(withId(R.id.equipo1Layout))),
                isDisplayed()
            )
        )
        imageView2.check(matches(isDisplayed()))
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
