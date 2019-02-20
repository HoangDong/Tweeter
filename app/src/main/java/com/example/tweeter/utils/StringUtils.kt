package com.example.tweeter.utils


object StringUtils {
    fun splitMessage(inputMsg: String, limitChar: Int) : Array<String> {

        var assumeNumberOfChildMessage = Math.ceil(inputMsg.length / limitChar.toDouble()).toInt()

        var results: Array<String>
        if (inputMsg.length < limitChar) {
            results = arrayOf(inputMsg)
            return results
        }
        if (!inputMsg.contains(" ")) {
            results = arrayOf()
            return results
        }
        var tempMsg: String
        //remove leading, trailing space and duplicate white space.
        val inputMsg = inputMsg.trim().replace("\\s+".toRegex(), " ")
        do {
            tempMsg = inputMsg
            results = Array(assumeNumberOfChildMessage) {""}
            var prefix: String
            var msg: String
            for (i in 1..assumeNumberOfChildMessage) {
                prefix = "$i/$assumeNumberOfChildMessage"
                tempMsg = "$prefix $tempMsg"
                msg = getFirstMostPossibleChildString(tempMsg,limitChar)
                if (msg == prefix) {
                    results = arrayOf()
                    tempMsg = ""
                    break
                } else {
                    results[i - 1] = msg
                    tempMsg = tempMsg.substring(msg.length, tempMsg.length)

                    if (tempMsg.isNotEmpty()) {
                        //delete first WHITE_SPACE character
                        tempMsg = tempMsg.substring(1, tempMsg.length)
                    }
                }
            }
            assumeNumberOfChildMessage += 1
        } while (tempMsg.isNotEmpty())

        return results
    }

    private fun getFirstMostPossibleChildString(inputString: String,limitChar: Int): String {
        return if (inputString.length <= limitChar) {
            inputString
        } else {
            inputString.substring(0, getMostPossibleWhiteSpacePosition(inputString,limitChar))
        }
    }

    private fun getMostPossibleWhiteSpacePosition(inputString: String,limitChar: Int): Int {
        var inputString = inputString
        var currentWhiteSpacePosition: Int
        var positionIsPossible = false

        do {
            currentWhiteSpacePosition = inputString.lastIndexOf(" ")
            if (currentWhiteSpacePosition < limitChar) {
                positionIsPossible = true
            } else {
                inputString = inputString.substring(0, currentWhiteSpacePosition)
            }
        } while (!positionIsPossible)
        return currentWhiteSpacePosition
    }
}