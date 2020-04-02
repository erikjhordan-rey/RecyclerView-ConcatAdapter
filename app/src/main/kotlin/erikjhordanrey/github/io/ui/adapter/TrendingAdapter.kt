package erikjhordanrey.github.io.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import erikjhordanrey.github.io.databinding.ItemTrendingBinding
import erikjhordanrey.github.io.databinding.ItemTrendingViewTypeBinding
import erikjhordanrey.github.io.domain.Trending

class TrendingAdapter : ListAdapter<Trending, RecyclerView.ViewHolder>(TrendingDiffCallback()) {

    var onTrendingListener: ((Trending) -> Unit)? = null
    var onSeeMoreListener: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = LayoutInflater.from(parent.context).run {
        return@run when (viewType) {
            ITEM_TRENDING_TYPE -> TrendingViewHolder(ItemTrendingBinding.inflate(this, parent, false), onTrendingListener)
            ITEM_SEE_MORE_TYPE -> TrendingViewTypeViewHolder(ItemTrendingViewTypeBinding.inflate(this, parent, false), onSeeMoreListener)
            else -> throw IllegalArgumentException("Unsupported view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            ITEM_TRENDING_POSITION -> bindTrending(holder, getItem(position))
            else -> bindSeeMore(holder)
        }
    }

    override fun getItemViewType(position: Int) = if (position == itemCount - 1) ITEM_SEE_MORE_TYPE else ITEM_TRENDING_TYPE

    private fun bindTrending(holder: RecyclerView.ViewHolder, trending: Trending) = (holder as TrendingViewHolder).bind(trending)

    private fun bindSeeMore(holder: RecyclerView.ViewHolder) = (holder as TrendingViewTypeViewHolder).bind()

    fun onClear() {
        onTrendingListener = null
        onSeeMoreListener = null
    }

    companion object {

        private const val ITEM_TRENDING_TYPE = -1
        private const val ITEM_SEE_MORE_TYPE = -2

        private const val ITEM_TRENDING_POSITION = 1
    }
}
