// точка входа
fun main() {
    val objCommon = CommonClass()
    objCommon.loud();

    println(Choice.name)
    Choice.showDescription("pick")
    Choice.showDescription("selection")
    FishTank.splitFish()
    triplePrint()
    destructureTtiplePrint()
    workWithCollection()
    workWithHashMap()
    workExtended()
}

// обычный класс со свойствами и методами
class CommonClass {
    val variable: String = "Example"
    fun loud() = println(variable)
}

// класс с объектом синглтоном (сопуствующий объект)
class Choice {
    companion object {
        var name: String = "lyric"
        fun showDescription(name:String) = println("My favorite $name")
    }
}

// дата-класс, работа с коллекциями
data class Fish(val name: String, val freshwater: Boolean)
object FishTank {
    val fishList = listOf(
        Fish("Goldfish", true),
        Fish("Clownfish", false),
        Fish("Guppy", true),
        Fish("Salmon", false),
        Fish("Betta", true)
    )

    fun isFreshWater(fish: Fish) = fish.freshwater

    fun splitFish() {
        val (freshwater, saltwater) = fishList.partition { isFreshWater(it) }
        println("Freshwater fish: $freshwater")
        println("Saltwater fish: $saltwater")
    }
}

// работа, с pair и tripple, как частный случай data-class

fun triplePrint() {
    val numbers = Triple(6, 9, 42)
    println(numbers.toString())
    println(numbers.toList())
}

fun destructureTtiplePrint() {
    val numbers = Triple(6, 9, 42)
    val (n1, n2, n3) = numbers
    println("$n1 $n2 $n3")
}
// работа с коллекциями
fun workWithCollection() {
    val list = listOf(1, 5, 3, 4)
    println(list.sum())
    val list2 = listOf("a", "bbb", "cc")
    println(list2.sumBy { it.length })
    val list3 = listOf("a", "bbb", "cc")
    for (s in list3.listIterator()) {
        println("$s ")
    }
}

// работа с словарем
fun workWithHashMap() {
    val scientific = hashMapOf(
        "guppy" to "poecilia reticulata",
        "catfish" to "corydoras",
        "zebra fish" to "danio rerio"
    )
    println (scientific.get("guppy"))
    println(scientific.get("zebra fish"))
    println(scientific.getOrDefault("swordtail", "sorry, I don't know"))
}

// работа с true константами
const val rocks = 3
class MyClass {
    companion object {
        const val CONSTANT3 = "constant in companion"
    }
}

//работа с расширениями функций класса
class AquariumPlant(val name: String) {
    override fun toString(): String = name
}
fun workExtended() {
    val plant1: AquariumPlant? = AquariumPlant("Fern")
    val plant2: AquariumPlant? = null
    fun AquariumPlant?.pull() {
        this?.apply { println("removing $this") }
    }

    plant1.pull()
    plant2.pull()
}

