package casboard

import casboard.controller.CASBoardController
import casboard.model.CASBoardModel
import casboard.resource.Strings
import casboard.view.CASBoardView
import javafx.application.Application
import javafx.stage.Stage

const val CASBOARD_NAME = "CASBoard"

class CASApp : Application() {
    override fun start(primaryStage: Stage) {
        val model = CASBoardModel()
        val controller = CASBoardController(model) {primaryStage.close()}
        val strings = Strings("lang/en_US.txt")
        CASBoardView(controller, strings, primaryStage)
        primaryStage.show()
    }
}

fun main(args: Array<String>) {
    logInfo("Starting CASBoard")
    Application.launch(CASApp::class.java, *args)
    logInfo("CASBoard stopped")
}