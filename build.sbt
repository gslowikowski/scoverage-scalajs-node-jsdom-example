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
    
    // uncomment to test with corresponding env
    // it works out of the box for these envs
    //
    //jsEnv := new org.scalajs.jsenv.nodejs.NodeJSEnv()
    //jsEnv := new org.scalajs.jsenv.rhino.RhinoJSEnv(withDOM = true)
    
    // not tested !!!
    //
    //jsEnv := new org.scalajs.jsenv.phantomjs.PhantomJSEnv()
    
    //!!! requires patching !!! for exposing `global` object
    // see for example: https://github.com/scalacenter/scalajs-bundler/pull/198/files
    //
    //jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv()

    // works with scalajs-bundler with PR: https://github.com/scalacenter/scalajs-bundler/pull/198
    //
    requireJsDomEnv in Test := true
  )

lazy val crossJS = cross.js.enablePlugins(ScalaJSBundlerPlugin)
lazy val crossJVM = cross.jvm
