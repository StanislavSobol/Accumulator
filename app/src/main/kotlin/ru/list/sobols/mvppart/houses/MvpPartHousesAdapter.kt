package ru.list.sobols.mvppart.houses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_house.view.*
import kotlinx.android.synthetic.main.item_region.view.*
import ru.list.sobols.R
import ru.list.sobols.model.HouseListItemDisplayModel
import ru.list.sobols.model.RegionListItemDislpayModel

class MvpPartHousesAdapter : RecyclerView.Adapter<MvpPartHousesAdapter.Holder>() {

    private val items = mutableListOf<IMvpPartHousesAdapterDelegate>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return when (viewType) {
            IMvpPartHousesAdapterDelegate.REGION_TYPE ->
                Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_region, parent, false))
            IMvpPartHousesAdapterDelegate.HOUSE_TYPE ->
                Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_house, parent, false))
            else -> throw IllegalStateException("Wrong type of houses adapter item")
        }
    }

    override fun getItemCount() = items.count()

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemViewType(position: Int) = items[position].getType()

    fun setItems(delegates: List<IMvpPartHousesAdapterDelegate>) {
        items.clear()
        items.addAll(delegates)
        notifyDataSetChanged()
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: IMvpPartHousesAdapterDelegate) {
            when (item.getType()) {
                IMvpPartHousesAdapterDelegate.REGION_TYPE -> bindLetter(item as RegionListItemDislpayModel)
                IMvpPartHousesAdapterDelegate.HOUSE_TYPE -> bindHouse(item as HouseListItemDisplayModel)
            }

            if (item.getType() == IMvpPartHousesAdapterDelegate.REGION_TYPE) {
                bindLetter(item as RegionListItemDislpayModel)
            }
        }

        private fun bindLetter(dislpayModel: RegionListItemDislpayModel) {
            itemView.houseLetter.text = dislpayModel.region
        }

        private fun bindHouse(displayModel: HouseListItemDisplayModel) {
            itemView.houseName.text = displayModel.name
            itemView.houseRegion.text = displayModel.region
        }

    }
}