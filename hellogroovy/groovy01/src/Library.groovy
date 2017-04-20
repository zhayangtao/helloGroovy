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

//应用方法
def addBook(library,bookTitle) {
    library[bookTitle] = []
}
def removeBook(library,bookTitle) {
    library.remove(bookTitle)
}
def lendBook(library,bookTitle,borrowerName) {
    library[bookTitle] << borrowerName
}
def returnBook(library,bookTitle,borrowerName) {
    library[bookTitle].remove(borrowerName)
}
def displayLoanStock(library) {
    println "Library stock:${library}\n"
}
def readNumberBorrowedBooks(library,borrowerName) {
    def borrowerNames = library.values().asList()
    borrowerNames = borrowerNames.flatten()
    return borrowerNames.count(borrowerName)
}
def readNumberBorrowers(library,bookTitle) {
    return library[bookTitle].size()
}

//第一个测试用例
displayLoanStock(library)

//其他方法和程序控制结构
def readBookTitle() {
    print('\tEnter book title:')
    return Console.readLine()
}
def doAddBook = {addBook(library,readBookTitle())}
def doRemoveBook = {removeBook(library, readBookTitle())}
