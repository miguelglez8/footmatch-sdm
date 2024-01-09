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
import org.hamcrest.Matchers.`is`
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MostrarEquipoTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainRecycler::class.java)

    @Test
    fun mostrarEquipoTest() {
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

        val recyclerView = onView(
            allOf(
                withId(R.id.recyclerClasificacion),
                childAtPosition(
                    withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                    2
                )
            )
        )
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(0, click()))


        val textView3 = onView(
            allOf(
                withId(R.id.estadioP), withText("Estadio:"),
                withParent(withParent(withId(R.id.linearLayoutContainer))),
                isDisplayed()
            )
        )
        textView3.check(matches(withText("Estadio:")))

        val button = onView(
            allOf(
                withId(R.id.button), withText("VISITAR WEB"),
                withParent(
                    allOf(
                        withId(R.id.linearLayout),
                        withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        button.check(matches(isDisplayed()))

        val textView4 = onView(
            allOf(
                withId(R.id.nombre), withText("Entrenador"),
                withParent(
                    allOf(
                        withId(R.id.linearLayout2),
                        withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        textView4.check(matches(withText("Entrenador")))

        val textView5 = onView(
            allOf(
                withId(R.id.nombre2), withText("Plantilla"),
                withParent(
                    allOf(
                        withId(R.id.linearLayout3),
                        withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        textView5.check(matches(withText("Plantilla")))
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
