/*
 * Copyright (c) 2011, ScalaFX Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package scalafx.animation

import javafx.{ animation => jfxa }
import javafx.util.Duration
import scalafx.Includes._
import scalafx.util.SFXDelegate
import scalafx.scene.Node
import javafx.geometry.Point3D
import scalafx.beans.property.DoubleProperty

object RotateTransition extends AnimationStatics {
  implicit def sfxRotateTransition2jfx(v: RotateTransition) = v.delegate
}

/**
 * Wraps a [[http://docs.oracle.com/javafx/2/api/javafx/animation/RotateTransition.html RotateTransition]].
 */
class RotateTransition(override val delegate: jfxa.RotateTransition = new jfxa.RotateTransition)
  extends Transition(delegate)
  with SFXDelegate[jfxa.RotateTransition] {

  /**
   * The constructor of RotateTransition
   *
   * @param duration The duration of the RotateTransition
   */
  def this(duration: Duration) = this(new jfxa.RotateTransition(duration))

  /**
   * The constructor of RotateTransition
   *
   * @param duration The duration of the RotateTransition
   * @param node The node which will be rotated
   */
  def this(duration: Duration, node: Node) =
    this(new jfxa.RotateTransition(duration, node))

  /**
   * The duration of this RotateTransition. Default value: 400ms
   */
  def duration = delegate.durationProperty
  def duration_=(d: Duration) {
    duration() = d
  }

  /**
   * Specifies the incremented stop angle value, from the start, of this 
   * RotateTransition.
   */
  def byAngle: DoubleProperty = delegate.byAngleProperty
  def byAngle_=(by: Double) {
    byAngle() = by
  }

  /**
   * Specifies the stop angle value for this RotateTransition. Default value:
   * Double.NaN
   */
  def toAngle: DoubleProperty = delegate.toAngleProperty
  def toAngle_=(to: Double) {
    toAngle() = to
  }

  /**
   * The target node of this RotateTransition.
   */
  def node = delegate.nodeProperty
  def node_=(n: Node) {
    node() = n
  }

  /**
   * Specifies the axis of rotation for this RotateTransition.Default value:
   * null
   */
  def axis = delegate.axisProperty
  def axis_=(p: Point3D) {
    axis() = p
  }

  /**
   * Specifies the start angle value for this RotateTransition. Default value:
   * Double.NaN
   */
  def fromAngle: DoubleProperty = delegate.fromAngleProperty
  def fromAngle_=(from: Double) {
    fromAngle() = from
  }
}