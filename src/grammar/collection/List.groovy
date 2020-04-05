package grammar.collection

/**
 * Created by jiangyunkai on 2020/4/4
 * desc: 列表学习
 */


//列表定义、初始化
def list = []
def list1 = [1, 3, 5]
println list1.class //output: java.util.ArrayList

//数组定义
int[] array = [1, 2, 3]
def array2 = [1, 2, 3] as int[]


/**
 * 列表排序
 */

def originList = [3, 65, 7, 43, 67, 547]
originList.sort() //排序
println originList
Comparator mc = {
    a, b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1
}
originList.sort(mc) //自定义排序规则
originList.sort {
    a, b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? 1 : -1
}
def stringList = ['abc', 'z', 'hello']
stringList.sort {
    it.length()
}
println stringList


/**
 * 列表查找
 */
def result = [0, -34932, 45392, 5292, 2343].find {it > 0}
def result2 = [3,342,-34,5,2,-4].findAll {it > 0}
def result3 = [3,123,653,3,4].any {it % 2 == 0}
def result4 = [3,2,5,6,34].every {it % 2 == 0}
def result5 = [23,5,432,2,5].min()
def result6 = [23,5,432,2,5].max()
def result7 = [32,3,5,6,2,6,8,8,2].count {
    it > 10
}

