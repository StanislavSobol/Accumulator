package ru.list.sobols.mvppart

data class RegionListItemModel(val region: String) : IMvpPartMainAdapterDelegate {
    override fun getType() = IMvpPartMainAdapterDelegate.REGION_TYPE
}

data class HouseListItemModel(val name: String, val region: String) : IMvpPartMainAdapterDelegate {
    override fun getType() = IMvpPartMainAdapterDelegate.HOUSE_TYPE
}