package com.projtech.presentation.ui.components.contact

import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.projtech.core.utils.Dimens.PaddingMedium
import com.projtech.core.utils.Dimens.PaddingSmall
import com.projtech.core.utils.Dimens.PaddingTiny
import com.projtech.domain.model.Contact

@Composable
fun ContactStoriesSection(
    contacts: List<Contact>,
    onContactClicked: (Contact) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .background(Color.Transparent)
            .padding(top = PaddingSmall, start = PaddingSmall),
        contentPadding = PaddingValues(horizontal = PaddingTiny, vertical = PaddingSmall),
        horizontalArrangement = Arrangement.spacedBy(PaddingMedium)
    ) {
        items(contacts) { contact ->
            ContactCard(contact) { onContactClicked(contact) }
        }
        item {
            AddContactButton { }
        }
    }
}
