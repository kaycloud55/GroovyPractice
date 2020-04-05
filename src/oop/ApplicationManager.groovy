package oop

/**
 * Created by jiangyunkai on 2020/4/4
 * desc: 模拟应用管理类
 */
class ApplicationManager {

    static void init() {
        //使通过metaClass添加的属性和方法全局可用
        ExpandoMetaClass.enableGlobally()
        //为第三方类添加方法
        Person.metaClass.static.createPerson = {
            String name, int age ->
                new Person(name: name, age: age)
        }
    }
}

class PersonManager {
    static Person createPerson() {
        Person.createPerson('sara', 2)
    }
}

class Entry {
    static void main(def args) {
        println 'App启动'
        //初始化
        ApplicationManager.init()
        println 'App初始化完成'

        Person person = PersonManager.createPerson()
        println person.name
    }
}