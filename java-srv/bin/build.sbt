lazy val root = (project in file("."))
  .settings(
    name := "spring-boot-scala-web",

    version := "1.0",

    scalaVersion := "2.11.8",

    libraryDependencies ++= Seq(
      "org.springframework.boot" % "spring-boot-starter-web" % "2.4.2",
      "org.springframework.boot" % "spring-boot-starter-aop" % "2.4.2",
      "org.springframework.boot" % "spring-boot-starter-actuator" % "2.4.2",
      "io.micrometer"%"micrometer-registry-prometheus"%"1.7.0"
     ),

    mainClass := Some("example.Main")
)
