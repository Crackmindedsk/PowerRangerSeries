package sharlene.work.powerrangerseries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import sharlene.work.powerrangerseries.adapter.ItemAdapter
import sharlene.work.powerrangerseries.data.Datasource

class MainActivity : AppCompatActivity() {
    companion object {
        val TITTLE="title"
        val SEARCH_PREFIX="https://www.google.com/search?q="
        val VIDEO_PREFIX="https://www.youtube.com/results?search_query="
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showDialog()
        setContentView(R.layout.activity_main)


        val myData=Datasource().loadList()
        val recyclerView=findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter=ItemAdapter(this,myData)
        recyclerView.setHasFixedSize(true)
    }
    private fun showDialog(){
     MaterialAlertDialogBuilder(this)
         .setTitle("Instructions")
         .setMessage("Click on image to find the season on youtube.\n\nClick on text to find about the show and cast.")
         .setCancelable(true)
         .setNegativeButton("OK"){_,_->this}
         .show()
    }
}