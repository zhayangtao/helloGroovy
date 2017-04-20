/**
 * Created by shliangyan on 2017/4/20.
 */

// MarkupBuilder 构造 xml文档
import groovy.xml.MarkupBuilder

def mb = new MarkupBuilder()
mb.book() {
    author('Ken Barclay')
    title('Groovy')
    publisher('Elsevier')
    isbn(number: '1234567890')
}

//使用参数化的构造器制定xml目的地
mb = new MarkupBuilder(new File('book.xml').newPrintWriter())
mb.book() {
    author('Ken Barclay')
    title('Groovy')
    publisher('Elsevier')
    isbn(number: '1234567890')
}
println()
//含有book对象的library
def data = ['11111' : ['Groovy', 'Ken', 'Else'],
            '222222': ['Object Design', 'john', 'Else'],
            '33333' : ['C Programming', 'Ken', 'Pren']
]
mb = new MarkupBuilder(new File('library.xml').newPrintWriter())
def lib = mb.library() {
    data.each { bk ->
        mb.book() {
            title(bk.value[0])
            author(bk.value[1])
            publisher(bk.value[2])
            isbn(number: bk.key)
        }
    }
}

//xml 解析
import groovy.util.*

def parser = new XmlParser()
def doc = parser.parse('library.xml')
println "${doc.book[0].title[0].text()}"

//迭代解析
doc.book.each { bk ->
    println "${bk.title[0].text()}"
}
//通过导航器简化代码
doc.book.title.each { title ->
    println "${title.text()}"
}

data = ['Ken Bar'   : ['David': '55', 'Angus': '75'],
        'John Sava' : ['Jack': '60', 'Todd': '44', 'Mark': '62'],
        'Jessie Ken': ['Mike': '50', 'Ruth': '70']]
mb = new MarkupBuilder(new File('staff.xml').newPrintWriter())
def staff = mb.staff() {
    data.each { lecturers ->
        mb.lecturer(name: lecturers.key) {
            lecturers.value.each { students ->
                student(name: students.key, grade: students.value)
            }
        }
    }
}

//属性  @property
doc = parser.parse('staff.xml')
println doc.lecturer.student['@name']
println doc.lecturer.student.findAll { stu ->
    stu['@grade'].toInteger() >= 65
}['@name']

data = ['Book'     : [['title', 'text'], ['isbn', 'text'], ['price', 'integer'], ['author', 'id'], ['publisher', 'id']],
        'author'   : [['surname', 'text'], ['forename', 'text']],
        'Publisher': [['name', 'text'], ['url', 'text']]]
mb = new MarkupBuilder(new File('tables.xml').newPrintWriter())
mb.tables() {
    data.each { tables ->
        mb.table(name: tables.key) {
            tables.value.each { fields ->
                field(name: fields[0], type: fields[1])
            }
        }
    }
}

