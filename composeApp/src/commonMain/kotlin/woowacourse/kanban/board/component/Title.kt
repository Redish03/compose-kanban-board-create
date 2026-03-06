package woowacourse.kanban.board.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.CustomColor

@Composable
fun Title(title: String) {
    Text(
        text = title,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = CustomColor.TITLE.color,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}