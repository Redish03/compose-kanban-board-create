package woowacourse.kanban.board.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.CustomColor

@Composable
fun Tags(tags: List<String>?) {
    if (tags != null) {
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val tagsCount = if(tags.size > 5) 5 else tags.size
            for (i in 0 until tagsCount) {
                val filteredTag = if (tags[i].length > 5) tags[i].substring(0 until 5) else tags[i]
                TagBox(filteredTag)
            }
        }
    }
}

@Composable
fun TagBox(filteredTag: String) {
    Box(
        modifier = Modifier
            .background(
                color = CustomColor.TAG_BACKGROUND.color,
                shape = RoundedCornerShape(14.dp),
            )
            .padding(vertical = 4.dp, horizontal = 6.dp)
        ,
    ) {
        Text(
            text = filteredTag,
            fontSize = 12.sp,
            color = CustomColor.TAG_TEXT.color,
        )
    }
}