package com.example.wishlist
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//extend RecyclerView.Adapter
class ItemAdapter(private var itemList: List<Item>): RecyclerView.Adapter<ItemAdapter.ViewHolder> () {
    //extend RecyclerView.ViewHolder
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val nameView: TextView
        val priceView: TextView
        val urlView: TextView

        init{
            //initialize view holder variables with views
            nameView = itemView.findViewById<TextView>(R.id.name)
            priceView  = itemView.findViewById<TextView>(R.id.price)
            urlView = itemView.findViewById<TextView>(R.id.url)
        }


    }

    fun update(newItem: Item){

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val itemView = inflater.inflate(R.layout.item_layout, parent, false)
        // Return a new holder instance
        return ViewHolder(itemView)

    }

    override fun onBindViewHolder(viewHolder: ItemAdapter.ViewHolder, position: Int){
        // Get the data model based on position
        val item: Item = itemList[position]
        // Set item views based on your views and data model
        viewHolder.nameView.text = item.name       //bind name to nameView text
        viewHolder.priceView.text = "$${item.price}"       //bind price to priceView text
        viewHolder.urlView.text = item.url    //bind url to urlView text

    }
    override fun getItemCount(): Int{
        return itemList.size
    }


}