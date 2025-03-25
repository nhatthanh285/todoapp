package com.dat.androidhmi.composetodolist.features.todo.grouplist.ui

import androidx.compose.runtime.Immutable
import com.dat.androidhmi.composetodolist.model.GroupIdWithList

@Immutable
data class UpdateGroupListState(
    val initialItems: List<GroupIdWithList> = listOf(),
    val items: List<GroupIdWithList> = listOf()
) {
    val isChanges = initialItems != items
}
