package erikjhordanrey.github.io.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import erikjhordanrey.github.io.domain.News

class NewsDiffCallback : DiffUtil.ItemCallback<News>() {

    override fun areItemsTheSame(oldItem: News, newItem: News) =
            oldItem.title == newItem.title && oldItem.dateCategory == newItem.dateCategory

    override fun areContentsTheSame(oldItem: News, newItem: News) = oldItem == newItem
}
