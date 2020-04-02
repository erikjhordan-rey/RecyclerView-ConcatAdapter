package erikjhordanrey.github.io.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import erikjhordanrey.github.io.databinding.ItemNewsBinding
import erikjhordanrey.github.io.domain.News

class NewsViewHolder(private val binding: ItemNewsBinding,
                     private val onNewsListener: ((News) -> Unit)?) : RecyclerView.ViewHolder(binding.root) {

    fun bind(news: News) = news.run {
        binding.dateCategoryTextView.text = dateCategory
        binding.titleTextView.text = title
        itemView.setOnClickListener { onNewsListener?.invoke(this) }
    }
}
