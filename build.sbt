import sbtcrossproject.CrossProject
import sbtcrossproject.CrossType

lazy val cross = CrossProject("test", file("."))(JVMPlatform, JSPlatform)
  .crossType(CrossType.Full)
  .settings(
    scalaVersion := "2.12.8",
    libraryDependencies += "org.scalatest" %%% "scalatest" % "3.0.7" % "test"
  )
  .jsSettings(
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.3",
    scalaJSStage := FastOptStage,
    jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv()
  )

lazy val crossJS = cross.js
lazy val crossJVM = cross.jvm
