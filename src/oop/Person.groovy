package oop

/**
 * Created by jiangyunkai on 2020/4/4
 * desc: Groovy面向对象，
 * 1.类的定义都一样，都是通过class
 * 2.默认都是public的
 */
class Person implements Action{

    String name
    Integer age  = 1

    //返回的是Object类型
    def increateAge(Integer years) {
        age += years
    }

    /**
     * 接口实现是一样的
     */
    @Override
    void eat() {

    }

    @Override
    void drink() {

    }

    /**
     * 当调用的方法找不到时就会调用这个方法，可以用作兜底
     * @param name
     * @param args
     * @return
     */
    @Override
    Object invokeMethod(String name, Object args) {
        return super.invokeMethod(name, args)
    }
}


