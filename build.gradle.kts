plugins {
  `java-library`
  `maven`
}

group = "io.djy"
version = "0.0.1"

repositories {
  jcenter()
  maven(url = "http://clojars.org/repo")
}

tasks.test {
  useJUnitPlatform()

  testLogging {
    showStandardStreams = true
  }
}

dependencies {
  api("alda:core:0.5.4")
  api("alda:server-clj:0.5.0")
  api("alda:sound-engine-clj:1.2.3")
  api("org.clojure:clojure:1.10.1")

  testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.0")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.0")
}
