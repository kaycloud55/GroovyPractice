package grammar.closure

/**
 * Created by jiangyunkai on 2020/4/4
 * desc: 闭包相关概念
 * Groovy中的闭包是一个**开放，匿名的代码块**，可以接受参数，返回值并分配给变量
 */

/**
 * 定义和使用
 */
def closure = {
    println 'hello groovy'
}
//调用方式有两种
closure() //这里是可以传递参数的
closure.call()


/**
 * 带参数的闭包
 */
def closureWithArg = { _ ->
    println 'hello'
}
//可以不定义参数类型
def closureWithArg2 = { arg ->
    println arg
}
closureWithArg2(1)
//
def closureWithArg3 = { String arg ->
    println arg
}
closureWithArg3('heelo')
closureWithArg3.call('hello')
//每个闭包默认都有一个it参数
def closureWithDefaultArg = {
    println it
}
closureWithDefaultArg(1111)


/**
 * 闭包的返回值
 */
def closureResult = {
    return it
}
println closureResult(1)
//默认情况下闭包一定是有返回值的，默认是最后一行
def closureH = {
    it * 2
}
println closureH(2)


/* =================================闭包的结合使用=============================== */

/**
 * 与基本类型结合使用
 * @param number
 * @return
 */
//求阶乘
int fab(int number) {
    int result = 1
    1.upto(number, { result *= it })
    return result
}

println fab(5) // 1*2*3*4*5

int fab2(int number) {
    int result = 1
    number.downto(1) {
        result *= it
    } //闭包作为最后一个参数时，可以放到外面
    return result
}

println fab2(5) // 5*4*3*2*1

int cal(int number) {
    int result
    number.times {
        result += it
    }
    return result
}

println cal(5) // 1+2+3+4


/**
 * 与String结合使用
 */

String str = 'the 2 and 3 is 5'
//each遍历
str.each {
    String temp -> println temp * 2
}
//find 寻找第一个符合条件的元素
println str.find {
    it.isNumber() //找到第一个数字
}
//findAll 返回所有符合条件的元素的集合
println str.findAll {
    it.isNumber() //找到所有的数字，返回的是集合
}

//any 返回布尔值，有任意一个符合的返回true
println str.any {
    it.isNumber()
}
//every 每个都符合条件就返回true
println str.every {
    it.isNumber()
}
//collect 对每个元素执行闭包的操作
str.collect {
    it.toUpperCase()
}


/* ============================== 闭包的三个重要变量 ======================= */

def scriptClosure = {
    println "this:$this" //定义闭包的那个类，如果在内部类中定义，指向的是内部类
    println "owner:$owner" //对应于定义闭包处的类或者对象，如果在闭包中定义，对应闭包，否则和this一样
    println "delegate:$delegate" //默认是和owner一致，或者自定义delegate指向
}
scriptClosure.call()

//类中的闭包
class ClosureWrapper {
    def innerClosure = {
        println "this:$this" //都是这个ClosureWrapper对象
        println "owner:$owner"
        println "delegate:$delegate"
    }

    def say() {
        def funcClosure = {
            println "this:$this" //都是这个ClosureWrapper对象
            println "owner:$owner"
            println "delegate:$delegate"
        }
        funcClosure.call()
    }
}
def wrapper = new ClosureWrapper()
wrapper.innerClosure.call()
wrapper.say()

//闭包中定义闭包

def nestClosure = {
    def innerClosure = {
        println "this:$this" //Closure这个类
        println "owner:" + owner //netClosure这个闭包
        println "delegate:$delegate" //netClosure这个闭包，如果设置了delegate就是设置的那个对象
    }
    innerClosure.delegate = wrapper
    innerClosure.call()
}
nestClosure.call()


/**
 * 闭包的作用
 */
class Student {
    String name
    def pretty = { "my name is $name"}

    String toString() {pretty.call()}
}

class Teacher {
    String name
}

def stu = new Student(name: 'sara')
def tea = new Teacher(name: 'tom')
println stu.toString() //默认输出sara

//设置委托
stu.pretty.resolveStrategy = groovy.lang.Closure.DELEGATE_FIRST
stu.pretty.delegate = tea // 这时候pretty调用的时候就会优先去tea中找这个name参数



