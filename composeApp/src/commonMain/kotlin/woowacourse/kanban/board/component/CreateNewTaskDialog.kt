package woowacourse.kanban.board.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(heightDp = 1000)
fun CreateNewTaskDialog() {
    Column {
        TopBar()
        HorizontalDivider()
        NewTaskForm()
        HorizontalDivider(Modifier.padding(24.dp))
        CreateNewTaskDialogBottom()
    }
}