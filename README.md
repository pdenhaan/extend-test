# extend-test

Extending a protocol to a type works fine in the REPL and the built-in ring server,
but fails miserably for me in a servlet container (I tried both Tomcat 7 and Jetty 8).
This ring project demonstrates the problem.

When running "lein ring server-headless", the output when visiting the site root is
as expected:

    Test Successful

But in Tomcat and Jetty the following exception is thrown:

    java.lang.IllegalArgumentException: No implementation of method: :bar of protocol: #'extend-test.core.handler/FooProtocol found for class: extend_test.core.handler.FooRecord
        clojure.core$_cache_protocol_fn.invoke(core_deftype.clj:544)
        extend_test.core.handler$eval44$fn__45$G__35__50.invoke(handler.clj:8)
        extend_test.core.handler$fn__65.invoke(handler.clj:16)
        compojure.core$make_route$fn__1431.invoke(core.clj:104)
        ...

I searched the clojure google group and the web. It looks like a class aliasing problem,
but I could not find any information to indicate that this behaviour is expected when
deploying to a servlet container. The problem has me stumped.

Any ideas would be very welcome in the clojure google group or peter.denhaan@qficonsulting.com.
Thanks.

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server
