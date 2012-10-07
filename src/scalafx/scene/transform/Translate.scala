/**
 *
 */
package scalafx.scene.transform

import scalafx.Includes._
import javafx.scene.{ transform => jfxst }
import scalafx.util.SFXDelegate
import scalafx.util.PositionDelegate

object Translate {
  implicit def sfxTranslate2jfx(v: Translate) = v.delegate
}

/**
 * @author RUAfonso
 *
 */
class Translate(override val delegate: jfxst.Translate = new jfxst.Translate)
  extends SFXDelegate[jfxst.Translate]
  with PositionDelegate {

  def this(x: Double, y: Double) = this(new jfxst.Translate(x, y))

  def this(x: Double, y: Double, z: Double) = this(new jfxst.Translate(x, y, z))

  /**
   * Defines the distance by which x and y coordinates are translated in their respectives axis
   * directions.
   */
  def positionedDelegate = delegate.asInstanceOf[Positioned]

  /**
   * Defines the distance by which coordinates are translated in the Z axis direction
   */
  def z = delegate.zProperty
  def z_=(v: Double) {
    z() = v
  }

}