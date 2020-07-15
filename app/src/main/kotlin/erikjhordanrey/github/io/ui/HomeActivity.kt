package erikjhordanrey.github.io.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter

import com.google.android.material.snackbar.Snackbar
import erikjhordanrey.github.io.data.createNewsList
import erikjhordanrey.github.io.data.createTrendingList
import erikjhordanrey.github.io.data.newsReceiver
import erikjhordanrey.github.io.databinding.ActivityHomeBinding
import erikjhordanrey.github.io.ui.adapter.TopicsHeaderAdapter
import erikjhordanrey.github.io.ui.adapter.NewsAdapter
import erikjhordanrey.github.io.ui.adapter.TrendingAdapter

class HomeActivity : AppCompatActivity() {

    private val topicsHeaderAdapter by lazy { TopicsHeaderAdapter() }
    private val trendingAdapter by lazy { TrendingAdapter() }
    private val newsAdapter by lazy { NewsAdapter() }

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initToolbar()
        initRecyclerView()
        initNewsReceiver()
    }

    override fun onDestroy() {
        super.onDestroy()
        topicsHeaderAdapter.onClear()
        trendingAdapter.onClear()
        newsAdapter.onClear()
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbar)
    }

    private fun initRecyclerView() {
        val concatAdapter = ConcatAdapter(createTopicsHeaderAdapter(), createTrendingAdapter(), createNewsAdapter())
        binding.recyclerView.adapter = concatAdapter
    }

    private fun createTopicsHeaderAdapter() = topicsHeaderAdapter.apply {
        onTopicsHeaderListener = { showSnackbar(it) }
    }

    private fun createTrendingAdapter() = trendingAdapter.apply {
        submitList(createTrendingList())
        onTrendingListener = { showSnackbar(it.title) }
        onSeeMoreListener = { showSnackbar(it) }
    }

    private fun createNewsAdapter() = newsAdapter.apply {
        submitList(createNewsList())
        onNewsListener = { showSnackbar(it.title) }
    }

    private fun initNewsReceiver() {
        newsReceiver { newsAdapter.submitList(it) }
    }

    private fun showSnackbar(message: String) = Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
}
