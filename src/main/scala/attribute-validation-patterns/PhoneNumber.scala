/*
 * Copyright 2023 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package validation.phonenumber

import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat

import scala.util.Try

case class PhoneNumber(unwrap: String)

object PhoneNumber {
  def validate(it: PhoneNumber): Boolean = {
    val phoneNumberUtil = PhoneNumberUtil.getInstance()
    Try(phoneNumberUtil.parse(it.unwrap, "GB")).isSuccess
  }

  def normalize(it: PhoneNumber): PhoneNumber = {
    val phoneNumberUtil = PhoneNumberUtil.getInstance()
    val pn = phoneNumberUtil.parse(it.unwrap, "GB")
    PhoneNumber(phoneNumberUtil.format(pn, PhoneNumberFormat.E164))
  }
}