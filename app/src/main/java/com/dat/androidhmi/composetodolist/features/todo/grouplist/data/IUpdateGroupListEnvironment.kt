package com.dat.androidhmi.composetodolist.features.todo.grouplist.data

import com.dat.androidhmi.composetodolist.foundation.wrapper.DateTimeProvider
import com.dat.androidhmi.composetodolist.model.GroupIdWithList
import kotlinx.coroutines.flow.Flow

interface IUpdateGroupListEnvironment {
    val dateTimeProvider: DateTimeProvider
    fun getListWithUnGroupList(groupId: String): Flow<List<GroupIdWithList>>
    suspend fun updateList(data: List<GroupIdWithList>)
}
