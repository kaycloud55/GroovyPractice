package grammar

/**
 * Created by jiangyunkai on 2020/4/4
 * desc: Groovy变量学习
 * Groovy的所有变量都是对象，没有Java中的基本类型的概念
 *
 *
 */

//可以强类型定义，声明的时候就限定变量的类型
int a = 1
//也可以定义弱类型的变量,用def声明
def text = "txt"
// def声明的是可以改变类型的
text = 2
def y = 3.14

println text  //输出2
println text.class //输出Integer
println a // Output:1
println a.class //输出java.lang.Integer


