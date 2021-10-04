trait Temperature

object TemperatureConverter:

  def celsiusToFahrenheit(tempCelsius: Double): Double = ???

  def fahrenheitToCelsius(tempFahrenheit: Double): Double  = ???

  /**
   * Strings are expected in the format '42C' or '42F'.
   *
   * See the tests for a more formal definition of the expected
   * behaviour.
   */
  def parse(input: String): Either[String, Temperature] = ???

  def convert(temperature: Temperature): Temperature = ???
