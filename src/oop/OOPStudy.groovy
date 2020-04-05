package oop

/**
 * Created by jiangyunkai on 2020/4/4
 * desc:
 */

//可以直接传入参数，类似构造方法的形式
def person = new Person(name: 'bob')

//调用是一致的
person.increateAge(10)

//为类动态添加一个属性
Person.metaClass.sex = 'male'
//动态添加方法
Person.metaClass.setUpperCase = {
    -> sex.toUpperCase()
}
def person2 = new Person()
println person2.setUpperCase()

println person2.sex