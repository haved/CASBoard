import javafx.application.Application
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.stage.Stage
import javafx.scene.control.ToolBar
import javafx.scene.image.Image
import javafx.scene.layout.VBox

const val CASBOARD_NAME = "CASBoard"

class Board : Group() {

}

class CASApp : Application() {
    private val toolbar = ToolBar()
    private val board = Board()

    private fun fillToolbar() {
        val button = Button("Click me")
        val button2 = Button("Press me")

        toolbar.items.addAll(button, button2)
    }

    override fun start(primaryStage: Stage) {
        primaryStage.title = CASBOARD_NAME
        getStreamToOpt("icon.png")?.let {
            primaryStage.icons.add(Image(it))
        }

        fillToolbar()

        val scene = Scene(VBox(toolbar, board), 960.0, 600.0)
        primaryStage.scene = scene
        primaryStage.show()
    }
}

fun main(args: Array<String>) {
    println("Starting CASBoard")
    Application.launch(CASApp::class.java, *args)
    println("CASBoard stopped")
}