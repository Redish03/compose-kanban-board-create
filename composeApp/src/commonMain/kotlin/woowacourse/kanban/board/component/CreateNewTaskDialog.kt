package woowacourse.kanban.board.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun CreateNewTaskDialog() {
    Column {
        TopBar()
        HorizontalDivider()
    }
}