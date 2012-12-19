/*
 * Copyright (c) 2012, ScalaFX Project
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
package scalafx.scene.control.cell

import javafx.{ collections => jfxc }
import javafx.scene.control.{ cell => jfxscc }
import javafx.{ util => jfxu }
import scalafx.Includes._
import scalafx.collections.ObservableBuffer
import scalafx.scene.control.TreeCell
import scalafx.scene.control.TreeView
import scalafx.util.SFXDelegate
import scalafx.util.StringConverter

object ChoiceBoxTreeCell {
  implicit def sfxChoiceBoxTreeCell2jfx[T](cell: ChoiceBoxTreeCell[T]) = cell.delegate

  /**
   * Creates a ChoiceBox cell factory for use in `TreeView` controls.
   */
  def forTreeView[T](items: ObservableBuffer[T]): (TreeView[T] => TreeCell[T]) =
    (view: TreeView[T]) => jfxscc.ChoiceBoxTreeCell.forTreeView[T](items).call(view)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(message = "Use forTreeView[T](ObservableBuffer[T])", since = "1.0")
  def forTreeView[T](items: jfxc.ObservableList[T]) = jfxscc.ChoiceBoxTreeCell.forTreeView[T](items)

  /**
   * Creates a ChoiceBox cell factory for use in `TreeView` controls.
   */
  def forTreeView[T](converter: StringConverter[T], items: ObservableBuffer[T]): (TreeView[T] => TreeCell[T]) =
    (view: TreeView[T]) => jfxscc.ChoiceBoxTreeCell.forTreeView[T](converter, items).call(view)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(message = "Use forTreeView[T](StringConverter[T], ObservableBuffer[T])", since = "1.0")
  def forTreeView[T](converter: jfxu.StringConverter[T], items: jfxc.ObservableList[T]) =
    jfxscc.ChoiceBoxTreeCell.forTreeView[T](converter, items)

  /**
   * Creates a ChoiceBox cell factory for use in `TreeView` controls.
   */
  def forTreeView[T](converter: StringConverter[T], items: T*): (TreeView[T] => TreeCell[T]) =
    (view: TreeView[T]) => jfxscc.ChoiceBoxTreeCell.forTreeView[T](converter, items: _*).call(view)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(message = "Use forTreeView[T](StringConverter[T], T*)", since = "1.0")
  def forTreeView[T](converter: jfxu.StringConverter[T], items: T*) = jfxscc.ChoiceBoxTreeCell.forTreeView[T](converter, items: _*)

  /**
   * Creates a ChoiceBox cell factory for use in `TreeView` controls.
   */
  def forTreeView[T](items: T*): (TreeView[T] => TreeCell[T]) =
    (view: TreeView[T]) => jfxscc.ChoiceBoxTreeCell.forTreeView[T](items: _*).call(view)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(message = "Use forTreeView[T](T*)", since = "1.0")
  def forTreeView[T](items: Array[T]) = jfxscc.ChoiceBoxTreeCell.forTreeView[T](items: _*)

}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/cell/ChoiceBoxTreeCell.html]]
 */
class ChoiceBoxTreeCell[T](override val delegate: jfxscc.ChoiceBoxTreeCell[T] = new jfxscc.ChoiceBoxTreeCell[T])
  extends TreeCell[T](delegate)
  with ConvertableCell[jfxscc.ChoiceBoxTreeCell[T], T, T]
  with UpdatableCell[jfxscc.ChoiceBoxTreeCell[T], T]
  with ItemnableCell[jfxscc.ChoiceBoxTreeCell[T], T]
  with SFXDelegate[jfxscc.ChoiceBoxTreeCell[T]] {

  /**
   * Creates a default `ChoiceBoxTreeCell` instance with the given items being used to populate the ChoiceBox when
   * it is shown.
   */
  def this(items: ObservableBuffer[T]) = this(new jfxscc.ChoiceBoxTreeCell[T](items))

  /**
   * Creates a `ChoiceBoxTreeCell` instance with the given items being used to populate the `ChoiceBox` when it is
   * shown, and the StringConverter being used to convert the item in to a user-readable form.
   */
  def this(converter: StringConverter[T], items: ObservableBuffer[T]) = this(new jfxscc.ChoiceBoxTreeCell[T](converter, items))

  /**
   * Creates a `ChoiceBoxTreeCell` instance with the given items being used to populate the `ChoiceBox` when it is
   * shown, and the StringConverter being used to convert the item in to a user-readable form.
   */
  def this(converter: StringConverter[T], items: T*) = this(new jfxscc.ChoiceBoxTreeCell[T](converter, items: _*))

  /**
   * Creates a default `ChoiceBoxTreeCell` instance with the given items being used to populate the `ChoiceBox` when
   * it is shown.
   */
  def this(items: T*) = this(new jfxscc.ChoiceBoxTreeCell[T](items: _*))

}