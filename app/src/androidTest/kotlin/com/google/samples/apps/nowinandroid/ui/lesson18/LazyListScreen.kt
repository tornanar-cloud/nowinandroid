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

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.hasTestTag
import com.google.samples.apps.nowinandroid.core.designsystem.component.scrollbar.LazyListItemPositionSemantics
import com.google.samples.apps.nowinandroid.core.designsystem.component.scrollbar.LazyListSizeSemantics
import io.github.kakaocup.compose.node.builder.ViewBuilder
import io.github.kakaocup.compose.node.core.BaseNode
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemBuilder
import io.github.kakaocup.compose.node.element.lazylist.KLazyListNode

object LazyListScreen: ComposeScreen<LazyListScreen>() {
val items = createLazyList(
    viewBuilderAction = {
        hasTestTag("forYou:topicSelection")
    },
    itemTypeBuilder = {
        itemType(::ForYouTopicSelectionListItem)
    })

}


fun BaseNode<*>.createLazyList(
    viewBuilderAction: ViewBuilder.() -> Unit,
    itemTypeBuilder: KLazyListItemBuilder.() -> Unit,
) = KLazyListNode(
    viewBuilderAction = viewBuilderAction,
    itemTypeBuilder = itemTypeBuilder,
    positionMatcher = {
        SemanticsMatcher.expectValue(LazyListItemPositionSemantics, it)
    },
    lengthSemanticsPropertyKey = LazyListSizeSemantics,
)

    /*
object LazyListScreen : ComposeScreen<LazyListScreen>() {

    val items = KLazyListNode(
        semanticsProvider = semanticsProvider, // передаётся только если не используется новый Kakao
        viewBuilderAction = {
            hasTestTag("lazy-list")
        },
        itemTypeBuilder = {
            itemType(::ListItem)
        },
        positionMatcher = {
            SemanticsMatcher.expectValue(LazyListItemPositionSemantics, it)
        },
        lengthSemanticsPropertyKey = LazyListSizeSemantics // передаётся только если используется новый Kakao
    )
}

   */