package erikjhordanrey.github.io.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import erikjhordanrey.github.io.R
import erikjhordanrey.github.io.databinding.ItemTopicsHeaderBinding

class TopicsHeaderViewHolder(private val binding: ItemTopicsHeaderBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind() {
        binding.titleTextView.text = itemView.context.getString(R.string.header_text)
    }
}
