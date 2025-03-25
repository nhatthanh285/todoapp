package com.dat.androidhmi.composetodolist.features.todo.grouplist.data

import com.dat.androidhmi.composetodolist.foundation.datasource.local.provider.ToDoListProvider
import com.dat.androidhmi.composetodolist.foundation.wrapper.DateTimeProvider
import com.dat.androidhmi.composetodolist.model.GroupIdWithList
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpdateGroupListEnvironment @Inject constructor(
    private val toDoListProvider: ToDoListProvider,
    override val dateTimeProvider: DateTimeProvider
) : IUpdateGroupListEnvironment {

    override fun getListWithUnGroupList(groupId: String): Flow<List<GroupIdWithList>> {
        return toDoListProvider.getListWithUnGroupList(groupId)
    }

    override suspend fun updateList(data: List<GroupIdWithList>) {
        val update = data.map { it.copy(list = it.list.copy(updatedAt = dateTimeProvider.now())) }
        toDoListProvider.updateList(update)
    }
}
