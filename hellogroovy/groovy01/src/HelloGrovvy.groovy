/**
 * Created by shliangyan on 2017/4/17.
 */
/*class HelloGrovvy {
}*/
def map = [:]
map."an" = "ALLOWED"
map.'with' = 'ALLOWED'
map.'single quote'
map."double quote"
map.'''triple single quote'''
map."""triple double quote"""

def name = "Test Groovy!"
def body = "Test $name"
assert name == "Test Groovy!"
assert body == "Test $name"
assert 'ab' == 'a' + 'b'


def aMultilineString = '''line one
line two
line three'''

def greeting = "Hello ${name}"
def sum = "The sum of 2 and 3 equals"

//闭包
def sParameter = "1 + 2 == ${-> 3}"
//一个参数闭包
def sOneParam = "1 + 2 == ${w -> w << 3}"

def number = 1
def eagerGString = "value == ${number}"
def lazyGString = "value == ${-> number}"

assert eagerGString == "value == 1"
assert lazyGString == "value == 1"

def template = """
Dear Mr ${name}
You're the winner of the lottery!
Yours sincerly
Dave
"""

def fooPattern = /.*foo.*/
assert fooPattern == '.*foo.*'
def escapeSlash = /The character \/ is a forward slash/
assert escapeSlash == 'The character / is a forward slash'

def multilineSlashy = /one
two
three/

//定义字符
char c1 = 'A'
assert c1 instanceof Character
def c2 = 'b' as char
def c3 = (char)'c'

//动态list
def numbers = [1, 2, 3]
assert numbers instanceof List
assert numbers.size() == 3

//list中存储任意类型
def hete = [1, "a", true]
//判断list默认类型
def arrayList = [1, 2, 3]
assert arrayList instanceof java.util.ArrayList
//使用as强转类型
def linkedList = [2, 3, 4] as LinkedList
//追加元素
linkedList << 'e'
arrayList << 'e'
//多维list
def multiList = [[0, 1], [2, 3]]
assert multiList[1][0] == 2

//Arrays类型
String[] arrStr = ['Ananas','banana','Kiwi']
assert arrStr instanceof String[]

def numArr = [1,2,3] as int[]

//Maps类型
def colors = [red:'#FF0000', green:'#00FF00',blue:'#0000FF']
assert colors['red'] == '#FF0000'

//运算符
assert 2 ** 3 == 8

class User{
    public final String name
    User(String name) {
        this.name = name
    }
}
def user = new User('Bob')
assert user.name == 'Name : Bob'
assert user.@name == 'Bob'

// .&
def list = ['a,','b,','c']
list.each {println it}
String printName(name) {
    println name
}
//方法指针操作符写法
list.each(this.&printName)

//三目运算符
displayName = user.name? user.name : 'Anonymous'
//简化为二目运算符
displayName = user.name ?: 'Anonymous'

//*.展开运算符
cars = [
        new User(name:'bob'),
        null,
        new User(name:'carry')
]
assert null*.make == null