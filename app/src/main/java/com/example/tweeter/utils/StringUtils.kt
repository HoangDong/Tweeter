package com.example.tweeter.utils


object StringUtils {
    fun splitMessage(input: String, limitChar: Int): Array<String> {

        //Return if empty
        if(input.isEmpty())
            throw IllegalArgumentException("The message is empty")

        //Estimate number split
        var estSplit = Math.ceil(input.length / limitChar.toDouble()).toInt()
        var results: Array<String>

        //User's input is less than or equal to limit characters
        if (input.length <= limitChar) {
            results = arrayOf(input)
            return results
        }
        //Check have word span of non-whitespace characters longer than limit characters
        if (checkErrorLimitWord(input,limitChar)) {
            throw IllegalArgumentException("The message contains a span of non-whitespace characters longer than 50 characters")
        }

        var tempMsg: String
        // Remove all extra white space
        val inputMsg = input.trim().replace("\\s+".toRegex(), " ")
        do {
            tempMsg = inputMsg
            results = Array(estSplit) { "" }
            var prefix: String
            var msg: String
            for (i in 1..estSplit) {
                prefix = "$i/$estSplit"
                tempMsg = "$prefix $tempMsg"

                //Get first most possible child string
                msg = getFirstMostPossibleChildString(tempMsg, limitChar)
                if (msg == prefix) {
                    results = arrayOf()
                    tempMsg = ""
                    break
                } else {
                    results[i - 1] = msg
                    tempMsg = tempMsg.substring(msg.length, tempMsg.length)

                    if (tempMsg.isNotEmpty()) {
                        //delete first white space character
                        tempMsg = tempMsg.substring(1, tempMsg.length)
                    }
                }
            }
            estSplit += 1
        } while (tempMsg.isNotEmpty())

        return results
    }

    private fun checkErrorLimitWord(inputMsg: String, limitChar: Int): Boolean {
        val words = inputMsg.split(" ")
        for (word in words) {
            if (word.length > limitChar)
                return true
        }
        return false
    }

    private fun getFirstMostPossibleChildString(inputString: String, limitChar: Int): String {
        return if (inputString.length <= limitChar) {
            inputString
        } else {
            inputString.substring(0, getMostPossibleWhiteSpacePosition(inputString, limitChar))
        }
    }

    private fun getMostPossibleWhiteSpacePosition(input: String, limitChar: Int): Int {
        var inputString = input
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