# Tweeter Project
![Sweeter](https://github.com/HoangDong/Tweeter/blob/master/documents/img_logo.png)

The product Tweeter allows users to post short messages limited to 50 characters each.
Sometimes, users get excited and write messages longer than 50 characters.
Instead of rejecting these messages, we would like to add a new feature that will split the message into parts and send multiple messages on the user's behalf, all of them meeting the 50 character requirement.

# Exemple
Suppose the user wants to send the following message:
+ "I can't believe Tweeter now supports chunking my messages, so I don't have to do it myself."

When the user presses send, it will send the following messages:

+ "1/2 I can't believe Tweeter now supports chunking" "2/2 my messages, so I don't have to do it myself."

# ScreenShot
<p align="middle">
  <img src="https://github.com/HoangDong/Tweeter/blob/master/documents/screen_1.jpg" width="200" />
  <img src="https://github.com/HoangDong/Tweeter/blob/master/documents/screen_2.jpg" width="200" /> 
  <img src="https://github.com/HoangDong/Tweeter/blob/master/documents/screen_3.jpg" width="200" /> 
  <img src="https://github.com/HoangDong/Tweeter/blob/master/documents/screen_4.jpg" width="200" /> 
</p>

# Git Branchs
+ Develop: For development
+ Master: Stable can release

# Application Development Environment
+ IDE: Android Studio
+ Languge: Kotlin

# Architecture Pattern
+ MVVM + Room + Binding Data + ViewModel + RxJava/RxAndroid

# Use split string
Call method from file [StringUtils.kt](https://github.com/HoangDong/Tweeter/blob/master/app/src/main/java/com/example/tweeter/utils/StringUtils.kt)
```kotlin
object StringUtils {
    fun splitMessage(input: String, limitChar: Int): Array<String> {
    ...................
}
```
Params:
+ Input: String that you would like to split
+ limitChar: Number of char that you want limit

# How to Test
All unit test you can check from file
 [StringUtilsUnitTest.kt](https://github.com/HoangDong/Tweeter/blob/master/app/src/test/java/com/example/tweeter/StringUtilsUnitTest.kt)
```kotlin
class StringUtilsUnitTest {

    @Test(expected = Exception::class)
    fun splitMessageErrorEmpty() {
    ...................
    }
    
    @Test(expected = Exception::class)
    fun splitMessageErrorSpan() {
    ...................
    }
    
    @Test
    fun splitMessage() {
    ...................
    }
```
}

Functions:
+ splitMessageErrorEmpty: Test when input is empty
+ splitMessageErrorSpan: Test when input container word length > 50
+ splitMessage: Test split input success
