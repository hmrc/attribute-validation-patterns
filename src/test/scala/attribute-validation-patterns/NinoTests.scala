package test.scala.ExampleTest

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import validation.nino.Nino
import validation.nino.Nino.{normalize, validate}

class NinoTests extends AnyWordSpec with Matchers {

  "Normalising national insurance numbers" should {
    "should strip spaces and convert to uppercase" in {
      normalize(Nino("Ab 34 56 78 c")) shouldBe Nino("AB345678C")
    }
  }

  "Validating national insurance numbers" should {
    "accept a good nino" in {
      validate(Nino("Ab345678c")) shouldBe true
    }

    "not validate nino with invalid prefix" in {
      val badNinos = Seq(
        "DA123456A",
        "FB123456A",
        "IC123456A",
        "QE123456A",
        "UG123456A",
        "AD123456A",
        "BF123456A",
        "CI123456A",
        "EQ123456A",
        "GU123456A",
        "GO123456A",
        "BG123456A",
        "GB123456A",
        "KN123456A",
        "NK123456A",
        "NT123456A",
        "TN123456A",
        "ZZ123456A",
      )

      badNinos.foreach(n => validate(Nino(n)) shouldBe false)
    }
  }
}
