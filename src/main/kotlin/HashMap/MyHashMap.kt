package HashMap

import com.sun.jdi.Value

class MyHashMap<K, V> (
    private val defaultSize: Int = 16,
    private val resizeFactor: Float = 0.75f
    ) {
    var array = Array<Node<K,V>?>(defaultSize){
        null
    }

    fun put(key: K, value: V){
        if (checkResize()){
            resize()
        }
        val keyClass = Key(keyValue = key)
        val hashCode = keyClass.hashCode()
        val index = (array.size - 1).and(hashCode)
        if (index >= array.size) throw IllegalStateException("Key out of bound index")
        if (array[index] == null) {
            array[index] = Node(key, value)
        }else{
            var tempNode = array[index]
            while (tempNode?.next != null){
                if (tempNode.value == value) return
                tempNode = tempNode.next
            }
            tempNode?.next =  Node(key, value)
        }
    }

    fun get(key: K): V?{
        val keyClass = Key(keyValue = key)
        val hashCode = keyClass.hashCode()
        val index = (array.size - 1).and(hashCode)
        if (index >= array.size) return null
        return array[index]?.value
    }

    private fun checkResize():Boolean{
        return array.filterNotNull().size.toFloat() / array.size >= resizeFactor
    }

    private fun resize(){
        val newArray = Array(array.size * 2){
            if (it < array.size) array[it] else null
        }
        array = newArray
    }
}