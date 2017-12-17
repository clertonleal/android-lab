package clertonleal.com.weather.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import clertonleal.com.weather.R
import clertonleal.com.weather.adapter.holder.DataBindingViewHolder
import clertonleal.com.weather.databinding.RowResultBinding
import clertonleal.com.weather.model.WeatherData
import clertonleal.com.weather.viewModel.ResultListViewModel

class ResultsAdapter(private val list: List<Pair<WeatherData, WeatherData>>) : RecyclerView.Adapter<DataBindingViewHolder<RowResultBinding>>() {

    override fun onBindViewHolder(holder: DataBindingViewHolder<RowResultBinding>?, position: Int) {
        holder?.binding?.viewModel = ResultListViewModel(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DataBindingViewHolder<RowResultBinding> {
        val binding = DataBindingUtil.inflate<RowResultBinding>(LayoutInflater.from(parent?.context), R.layout.row_result, parent, false)
        return DataBindingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}