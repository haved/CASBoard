package casboard

import casboard.view.CASBoardView
import javafx.application.Application
import javafx.stage.Stage

const val CASBOARD_NAME = "CASBoard"

class CASApp : Application() {
    override fun start(primaryStage: Stage) {
        CASBoardView(primaryStage)
    }
}

fun main(args: Array<String>) {
    println("Starting CASBoard")
    Application.launch(CASApp::class.java, *args)
    println("CASBoard stopped")
}