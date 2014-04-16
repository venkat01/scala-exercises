name := "Scala Exercises"

version := "0.1-SNAPSHOT"

scalaVersion := "2.10.4"

organization := "pl.net.stepniak"

libraryDependencies += "org.specs2" %% "specs2" % "2.3.11" % "test"

scalacOptions in Test ++= Seq("-Yrangepos")
