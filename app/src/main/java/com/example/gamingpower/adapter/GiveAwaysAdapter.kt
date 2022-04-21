package com.example.gamingpower.adapter



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamingpower.Model.GiveAwayItem
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator
import org.koin.core.component.getScopeId

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
        fun inflate(from: LayoutInflater?, parent: ViewGroup, b: Boolean): Any {
            return toString()
        }
    }
    override fun onBindViewHolder(holder: GiveAwayViewHolder, position: Int) =
        holder.bind(giveaways[position])

    override fun getItemCount(): Int = giveaways.size
    fun setNewGiveaways(giveaways: List<GiveAwayItem>) {

    }

}

class GiveAwayViewHolder(
    private val binding : GiveawayAdapter.GiveAwayItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(giveaways: GiveAwayItem) {

             Picasso.get()
            .load(giveaways.image)
            .into(binding.getScopeId())
    }

}

private fun RequestCreator.into(giveawayImage: Any) {
}

