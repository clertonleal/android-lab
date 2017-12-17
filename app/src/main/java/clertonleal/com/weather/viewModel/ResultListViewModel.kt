package clertonleal.com.weather.viewModel

import clertonleal.com.weather.model.WeatherData
import java.text.SimpleDateFormat
import java.util.*

class ResultListViewModel(private val result: Pair<WeatherData, WeatherData>) {

    private val dateFormat = SimpleDateFormat("dd 'de' MMMM", Locale.getDefault())

    fun weatherResult() : String {
        return "De ${dateFormat.format(result.first.date)} a ${dateFormat.format(result.first.date)}"
    }

}