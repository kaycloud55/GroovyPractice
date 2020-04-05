package operatefile

import groovy.xml.MarkupBuilder
import groovy.xml.XmlSlurper

/**
 * Created by jiangyunkai on 2020/4/4
 * desc: Xml解析
 */

/**
 * 解析XML文件
 */
final String xml = '''<CATALOG>
<PLANT>
<COMMON>Bloodroot</COMMON>
<BOTANICAL>Sanguinaria canadensis</BOTANICAL>
<ZONE>4</ZONE>
<LIGHT>Mostly Shady</LIGHT>
<PRICE>$2.44</PRICE>
<AVAILABILITY>031599</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Columbine</COMMON>
<BOTANICAL>Aquilegia canadensis</BOTANICAL>
<ZONE>3</ZONE>
<LIGHT>Mostly Shady</LIGHT>
<PRICE>$9.37</PRICE>
<AVAILABILITY>030699</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Marsh Marigold</COMMON>
<BOTANICAL>Caltha palustris</BOTANICAL>
<ZONE>4</ZONE>
<LIGHT>Mostly Sunny</LIGHT>
<PRICE>$6.81</PRICE>
<AVAILABILITY>051799</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Cowslip</COMMON>
<BOTANICAL>Caltha palustris</BOTANICAL>
<ZONE>4</ZONE>
<LIGHT>Mostly Shady</LIGHT>
<PRICE>$9.90</PRICE>
<AVAILABILITY>030699</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Dutchman's-Breeches</COMMON>
<BOTANICAL>Dicentra cucullaria</BOTANICAL>
<ZONE>3</ZONE>
<LIGHT>Mostly Shady</LIGHT>
<PRICE>$6.44</PRICE>
<AVAILABILITY>012099</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Ginger, Wild</COMMON>
<BOTANICAL>Asarum canadense</BOTANICAL>
<ZONE>3</ZONE>
<LIGHT>Mostly Shady</LIGHT>
<PRICE>$9.03</PRICE>
<AVAILABILITY>041899</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Hepatica</COMMON>
<BOTANICAL>Hepatica americana</BOTANICAL>
<ZONE>4</ZONE>
<LIGHT>Mostly Shady</LIGHT>
<PRICE>$4.45</PRICE>
<AVAILABILITY>012699</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Liverleaf</COMMON>
<BOTANICAL>Hepatica americana</BOTANICAL>
<ZONE>4</ZONE>
<LIGHT>Mostly Shady</LIGHT>
<PRICE>$3.99</PRICE>
<AVAILABILITY>010299</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Jack-In-The-Pulpit</COMMON>
<BOTANICAL>Arisaema triphyllum</BOTANICAL>
<ZONE>4</ZONE>
<LIGHT>Mostly Shady</LIGHT>
<PRICE>$3.23</PRICE>
<AVAILABILITY>020199</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Mayapple</COMMON>
<BOTANICAL>Podophyllum peltatum</BOTANICAL>
<ZONE>3</ZONE>
<LIGHT>Mostly Shady</LIGHT>
<PRICE>$2.98</PRICE>
<AVAILABILITY>060599</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Phlox, Woodland</COMMON>
<BOTANICAL>Phlox divaricata</BOTANICAL>
<ZONE>3</ZONE>
<LIGHT>Sun or Shade</LIGHT>
<PRICE>$2.80</PRICE>
<AVAILABILITY>012299</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Phlox, Blue</COMMON>
<BOTANICAL>Phlox divaricata</BOTANICAL>
<ZONE>3</ZONE>
<LIGHT>Sun or Shade</LIGHT>
<PRICE>$5.59</PRICE>
<AVAILABILITY>021699</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Spring-Beauty</COMMON>
<BOTANICAL>Claytonia Virginica</BOTANICAL>
<ZONE>7</ZONE>
<LIGHT>Mostly Shady</LIGHT>
<PRICE>$6.59</PRICE>
<AVAILABILITY>020199</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Trillium</COMMON>
<BOTANICAL>Trillium grandiflorum</BOTANICAL>
<ZONE>5</ZONE>
<LIGHT>Sun or Shade</LIGHT>
<PRICE>$3.90</PRICE>
<AVAILABILITY>042999</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Wake Robin</COMMON>
<BOTANICAL>Trillium grandiflorum</BOTANICAL>
<ZONE>5</ZONE>
<LIGHT>Sun or Shade</LIGHT>
<PRICE>$3.20</PRICE>
<AVAILABILITY>022199</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Violet, Dog-Tooth</COMMON>
<BOTANICAL>Erythronium americanum</BOTANICAL>
<ZONE>4</ZONE>
<LIGHT>Shade</LIGHT>
<PRICE>$9.04</PRICE>
<AVAILABILITY>020199</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Trout Lily</COMMON>
<BOTANICAL>Erythronium americanum</BOTANICAL>
<ZONE>4</ZONE>
<LIGHT>Shade</LIGHT>
<PRICE>$6.94</PRICE>
<AVAILABILITY>032499</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Adder's-Tongue</COMMON>
<BOTANICAL>Erythronium americanum</BOTANICAL>
<ZONE>4</ZONE>
<LIGHT>Shade</LIGHT>
<PRICE>$9.58</PRICE>
<AVAILABILITY>041399</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Anemone</COMMON>
<BOTANICAL>Anemone blanda</BOTANICAL>
<ZONE>6</ZONE>
<LIGHT>Mostly Shady</LIGHT>
<PRICE>$8.86</PRICE>
<AVAILABILITY>122698</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Grecian Windflower</COMMON>
<BOTANICAL>Anemone blanda</BOTANICAL>
<ZONE>6</ZONE>
<LIGHT>Mostly Shady</LIGHT>
<PRICE>$9.16</PRICE>
<AVAILABILITY>071099</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Bee Balm</COMMON>
<BOTANICAL>Monarda didyma</BOTANICAL>
<ZONE>4</ZONE>
<LIGHT>Shade</LIGHT>
<PRICE>$4.59</PRICE>
<AVAILABILITY>050399</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Bergamot</COMMON>
<BOTANICAL>Monarda didyma</BOTANICAL>
<ZONE>4</ZONE>
<LIGHT>Shade</LIGHT>
<PRICE>$7.16</PRICE>
<AVAILABILITY>042799</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Black-Eyed Susan</COMMON>
<BOTANICAL>Rudbeckia hirta</BOTANICAL>
<ZONE>Annual</ZONE>
<LIGHT>Sunny</LIGHT>
<PRICE>$9.80</PRICE>
<AVAILABILITY>061899</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Buttercup</COMMON>
<BOTANICAL>Ranunculus</BOTANICAL>
<ZONE>4</ZONE>
<LIGHT>Shade</LIGHT>
<PRICE>$2.57</PRICE>
<AVAILABILITY>061099</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Crowfoot</COMMON>
<BOTANICAL>Ranunculus</BOTANICAL>
<ZONE>4</ZONE>
<LIGHT>Shade</LIGHT>
<PRICE>$9.34</PRICE>
<AVAILABILITY>040399</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Butterfly Weed</COMMON>
<BOTANICAL>Asclepias tuberosa</BOTANICAL>
<ZONE>Annual</ZONE>
<LIGHT>Sunny</LIGHT>
<PRICE>$2.78</PRICE>
<AVAILABILITY>063099</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Cinquefoil</COMMON>
<BOTANICAL>Potentilla</BOTANICAL>
<ZONE>Annual</ZONE>
<LIGHT>Shade</LIGHT>
<PRICE>$7.06</PRICE>
<AVAILABILITY>052599</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Primrose</COMMON>
<BOTANICAL>Oenothera</BOTANICAL>
<ZONE>3 - 5</ZONE>
<LIGHT>Sunny</LIGHT>
<PRICE>$6.56</PRICE>
<AVAILABILITY>013099</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Gentian</COMMON>
<BOTANICAL>Gentiana</BOTANICAL>
<ZONE>4</ZONE>
<LIGHT>Sun or Shade</LIGHT>
<PRICE>$7.81</PRICE>
<AVAILABILITY>051899</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Blue Gentian</COMMON>
<BOTANICAL>Gentiana</BOTANICAL>
<ZONE>4</ZONE>
<LIGHT>Sun or Shade</LIGHT>
<PRICE>$8.56</PRICE>
<AVAILABILITY>050299</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Jacob's Ladder</COMMON>
<BOTANICAL>Polemonium caeruleum</BOTANICAL>
<ZONE>Annual</ZONE>
<LIGHT>Shade</LIGHT>
<PRICE>$9.26</PRICE>
<AVAILABILITY>022199</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Greek Valerian</COMMON>
<BOTANICAL>Polemonium caeruleum</BOTANICAL>
<ZONE>Annual</ZONE>
<LIGHT>Shade</LIGHT>
<PRICE>$4.36</PRICE>
<AVAILABILITY>071499</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>California Poppy</COMMON>
<BOTANICAL>Eschscholzia californica</BOTANICAL>
<ZONE>Annual</ZONE>
<LIGHT>Sun</LIGHT>
<PRICE>$7.89</PRICE>
<AVAILABILITY>032799</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Shooting Star</COMMON>
<BOTANICAL>Dodecatheon</BOTANICAL>
<ZONE>Annual</ZONE>
<LIGHT>Mostly Shady</LIGHT>
<PRICE>$8.60</PRICE>
<AVAILABILITY>051399</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Snakeroot</COMMON>
<BOTANICAL>Cimicifuga</BOTANICAL>
<ZONE>Annual</ZONE>
<LIGHT>Shade</LIGHT>
<PRICE>$5.63</PRICE>
<AVAILABILITY>071199</AVAILABILITY>
</PLANT>
<PLANT>
<COMMON>Cardinal Flower</COMMON>
<BOTANICAL>Lobelia cardinalis</BOTANICAL>
<ZONE>2</ZONE>
<LIGHT>Shade</LIGHT>
<PRICE>$3.02</PRICE>
<AVAILABILITY>022299</AVAILABILITY>
</PLANT>
</CATALOG>'''
def xmlSlurper = new XmlSlurper()
def response = xmlSlurper.parseText(xml)

