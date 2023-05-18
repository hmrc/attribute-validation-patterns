import sbt.Keys._
import sbt._

ThisBuild / name := "attribute-validation-patterns"
ThisBuild / organization := "uk.gov.hmrc"

val scala2_13 = "2.13.10"

lazy val `attribute-validation-patterns` = (project in file("."))
  .settings(
    scalaVersion := scala2_13,
    libraryDependencies ++= Seq(
      "com.googlecode.libphonenumber" % "libphonenumber" % "8.13.9",
      "com.googlecode.libphonenumber" % "geocoder" % "2.201",
      "org.scalatest" %% "scalatest" % "3.2.15" % Test,
      "com.vladsch.flexmark" % "flexmark-all" % "0.64.0" % Test
    ),
    Test / fork := true
  )
