# Temperature Converter - Scala Kata

This repo contains a [kata][uncleBobKata], written in Scala 3, where the idea
is to implement a simple command-line application that will allow a user to
convert temperature between units of Celsius and Fahrenheit.

The kata is in two parts: initially, there is a [ScalaTest][scalaTest] suite
for functions that are missing implementations (some of the tests are also
missing parts of their implementations), the first task is to make these pass
by implementing the stubs.

Once the tests are all passing, you are left with a core set of pure functions
that can be used to build an interactive application; the second task is to
build a command-line app that allows a user to provide a temperature in either
Celsius or Fahrenheit and have it converted to Fahrenheit or Celsius
respectively.

## Usage

1. Checkout the `exercise` tag using `git checkout exercise`.
1. Run `sbt test` to see the currently failing tests.
1. Implement a solution to make the tests pass.
1. If you get stuck, or just want to see a working solution where the tests
   pass, checkout the `solution` tag using `git checkout core-solution`.
1. Expand on your working code to create a command-line application.
1. If you get stuck, or just want to see a working solution where the
   command-line app is implemented, checkout the `app-solution` tag using `git
   checkout app-solution`.

### Extra credit

If it did not already, refactor your command-line application to be purely
functional using the effects system of your choice, e.g. cats-effect, Zio,
Scalaz, etc. You can see a working solution by checking out the
`effectful-solution` git tag.


[scalaTest]: https://www.scalatest.org/
[uncleBobKata]: https://sites.google.com/site/unclebobconsultingllc/home/articles/what-s-all-this-nonsense-about-katas
