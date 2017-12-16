package clertonleal.com.weather.adapter.holder

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView


open class DataBindingViewHolder<out T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)