package casboard

import casboard.controller.CASBoardController
import casboard.model.CASBoardModel
import casboard.view.CASBoardView
import javafx.application.Application
import javafx.stage.Stage

const val CASBOARD_NAME = "CASBoard"

class CASApp : Application() {
    override fun start(primaryStage: Stage) {
        val model = CASBoardModel()
        val view = CASBoardView(primaryStage)
        val controller = CASBoardController(model, view)
        view.controller = controller
        primaryStage.show()
    }
}

fun main(args: Array<String>) {
    println("Starting CASBoard")
    Application.launch(CASApp::class.java, *args)
    println("CASBoard stopped")
}