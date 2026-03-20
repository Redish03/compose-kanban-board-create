package woowacourse.kanban.board.component.kanbanboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.CustomColor
import woowacourse.kanban.board.data.Task
import woowacourse.kanban.board.data.TaskStatus
import woowacourse.kanban.board.tasksExample

@Composable
fun KanbanBoard(tasks: List<Task>) {
    FlowRow(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxHeight(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        TaskStatusCardHolder(
            tasks = tasks.filter { it.status == TaskStatus.TO_DO },
            tasksSize = tasks.filter { it.status == TaskStatus.TO_DO }.size,
            headerColor = CustomColor.TODO_CARD_HOLDER_HEADER_COLOR.color,
            backgroundColor = CustomColor.TODO_CARD_HOLDER_BACKGROUND_COLOR.color,
            taskStatusString = "To Do",
            borderColor = CustomColor.TODO_CARD_HOLDER_BORDER_COLOR.color,
        )

        TaskStatusCardHolder(
            tasks = tasks.filter { it.status == TaskStatus.IN_PROGRESS },
            tasksSize = tasks.filter { it.status == TaskStatus.IN_PROGRESS }.size,
            headerColor = CustomColor.IN_PROGRESS_CARD_HOLDER_HEADER_COLOR.color,
            backgroundColor = CustomColor.IN_PROGRESS_CARD_HOLDER_BACKGROUND_COLOR.color,
            taskStatusString = "In Progress",
            borderColor = CustomColor.IN_PROGRESS_CARD_HOLDER_BORDER_COLOR.color,
        )

        TaskStatusCardHolder(
            tasks = tasks.filter { it.status == TaskStatus.DONE },
            tasksSize = tasks.filter { it.status == TaskStatus.DONE }.size,
            headerColor = CustomColor.DONE_CARD_HOLDER_HEADER_COLOR.color,
            backgroundColor = CustomColor.DONE_CARD_HOLDER_BACKGROUND_COLOR.color,
            taskStatusString = "Done",
            borderColor = CustomColor.DONE_CARD_HOLDER_BORDER_COLOR.color,
        )
    }
}

@Preview(widthDp = 1200)
@Composable
private fun KanbanBoardPreview() {
    KanbanBoard(tasksExample)
}
