package casboard.view

import javafx.beans.value.ObservableValue
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.ToolBar
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.VBox
import javafx.stage.Popup

class CASToolBar(private val imageHeight:Double) : ToolBar() {
    private val instantTooltip = InstantTooltip()

    init {
        addButton(Image("add_cas.png"), null, "Add CAS block", "Adds an empty block for CAS")
        addButton(null, null, "Add wire", "Adds a wire")
    }

    private fun addButton(icon:Image?, handler:EventHandler<ActionEvent>?, title:String, desc:String) {
        val button = Button()
        button.id = "image_button"
        icon?.let {
            val iv =  ImageView(it)
            iv.fitHeight = imageHeight
            iv.isPreserveRatio = true
            button.graphic = iv
        }
        handler?.let { button.onAction = it }

        instantTooltip.addButton(button, title, desc)
        items.add(button)
    }
}

class InstantTooltip : Popup() {
    private var currentNode : Node? = null
    private val titleLabel = Label()
    private val descLabel = Label()

    init {
        titleLabel.id = "tooltip_title"
        val pane = VBox(titleLabel, descLabel)
        pane.id = "tooltip_pane"
        content.add(pane)
    }

    fun addButton(button: Button, title: String, desc: String) {
        fun stateChange(new: Boolean) {
            if(new) {
                titleLabel.text = title
                descLabel.text = desc
                val bounds = button.localToScreen(button.boundsInLocal)
                show(button, bounds.minX, bounds.maxY)
                currentNode = button
            } else if(currentNode == button)
                hide()
        }

        button.hoverProperty().addListener { _: ObservableValue<out Boolean>, _: Boolean, new: Boolean ->
            stateChange(new)
        }
        button.onTouchStationary = EventHandler{ stateChange(true) }
        button.armedProperty().addListener { _: ObservableValue<out Boolean>, _: Boolean, _: Boolean ->
            stateChange(false)
        }
    }
}