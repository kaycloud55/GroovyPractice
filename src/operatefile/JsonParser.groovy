package operatefile

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import oop.Person

/**
 * Created by jiangyunkai on 2020/4/4
 * desc: 将实体转化为json，或者逆转
 */

def list = [new Person(name: 'john', age: 22), new Person(name: 'karry', age: 18)]
def json = JsonOutput.toJson(list)
println json
println JsonOutput.prettyPrint(json)



def jsonSlurper = new JsonSlurper()
def bean = jsonSlurper.parseText(json)
//def bean1 = jsonSlurper.parse()
println bean

