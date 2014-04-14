package pl.net.stepniak.implicits

import org.specs2.mutable.Specification
import java.lang.IllegalArgumentException

class BankAccountTest extends Specification {

  val validAccountNumber = "1234-1234-0000-1234-1234"

  val positiveAccountBalance = BigDecimal.valueOf(100.0)

  val negativeAccountBalance = BigDecimal.valueOf(-2.00)

  val validCreditAmount = BigDecimal.valueOf(50.0)

  val allowedDebitAmount = BigDecimal.valueOf(4.00)
  
  val bankAccountWithPositiveBalance = new BankAccount(validAccountNumber, positiveAccountBalance)

  "BankAccount" should {
    "throw an exception if initial balance is less than 0.00" in {
      new BankAccount(validAccountNumber, negativeAccountBalance) must throwA[IllegalArgumentException]
    }

    "throw an exception if credited amount is equal 0.00" in {
      bankAccountWithPositiveBalance.credit(BigDecimal.valueOf(0.00)) must throwA[IllegalArgumentException]
    }

    "throw an exception if credited amount is less than 0.00" in {
      bankAccountWithPositiveBalance.credit(BigDecimal.valueOf(-1.00)) must throwA[IllegalArgumentException]
    }

    "increase bank account balance after credit with valid amount" in {
      val bankAccount = bankAccountWithPositiveBalance.credit(validCreditAmount)
      bankAccount.balance mustEqual (positiveAccountBalance + validCreditAmount)
    }

    "not to change account number after credit with valid amount" in {
      val bankAccount = bankAccountWithPositiveBalance.credit(validCreditAmount)
      bankAccount.accountNumber mustEqual bankAccountWithPositiveBalance.accountNumber
    }

    "throw an exception if debit amount is higher than current account balance" in {
      bankAccountWithPositiveBalance.debit(
        bankAccountWithPositiveBalance.balance + BigDecimal.valueOf(1.00)
      ) must throwA[IllegalArgumentException]
    }

    "decrease bank account balance after debit with valid amount" in {
      val bankAccount = bankAccountWithPositiveBalance.debit(allowedDebitAmount)
      bankAccount.balance mustEqual bankAccountWithPositiveBalance.balance - allowedDebitAmount
    }

    "not to change account number after debit valid amount" in {
      val bankAccount = bankAccountWithPositiveBalance.debit(allowedDebitAmount)
      bankAccount.accountNumber mustEqual bankAccountWithPositiveBalance.accountNumber
    }
  }
}
