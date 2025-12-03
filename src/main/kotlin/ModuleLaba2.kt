package org.example

fun randomDay(): String {
    return listOf(
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday"
    ).random()
}

fun fishFood (day : String) : String {
    var food = ""
    when (day) {
        "Monday" -> food = "flakes"
        "Tuesday" -> food = "pellets"
        "Wednesday" -> food = "redworms"
        "Thursday" -> food = "granules"
        "Friday" -> food = "mosquitoes"
        "Saturday" -> food = "lettuce"
        "Sunday" -> food = "plankton"
    }
    return food
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)

    println ("Today is $day and the fish eat $food")
}
fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else  -> false
    }
}

val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

val mysports = listOf("basketball", "fishing", "running")
val myplayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
val mycities = listOf("Los Angeles", "Chicago", "Jamaica")
val mylist = listOf(mysports, myplayers, mycities)     // list of lists

var dirtyLevel = 20
val waterFilter = { dirty : Int -> dirty / 2}
var dirtyLevel2 = 19

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun main() {
    //
    val isUnit = println("This is an expression")
    println(isUnit)
    //
    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)
    //
    val temperature2 = 10
    val message = "The water temperature is ${ if (temperature2 > 50) "too warm" else "OK" }."
    println(message)
    // вызов фиш функций:
    println(randomDay())
    println(feedTheFish())
    println(fishFood("Monday"))
    // вызов компактных функций
    println(isTooHot(10))
    println(isDirty(5))
    println(isSunday("Monday"))
    println(shouldChangeWater("Monday"))
    // вызов фильтров
    println( decorations.filter {it[0] == 'p'})
    println("-----")
    println("Flat: ${mylist.flatten()}")
    // вызов лямбда-функций
    println(waterFilter(dirtyLevel))
    dirtyLevel = updateDirty(dirtyLevel) { dirtyLevel -> dirtyLevel2 + 23}
    println(dirtyLevel)

}