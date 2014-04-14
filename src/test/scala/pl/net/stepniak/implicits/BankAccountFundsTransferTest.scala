package pl.net.stepniak.implicits

import org.specs2.mutable.Specification
import pl.net.stepniak.traits.Logger
import org.specs2.mock.Mockito


class BankAccountFundsTransferTest extends Specification with Mockito {

  implicit val loggerMock: Logger = mock[Logger]

  val explicitLoggerMock = mock[Logger]

  val firstBankAccount = mock[BankAccount]

  val secondBankAccount = mock[BankAccount]

  val bankAccountFundsTransfer = new BankAccountFundsTransfer

  val validTransactionAmount = BigDecimal.valueOf(100.0)

  "BankAccountFundsTransfer" should {
    "call two times implicitly set logger" in {
      bankAccountFundsTransfer.runTransaction(validTransactionAmount, firstBankAccount, secondBankAccount)
      there was two(loggerMock).log(any[String])
    }

    "call two times explicitly set logger" in {      
      bankAccountFundsTransfer.runTransaction(validTransactionAmount, firstBankAccount, secondBankAccount)(explicitLoggerMock)
      there was two(explicitLoggerMock).log(any[String])
    }
  }
}
