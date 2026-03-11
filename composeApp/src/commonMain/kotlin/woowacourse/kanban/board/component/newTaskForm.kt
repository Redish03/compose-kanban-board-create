package woowacourse.kanban.board.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun newTaskForm(text: String) {
    defaultTextField(text = text)
}

@Composable
fun defaultTextField(text: String) {

    var value by remember { mutableStateOf("제목 1") }
    Column() {
        Text(
            text = text,
            fontSize = 20.sp,
        )

        TextField(
            value = value,
            modifier = Modifier,
            placeholder = { Text("태스크 제목을 입력하세요") },
            onValueChange = { value = it },
        )
    }

}

@Preview
@Composable
private fun newTaskFormPreview() {

    newTaskForm("제목 *")
}