package woowacourse.kanban.board.component.task

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.CustomColor

@Composable
fun TaskTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        modifier = modifier,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = CustomColor.TITLE.color,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}

@Preview
@Composable
private fun TaskTitlePreview(@PreviewParameter(TaskTitlePreviewProvider::class) title: String) {
    TaskTitle(title)
}

private class TaskTitlePreviewProvider : PreviewParameterProvider<String> {
    override val values = sequenceOf(
        "Alice",
        "너무너무긴이름은\n말줄임표로출력합니다.",
        "많이많이긴이름을프리뷰합니다",
    )
}
