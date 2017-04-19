import groovy.json.JsonOutput
import groovy.json.JsonSlurper

/**
 * Created by shliangyan on 2017/4/17.
 */
class Person {
    int id
    String name
    List<Book> books

    @Override
    String toString() {
        "Book(id:$id,name:$name,books:${books})"
    }
}

class Book {
    int id
    String name

    @Override
    String toString() {
        "Book(id:$id,name:$name)"
    }

}

static void parseSimpleObject() {
    def book = new Book(id: 1, name: 'Thinking in Java')
    def jsonOutput = new JsonOutput()
    def result = jsonOutput.toJson(book)

    println(result)
    println jsonOutput.prettyPrint(result)
}

static void parseSimpleJson() {
    def text = '{"id":1,"name":"Thinking in Java"}'
    def jsonSlurper = new JsonSlurper()

    def map = jsonSlurper.parseText(text)
    println map
    def obj = new Book(map)
    puts obj

}
println 6 / 5
13.intdiv(5)

def count = 0
count += 1

def age = 25
'My age is ${age}'
"My age is ${age}"
"""My age is ${age}"""

def greeting = "Helo world"
greeting[4]
greeting[1..2]
greeting[1..<3]

