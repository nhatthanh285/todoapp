package com.dat.androidhmi.composetodolist.foundation.extension

import androidx.compose.ui.text.input.TextFieldValue
import com.dat.androidhmi.composetodolist.features.todo.group.ui.CreateGroupState
import com.dat.androidhmi.composetodolist.features.todo.group.ui.isValidGroupName
import org.junit.Assert
import org.junit.Test

class CreateGroupStateExtTest {

    @Test
    fun validGroupName() {
        Assert.assertTrue(CreateGroupState(TextFieldValue("name")).isValidGroupName())
    }

    @Test
    fun invalidGroupName() {
        Assert.assertFalse(CreateGroupState(TextFieldValue("")).isValidGroupName())
    }

}
