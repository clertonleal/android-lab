package clertonleal.com.weather.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import clertonleal.com.weather.R
import clertonleal.com.weather.adapter.holder.DataBindingViewHolder
import clertonleal.com.weather.databinding.RowWeatherBinding
import clertonleal.com.weather.model.Weather
import clertonleal.com.weather.viewModel.WeatherViewModel

class WeatherAdapter(private val weather: ArrayList<Weather>,
                     var selectedWeather: ArrayList<Weather>) :
        RecyclerView.Adapter<DataBindingViewHolder<RowWeatherBinding>>() {

    override fun onBindViewHolder(holder: DataBindingViewHolder<RowWeatherBinding>?, position: Int) {
        holder?.binding?.viewModel = WeatherViewModel(weather[position],
                selectedWeather.contains(weather[position]),
                { selected ->
                    if (selectedWeather.contains(selected)) {
                        selectedWeather.remove(selected)
                    } else {
                        selectedWeather.add(selected)
                    }

                    notifyItemChanged(position)
                })
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DataBindingViewHolder<RowWeatherBinding> {
        val binding = DataBindingUtil.inflate<RowWeatherBinding>(LayoutInflater.from(parent?.context), R.layout.row_weather, parent, false)
        return DataBindingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return weather.size
    }
}