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
package scalafx.scene

import javafx.beans.{binding => jfxbb}
import javafx.beans.{property => jfxbp}
import javafx.{scene => jfxs}
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.delegate.SFXDelegate

object SceneProperty {
  implicit def sfxSceneProperty2jfx(p: SceneProperty) = p.delegate
}

// This particular construct enables the reading of properties of the scene that will be set into the property later on.
class SceneProperty(override val delegate: jfxbp.ReadOnlyObjectProperty[jfxs.Scene])
  extends ReadOnlyObjectProperty[jfxs.Scene](delegate)
  with SFXDelegate[jfxbp.ReadOnlyObjectProperty[jfxs.Scene]] {

  def width = jfxbb.Bindings.selectDouble(delegate, "width")
  def height = jfxbb.Bindings.selectDouble(delegate, "height")

  // NOTE JFX8: The line with "jfxbb.Bindings.select ..." does not compile with:
  //              error: ambiguous reference to overloaded definition
  // See also [[http://stackoverflow.com/questions/3313929/how-do-i-disambiguate-in-scala-between-methods-with-vararg-and-without]]
  // and [[https://issues.scala-lang.org/browse/SI-2991]]
  //  def stylesheets = jfxbb.Bindings.select(delegate, "stylesheets").asInstanceOf[jfxbb.ObjectBinding[javafx.collections.ObservableList[String]]]
}
