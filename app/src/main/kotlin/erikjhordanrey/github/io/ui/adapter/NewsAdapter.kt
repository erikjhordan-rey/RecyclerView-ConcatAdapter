package erikjhordanrey.github.io.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import erikjhordanrey.github.io.databinding.ItemNewsBinding
import erikjhordanrey.github.io.domain.News

class NewsAdapter : ListAdapter<News, NewsViewHolder>(NewsDiffCallback()) {

    var onNewsListener: ((News) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            NewsViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false), onNewsListener)

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)
    }
}
