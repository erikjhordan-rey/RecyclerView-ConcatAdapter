package erikjhordanrey.github.io.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import erikjhordanrey.github.io.databinding.ItemTopicsHeaderBinding

class TopicsHeaderAdapter : RecyclerView.Adapter<TopicsHeaderViewHolder>() {

    var onTopicsHeaderListener: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            TopicsHeaderViewHolder(ItemTopicsHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false),
                    onTopicsHeaderListener)

    override fun onBindViewHolder(holderTopics: TopicsHeaderViewHolder, position: Int) {
        holderTopics.bind()
    }

    override fun getItemCount() = HEADER

    companion object {
        private const val HEADER = 1
    }
}
