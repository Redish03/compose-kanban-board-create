package woowacourse.kanban.board.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.TaskUIMapper
import woowacourse.kanban.board.data.Task

@Composable
fun TaskBackground(generateTask: @Composable () -> Unit) {
    FlowRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(38.dp),
        maxItemsInEachRow = 4,
        horizontalArrangement = Arrangement.spacedBy(52.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        generateTask()
    }
}

@Composable
@Preview
private fun TaskBackgroundPreview() {
    val data = listOf(Task("조디악", nickname = "조디악"))
    TaskBackground { TaskUIMapper().createTaskUI(data) }
}
