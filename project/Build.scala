import sbt._
import sbt.Keys._

object Build extends sbt.Build {

  lazy val root = Project("root", file("."))
    .settings ( globalSettings: _* )

  lazy val web = {
    play.Project(
      "web",
      "1.0-SNAPSHOT", 
      {
        import play.Project._
        Seq(jdbc, anorm)
      },
      path=file("web")
    )
      .settings( globalSettings : _* )
  }

  type Settings = Seq[Setting[_]]

  lazy val globalSettings: Settings = Seq(
    scalaVersion := "2.10.0"
  )

  lazy val scalatest = "org.scalatest" %% "scalatest" % "1.9.1"

}
