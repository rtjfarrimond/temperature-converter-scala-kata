import scala.util.Try
import scala.util.Success
import scala.util.Failure

sealed trait Temperature {
  def value: Double
}
case class CelsiusTemperature(value: Double) extends Temperature
case class FahrenheitTemperature(value: Double) extends Temperature

object TemperatureConverter:

  def celsiusToFahrenheit(tempCelsius: Double): Double =
    tempCelsius * 9.0 / 5.0 + 32.0

  def fahrenheitToCelsius(tempFahrenheit: Double): Double  =
    (tempFahrenheit - 32.0) * 5.0 / 9.0

  /**
   * Strings are expected in the format '42C' or '42F'.
   *
   * See the tests for a more formal definition of the expected
   * behaviour.
   */
  def parse(input: String): Either[String, Temperature] = {
    val inputLower = input.toLowerCase
    if (inputLower == "") Left("Input was the empty String")
    else {
      val (temp, unit) = inputLower.splitAt(input.length - 1)
      (temp, unit) match {
        case ("", _) =>
          Left(s"No temperature was provided in input $inputLower")
        case (t, u) =>
          Try(u.toInt) match {
            case Success(_) =>
              Left("No unit was provided")
            case Failure(_) =>
              Try(t.toDouble) match {
                case Failure(error) =>
                  Left(s"Failed to parse temperature: $error")
                case Success(tempDouble) =>
                  u match {
                    case "c" => Right(CelsiusTemperature(tempDouble))
                    case "f" => Right(FahrenheitTemperature(tempDouble))
                    case _ => Left(s"Unit must be one of c or f, but was $u")
                  }
              }
          }
      }
    }
  }

  def convert(temperature: Temperature): Temperature =
    temperature match {
      case CelsiusTemperature(v) =>
        FahrenheitTemperature(celsiusToFahrenheit(v))
      case FahrenheitTemperature(v) =>
        CelsiusTemperature(fahrenheitToCelsius(v))
    }
