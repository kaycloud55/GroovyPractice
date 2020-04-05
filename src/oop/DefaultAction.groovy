package oop

/**
 * Created by jiangyunkai on 2020/4/4
 * desc: 可以有默认实现的接口
 */
trait DefaultAction {

    abstract void eat()

    void play() {
        //....
    }
}