//深度遍历
def plant = response.depthFirst().findAll {
    plant -> plant.PRICE = '$5.63'
}
println plant.toListString()

//广度遍历


/**
 * 生成xml
 */
def sw = new StringWriter()
def xmlBuilder = new MarkupBuilder(sw) //用来生成xml数据的核心类
//根节点langs创建成功
xmlBuilder.langs(type: 'current', count: '3', mainstream: 'true') {
    //第一个language节点
    language(flavor: 'static', version: '1.5', 'java')
    language(flavor: 'dynamic', version: '1.5', 'java')
    language(flavor: 'static', version: '1.5', 'java')
}
/**
 * <langs type='current' count='3' mainstream='true'>
 *   <language flavor='static' version='1.5'>java</language>
 *   <language flavor='dynamic' version='1.5'>java</language>
 *   <language flavor='static' version='1.5'>java</language>
 * </langs>
 */

println sw


//对应xml中的langs节点
class Langs {
    String type = 'current'
    int count = 3
    boolean mainsteram = true
    def languages = [new Language(), new Language(), new Language()]
}
//对应xml中的language节点
class Language {
    String flavor
    String version
    String value
}
def langs = new Langs()
xmlBuilder.langs(type: langs.type, count: langs.count, mainstream: langs.mainsteram) {
    langs.languages.each {
        lang -> language(flavor: lang.flavor, version:lang.version, lang.value)
    }
}