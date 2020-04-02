package erikjhordanrey.github.io.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import erikjhordanrey.github.io.R
import erikjhordanrey.github.io.databinding.ItemTopicsHeaderBinding

class TopicsHeaderViewHolder(private val binding: ItemTopicsHeaderBinding, private val onTopicsHeaderListener: ((String) -> Unit)?) : RecyclerView.ViewHolder(binding.root) {

    fun bind() = itemView.run {
        val headerTitle = context.getString(R.string.header_text)
        binding.titleTextView.text = headerTitle
        setOnClickListener { onTopicsHeaderListener?.invoke(headerTitle) }
    }
}
