/**
 * Created by shliangyan on 2017/4/20.
 */
//映射一个简单模板的值
import groovy.text.*
import java.io.*
import groovy.xml.MarkupBuilder

def mb = new MarkupBuilder(new File('book.template').newPrintWriter())
mb.book(){
    author('${author}')
    title('${title}')
    publisher('${publisher}')
    isbn(number:'${isbn}')
}

def file = new File('book.template')
def binding = ['author': 'Ken Bar', 'title': 'Groovy', 'publisher': 'Else', 'isbn': '1234']
def engine = new SimpleTemplateEngine()
def template = engine.createTemplate(file)
def writable = template.make(binding)
println writable

// 保存模板
writable = new SimpleTemplateEngine().createTemplate(file).make(binding)
def destination = new FileWriter('book.xml')
writable.writeTo(destination)
destination.flush()
destination.close()