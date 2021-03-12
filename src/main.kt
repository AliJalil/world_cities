import model.City
import java.io.File

fun main() {

    //region init
    //open csv file
    val citiesFile = File("worldcities.csv")

    //check if file not exists
    if (!citiesFile.exists()){
        showError("file not found")
        return
    }

    val citiesList = mutableListOf<City>()

    citiesFile.forEachLine {
        citiesList.add(City.fromCSV(it))
    }
    //endregion

    println("total population: ${getTotalPopulation(citiesList)}")
    println("population of far east city: ${getPopulationOfFarEastCity(citiesList)}")
    println("cities start with 'B': ${countOfCitiesStartWith(citiesList, 'B')}")
    println("cities belong Iraq: ${countOfCitiesBelongCountry(citiesList, "Iraq")}")

}

fun showError(message: String){
    println("Error: $message")
}

fun getTotalPopulation(list: MutableList<City>): Long = list.sumOf { it.population }.toLong()

fun getPopulationOfFarEastCity(list: MutableList<City>): Long{
    list.sortBy { it.longitude }
    return list.last().population.toLong()
}

fun countOfCitiesStartWith(list: MutableList<City>, char: Char) = list.filter { it.cityName.startsWith(char) }.size

fun countOfCitiesBelongCountry(list: MutableList<City>, country: String) = list.filter { it.countryName == country }.size