package pl.net.stepniak.implicits

class BankAccount(val accountNumber: String, val balance: BigDecimal) {

  require(balance >= java.math.BigDecimal.ZERO, "This bank account has to have positive balance!")

  def credit(amount: BigDecimal) = {
    require(amount > java.math.BigDecimal.ZERO, "Credited amount has to be higher then 0.00")
    new BankAccount(accountNumber, balance + amount)
  }

  def debit(amount: BigDecimal) = {
    require(amount <= balance, "Debit amount must be lower or equal current balance")
    new BankAccount(accountNumber, balance - amount)
  }
}
