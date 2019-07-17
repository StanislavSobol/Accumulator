package ru.list.sobols.mvppart.houses

data class RegionListItemModel(val region: String) : IMvpPartHousesAdapterDelegate {
    override fun getType() = IMvpPartHousesAdapterDelegate.REGION_TYPE
}

data class HouseListItemModel(val name: String, val region: String) : IMvpPartHousesAdapterDelegate {
    override fun getType() = IMvpPartHousesAdapterDelegate.HOUSE_TYPE
}