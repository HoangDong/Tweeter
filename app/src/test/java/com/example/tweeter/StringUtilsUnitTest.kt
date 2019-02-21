package com.example.tweeter

import com.example.tweeter.utils.StringUtils
import org.junit.Test

import org.junit.Assert.*
class StringUtilsUnitTest {

    private val limit = 50
    private val inputErrorSpan="I can't believebelievebelievebelievebelievebelievebelievebelievebelieve  do it myself."

    @Test(expected = Exception::class)
    fun splitMessageErrorEmpty() {
        //Error Empty
        StringUtils.splitMessage("",limit)
    }

    @Test(expected = Exception::class)
    fun splitMessageErrorSpan() {
        //Error container word span of non-whitespace
        StringUtils.splitMessage(inputErrorSpan,limit)
    }

    @Test
    fun splitMessage() {
        //Test split
        val input3 = "I can't believe Tweeter now supports chunking my messages, so I don't have to do it myself."
        val expected3 = arrayOf("1/2 I can't believe Tweeter now supports chunking",
            "2/2 my messages, so I don't have to do it myself.")
        val output3=StringUtils.splitMessage(input3,limit)
        assertEquals(expected3, output3)

    }
}
