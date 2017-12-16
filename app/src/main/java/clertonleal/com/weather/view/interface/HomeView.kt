package clertonleal.com.weather.view.`interface`

import clertonleal.com.weather.model.City
import clertonleal.com.weather.model.Weather
import clertonleal.com.weather.picker.PickerInput


interface HomeView {

    fun openSelectCities(cities: List<City>)
    fun openSelectWeather(weather: List<Weather>, selectedWeather: List<Weather>)
    fun openDatePicker(input: PickerInput)

}