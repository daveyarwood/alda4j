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

## Setup

Alda4j artifacts are deployed to JCenter. Alda4j depends on Alda libraries
(written in Clojure) that are deployed to Clojars. As such, the following two
repositories need to be available to your build tool:

* http://jcenter.bintray.com
* https://clojars.org/repo

The artifact group ID is `io.djy` and the artifact ID is `alda4j`. The latest
deployed version is: [ ![Download](https://api.bintray.com/packages/daveyarwood/maven/alda4j/images/download.svg) ](https://bintray.com/daveyarwood/maven/alda4j/_latestVersion)

### Maven

See [this StackOverflow
answer](https://stackoverflow.com/questions/44265547/how-to-properly-specify-jcenter-repository-in-maven-config/44304245) for details about adding repositories to your Maven project.

Basically, you need to add the following to the `<repositories>` section of your
settings.xml:

```xml
<repository>
  <id>jcenter.bintray.com</id>
  <url>http://jcenter.bintray.com</url>
</repository>
<repository>
  <id>clojars.org</id>
  <url>https://clojars.org/repo</url>
</repository>
```

Add alda4j to the `<dependencies>` section of your pom.xml:

> NB: Replace `VERSION` below with the version you want to use.

```xml
<dependency>
  <groupId>io.djy</groupId>
  <artifactId>alda4j</artifactId>
  <version>VERSION</version>
  <type>pom</type>
</dependency>
```

### Gradle

#### Groovy DSL

Add `jcenter()` and `maven { url 'https://clojars.org/repo' }` to the
`repositories` section of your `build.gradle`.

Add alda4j to the dependencies:

> NB: Replace `VERSION` below with the version you want to use.

```groovy
compile 'io.djy:alda4j:VERSION'
```

#### Kotlin DSL

Add `jcenter()` and `maven("https://clojars.org/repo")` to the `repositories`
section of your `build.gradle.kts`.

Add alda4j to the dependencies:

> NB: Replace `VERSION` below with the version you want to use.

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
