package casboard.view

import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.scene.control.MenuItem
import javafx.scene.control.SeparatorMenuItem

class MenuBarView(private val parent: CASBoardView) : MenuBar() {
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