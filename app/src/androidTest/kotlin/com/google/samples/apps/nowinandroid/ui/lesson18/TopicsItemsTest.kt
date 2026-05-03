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

package com.google.samples.apps.nowinandroid.ui.lesson18

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performScrollToIndex
import androidx.compose.ui.test.performScrollToNode
import com.google.samples.apps.nowinandroid.ui.lesson15.ConfiguredTest
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Test
import kotlin.test.assertTrue

@HiltAndroidTest
class TopicsItemsTest : ConfiguredTest() {

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun checkFirstIndex() {
        run {


            step("Нажимает на кнопку тогл в 0 индексе топика") {
                LazyListScreen {
                    itemsTopic.childAt<ForYouTopicSelectionListItem>(0) {
                        toggleButton.performClick()
                        checkedButtonIcon.assertIsDisplayed()
                    }
                }
            }


            Thread.sleep(2000)
            step("Проверяет отображается ли тайтл в нулевом индексе в feed"){
                LazyListScreen{

                    itemsFeed {
                        assertIsDisplayed()
                    }
                    itemsFeed.childAt<ForYouFeedItemList>(0){
                        cardDate.performScrollTo()

                        cardTitle.assertIsDisplayed()
                        Thread.sleep(2000)
                        //cardTitle.assertTextContains("The new Google Pixel Watch is here  — start building for Wear OS!")
                    }
                }
            }

            //

        }
    }
}