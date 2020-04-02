package erikjhordanrey.github.io.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import erikjhordanrey.github.io.databinding.ItemTrendingViewTypeBinding

class TrendingViewTypeViewHolder(private val binding: ItemTrendingViewTypeBinding, private val onSeeMoreListener: ((String) -> Unit)?) :
        RecyclerView.ViewHolder(binding.root) {

    fun bind() {
        itemView.setOnClickListener { onSeeMoreListener?.invoke(binding.titleTextView.text.toString()) }
    }
}
