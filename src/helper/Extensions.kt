package helper
import model.City

fun Any?.printMe() = println(this)


fun List<City>.toCSV(): String{
    var result = ""
    this.forEach {
        result += "${it.cityName},${it.countryName},${it.latitude},${it.longitude},${it.population}\n"
    }
    return result
}