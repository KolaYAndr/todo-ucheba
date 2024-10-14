package com.cleverpumpkin.network.data.utils

object ApiRoutes {
    private const val BASE_URL = "http://localhost:8000"

    fun getItemsListRoute() = "$BASE_URL/notes"

    fun getItemByIdRoute(id: String) = "$BASE_URL/notes/$id"

    fun addItemRoute() = "$BASE_URL/list"

    fun changeItemRoute(id: String) = "$BASE_URL/notes/$id"

    fun deleteItemByIdRoute(id: String) = "$BASE_URL/note/$id"
}
