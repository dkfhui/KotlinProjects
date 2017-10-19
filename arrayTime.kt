package ch02.ex1_1_HelloWorld
import java.util.Random

fun main(args: Array<String>) {
    /*println(random(10))
    println(dice())*/
    val arr: IntArray = IntArray(10, {random(10)})
    printArray(arr)
    val mergedArr = mergeSort(arr)
    printArray(mergedArr);
    print(binarySearch(mergedArr, 7, 0, mergedArr.size))
    
    //printArray(merge(intArrayOf(1, 3), intArrayOf(2, 4), 4))
    //printArray(mergeSort(intArrayOf(1,3,2,4,1)))
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
    //print("middle: $middle\n")
    var left: IntArray = arr.copyOf(middle)
    var right: IntArray = arr.copyOfRange(middle, arr.size)
    
    left = mergeSort(left)
    right = mergeSort(right)
    
    return(merge(left, right, left.size + right.size))
}

fun merge(left: IntArray, right: IntArray, length: Int): IntArray{
    var arr: IntArray = IntArray(length, {i->0})
    var leftIndex: Int = 0; var rightIndex: Int = 0; var arrIndex: Int = 0
    var lsize = left.size; var rsize = right.size
    
    //print("left.size: $lsize\tright.size: $rsize\tlength:$length\n")
    while(leftIndex < left.size && rightIndex < right.size){
        var l = left[leftIndex]
        var r = right[rightIndex]
        //print("$leftIndex\t$rightIndex\t$arrIndex\n")
        //print("l: $l\tr: $r\n\n")
        if(left[leftIndex] <= right[rightIndex]){
            arr[arrIndex++] = left[leftIndex++]
            //leftIndex++
        }
        else{
            arr[arrIndex++] = right[rightIndex++]
            //rightIndex++
        }
        //arrIndex++
    }
    //print("$leftIndex\t$rightIndex\t$arrIndex\n\n")
    
    if(leftIndex < left.size){    
        for(i in leftIndex..left.size-1){
            arr[arrIndex++] = left[leftIndex++]
            /*arrIndex++
            leftIndex++*/
        }
    }
    if(rightIndex < right.size){
        for(i in rightIndex..right.size-1){
            //print("$leftIndex\t$rightIndex\t$arrIndex\n")
            arr[arrIndex++] = right[rightIndex++]
            /*arrIndex++
            rightIndex++*/
        }
    }
    
    return arr
}

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
