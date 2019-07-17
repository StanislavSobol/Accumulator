package ru.list.sobols.mvppart.houses

interface IMvpPartHousesAdapterDelegate {

    fun getType(): Int

    companion object {
        val REGION_TYPE = 0
        val HOUSE_TYPE = 1
    }
}