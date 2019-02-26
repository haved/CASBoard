package casboard.view

import casboard.model.CASBlock
import javafx.scene.Group
import javafx.scene.input.MouseEvent
import javafx.scene.layout.Pane
import view.BlockView

class BoardView(private val parent: CASBoardView) : Pane() {
    private val dragGroup = Group()
    private val blockViews = HashMap<CASBlock, BlockView>()

    init {
        id = "board_area"
        children.add(dragGroup)

        addEventHandler(MouseEvent.MOUSE_PRESSED)  {
            this.requestFocus()
        }
    }

    fun addBlockView(model: CASBlock) {
        if(blockViews.contains(model)) {
            error("CASBlock already has a BlockView, but was added again. Something is wrong")
            return
        }
        val view = BlockView(model, this)
        dragGroup.children.add(view)
        blockViews.set(model, view)
    }

    fun removeBlockView(model: CASBlock) {
        if(!blockViews.contains(model)) {
            error("Tried to remove a CASBlock from the BoardView that didn't exist. Something is wrong")
            return
        }

        val view = blockViews[model]
        dragGroup.children.remove(view)
        blockViews.remove(model)
    }
}