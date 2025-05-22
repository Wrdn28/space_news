package com.hirokixd.newsportal

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<NewsPortal>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imageId = arrayOf(
            R.drawable.news1,
            R.drawable.news2,
            R.drawable.news3,
            R.drawable.news4,
            R.drawable.news5,
            R.drawable.news6,
            R.drawable.news7,
            R.drawable.news8,
            R.drawable.news9,
            R.drawable.news10,

        )

        heading = arrayOf(
            "ESA mencari pendanaan untuk program satelit 'keamanan dan ketahanan'",
            "Fenomena Langit Langka, Dua Planet Bersama Bulan akan Membentuk 'Wajah Tersenyum'",
            "AI dapat memberikan wawasan jika dipasangkan dengan manusia (yang tepat)",
            "NASA mengatakan kekurangan anggaran jangka panjang dapat menyebabkan pengurangan kru ISS dan pengurangan penelitian",
            "Roket SpaceX Meluncur Jemput 2 Astronot yang Sudah 9 Bulan Terjebak di Luar Angkasa",
            "Cina Mulai Rakit Jaringan 2.800 Satelit Superkomputer AI di Antariksa",
            "Bukti Terkuat Adanya Kehidupan di Luar Bumi Ditemukan",
            "Crew Packs Dragon for Thursday Departure and Keeps Up Research",
            "Devil’s in Details in Selfie Taken by NASA’s Mars Perseverance Rover",
            "Discovery Alert: A Possible Perpendicular Planet",
        )

        newRecyclerView = findViewById(R.id.recycleview)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<NewsPortal>()
        getuserdata()
    }

    private fun getuserdata() {
        for(i in imageId.indices) {
            val news = NewsPortal(imageId[i], heading[i])
            newArrayList.add(news)
        }

        newRecyclerView.adapter = MyAdapter(newArrayList)
    }
}