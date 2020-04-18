lazy val harmonyDemo = project.in(file("."))
  .enablePlugins(SbtIdeaPlugin)
  .settings(
    scalaVersion := "2.12.11",
    intellijPlugins += "org.intellij.scala".toPlugin
  )

lazy val harmonyRunner = createRunnerProject(harmonyDemo)