package casboard.view

import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.stage.Stage
import javafx.scene.image.Image
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

class Board : Group() {

}

//TODO: We would want this to be part of the css
const val TOOLBAR_ICON_HEIGHT = 32.0

class CASBoardView(primaryStage: Stage) {
    private val menubar = CASMenuBar()
    private val toolbar = CASToolBar(TOOLBAR_ICON_HEIGHT)
    private val board = Board()
    private val scene : Scene

    init {
        primaryStage.title = casboard.CASBOARD_NAME
        primaryStage.icons.add(Image("icon.png"))

        scene = Scene(VBox(menubar, toolbar, board), 960.0, 600.0)
        scene.stylesheets.add("style.css")
        primaryStage.scene = scene
        primaryStage.show()
    }

    fun setFontSize() {
        scene
    }
}