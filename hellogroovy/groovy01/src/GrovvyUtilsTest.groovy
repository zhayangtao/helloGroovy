/**
 * Created by shliangyan on 2017/4/17.
 */
def config = new ConfigSlurper().parse('''
app.data = new Date()
app.age = 42
app {
name = "Test${42}
}
''')

def expando = new Expando()
expando.toString = { -> 'John'}
expando.say = {String s -> "John says: ${s}"}
assert expando as String == "John"
assert expando.say("Hi") == "John says:Hi"

