package pl.net.stepniak.implicits

import pl.net.stepniak.traits.Logger

class BankAccountFundsTransfer {

  def runTransaction(amount: BigDecimal, from: BankAccount, to: BankAccount)(implicit logger: Logger) {
    logger.log(s"Starting transfer $amount from ${from.accountNumber} to ${to.accountNumber}")
    from.debit(amount)
    to.credit(amount)
    logger.log("Transaction completed...")
  }
}
