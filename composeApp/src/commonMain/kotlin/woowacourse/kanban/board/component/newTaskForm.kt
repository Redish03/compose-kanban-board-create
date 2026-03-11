package woowacourse.kanban.board.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.CustomColor
import woowacourse.kanban.board.component.task.Profile

@Composable
fun NewTaskForm() {
    Column(
        modifier = Modifier
            .size(672.dp, 654.dp)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        defaultTextField(text = "제목 *", hintText = "태스크 제목을 입력하세요", supportingText = null)
        defaultTextField(text = "설명", hintText = "테스크에 대한 자세한 설명을 입력하세요", supportingText = null)
        defaultTextField(
            text = "태그",
            hintText = "태그를 쉼표로 구분하여 입력하세요 (예: 버그, 긴급)",
            supportingText = "5자 이내의 태그를 최대 5개까지 등록할 수 있습니다.",
        )
        ItemSelectionFormBox(
            text = "상태 *",
            { Text("To Do", modifier = Modifier.align(Alignment.Center)) },
            { Text("In Progress", modifier = Modifier.align(Alignment.Center)) },
            { Text("Done", modifier = Modifier.align(Alignment.Center)) },
        )
        ItemSelectionFormBox(
            text = "담당자",
            { Profile("다이노", modifier = Modifier.align(Alignment.CenterStart)) },
            { Profile("페임스", modifier = Modifier.align(Alignment.CenterStart)) },
        )
    }
}

@Composable
fun defaultTextField(text: String, hintText: String, supportingText: String?) {
    var value by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = value,
            modifier = Modifier
                .fillMaxWidth(),
            textStyle = TextStyle(
                color = CustomColor.GRAY_TEXT_COLOR.color,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            ),
            placeholder = { Text(hintText) },
            onValueChange = { value = it },
            supportingText = { Text(supportingText ?: "") },
        )
    }
}

@Preview
@Composable
private fun newTaskFormPreview(widthDp: Dp = 672.dp, heightDp: Dp = 818.09.dp) {
    NewTaskForm()
}

@Preview
@Composable
fun defaultTextFieldPreview(@PreviewParameter(DefaultTextFieldParameterProvider::class) text: String) {
    defaultTextField(text, "hint", null)
}

private class DefaultTextFieldParameterProvider() : PreviewParameterProvider<String> {
    override val values = sequenceOf<String>(
        "제목 *",
        "설명",
        "태그",
    )
}