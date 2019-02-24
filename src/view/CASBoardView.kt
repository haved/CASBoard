package casboard.view

import casboard.controller.CASBoardController
import casboard.model.CASBoardModel
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import javafx.stage.Stage

class CASBoardView(val controller: CASBoardController, primaryStage: Stage) {
    private val menubar = MenuBarView(this)
    private val toolbar = ToolBarView(this)
    private val board = BoardView(this)

    init {
        primaryStage.title = casboard.CASBOARD_NAME
        primaryStage.icons.add(Image("icon.png"))

        val vBox = VBox(menubar, toolbar, board)
        VBox.setVgrow(board, Priority.ALWAYS)

        val scene = Scene(vBox, 960.0, 600.0)
        scene.stylesheets.add("style.css")
        primaryStage.scene = scene
    }

    fun onModelSet(old: CASBoardModel?, new: CASBoardModel) {

    }
}