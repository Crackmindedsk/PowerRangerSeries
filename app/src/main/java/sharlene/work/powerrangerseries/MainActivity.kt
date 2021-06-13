package sharlene.work.powerrangerseries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import sharlene.work.powerrangerseries.adapter.ItemAdapter
import sharlene.work.powerrangerseries.data.Datasource

class MainActivity : AppCompatActivity() {
    companion object {
        val TITTLE="title"
        val SEARCH_PREFIX="https://www.google.com/search?q="
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myData=Datasource().loadList()
        val recyclerView=findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter=ItemAdapter(this,myData)
        recyclerView.setHasFixedSize(true)

    }
}