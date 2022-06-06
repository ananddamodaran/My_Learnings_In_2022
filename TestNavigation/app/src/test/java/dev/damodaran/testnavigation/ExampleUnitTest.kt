package dev.damodaran.testnavigation

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
/** Define the type of function from A to B */
typealias Fun<A, B> = (A) -> B

/** A Predicate is a function returning a Boolean */
typealias Predicate<A> = Fun<A, Boolean>

class ExampleUnitTest {


    /** This is the after high order function */
    inline infix fun <A, B, C> Fun<B, C>.after(crossinline f: Fun<A, B>): Fun<A, C> =
        { a: A ->
            this(f(a))
        }

    fun twice(a: Int): Int = a * 2

    /** Format a string as a result */
    fun format(b: Int): String = "Result is $b"

    val f: Fun<Int, Int> = ::twice
    val g: Fun<Int, String> = ::format
    val formatTwice = g after f

    @Test
    fun addition_isCorrect() {
        assertEquals("Result is 74", formatTwice(37))
    }
}