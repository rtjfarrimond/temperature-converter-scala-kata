import org.scalatest.matchers.must.Matchers
import org.scalatest.flatspec.AnyFlatSpec

class TempertatureConverterSpec extends AnyFlatSpec with Matchers:

  import TemperatureConverter._

  "celsiusToFahrenheit" must "be the same in Fahrenheit for -40C" in {
    celsiusToFahrenheit(-40.0) mustBe -40.0
  }

  it must "convert 0C to 32F" in {
    celsiusToFahrenheit(0.0) mustBe 32.0
  }

  it must "convert 100C to 212F" in {
    celsiusToFahrenheit(100.0) mustBe 212.0
  }

  it must "convert -100C to -148F" in {
    celsiusToFahrenheit(-100.0) mustBe -148.0
  }

  "fahrenheitToCelsius" must "be the same in Celsius for -40C" in {
    fahrenheitToCelsius(-40.0) mustBe -40.0
  }

  it must "convert 32F to 0C" in {
    fahrenheitToCelsius(32.0) mustBe 0.0
  }

  it must "convert 212F to 100C" in {
    fahrenheitToCelsius(212.0) mustBe 100.0
  }

  it must "convert -148F to -100C" in {
    fahrenheitToCelsius(-148.0) mustBe -100.0
  }

  "parse" must "return Left if input is the empty String" in {
    parse("") mustBe Left(???)
  }

  it must "return Left if no unit is provided" in {
    parse("42") mustBe Left(???)
  }

  it must "return Left if unit is not c or f" in {
    val unit = 'g'
    parse("42g") mustBe Left(???)
  }

  it must "return Left if no temperature is provided" in {
    val input = "c"
    parse(input) mustBe Left(???)
  }

  it must "return Left if temperature is not parsable number" in {
    val input = "fooc"
    parse(input) mustBe Left(???)
  }

  it must "return Right with Temperature in Celsius when input has lowercase c" in {
    parse("42c") mustBe Right(???)
  }

  it must "return Right with Temperature in Celsius when input has uppercase C" in {
    parse("42C") mustBe Right(???)
  }

  it must "return Right with Temperature in Fahrenheit when input has lowercase f" in {
    parse("42f") mustBe Right(???)
  }

  it must "return Right with Temperature in Fahrenheit when input has uppercase F" in {
    parse("42F") mustBe Right(???)
  }

  "convert" must "convert Temperature in Celsius to correct Temperature in Fahrenheit" in {
    convert(???) mustBe ???
  }

  it must "convert Temperature in Fahrenheit to correct Temperature in Celcius" in {
    convert(???) mustBe ???
  }
