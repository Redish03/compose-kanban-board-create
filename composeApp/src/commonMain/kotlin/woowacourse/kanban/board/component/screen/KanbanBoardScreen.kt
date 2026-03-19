package woowacourse.kanban.board.component.screen

import androidx.compose.runtime.Composable
import woowacourse.kanban.board.component.TaskBackground
import woowacourse.kanban.board.tasksExample

@Composable
fun MainScreen() {
    TaskBackground(tasksExample)
}
