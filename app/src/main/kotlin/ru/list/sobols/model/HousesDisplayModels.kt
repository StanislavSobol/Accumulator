package ru.list.sobols.model

import ru.list.sobols.mvppart.houses.IMvpPartHousesAdapterDelegate

data class RegionListItemDislpayModel(val region: String) : IMvpPartHousesAdapterDelegate {

    override fun getType() = IMvpPartHousesAdapterDelegate.REGION_TYPE
}

data class HouseListItemDisplayModel(val name: String, val region: String) : IMvpPartHousesAdapterDelegate {

    override fun getType() = IMvpPartHousesAdapterDelegate.HOUSE_TYPE

    companion object {

        fun listFromHouseModels(houseModels: List<HouseModel>): List<IMvpPartHousesAdapterDelegate> {
            val result = mutableListOf<IMvpPartHousesAdapterDelegate>()
            var region: String? = null

            houseModels.sortedBy { item -> item.region }.forEach { item ->
                run {
                    if (region == null || region != item.region) {
                        result.add(RegionListItemDislpayModel(item.region))
                        result.add(HouseListItemDisplayModel(item.name, item.region))
                        region = item.region
                    } else {
                        result.add(HouseListItemDisplayModel(item.name, item.region))
                    }
                }
            }

            return result
        }
    }
}

