/**
 * Created by shliangyan on 2017/4/18.
 */
def clos = {
    println "Hello world"
}
clos.call()

//参数化的闭包
clos = { param ->
    println "Hello ${param}"
}
clos.call('world')
clos('shortcut')
//闭包使用隐式参数 it
clos = {
    println "hello ${it}"
}
clos('it')

//闭包的作用范围
def greeting = "hello"
clos = { param ->
    println "${greeting}${param}"
}

def demo(clo) {
    def greeting = 'Bonjour'
    clo.call('Ken')
}

demo(clos)
demo() { param ->
    println "welcome ${param}"
}

1.upto(10) {
    println "Hell world"
}

//使用闭包求阶乘
def factorial = 1
1.upto(5) { num ->
    factorial *= num
}
println "Factorial(5):${factorial}"

//each
[1,2,3,4].each {println it}
['Ken':21,'John':25,'Jovi':25].each {println it}

//条件元素
[1,2,3,4].each {num -> if(num %2 == 0) println num}

//find 方法
def value = [1,3,5,7,9].find{element -> element > 6}
println "Fount:${value}"
value.each {println it}

//any 和 every方法
def anyElement = [11,12,13,14].any{element -> element > 12}
println "anyElement:${anyElement}"
def allElement = [11,12,13,14].every {element -> element > 10}
println "allElement:${allElement}"

// collect
def list = [1,2,3,4].collect{element ->
    return element * element
}
println "list:${list}"
list = [0..<5].collect{element ->
//    2 * element
}

//collect 高级范例
def doubles = {item -> 2 * item}
def triples = {item -> 3 * item}
def isEven = {item -> (item %2 == 0)}
def map(clos, list) {
    return list.collect(clos)
}
println "Double : ${map(doubles,[1,2,3,4])}"
println "Tripling : ${map(triples,[1,2,3,4])}"
println "Evens : ${map(isEven,[1,2,3,4])}"

// 范例 求 5 的阶乘值
def factorial2 = [2,3,4,5].inject(1){previous, element -> previous * element}
println "factorial2(5):${factorial2}"
def fact = 1
[2,3,4,5].each {number -> fact *= number}
println "fact:${fact}"
list = [2,3,4,5]
factorial2 = list.inject(1) {previous, element -> previous * element}
println "factorial2(5):${factorial2}"

//闭包的其他特性
def filter(list, predicate){
    return list.findAll(predicate)
}
def isOdd = {x -> return !isEven(x)}

def table = [11,12,13,14]
def evens = filter(table,isEven)
println "evens ; ${evens}"
def odds = filter(table, isOdd)
println "odds:${odds}"

//闭包作为另一个闭包的参数
def takeWhile = {predicate, list1 ->
    def result = []
    for(element in list1) {
        if(predicate(element)) {
            result << element
        }else {
            return result
        }
    }
    return result
}
def table1 = [12,14,15,18]
def table2 = [11,13,15,16,18]
evens = takeWhile(isEven,table1)
println "takeWhile evens : ${evens}"
odds = takeWhile(isOdd,table2)
println "takeWhile odds : ${odds}"

//闭包作为返回值
def multiply(x){
    return {y ->
        return x * y
    }
}
def twice = multiply(2)
println "twice(4):${twice(4)}"
def multiplication = {x ->
    return {y ->
        return x * y
    }
}
def quadruple = multiplication(4)
println "quadruple(3):${quadruple(3)}"

//选择性排序
def selectionSort = {list2 ->
    def swap = {sList,p,q ->
        def temp = sList[p]
        sList[p] = sList[q]
        sList[q] = temp
    }
    def mininumPositaion = {pList, from ->
        def mPos = from
        def nextFrom = 1 + from
        for(j in nextFrom..<pList.size()) {
            if(pList[j] < pList[mPos]) {
                mPos = j
            }
        }
            return mPos
    }
    def size = list2.size() - 1
    for (k in 0..size) {
        def minPos = mininumPositaion(list2, k)
        swap(list2, minPos, k)
    }
    return list2

}
table = [13,14,12,11,14]
def sorted = selectionSort(table)
println "sorted:${sorted}"
