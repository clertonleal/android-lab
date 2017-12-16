package clertonleal.com.weather.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import clertonleal.com.weather.R
import clertonleal.com.weather.adapter.holder.DataBindingViewHolder
import clertonleal.com.weather.databinding.RowHomeWeatherBinding
import clertonleal.com.weather.model.Weather
import clertonleal.com.weather.viewModel.WeatherHomeViewModel

class WeatherHomeAdapter(private var selectedWeather: ArrayList<Weather>, private val click: () -> Unit) :
        RecyclerView.Adapter<DataBindingViewHolder<RowHomeWeatherBinding>>() {

    override fun onBindViewHolder(holder: DataBindingViewHolder<RowHomeWeatherBinding>?, position: Int) {
        holder?.binding?.viewModel = WeatherHomeViewModel(selectedWeather[position], click)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DataBindingViewHolder<RowHomeWeatherBinding> {
        val binding = DataBindingUtil.inflate<RowHomeWeatherBinding>(LayoutInflater.from(parent?.context), R.layout.row_home_weather, parent, false)
        return DataBindingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return selectedWeather.size
    }

    fun setData(data: List<Weather>) {
        selectedWeather = data as ArrayList<Weather>
        notifyDataSetChanged()
    }
}