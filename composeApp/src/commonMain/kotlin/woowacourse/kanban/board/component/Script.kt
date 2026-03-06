package woowacourse.kanban.board.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.CustomColor


@Composable
fun Script(script: String?) {
    if (script != null) Text(
        text = script,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = CustomColor.SCRIPT.color,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
    )
}