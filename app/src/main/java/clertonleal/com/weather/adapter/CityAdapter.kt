package clertonleal.com.weather.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import clertonleal.com.weather.R
import clertonleal.com.weather.adapter.holder.DataBindingViewHolder
import clertonleal.com.weather.databinding.RowCityBinding
import clertonleal.com.weather.model.City
import clertonleal.com.weather.viewModel.CityViewModel


class CityAdapter(private val cities: List<City>, private val click: (city: City) -> Unit) : RecyclerView.Adapter<DataBindingViewHolder<RowCityBinding>>() {

    override fun onBindViewHolder(holder: DataBindingViewHolder<RowCityBinding>?, position: Int) {
        holder?.binding?.viewModel = CityViewModel(cities[position], click)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DataBindingViewHolder<RowCityBinding> {
        val binding = DataBindingUtil.inflate<RowCityBinding>(LayoutInflater.from(parent?.context), R.layout.row_city, parent, false)
        return DataBindingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return cities.size
    }
}