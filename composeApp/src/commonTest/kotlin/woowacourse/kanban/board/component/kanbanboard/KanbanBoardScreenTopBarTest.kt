package woowacourse.kanban.board.component.kanbanboard

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import org.junit.Test
import woowacourse.kanban.board.component.screen.KanbanBoardScreen

@OptIn(ExperimentalTestApi::class)
class KanbanBoardScreenTopBarTest {
    @Test
    fun `새 태스크 생성 버튼을 누르면 Dialog가 생성된다`() = runComposeUiTest {
        setContent {
            KanbanBoardScreen()
        }

        onNodeWithText("새 태스크 생성").performClick()
        onNodeWithText("생성").assertIsDisplayed()
    }
}
