sbtPlugin := true

name := "sbt-antlr"

organization := "com.github.stefri"

version := "0.5.1"

libraryDependencies += "org.antlr" % "antlr" % "3.5" % "compile"

scalacOptions := Seq("-deprecation", "-unchecked")

publishTo <<= version { v =>
  val reltype = if (v contains "-SNAPSHOT") "snapshot" else "release"
  val repo = s"ext-$reltype-local"
  Some(repo at s"http://artifactory.sphoniclabs.net:8081/artifactory/$repo")
}

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

crossBuildingSettings

CrossBuilding.crossSbtVersions := Seq("0.12", "0.13")
