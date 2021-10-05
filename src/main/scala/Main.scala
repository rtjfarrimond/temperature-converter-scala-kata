import cats.effect.ExitCode
import cats.effect.IO
import cats.effect.IOApp
import scala.io.StdIn.readLine
import TemperatureConverter._


object Main extends IOApp:

  def run(args: List[String]): IO[ExitCode] =

    val message = """
This program converts temperatures between units of Fahrenheit and Celsius.

When prompted, please enter a temperature in the following format: 42F

In the example above, the F indicates that this is a temperature in
Fahrenheit.

For a temperature in Celsius, we would instead use C, as in: 42C

It does not matter whether the unit is uppercase or lowercase, but there
must be no space between the number indicating the temperature and the
letter indicating the unit.

Please enter the temperature to convert:"""

    val program: IO[Unit] =
      for {
        _ <- IO(println(message))
        user_input <- IO(readLine())
        parsedTemperatureOrErrorString = TemperatureConverter.parse(user_input)
      } yield {
        val outputStringOrErrorString = parsedTemperatureOrErrorString.map { temperature =>
          val converted = TemperatureConverter.convert(temperature)
          converted match {
            case CelsiusTemperature(value) =>
              s"$value degrees Celsius"
            case FahrenheitTemperature(value) =>
              s"$value degrees Fahrenheit"
          }
        }

        outputStringOrErrorString match {
          case Left(error) =>
            println(error)
          case Right(output) =>
            println(output)
        }
      }

    program.as(ExitCode.Success)
