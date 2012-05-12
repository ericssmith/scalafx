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

package scalafx

import application.JFXApp
import javafx.event.ActionEvent
import javafx.event.EventHandler
import scalafx.Includes._
import scalafx.beans.Observable._
import scalafx.scene.control._
import scalafx.scene.layout.GridPane
import scalafx.scene.paint.Color
import scalafx.scene.Scene
import scalafx.stage.Stage

object CheckBoxTest extends JFXApp {

  val check = new CheckBox {
    text = "CheckBox"
  }
  check.onAction = new EventHandler[ActionEvent] {
    def handle(event: ActionEvent) {
      lblCheckState.text = if (check.indeterminate.get) "Indeterminate" else check.selected.get().toString()
    }
  }

  val lblCheckState = new Label {
    text = check.selected.get().toString()
  }

  val btnAllowIndeterminate = new scalafx.scene.control.Button {
    text = "Allow Indeterminate"
  }
  btnAllowIndeterminate.onAction = new EventHandler[ActionEvent] {
    def handle(event: ActionEvent) {
      check.allowIndeterminate = !check.allowIndeterminate.get()
    }
  }

  val lblAllowIndeterminate = new Label {
    text <== when(check.allowIndeterminate) then "Can be Indeterminate" otherwise "Can not be Indeterminate"
  }

  val btnFire = new Button {
    text = "Fire!"
  }
  btnFire.onAction = new EventHandler[ActionEvent] {
    def handle(event: ActionEvent) {
      check.fire
    }
  }

  val txfText = new TextField 
  txfText.delegate.textProperty.bindBidirectional(check.text)

  val grid = new GridPane {
    hgap = 5
    vgap = 5
  }
  grid.add(check, 0, 0)
  grid.add(lblCheckState, 1, 0)
  grid.add(btnAllowIndeterminate, 0, 1)
  grid.add(lblAllowIndeterminate, 1, 1)
  grid.add(btnFire, 0, 2)
  grid.add(txfText, 1, 2)

  stage = new Stage {
    title = "CheckBox Test"
    width = 300
    height = 100
    scene = new Scene {
      fill = Color.LIGHTGRAY
      content = grid
    }
  }

}