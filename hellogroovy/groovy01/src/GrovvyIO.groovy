/**
 * Created by shliangyan on 2017/4/17.
 */
/*class GrovvyIO {
}*/
new File('E:\\车险文档', '旧车测试数据.txt').eachLine {line ->
    println line
}
new File('E:\\车险文档', '旧车测试数据.txt').eachLine {line,nb ->
    println "Line $nb:$line"
}

def count = 0, MAXSIZE = 3
new File('E:\\车险文档', "旧车测试数据.txt").withReader {reader ->
    while(reader.readLine()) {
        if(++count > MAXSIZE){
//            throw new RuntimeException("3 verses")
        }
    }
}

def list =  new File('E:\\车险文档', "旧车测试数据.txt").collect{it}
def array = new File('E:\\车险文档', "旧车测试数据.txt") as String[]
//byte[] contents = file.bytes
def is = new File('E:\\车险文档', "旧车测试数据.txt").newInputStream()
is.close()
new File('E:\\车险文档', "旧车测试数据.txt").withInputStream {
    stream -> //doSomethind
}

//写文件
new File('E:\\车险文档', "旧车测试数据.txt").withWriter {
    writer ->
        writer.writeLine 'Into the ancient pond'
        writer.writeLine 'A frog jumps'
        writer.writeLine "water's sound!"
}

//文件树操作
/*
dir.eachFile{file ->
    println file.name
}*/
def process = "ls -l".execute()
println "Found text ${process.text}"
def process1 = "ls -l".execute()
process1.in.eachLine{line ->
    println line
}
