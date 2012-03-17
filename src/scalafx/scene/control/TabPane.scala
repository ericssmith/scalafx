package scalafx.scene.control

import javafx.geometry.Side
import javafx.scene.control.TabPane.TabClosingPolicy
import javafx.scene.{control => jfxsc}
import scalafx.Includes._
import scalafx.util.SFXDelegate

object TabPane {

  implicit def sfxTabPane2jfx(v: TabPane) = v.delegate

  /**
   * TabPane mode will be changed to floating allowing the TabPane to be placed alongside other control.
   */
  val StyleClassFloating = jfxsc.TabPane.STYLE_CLASS_FLOATING

}

class TabPane(override val delegate: jfxsc.TabPane = new jfxsc.TabPane) extends Control(delegate) with SFXDelegate[jfxsc.TabPane] {

  /**
   * The rotatedGraphic state of the tabs in the TabPane.
   */
  def rotateGraphic = delegate.rotateGraphicProperty
  def rotateGraphic_=(v: Boolean) {
    rotateGraphic() = v
  }

  /**
   * The selection model used for selecting tabs.
   */
  def selectionModel = delegate.selectionModelProperty
  def selectionModel_=(v: SingleSelectionModel[Tab]) {
    selectionModel() = v.asInstanceOf[jfxsc.SingleSelectionModel[jfxsc.Tab]]
  }

  /**
   * The position of the tabs in the TabPane.
   */
  def side = delegate.sideProperty
  def side_=(v: Side) {
    side() = v
  }

  /**
   * The closing policy for the tabs.
   */
  def tabClosingPolicy = delegate.tabClosingPolicyProperty
  def tabClosingPolicy_=(v: TabClosingPolicy) {
    tabClosingPolicy() = v
  }

  /**
   * The maximum height of the tabs in the TabPane.
   */
  def tabMaxHeight = delegate.tabMaxHeightProperty
  def tabMaxHeight_=(v: Double) {
    tabMaxHeight() = v
  }

  /**
   * The maximum width of the tabs in the TabPane.
   */
  def tabMaxWidth = delegate.tabMaxWidthProperty
  def tabMaxWidth_=(v: Double) {
    tabMaxWidth() = v
  }

  /**
   * The minimum height of the tab.
   */
  def tabMinHeight = delegate.tabMinHeightProperty
  def tabMinHeight_=(v: Double) {
    tabMinHeight() = v
  }

  /**
   * The minimum width of the tabs in the TabPane.
   */
  def tabMinWidth = delegate.tabMinWidthProperty
  def tabMinWidth_=(v: Double) {
    tabMinWidth() = v
  }

  /**
   * The tabs to display in this TabPane.
   */
  def tabs = delegate.getTabs
  
  /**
   * Append a new Tab to tabs 
   */
  def +=(tab: Tab) = {
    tabs.add(tab)
    this
  }

}
