package casboard.controller

import casboard.model.CASBlock
import casboard.model.CASBoardModel
import casboard.model.Watched
import casboard.view.CASBoardView

class CASBoardController(m: CASBoardModel, private val close_fun:(code:Int)->Unit) {
    var model = Watched(m)

    fun addCASBlock() {
        model.get().blocks.add(CASBlock())
    }

    fun exitWanted() {
        //TODO: Test for unsaved changes
        close_fun(0)
    }
}