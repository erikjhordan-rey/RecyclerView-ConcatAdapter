package erikjhordanrey.github.io.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import erikjhordanrey.github.io.databinding.ItemTrendingBinding
import erikjhordanrey.github.io.domain.Trending

class TrendingAdapter : ListAdapter<Trending, TrendingViewHolder>(TrendingDiffCallback()) {

    var onTrendingListener: ((Trending) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            TrendingViewHolder(ItemTrendingBinding.inflate(LayoutInflater.from(parent.context), parent, false), onTrendingListener)

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        val trending = getItem(position)
        holder.bind(trending)
    }

    fun onClear() {
        onTrendingListener = null
    }
}
