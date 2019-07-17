package ru.list.sobols.mvppart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_house.view.*
import kotlinx.android.synthetic.main.item_region.view.*
import ru.list.sobols.R

class MvpPartHousesAdapter : RecyclerView.Adapter<MvpPartHousesAdapter.Holder>() {

    private val items = mutableListOf<IMvpPartMainAdapterDelegate>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return when (viewType) {
            IMvpPartMainAdapterDelegate.REGION_TYPE ->
                Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_region, parent, false))
            IMvpPartMainAdapterDelegate.HOUSE_TYPE ->
                Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_house, parent, false))
            else -> throw IllegalStateException("Wrong type of houses adapter item")
        }
    }

    override fun getItemCount() = items.count()

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemViewType(position: Int) = items[position].getType()

    fun setItems(delegates: List<IMvpPartMainAdapterDelegate>) {
        items.clear()
        items.addAll(delegates)
        notifyDataSetChanged()
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: IMvpPartMainAdapterDelegate) {
            when (item.getType()) {
                IMvpPartMainAdapterDelegate.REGION_TYPE -> bindLetter(item as RegionListItemModel)
                IMvpPartMainAdapterDelegate.HOUSE_TYPE -> bindHouse(item as HouseListItemModel)
            }

            if (item.getType() == IMvpPartMainAdapterDelegate.REGION_TYPE) {
                bindLetter(item as RegionListItemModel)
            }
        }

        private fun bindLetter(model: RegionListItemModel) {
            itemView.houseLetter.text = model.region
        }

        private fun bindHouse(model: HouseListItemModel) {
            itemView.houseName.text = model.name
            itemView.houseRegion.text = model.region
        }

    }
}