package casboard.controller

import casboard.model.CASBoardModel
import casboard.view.CASBoardView

class CASBoardController(private var model: CASBoardModel, view_gen:(c:CASBoardController)->CASBoardView) {
    val view = view_gen(this)

    init {
        view.onModelSet(null, model)
    }

    fun setModel(model: CASBoardModel) {
        view.onModelSet(this.model, model)
        this.model = model
    }
    fun getModel() = model
}