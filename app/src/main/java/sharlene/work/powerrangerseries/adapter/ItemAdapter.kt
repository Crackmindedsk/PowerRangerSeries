package sharlene.work.powerrangerseries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sharlene.work.powerrangerseries.R
import sharlene.work.powerrangerseries.model.PowerRanger

class ItemAdapter (
    private val context: Context,
    private val  data: List<PowerRanger>
    ):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

        class ItemViewHolder(view: View):RecyclerView.ViewHolder(view){
            val imageView:ImageView=view.findViewById(R.id.list_image)
            val textView:TextView=view.findViewById(R.id.list_item)


        }
    //size of the data (list)
    override fun getItemCount()=data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout=LayoutInflater.from(parent.context).inflate(R.layout.list,parent,false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item=data[position]
        holder.textView.text=context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }
}