/*
 * Copyright 2026 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.nowinandroid.ui.lesson15

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.google.samples.apps.nowinandroid.MainActivity
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.github.kakaocup.compose.rule.KakaoComposeTestRule
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class ComposeTest : ConfiguredTest() {

    @Test
    fun checkToolbarTitle() {
        run {

            MainScreenCompose {
                step("Проверят что текст в тулбаре \"Now in Android\"") {
                    toolbarTitle.assertTextEquals("Now in Android")
                }
                step("Проверяет отображение кнопки и иконки поиска") {
                    searchButtonOnMainScreen.assertIsDisplayed()
                    searchButtonIcon.assertIsDisplayed()
                }
                step("Проверяет отображение кнопки и иконки настроек") {
                    settingButton.assertIsDisplayed()
                    settingsIcon.assertIsDisplayed()
                }

                step("Проверяет отображение тайтл в первой секции. Проверяет текст тайтл во второй секции.") {
                    titleOnFirstSection.assertIsDisplayed()
                    titleOnFirstSection.assertTextEquals("What are you interested in?")
                }
                step("Проверяет отображение сабтайтл в первой секции. Проверяет текст сабтайтл в первой секции. ") {
                    subTitleOnFirstSection.assertIsDisplayed()
                    subTitleOnFirstSection.assertTextEquals("Updates from topics you follow will appear here. Follow some things to get started.")
                }
                step("Проверяет отображение кнопки Done. Проверяет текст в кнопке Done ") {
                    doneButton.assertIsDisplayed()
                    doneButtonText.assertTextContains("Done")
                }
                step("Нажимает на кнопку поиска"){
                    searchButtonOnMainScreen.performClick()
                }
            }



            SearchToolbarScreenCompose {
                step("Проверяет отображение иконки на кнопке back и нажимает её") {
                    backButtonIcon.assertIsDisplayed()
                    backButtonIcon.performClick()
                }
            }

            MainScreenCompose{
                step("Нажимает на кнопку поиска"){
                    searchButtonOnMainScreen.performClick()
                }
            }

            SearchToolbarScreenCompose{
                step("Проверяет отображение иконки лупы в поле ввода"){
                    textFieldSearchIcon.assertIsDisplayed()
                }
                step("Вводит текст в тектосовое поле поиска"){
                    searchTextField.performTextInput("test value")
                }
                step("Проверяет, что отобржается иконка в виде креста в текстовом поле и нажимает её"){
                    searchFieldCloseIcon.assertIsDisplayed()
                    searchFieldCloseIcon.performClick()
                }
                step("Проверяет, что поле стало пустым"){
                    searchTextField.assertTextEquals("")
                }
            }
        }
    }
}