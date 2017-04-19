/**
 * Created by shliangyan on 2017/4/17.
 */
def regex = ~'cheese'
'cheesecake' =~ 'cheese'
!('cheesecake' =~ 'fromage')
'cheesecake' =~ regex

def numbers = [11,12,13,14]
numbers[0]
numbers[3]
numbers[-1]
numbers[-2]
//索引范围
numbers[0..2] //包含末尾
numbers[1..<3]//不包含末尾
numbers[1] = 22
numbers[1] = [33,44]
numbers << 15
numbers + [15,16]
numbers - [13]
numbers.flatten()

//映射
def names = ['Ken':'Barclay','John':'Savage']
def divisors = [4:[2],6:[3,2],12:[6,4,3,2]]
[:]  //空映射
names.Ken
names['Ken']
names['Jovi'] = 'Love'

def start = 10
def end = 20
start..end + 1 //[10 .....21]

print "my name is "
print "ken"
println()
println "My first program"
println "This is fun"

def age = 25
print "My age is: ${age}"

numbers = [11,12,13,14]
def staffTel = ['Ken':2545,'John':5678]

