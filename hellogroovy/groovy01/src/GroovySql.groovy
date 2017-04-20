/**
 * Created by shliangyan on 2017/4/19.
 */
import groovy.sql.*
def DB = 'jdbc:derby:accountDB'
def USER = ''
def PASSWORD = ''
def DRIVER = 'or'
def sql = Sql.newInstance(DB,USER,PASSWORD,DRIVER)

println 'Accounts'
println 'Number Balance'
println '+----------+----------+'
sql.eachRow('select * from accounts'){acc ->
    printf('|%-8s|%-8d|\n',[acc.number,acc.balance])
}
