package grammar

/**
 * Created by jiangyunkai on 2020/4/4
 * desc: 字符串学习
 *
 * 有两种：
 * 1. String
 * 2. GString
 */

/**
 * 均可以使用反斜杠进行转义
 */
def singleName = 'a single String' //单引号定义，属于java.lang.String，和Java中的双引号定义的类似。
def newName = '''a new String
line one
line two
line three''' //也是java.lang.String，但是它有格式


/**
 * 双引号定义直接定义，也是java.lang.String
 * 但是如果有$类似的语法的话 ，就会自动被转换为GString —— 类似kotlin的字符串模板
 */
def doubleName = "a double String" //java.lang.String
def SpecialDoubleName = "a $doubleName String" //org.codehaus.groovy.runtime.GStringImpl，也就是GString类型
println SpecialDoubleName.class


/**
 * String和GString是可以直接互相传递调用的，不用强转
 */
java.lang.String echo(java.lang.String message) {
    return message
}
println echo(SpecialDoubleName) //这里不会报错






/* ===================================字符串的方法=======================================*/

/**
 * 填充
 * center 对已有字符串进行填充，arg1表示填充到的长度，arg2表示用什么字符占位
 * padLeft 在左边填充
 * padRight 在右边填充
 */
def str = "groovy"
x = str.center(8,'a') //对已有字符串进行填充，arg1表示填充到的长度，arg2表示用什么字符占位
println x //output: agroovya


/**
 * 比较
 * 1.使用compareTo()
 * 2.使用 比较符 > ,< , =
 */
def str2 = "Hello"
println str > str2
println str.compareTo(str2)

/**
 * 获取字符串中的某个字符
 */
def str3 = "GET"
println str3[0] //output : G
println str3[0..1] //output: GE

/**
 * 裁剪
 */
def str4 = "hello groovy"
println str4 - str //output : hello ，会把字符串中的某个匹配的内容直接移除

/**
 * 排序
 */
println str4.reverse() //直接倒序


/**
 * 首字母大写
 */
println str.capitalize()


/**
 * 判断是否是数字
 */
println str.isNumber()

/**
 * 转化
 */
println str.toInteger()
println str.toDouble()

