object newSalaries extends App {
  val salaries = Seq(20000, 70000, 40000)
  val doubleSalary = (x: Int) => x * 2
  val newSalaries = salaries.map(doubleSalary)
  val newSalaries2 = salaries.map(x => x * 2)
  val newSalaries3 = salaries.map(_ * 2)
  println(newSalaries)
  println(newSalaries2)
  println(newSalaries3)
}

//

case class WeeklyWeatherForecast(temperatures: Seq[Double]) {
  private def convertCtoF(temp: Double) = temp * 1.8 + 32
  def forecatInFahrenheit: Seq[Double] = temperatures.map(convertCtoF)
}

//

object SalaryRaiser {

  private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =
    salaries.map(promotionFunction)

  def smallPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * 1.1)

  def greatPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * math.log(salary))

  def hugePromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * salary)
}


object domainName extends App {
  def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
    val schema = if (ssl) "https://" else "http://"
    (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
  }

  val domainName = "www.example.com"
  def getURL = urlBuilder(ssl=true, domainName)
  val endpoint = "users"
  val query = "id=1"
  val url = getURL(endpoint, query)
  println(url)
}
