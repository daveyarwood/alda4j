plugins {
    `java-library`
}

repositories {
    jcenter()
    maven(url = "http://clojars.org/repo")
}

dependencies {
    api("alda:core:0.5.4")
    api("alda:sound-engine-clj:1.2.3")
}
