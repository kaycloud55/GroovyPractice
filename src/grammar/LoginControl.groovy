package grammar

/**
 * Created by jiangyunkai on 2020/4/4
 * desc: 逻辑控制，if/else , switch/case, while循环, for循环
 */


def x = 1.23
def result
switch (x) {
    case 'foo':
        result = 'found foo'
        break;
    case 'bar':
        result = 'bar'
        break;
    case [4, 5, 6, 'inlist']: //列表
        result = 'list'
        break
    case 12..30:
        result = 'range' //范围
        break
    case Integer:
        result = 'integer' //类型
        break
    default:
        break
}


//对范围的循环
def sum = 0
for (i in 0..9) {
    sum += i
}
println sum

//对list的循环
for (i in [1, 2, 3, 4]) {
    sum += i
}


//对map的循环
for (entry in ['jacky': 12, 'bob': 10]) {
    sum += entry.value
}



