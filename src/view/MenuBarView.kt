package casboard.view

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.scene.control.MenuItem
import javafx.scene.control.SeparatorMenuItem

class MenuBarView(private val parent: CASBoardView) : MenuBar() {
    fun String.load(vararg args : Any) = parent.strings.getString(this, *args)

    init {
        val file = Menu("menubar.menu.file".load())
        val new = MenuItem("New")
        val open = MenuItem("Open")
        val save = MenuItem("Save")
        val saveAs = MenuItem("SaveAs")
        val exit = MenuItem("Exit")
        exit.onAction = EventHandler<ActionEvent> {parent.controller.exitWanted()}
        file.items.addAll(new, open, save, saveAs, SeparatorMenuItem(), exit)

        val edit = Menu("Edit")
        val undo = MenuItem("Undo")
        val redo = MenuItem("Redo")
        edit.items.addAll(undo, redo)

        menus.addAll(file, edit)
    }
}