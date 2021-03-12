package helper

import model.City

/**
 * this function take a line from csv file and parse it into City object
 * @param line a line from worldcities csv file
 * @return an instance of City with info parsed from the line
 */
fun parseLineToCity(line: String): City {
    val tokenList = line.split(",")
    return City(
        cityName = tokenList[Constatnts.CITY_INDEX],
        countryName = tokenList[Constatnts.COUNTRY_INDEX],
        latitude = tokenList[Constatnts.LATITUDE_INDEX].toDouble(),
        longitude = tokenList[Constatnts.LONGITUDE_INDEX].toDouble(),
        population = tokenList[Constatnts.POPULATION_INDEX].toDoubleOrNull() ?: 0.0
    )
}