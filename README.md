# alda4j

> **Experimental:** use at your own peril!

A convenient wrapper library for using [Alda](https://alda.io) (implemented in
Clojure) entirely in a single client, which could be written in Java or any
other JVM language.

NB: The Clojure runtime can take a good 5-10 seconds to load. This bootstrapping
process occurs as soon as you [use the Clojure Java
API](https://clojure.org/reference/java_interop#_calling_clojure_from_java). The
delay makes Clojure unsuitable for implementing command line applications, which
is the reason that Alda is implemented as a thin Java client communicating with
a Clojure server process. Depending on your needs, the delay might be
acceptable. If so, this library might be up your alley!

## Artifact

Latest version: [ ![Download](https://api.bintray.com/packages/daveyarwood/maven/alda4j/images/download.svg) ](https://bintray.com/daveyarwood/maven/alda4j/_latestVersion)

Artifacts are deployed to JCenter (repo URL: http://jcenter.bintray.com). Gradle
users can simply add `jcenter()` to the `repositories` section of their
`build.gradle`. For Maven, etc., see [this StackOverflow
answer](https://stackoverflow.com/questions/44265547/how-to-properly-specify-jcenter-repository-in-maven-config/44304245).

To add alda4j as a dependency in your project:

> NB: Replace `VERSION` below with the version you want to use.

### Maven

```xml
<dependency>
  <groupId>io.djy</groupId>
  <artifactId>alda4j</artifactId>
  <version>VERSION</version>
  <type>pom</type>
</dependency>
```

### Gradle

#### Groovy DSL (build.gradle)

```groovy
compile 'io.djy:alda4j:VERSION'
```

#### Kotlin DSL (build.gradle.kts)

```kotlin
compile("io.djy:alda4j:VERSION")
```

## Example

There is an example in the `example` directory. See
[App.java](example/src/main/java/alda4j/example/App.java).

To build and run the example, run `bin/example`.

## License

Copyright © 2019 Dave Yarwood

Distributed under the Eclipse Public License version 2.0.
