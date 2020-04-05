package operatefile

/**
 * Created by jiangyunkai on 2020/4/4
 * desc:
 */

def file = new File('../../GroovyPractice.iml')
//file.eachLine {
//    println it
//}

def text = file.getText()
println text
def result = file.readLines()

def reader = file.withReader {
    reader ->
        char[] buffer = new char[100]
        reader.read(buffer)
        return buffer
}

def writer = file.withWriter {
}

def copy(String originPath, String desPath) {
    try {
        //首先创建目标文件
        def desFile = new File(desPath)
        if (!desFile.exists()) {
            desFile.createNewFile()
        }
        //开始copy
        new  File(originPath).withReader { reader ->
            def lines = reader.readLine()
            desFile.withWriter { writer ->
                lines.eachLine {
                    writer.append(it)
                }
            }
        }
    } catch(Exception e) {

    }
}

copy('../../GroovyPractice.iml', '../../GroovyPractice2.iml')