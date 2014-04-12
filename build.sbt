name := "Scala Exercises"

version := "0.1-SNAPSHOT"

scalaVersion := "2.10.2"

organization := "pl.net.stepniak"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.3.11" % "test"
)

scalacOptions in Test ++= Seq("-Yrangepos")

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)
