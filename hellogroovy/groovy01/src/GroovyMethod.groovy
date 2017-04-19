import groovy.ui.Console

/**
 * Created by shliangyan on 2017/4/18.
 */
def greetings(){
    println 'hello and welcome'
}
greetings()
def reverse() {
    print 'Enter the two integer values:'
}

import console.*
def processTime() {
    def hours = Console.readInteger()
}

//方法参数
def someMethod(para1,para2 = 0, para3 = 1) {
    // do something
}

def sayHello(salutation, name = 'Jovi') {
    println "${salutation} ${name}"
}
sayHello('Hello')
sayHello('Welcome', 'Steve')

def printName(name) {
    println "Name (at entry):${name}"
    name = 'John'
    println "Name (after assignment):${name}"
}
def tutor = "Ken"
printName(tutor)
println "Tutor:${tutor}"

def sort(list, ascending  = true) {
    list.sort()
    if (ascending == false) {
        list = list.reverse()
    }
    list
}
def numbers = [10,5,3,6]
assert sort(numbers,false) == [10,6,5,3]

def limit = 10
println 'Start'
for (count in 1..<limit) {
    println "count : ${count}"
}
println 'Done'

def staff = ['Ken':21,'John':25,'Jovi':25]
def totalAge = 0
for(staffEntry in staff) {
    totalAge += staffEntry.value
}
println "Total staff age: ${totalAge}"

def name = "Kenneth"
def listOfCharacters = []
for(letter in name) {
    listOfCharacters << letter
}
println "listOfCharacters : ${listOfCharacters}"

def score = 99
def grade
switch (score){
    case 70..100:
        grade = 'A'
        break
    case 60..69:
        grade = 'B'
        break
    default:
        grade = 'D'
}

def number = 32
switch (number) {
    case [21, 22, 23, 24]:
        println 'number is a twenty something'
        break
    case [31, 32, 33, 34]:
        println 'number is a thirty something'
        break
    default:
        println 'number type is unknown'
        break
}

switch (number) {
    case ~'[0-9]{3}-[0-9]{4}':
        println 'number is a telephone number'
        break
    case ~'[0-9]{4}':
        println 'number is a 4-digit sequence'
        break
    default:
        println 'number type is unknown'
}
def max = 10
def sum = 0
for(k in 1..max) {
    print 'enter next value'
}