plugins {
  java
  application
}

repositories {
  jcenter()
  mavenLocal()
  maven("https://clojars.org/repo")
}

dependencies {
  compile("io.djy:alda4j:0.0.9")
  compile("jline:jline:2.14.6")
}

application {
  mainClassName = "alda4j.example.App"
}

val run by tasks.getting(JavaExec::class) {
  standardInput = System.`in`
}

val fatJar = task("fatJar", type = Jar::class) {
  baseName = "${project.name}-fat"
  manifest {
    attributes["Main-Class"] = "alda4j.example.App"
  }
  from(configurations.compile.get().map({ if (it.isDirectory) it else zipTree(it) }))
  from(configurations.runtime.get().map({ if (it.isDirectory) it else zipTree(it) }))
  with(tasks["jar"] as CopySpec)
}

tasks {
  "build" {
    dependsOn(fatJar)
  }
}
