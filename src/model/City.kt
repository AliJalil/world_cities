package model

import helper.parseLineToCity

data class City(
    val cityName: String,
    val countryName: String,
    val latitude: Double,
    val longitude: Double,
    val population: Double
){

    companion object{
        fun fromCSV(line: String): City = parseLineToCity(line)
    }
}