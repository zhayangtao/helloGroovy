/**
 * Created by shliangyan on 2017/4/17.
 */
class GroovyTest {
    def name
    def age

    def test =
            println "hello groovy"

    static void main(String[] args) {
        def map = ['name': 'john', 'age': 14, 'sex': 'm']
        map= map + ['weight':50]
        map.each {key,value -> println "$key:,$value"}
        map.each {println it}
        map.each{println it.getKey() + "-->" + it.getValue()}

        GroovyTest gt = new GroovyTest();
        gt.say('groovy')
        gt.setName 'kk'
        println gt.getName()

        def gtObj = new GroovyTest();
        def gtObj2 = new GroovyTest(['name':'good','age':22])
        println gtObj2

//String displayName = name != null?name:"Ubnknown"
    }

    def say = {word -> println "hi,$word!"}


}
