plugins {
  `java-library`
  `maven`
  id("com.jfrog.bintray") version "1.8.4"
}

group = "io.djy"
version = "0.0.2"

bintray {
  user = System.getenv("BINTRAY_USER")
  key = System.getenv("BINTRAY_KEY")

  setConfigurations("archives")
  publish = true

  with(pkg) {
    repo = "maven"
    name = "alda4j"
    vcsUrl = "https://github.com/daveyarwood/alda4j.git"
    setLicenses("EPL-2.0")
  }
}

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
