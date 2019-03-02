package casboard.view

import casboard.controller.CASBoardController
import casboard.model.CASBlock
import casboard.model.CASBoardModel
import casboard.model.Watched
import casboard.model.WatchedList
import casboard.resource.Strings
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import javafx.stage.Stage

class CASBoardView(val controller: CASBoardController, val strings:Strings, primaryStage: Stage) {
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

    val blockListChangeListener = object : WatchedList.Listener<CASBlock> {
        override fun onAdd(added: CASBlock) {
            board.addBlockView(added)
        }

        override fun onRemove(removed: CASBlock) {
            board.removeBlockView(removed)
        }
    }

    fun onModelSet(old: CASBoardModel?, new: CASBoardModel?) {
        old?.blocks?.removeListener(blockListChangeListener, retroactive=true)
        new?.blocks?.addListener(blockListChangeListener, retroactive=true)
    }

    init {
        controller.model.addListener(object : Watched.Listener<CASBoardModel> {
            override fun onChanged(old: CASBoardModel?, new: CASBoardModel?) {
                onModelSet(old, new)
            }
        }, retroactive = true)
    }
}