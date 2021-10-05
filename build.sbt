val scala3Version = "3.0.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "Temperature Converter",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-effect"  % "3.2.9",
      "org.scalatest" %% "scalatest"    % "3.2.10" % "test"
    )
  )
