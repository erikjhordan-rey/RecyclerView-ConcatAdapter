package erikjhordanrey.github.io.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.MergeAdapter
import com.google.android.material.snackbar.Snackbar
import erikjhordanrey.github.io.data.createNewsList
import erikjhordanrey.github.io.data.createTrendingList
import erikjhordanrey.github.io.data.newsReceiver
import erikjhordanrey.github.io.databinding.ActivityMainBinding
import erikjhordanrey.github.io.ui.adapter.NewsAdapter
import erikjhordanrey.github.io.ui.adapter.TrendingAdapter

class MainActivity : AppCompatActivity() {

    private val newsAdapter by lazy { NewsAdapter() }
    private val trendingAdapter by lazy { TrendingAdapter() }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
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
        newsAdapter.onNewsListener = { Snackbar.make(binding.root, it.title, Snackbar.LENGTH_LONG).show() }
        newsAdapter.submitList(createNewsList())
        trendingAdapter.submitList(createTrendingList())
        trendingAdapter.onTrendingListener = { Snackbar.make(binding.root, it.title, Snackbar.LENGTH_LONG).show() }
        val mergeAdapter = MergeAdapter(trendingAdapter, newsAdapter)
        binding.recyclerView.adapter = mergeAdapter
    }

    private fun initNewsReceiver() {
        newsReceiver { newsAdapter.submitList(it) }
    }
}
