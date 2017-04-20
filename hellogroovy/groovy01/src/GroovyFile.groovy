/**
 * Created by shliangyan on 2017/4/19.
 */
//按行读取文件
import java.io.File
if(args.size() != 1) {
    println "Usage:GroovyFile filename"
}else {
    new File(args[0]).eachLine {line ->
        println "Line:${line}"
    }
}

//word counter
def chars = 0
def words = 0
def lines = 0
if(args.size() != 1) {
    println "Usage:GroovyFile filename"
}else {
    new File(args[0]).eachLine {line ->
        chars += 1 + line.length()
        words = line.tokenize().size()
        lines++
    }
}

//目录列表
def listDir(dirFile, indent) {
    dirFile.eachFile{file ->
        (0..indent).each {print " "}
        println "${file.getName()}"
        if(file.isDirectory()) {
            listDir(file, 2 + indent)
        }
    }
}
def printDir(dirName) {
    listDir(new File(dirName), 0)
}

//目录递归访问 eachFileRecurse 方法会递归查询目录中的子目录
def printDir(dirName,size) {
    new File(dirName).eachFileRecurse {file ->
        if(file.length() > size) {
            println "${file.getName()}"
        }
    }
}

//文件拷贝
def outFile = new File(args[1])
if(outFile.exists()) {
    outFile.delete()
}
def printWriter = outFile.newPrintWriter()
new File(args[0]).eachLine {line ->
    printWriter.println(line)
}
printWriter.flush()
printWriter.close()
