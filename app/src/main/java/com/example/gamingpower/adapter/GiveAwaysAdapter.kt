package com.example.gamingpower.adapter



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamingpower.Model.GiveAwayItem
import com.example.gamingpower.Utils.GiveAwayState
import com.squareup.picasso.Picasso

class GiveawayAdapter(
    private val giveaways: MutableList<GiveAwayItem> = mutableListOf()
) : RecyclerView.Adapter<GiveAwayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiveAwayViewHolder {
        return GiveAwayViewHolder(
            GiveAwayItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GiveAwayViewHolder, position: Int) =
        holder.bind(giveaways[position])

    override fun getItemCount(): Int = giveaways.size

    fun setNewGiveaways(newGiveaways: List<GiveAwayState>) {
        giveaways.clear()
        giveaways.addAll(newGiveaways)
        notifyDataSetChanged()
    }
}


class GiveAwayViewHolder(
    private val binding: GiveawayItemBinding
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(giveaways: GiveAwayItem) {
        binding.giveawayDate.text = giveaways.endDate
        binding.giveawayPlatform.text = giveaways.platforms
        binding.giveawayTitle.text = giveaways.title
        binding.giveawayWorth.text = giveaways.worth
        binding.giveawayStatus.text = giveaways.status

        Picasso.get()
            .load(giveaways.image)
            .into(binding.giveawayImage)
    }

}