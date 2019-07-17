package ru.list.sobols.mvppart

interface IMvpPartMainAdapterDelegate {

    fun getType(): Int

    companion object {
        val REGION_TYPE = 0
        val HOUSE_TYPE = 1
    }
}