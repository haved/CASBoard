package casboard.view

import javafx.scene.Scene
import javafx.scene.control.*
import javafx.stage.Stage
import javafx.scene.image.Image
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox

class CASMenuBar : MenuBar() {
    init {
        val file = Menu("File")
        val new = MenuItem("New")
        val open = MenuItem("Open")
        val save = MenuItem("Save")
        val saveAs = MenuItem("SaveAs")
        val exit = MenuItem("Exit")
        file.items.addAll(new, open, save, saveAs, SeparatorMenuItem(), exit)

        val edit = Menu("Edit")
        val undo = MenuItem("Undo")
        val redo = MenuItem("Redo")
        edit.items.addAll(undo, redo)

        menus.addAll(file, edit)
    }
}

//TODO: We would want this to be part of the css
const val TOOLBAR_ICON_HEIGHT = 32.0

class CASBoardView(primaryStage: Stage) {
    private val menubar = CASMenuBar()
    private val toolbar = CASToolBar(TOOLBAR_ICON_HEIGHT)
    private val board = BoardArea()
    private val scene : Scene

    init {
        primaryStage.title = casboard.CASBOARD_NAME
        primaryStage.icons.add(Image("icon.png"))

        val vBox = VBox(menubar, toolbar, board)
        VBox.setVgrow(board, Priority.ALWAYS)

        scene = Scene(vBox, 960.0, 600.0)
        scene.stylesheets.add("style.css")
        primaryStage.scene = scene
        primaryStage.show()
    }

    fun setFontSize() {
        TODO("ability to se font size")
    }

    fun spawnCASBlock() = board.spawnCASBlock()
}