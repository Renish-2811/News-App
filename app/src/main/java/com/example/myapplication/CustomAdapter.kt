package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class CustomAdapter(private val listener: nic) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    private val dataSet: ArrayList<news> = ArrayList()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.text_row_item, viewGroup, false)
        val ViewHolder = CustomAdapter.ViewHolder(view);

       view.setOnClickListener()
       {
           listener.Onitemclicked(dataSet[ViewHolder.adapterPosition])
       }


        return ViewHolder
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)
        val at : TextView = view.findViewById(R.id.authorss)
        val iv :ImageView = view.findViewById(R.id.imageView)

        init {
            // Define click listener for the ViewHolder's View.
        }
    }

    // Create new views (invoked by the layout manager)


    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val citem = dataSet[position]
        viewHolder.textView.text = citem.Title;
        viewHolder.at.text=citem.Author;
        Glide.with(viewHolder.itemView.context).load(citem.utimage).into(viewHolder.iv)


    }
    fun updatenews(updatenews: ArrayList<news>)
    {

        dataSet.clear();
        dataSet.addAll(updatenews)
        notifyDataSetChanged()
    }


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
interface nic
{


    fun Onitemclicked(news: news)

}

