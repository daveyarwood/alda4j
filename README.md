# alda4j

> **Experimental:** use at your own peril!

A convenient wrapper library for using Alda (implemented in Clojure) entirely in
a single client, which could be written in Java or any other JVM language.

NB: The Clojure runtime can take a good 5-10 seconds to load. This bootstrapping
process occurs as soon as you [use the Clojure Java
API](https://clojure.org/reference/java_interop#_calling_clojure_from_java). The
delay makes Clojure unsuitable for implementing command line applications, which
is the reason that Alda is implemented as a thin Java client communicating with
a Clojure server process. Depending on your needs, the delay might be
acceptable. If so, this library might be up your alley!

## License

Copyright © 2019 Dave Yarwood

Distributed under the Eclipse Public License version 2.0.
