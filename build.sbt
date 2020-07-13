name := "Anno Domini"

version := "0.0.1"

scalaVersion := "2.13.2"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.1.2"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.2" % "test"

libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "2.1.1"

//injections
libraryDependencies += "com.google.inject" % "guice" % "4.1.0"
libraryDependencies += "net.codingwell" %% "scala-guice" % "4.2.11"

libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.3.0"
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.9.0"