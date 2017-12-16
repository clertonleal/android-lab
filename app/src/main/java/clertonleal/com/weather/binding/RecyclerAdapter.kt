package clertonleal.com.weather.binding

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import clertonleal.com.weather.adapter.WeatherHomeAdapter
import clertonleal.com.weather.model.Weather

object RecyclerAdapter {
    @JvmStatic
    @BindingAdapter("data")
    fun setData(list: RecyclerView, data: List<Weather>) {
        val adapter = list.adapter
        if (adapter is WeatherHomeAdapter) {
            adapter.setData(data)
            adapter.notifyDataSetChanged()
        }
    }
}