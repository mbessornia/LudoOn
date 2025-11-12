package com.example.ludoon.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ludoon.models.Feed
import com.example.ludoon.ui.theme.spacingLarge
import com.example.ludoon.ui.theme.spacingXLarge

@Composable
fun FeedList(posts: List<Feed>) {
    LazyColumn(modifier = Modifier.padding(top = spacingLarge, bottom = spacingXLarge)) {
        itemsIndexed(posts){ _, post ->
            FeedItem(post)

        }
    }
}
