/**
 * Created by shliangyan on 2017/4/19.
 */

class CurrentAccount{
    def number
    def balance
    def overdraftLimit

    String toString(){
        return "Current Account:${number};balance:${balance};overdraftLimit:${overdraftLimit}"
    }
}
def accounts = [new CurrentAccount(number:'AAA111',balance: 1000,overdraftLimit: 400),
                new CurrentAccount(number:'AAA111',balance: 1000,overdraftLimit: 400)]
accounts.each {acc ->
    println acc
}


class Account1{
    def number
    def balance
    String toString(){
        return "${number};balance:${balance};"
    }
}
class CurrentAccount1 extends Account1{
    def overdraftLimit
    String toString(){
    'Current1 Account:' + super.toString() + ";${overdraftLimit}"
    }
}
accounts = [new CurrentAccount1(number:'AAA111',balance: 1000,overdraftLimit: 400),
                new CurrentAccount1(number:'AAA111',balance: 1000,overdraftLimit: 400)]
accounts.each {acc ->
    println acc
}
class DepositAccount extends Account1{

    def interestRate

    @Override
    public String toString() {
        return "DepositAccount{" +
                "interestRate=" + interestRate +
                '}';
    }
}

abstract class Account3{

    def name
    def balance
    /**
     * 抽象方法
     * @return
     */
    def abstract isOverdrawn()
}
class CurrentAccount3 extends Account3{

    def overdraftLimit
    @Override
    def isOverdrawn() {
        return balance < -overdraftLimit
    }
}
def ca = new CurrentAccount3(name:'AAA111',balance: 2000,overdraftLimit: 400)
println ca.isOverdrawn()

//接口类
interface AccountIF{
    def isOverdrwwn()
}
class AccountAB implements AccountIF{

    def number
    def balance
    @Override
    def isOverdrwwn() {
        return balance < 0
    }
}