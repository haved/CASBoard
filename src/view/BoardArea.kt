package casboard.view

import javafx.event.EventHandler
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.input.MouseEvent
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox

class CASBlock : HBox() {
    private val idLabel = Label("Id:")
    private val input = TextField()
    private val outputLabel = Label("<Output>")
    init {
        val idStackPane = StackPane(idLabel)
        idStackPane.id = "cas_block_id"

        input.id = "cas_block_input"

        outputLabel.id = "cas_block_output"

        val box = VBox(input, outputLabel)
        box.id = "cas_block_contents"

        id = "cas_block"
        children.addAll(idStackPane, box)
        isFillHeight = true
    }
}

class BoardArea : Pane() {
    private var blocks = ArrayList<CASBlock>()

    init {
        id = "board_area"

        //isFocusTraversable = true
        onMousePressed = EventHandler<MouseEvent> {
            this.requestFocus()
        }
    }

    fun spawnCASBlock() {
        val block = CASBlock()
        block.translateX = 200.0
        block.translateY = 200.0
        children.add(block)
        blocks.add(block)
    }
}