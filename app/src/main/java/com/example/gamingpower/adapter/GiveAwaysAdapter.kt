package com.example.gamingpower.adapter



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamingpower.Model.GiveAwayItem
import com.example.gamingpower.Utils.GiveAwayState
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

class GiveawayAdapter(
    private val giveAwayItemBinding: GiveAwayItemBinding,
    private val giveaways: MutableList<GiveAwayItem> = mutableListOf()
) : RecyclerView.Adapter<GiveAwayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiveAwayViewHolder {
        return GiveAwayViewHolder(
            giveAwayItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ) as GiveAwayItemBinding
        )
    }
    class GiveAwayItemBinding {


        val root: View,
        val giveawayImage: Any,

        fun inflate(from: LayoutInflater?, parent: ViewGroup, b: Boolean): Any {
            return toString()
        }
    }
    override fun onBindViewHolder(holder: GiveAwayViewHolder, position: Int) =
        holder.bind(giveaways[position])

    override fun getItemCount(): Int = giveaways.size

    fun setNewGiveaways(newGiveaways: List<GiveAwayState>) {
        giveaways.clear()
        giveaways.addAll(giveaways)
        notifyDataSetChanged()
    }
}


class GiveAwayViewHolder(
    private val binding : GiveawayAdapter.GiveAwayItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(giveaways: GiveAwayItem) {
        Picasso.get()
            .load(giveaways.image)
            .into(binding.giveawayImage)
    }

}

private fun RequestCreator.into(giveawayImage: Any) {
}

