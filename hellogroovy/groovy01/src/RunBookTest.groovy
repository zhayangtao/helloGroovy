/**
 * Created by shliangyan on 2017/4/19.
 */

import groovy.util.GroovyTestCase
class BookTest extends GroovyTestCase{
    def void testToString(){
        def bk1 = new Book1(catalogNumber: '111',title: 'Groovy',author: 'Ken')
        def expected = 'Book:111:Groovy by: Ken'
        assertToString(bk1,expected)
    }
}
class LibraryTest extends GroovyTestCase{
    void setUp(){
        lib = new Library1(name:'Dunning')
        bk1 = new Book1(catalogNumber: '111',title:'Groovy',author:'Ken')
        bk2 = new Book1(catalogNumber: '222',title:'JAVA',author:'Eric')
    }
}