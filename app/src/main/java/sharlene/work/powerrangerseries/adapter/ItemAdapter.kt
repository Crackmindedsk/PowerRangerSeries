package sharlene.work.powerrangerseries.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import sharlene.work.powerrangerseries.MainActivity.Companion.SEARCH_PREFIX
import sharlene.work.powerrangerseries.MainActivity.Companion.VIDEO_PREFIX
import sharlene.work.powerrangerseries.R
import sharlene.work.powerrangerseries.model.PowerRanger


class ItemAdapter (
    private val context: Context,
    private val  data: List<PowerRanger>
    ):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

        class ItemViewHolder(view: View):RecyclerView.ViewHolder(view){
            val imageButton:ImageButton=view.findViewById(R.id.list_image)
            val button:Button=view.findViewById(R.id.list_item)


        }
    //size of the data (list)
    override fun getItemCount()=data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout=LayoutInflater.from(parent.context).inflate(R.layout.list,parent,false)
        adapterLayout.accessibilityDelegate=Accessibility
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item=data[position]
        holder.button.text=context.resources.getString(item.stringResourceId)
        val word=context.resources.getString(item.stringResourceId)
        holder.imageButton.setImageResource(item.imageResourceId)
        holder.imageButton.setOnClickListener {
            val queryUrl:Uri= Uri.parse("${VIDEO_PREFIX}${word}")
            val intent=Intent(Intent.ACTION_VIEW,queryUrl)
            context.startActivity(intent)

        }
        holder.button.setOnClickListener {
            val querUrl:Uri= Uri.parse("${SEARCH_PREFIX}${word}")
            val intent=Intent(Intent.ACTION_VIEW,querUrl)
            context.startActivity(intent)
        }

    }

    companion object Accessibility: View.AccessibilityDelegate(){
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun onInitializeAccessibilityNodeInfo(host: View?, info: AccessibilityNodeInfo?) {
            super.onInitializeAccessibilityNodeInfo(host, info)
            val customString=host?.context?.getString(R.string.look_in_browser)
            val customClick=AccessibilityNodeInfo.AccessibilityAction(
                AccessibilityNodeInfo.ACTION_CLICK,
                customString
            )
            info?.addAction(customClick)
        }
    }
}