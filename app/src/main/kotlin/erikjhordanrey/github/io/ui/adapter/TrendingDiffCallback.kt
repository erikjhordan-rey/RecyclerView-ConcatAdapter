package erikjhordanrey.github.io.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import erikjhordanrey.github.io.domain.Trending

class TrendingDiffCallback : DiffUtil.ItemCallback<Trending>() {

    override fun areItemsTheSame(oldItem: Trending, newItem: Trending) =
            oldItem.id == newItem.id && oldItem.title == newItem.title && oldItem.viewsCounter == newItem.viewsCounter

    override fun areContentsTheSame(oldItem: Trending, newItem: Trending) = oldItem == newItem
}
