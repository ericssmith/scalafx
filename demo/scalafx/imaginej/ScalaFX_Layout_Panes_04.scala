package scalafx.imaginej

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

//             ________                                __                   ________   __    __
//           /   _____/\                             /  /\                /   _____/\/__/\ /  /\
//          /  /\_____\/  ________     _______      /  / /   ________    /  /\_____\/\  \ /  / /
//         /  /_/___    /   _____/\  /_____   /\   /  / /  /_____   /\  /  /_/__      \  /  / /
//        /______  /\  /  /\_____\/  \____/  / /  /  / /   \____/  / / /   ____/\      \/  / /
//        \_____/ / / /  / /       /  ___   / /  /  / /  /  ___   / / /  /\____\/      /  / /\
//       ______/ / / /  /_/___    /  /__/  / /  /  / /  /  /__/  / / /  / /           /  / /\ \
//     /________/ / /________/\  /________/ /  /__/ /  /________/ / /__/ /           /__/ /  \ \
//     \________\/  \________\/  \________\/   \__\/   \________\/  \__\/            \__\/ \__\/
//
//                                  ScalaFX Programming Library Examples
//

import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import javafx.geometry.Pos

import scalafx.application.JFXApp
import scalafx.stage.Stage
import scalafx.scene.Scene
import scalafx.geometry.Insets
import scalafx.scene.control.Button
import scalafx.scene.shape.Rectangle
import scalafx.scene.text.Text
import scalafx.scene.text.Font
import scalafx.scene.layout.{StackPane, VBox, HBox, BorderPane}

/**
 * @author Luc Duponcheel <luc.duponcheel@gmail.com>
 *
 * based upon: Example 1-4 Create a Stack Pane
 *
 * note: no linear gradient and hard coded positioning of stack pane
 *
 * http://docs.oracle.com/javafx/2.0/layout/builtin_layouts.htm
 *
 */

object ScalaFX_Layout_Panes_04 extends JFXApp {
  val currentButton = new Button {
    text = "Current"
    prefWidth = 100
    prefHeight = 20
  }
  val projectedButton = new Button {
    text = "Projected"
    prefWidth = 100
    prefHeight = 20
  }
  val questionText: Text = new Text {
    fill = Color.WHITE
    stroke = Color.DARKBLUE
    font = Font.font("Amble Cn", FontWeight.BOLD, 18)
    text = " ? "
  }
  val questionRectangle = new Rectangle {
    fill = Color.LIGHTBLUE
    stroke = Color.WHITE
    arcHeight = 3.5
    arcWidth = 3.5
    width = questionText.boundsInLocal.getValue.getWidth() + 10
    height = questionText.boundsInLocal.getValue.getHeight() + 10
  }
  val stackPane = new StackPane {
    innerAlignment = Pos.CENTER
    content = List(questionRectangle, questionText)
  }
  val hBox = new HBox {
    spacing = 10
    padding = Insets(15, 12, 15, 12)
    style = "-fx-background-color: #336699"
    content = List(
      currentButton,
      projectedButton,
      new Rectangle {
        width = 200
      },
      stackPane
    )
  }
  val data = List(
    new Text {
      font = Font.font("Amble CN", FontWeight.BOLD, 14)
      text = "Data"
    },
    new Text {
      text = "  Sales"
    },
    new Text {
      text = "  Marketing"
    },
    new Text {
      text = "  Distribution"
    },
    new Text {
      text = "  Costs"
    }
  )
  val vBox = new VBox {
    spacing = 10
    padding = Insets(10, 10, 10, 10)
    content = data
  }

  val rectangle = new Rectangle {
    width = 380
    height = 220
    fill = Color.WHITE
  }

  stage = new Stage {
    title = "ScalaFX Layout Panes 04"
    scene = new Scene {
      content = new BorderPane {
        top = hBox
        left = vBox
        center = rectangle
      }
    }
  }
}

