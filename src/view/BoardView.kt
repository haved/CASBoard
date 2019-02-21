package casboard.view

import javafx.scene.Group
import javafx.scene.input.MouseEvent
import javafx.scene.layout.Pane

class BoardView(private val parent: CASBoardView) : Pane() {

    private val dragGroup = Group()

    init {
        id = "board_area"
        children.add(dragGroup)

        addEventHandler(MouseEvent.MOUSE_PRESSED)  {
            this.requestFocus()
        }
    }
}