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
fun Script(script: String, modifier: Modifier = Modifier) {
    Text(
        text = script,
        modifier = modifier,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = CustomColor.SCRIPT.color,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
    )
}

@Preview
@Composable
private fun ScriptPreview(@PreviewParameter(ScriptPreviewProvider::class) script: String, modifier: Modifier = Modifier) {
    Script(script, modifier = modifier)
}

private class ScriptPreviewProvider() : PreviewParameterProvider<String?> {
    override val values = sequenceOf(
        "",
        "  ",
        "본문내용본문내용본문내용본문내용본문내용본문내용본문내용본문내용",
        "본문내용본문내용본문내용본문내용\n본문내용본문내용본문내용본문내용",
        "정말 정말 긴 본문 내용, 정말 정말 긴 본문 내용, 정말 정말 긴 본문 내용, 정말 정말 긴 본문 내용, " +
                "정말 정말 긴 본문 내용, 정말 정말 긴 본문 내용, 정말 정말 긴 본문 내용, 정말 정말 긴 본문 내용, " +
                "정말 정말 긴 본문 내용, 정말 정말 긴 본문 내용, 정말 정말 긴 본문 내용, 정말 정말 긴 본문 내용, ",
    )
}
