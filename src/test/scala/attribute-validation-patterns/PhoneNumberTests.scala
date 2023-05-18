package `attribute-validation-patterns`

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import validation.phonenumber.PhoneNumber
import validation.phonenumber.PhoneNumber.{normalize, validate}

class PhoneNumberTests extends AnyWordSpec with Matchers {

  "Normalising phone numbers" should {
    "Format the country code and strip leading zeros" in {
      normalize(PhoneNumber("004414941231234")) shouldBe PhoneNumber("+4414941231234")
    }
  }

  "Validating phone numbers" should {
    "Accept a valid phone number" in {
      validate(PhoneNumber("+4414941231234")) shouldBe true
    }

    "Reject a string which contains invalid characters" in {
      validate(PhoneNumber("nophone4ulol")) shouldBe false
    }
  }

}
