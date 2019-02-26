package casboard.controller

import casboard.model.CASBoardModel
import casboard.view.CASBoardView

class CASBoardController(m: CASBoardModel, private val close_fun:(code:Int)->Unit, view_gen:(c:CASBoardController)->CASBoardView) {
    @Suppress("JoinDeclarationAndAssignment") //We pass this to the view, so postpone as much as possible
    val view : CASBoardView
    var model = m
    set(value) {
        view.onModelSet(field, value)
        field = value
    }

    init {
        view = view_gen(this)
        view.onModelSet(null, model)
    }

    fun addCASBlock() {
        //model.blocks.add(CASBlock())
    }

    fun exitWanted() {
        //TODO: Test for unsaved changes
        close_fun(0)
    }
}