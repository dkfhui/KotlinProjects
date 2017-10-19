package ch02.ex1_1_HelloWorld
import java.util.Random

fun main(args: Array<String>) {
    val arr: IntArray = IntArray(10, {random(10)})
    printArray(arr)
    val mergedArr = mergeSort(arr)
    printArray(mergedArr);
    print(binarySearch(mergedArr, 7, 0, mergedArr.size))
}

fun sum(x: Int, y: Int) = x + y
fun sub(x: Int, y: Int) = x - y
fun mult(x: Int, y: Int) = x * y
fun div(x: Float, y: Float) = x / y

fun random(to: Int, from: Int = 0) = Random().nextInt(to - from) + from
fun dice() = Random().nextInt(6) + 1

/* Performs a merge sort algorithm on arr */ 
fun mergeSort(arr: IntArray): IntArray {
    if(arr.size <= 1)
    	return arr
    
    var middle: Int = arr.size / 2
    var left: IntArray = arr.copyOf(middle)
    var right: IntArray = arr.copyOfRange(middle, arr.size)
    
    left = mergeSort(left)
    right = mergeSort(right)
    
    return(merge(left, right, left.size + right.size))
}

/* Merges two sorted integer arrays together and returns a sorted array */
fun merge(left: IntArray, right: IntArray, length: Int): IntArray{
    var arr: IntArray = IntArray(length, {i->0})
    var leftIndex: Int = 0; var rightIndex: Int = 0; var arrIndex: Int = 0
    var lsize = left.size; var rsize = right.size
    
    while(leftIndex < left.size && rightIndex < right.size){
        var l = left[leftIndex]
        var r = right[rightIndex]
        if(left[leftIndex] <= right[rightIndex])
            arr[arrIndex++] = left[leftIndex++]
        else
            arr[arrIndex++] = right[rightIndex++]
    }
    
    if(leftIndex < left.size){    
        for(i in leftIndex..left.size-1)
            arr[arrIndex++] = left[leftIndex++]
    }
    if(rightIndex < right.size){
        for(i in rightIndex..right.size-1)
            arr[arrIndex++] = right[rightIndex++]
    }
    
    return arr
}

/* Prints all the contents of an integer array */
fun printArray(arr: IntArray){
    for(i in arr)
    	print("$i ")
    println();
}

fun test(){
    val x = 3
    var a = arrayOf(1, 2, 3, 4, 5)
    
    for(i in 0..1)
    	println(a.copyOf(a.size/2)[i])
}

/* Performs a binary search on sorted integer array arr for query with left
   denoting the leftmost bound and right denoting the rightmost bound */
fun binarySearch(arr: IntArray, query: Int, left: Int, right: Int): Int{
    val middle: Int = (left + right)/2

    if(query == arr[middle])
    	return middle
    if(query < arr[middle])
    	return binarySearch(arr, query, left, middle)
    else
    	return binarySearch(arr, query, middle+1, right)
    return -1
}
