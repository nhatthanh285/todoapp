package com.dat.androidhmi.composetodolist.features.todo.grouplist.ui

import com.dat.androidhmi.composetodolist.model.GroupIdWithList

sealed class UpdateGroupListAction {

    data class Change(val item: GroupIdWithList) : UpdateGroupListAction()
    object Submit : UpdateGroupListAction()

}
