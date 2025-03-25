package com.dat.androidhmi.composetodolist.features.todo.step.ui

sealed class StepEffect {
    data class ScrollTo(val position: Int) : StepEffect()
}
