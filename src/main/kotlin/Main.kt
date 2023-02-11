import HashMap.Key
import HashMap.MyHashMap

fun main(args: Array<String>) {
    val testMap = MyHashMap<String, String>()
    testMap.put("first","Hello")
    testMap.put("second","world")
    println(testMap.get("first"))
    println(testMap.get("second"))
}