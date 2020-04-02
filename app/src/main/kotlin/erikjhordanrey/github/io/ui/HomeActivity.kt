package erikjhordanrey.github.io.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.MergeAdapter
import com.google.android.material.snackbar.Snackbar
import erikjhordanrey.github.io.data.createNewsList
import erikjhordanrey.github.io.data.createTrendingList
import erikjhordanrey.github.io.data.newsReceiver
import erikjhordanrey.github.io.databinding.ActivityHomeBinding
import erikjhordanrey.github.io.ui.adapter.NewsAdapter
import erikjhordanrey.github.io.ui.adapter.TrendingAdapter

class HomeActivity : AppCompatActivity() {

    private val newsAdapter by lazy { NewsAdapter() }
    private val trendingAdapter by lazy { TrendingAdapter() }

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
        trendingAdapter.onClear()
        newsAdapter.onClear()
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbar)
    }

    private fun initRecyclerView() {
        val mergeAdapter = MergeAdapter(createTrendingAdapter(), createNewsAdapter())
        binding.recyclerView.adapter = mergeAdapter
    }

    private fun createNewsAdapter() = newsAdapter.apply {
        submitList(createNewsList())
        onNewsListener = { Snackbar.make(binding.root, it.title, Snackbar.LENGTH_LONG).show() }
    }

    private fun createTrendingAdapter() = trendingAdapter.apply {
        submitList(createTrendingList())
        onTrendingListener = { Snackbar.make(binding.root, it.title, Snackbar.LENGTH_LONG).show() }
    }

    private fun initNewsReceiver() {
        newsReceiver { newsAdapter.submitList(it) }
    }
}
