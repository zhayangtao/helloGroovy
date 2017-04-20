/**
 * Created by shliangyan on 2017/4/19.
 */
// groovy class
class Account {
    def number
    def balance

    Account(){

    }
    //构造器
    def Account(number, balance) {
        this.number = number
        this.balance = balance
    }
    def credit(amount){
        balance += amount
    }
    def debit(amount) {
        if(balance >= amount) {
            balance -= amount
        }
    }
    def display() {
        println "Account:${number} with balance:${balance}"
    }
    String toString() {
        return "Account:${number} with balance:${balance}"
    }
}
def acc = new Account(number:'ABC123',balance:1200)
println "Account ${acc.number} has balance ${acc.balance}"

def acc1 = new Account(number:'XYZ888',balance: 400)
println "Account ${acc1.number} has balance ${acc1.balance}"
println "Account ${acc1.getNumber()} has balance ${acc1.getBalance()}"

acc.credit(200)
acc.display()

class Bank{
    def name
    def accounts = [:]
    def openAccount(number,balance) {
        def acc = new Account(number:number,balance:balance)
        accounts[number] = acc
    }
    def creditAccount(number,amount){
        def acc = this.findAccount(number)
        if(acc != null) {
            acc.credit(amount)
        }
    }
    def debitAccount(number,amount){
        def acc = this.findAccount(number)
        if(acc != null) {
            acc.debit(amount)
        }
    }
    def getAccountBalance(number){
        def acc = this.findAccount(number)
        return (acc == null)?:acc.balance
    }
    def getTotalAssets() {
        def total = 0
        accounts.each {number,account ->
            total += account.balance
            return total
        }
    }
    def findAccount(number) {
        def acc = accounts.find {entry -> entry.key == number}
        return (acc == null)?:acc.value
    }
}
def bk = new Bank(name:'Community')
bk.openAccount('ABC123',1200)
bk.openAccount('DEF456',1000)
bk.creditAccount('ABC123',200)
bk.debitAccount('ABC123',900)
println "balance for account ABC123 is:${bk.getAccountBalance('ABC123')}"
println "Total assets:${bk.getTotalAssets()}"

// library 01
class Book1{
    def catalogNumber
    def title
    def author
    @Override
    String toString(){
         "Book:${catalogNumber}:${title} by:${author}"
    }
}
class Library1{
    def name
    def loanStock = [:]

    def addBook(bk){
        loanStock[bk.catalogNumber] = bk
    }
    def displayStock(){
        println "Library1:${name}"
        println '==============='
        loanStock.each {catalogNumber,book ->
            println "${book}"
        }
    }
}
def lib = new Library1(name:'Dunning')
def bk1 = new Book1(catalogNumber:'111',title:'Groovy',author:'Ken')
lib.addBook(bk1)
lib.displayStock()

// library 02 Borrowers
class Book2{
    def catalogNumber
    def title
    def author
    def borrower
    def attachBorrower(borrower) {
        this.borrower = borrower
    }
    def detachBorrower(){
        borrower = null
    }
    @Override
    String toString(){
        return "Book:${catalogNumber}:${title} by:${author}"
    }
}
class Borrower{
    def membershipNumber
    def name
    def borrowerBooks = [:]
    def attachBook(bk) {
        borrowerBooks[bk.catalogNumber] = bk
        bk.attachBorrower(this)
    }
    def detachBook(bk){
        borrowerBooks.remove(bk.catalogNumber)
        bk.detachBorrower()
    }
    String toString(){
        return "Borrower:${membershipNumber};${name}"
    }
}
class Library2{

}