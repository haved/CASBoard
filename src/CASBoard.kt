import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Group
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.stage.Stage
import javafx.scene.control.ToolBar
import javafx.scene.image.Image
import javafx.scene.input.MouseEvent
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import javafx.stage.Popup

const val CASBOARD_NAME = "CASBoard"

class Board : Group() {

}

class InstantTooltip : Popup(), EventHandler<MouseEvent> {
    private val map = HashMap<Node, Pair<String, String>>()
    private var currentNode : Node? = null
    private val title = Label()
    private val desc = Label()

    init {
        title.id = "tooltip_title"
        val pane = VBox(title, desc)
        pane.id = "tooltip_pane"
        content.add(pane)
    }

    fun addNode(node: Node, title: String, desc: String) {
        node.onMouseEntered = this
        node.onMouseExited = this
        map[node] = Pair(title, desc)
    }

    override fun handle(event: MouseEvent) {
        val target = event.target
        if(event.eventType == MouseEvent.MOUSE_ENTERED) {
            map[target]?.let {
                val (title_text, desc_text) = it
                title.text = title_text
                desc.text = desc_text
                val node = target as Node
                val screenBounds = node.localToScreen(node.boundsInLocal)
                show(node, screenBounds.minX, screenBounds.maxY)
                currentNode = node
            } ?: error("What")
        } else if(event.eventType == MouseEvent.MOUSE_EXITED && target == currentNode) {
            currentNode = null
            hide()
        }
    }
}

class CASToolBar : ToolBar() {
    private val instantTooltip = InstantTooltip()

    init {
        val button = Button("AdCAS")
        instantTooltip.addNode(button, "Add CAS block", "Adds an empty block for CAS")
        val button2 = Button("AdWre")
        instantTooltip.addNode(button2, "Add wire", "Adds a wire")

        items.addAll(button, button2)
    }
}

class CASApp : Application() {
    private val toolbar = CASToolBar()
    private val board = Board()

    override fun start(primaryStage: Stage) {
        primaryStage.title = CASBOARD_NAME
        getStreamToOpt("icon.png")?.let {
            primaryStage.icons.add(Image(it))
        }

        val scene = Scene(VBox(toolbar, board), 960.0, 600.0)
        scene.stylesheets.add("style.css")
        primaryStage.scene = scene
        primaryStage.show()
    }
}

fun main(args: Array<String>) {
    println("Starting CASBoard")
    Application.launch(CASApp::class.java, *args)
    println("CASBoard stopped")
}