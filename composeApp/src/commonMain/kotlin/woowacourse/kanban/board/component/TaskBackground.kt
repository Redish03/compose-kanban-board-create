package woowacourse.kanban.board.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.component.task.TaskCard
import woowacourse.kanban.board.data.Task
import woowacourse.kanban.board.tasksExample

@Composable
fun TaskBackground(tasks: List<Task>) {
    FlowRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(38.dp),
        maxItemsInEachRow = 4,
        horizontalArrangement = Arrangement.spacedBy(52.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        tasks.forEach { task ->
            TaskCard(task.taskTitle, task.taskScript, task.tags, task.nickname)
        }
    }
}

@Composable
@Preview
private fun TaskBackgroundPreview() {
    TaskBackground(tasksExample)
}
