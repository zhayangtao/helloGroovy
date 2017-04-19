/**
 * Created by shliangyan on 2017/4/18.
 */
def library = [['Ken', 'Groovy'],
               ['Ken', 'UML'],
               ['John', 'Java']]

library << ['John', 'OOD']
library.add(['Sally', "Basic"])
println "Library:${library}"
println library.contains(['Ken', 'UML'])
println library.size()

library = ['Ken': ['Groovy', 'UML'], 'John': ['Java']]
library.John = library.John << 'OOD'
library.keySet().sort()
