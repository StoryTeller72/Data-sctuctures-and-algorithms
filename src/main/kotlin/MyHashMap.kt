class MyHashMap {
    val array = Array(16){
        ""
    }

    fun put(key: Int, value: String){
        if (key >= array.size) throw IllegalStateException("Key out of bound index")
        array[key] = value
    }

    fun get(key: Int): String?{
        if (key >= array.size) throw IllegalStateException("Key out of bound index")
        return array[key]
    }
}