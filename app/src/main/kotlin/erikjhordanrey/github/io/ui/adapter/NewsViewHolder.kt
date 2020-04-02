package erikjhordanrey.github.io.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import erikjhordanrey.github.io.databinding.ItemNewsBinding
import erikjhordanrey.github.io.domain.News

class NewsViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(news: News, onNewsListener: ((News) -> Unit)?) = news.run {
        binding.dateCategoryTextView.text = dateCategory
        binding.titleTextView.text = title
        itemView.setOnClickListener { onNewsListener?.invoke(this) }
    }
}
