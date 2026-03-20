package woowacourse.kanban.board.component.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import woowacourse.kanban.board.component.kanbanboard.KanbanBoard
import woowacourse.kanban.board.component.kanbanboard.KanbanBoardScreenTopBar
import woowacourse.kanban.board.tasksExample

@Composable
fun KanbanBoardScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        KanbanBoardScreenTopBar()
        KanbanBoard(tasksExample)
    }
}

@Preview
@Composable
private fun KanbanBoardScreenPreview() {
    KanbanBoardScreen()
}
