package view

import casboard.model.CASBlock
import casboard.view.BoardView
import javafx.scene.control.Label
import javafx.scene.layout.Pane

class BlockView(private val model: CASBlock, private val parent: BoardView) : Pane() {
    init {
        id = "cas_block"
        children.add(Label("Hei"))
    }
}
