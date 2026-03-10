package woowacourse.kanban.board

import androidx.compose.runtime.Composable
import woowacourse.kanban.board.component.task.TaskCard
import woowacourse.kanban.board.data.Task

class TaskUIMapper {
    @Composable
    fun createTaskUI(tasks: List<Task>) {
        tasks.forEach { task ->
            TaskCard(task.taskTitle, task.taskScript, task.tags, task.nickname)
        }
    }
}