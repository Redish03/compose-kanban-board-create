package woowacourse.kanban.board.component.screen

import androidx.compose.runtime.Composable
import woowacourse.kanban.board.component.KanbanBoard
import woowacourse.kanban.board.tasksExample

@Composable
fun MainScreen() {
    KanbanBoard(tasksExample)
}
