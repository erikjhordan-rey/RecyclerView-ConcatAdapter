package erikjhordanrey.github.io.data

import erikjhordanrey.github.io.domain.News
import erikjhordanrey.github.io.domain.Trending
import java.util.Random
import java.util.Timer
import java.util.TimerTask

import java.util.concurrent.TimeUnit

private const val PERIOD_SECONDS: Long = 2
private const val MIN_INDEX = 0

private val timer = Timer()
private val random = Random()
private val period = TimeUnit.SECONDS.toMillis(PERIOD_SECONDS)

internal fun newsReceiver(onNewsList: ((List<News>) -> Unit)) {
    timer.schedule(object : TimerTask() {
        override fun run() {
            val newsList = createNewsList()
            var randomMax = random.nextInt(newsList.size)

            when (randomMax) {
                MIN_INDEX -> {
                    randomMax += 1
                }
            }
            onNewsList.invoke(newsList.subList(MIN_INDEX, randomMax))
        }
    }, period, period)
}

fun createTrendingList() = mutableListOf<Trending>().apply {
    for (i in 1..5) {
        add(Trending(i.toString(), "Trending $i", "${i * 1000} views"))
    }
}

fun createNewsList() = mutableListOf<News>().apply {
    for (i in 1..10) {
        add(News("News $i", "Music · Yesterday"))
    }
}
