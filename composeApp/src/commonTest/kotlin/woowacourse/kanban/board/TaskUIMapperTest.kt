package woowacourse.kanban.board

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import org.junit.Test
import woowacourse.kanban.board.data.Task

@OptIn(ExperimentalTestApi::class)
class TaskUIMapperTest {
    @Test
    fun `할 일 UI를 생성한다`() = runComposeUiTest {
        val tasks = listOf(
            Task(
                taskTitle = "test1",
                taskScript = "스크립트는 자바스크립트로 이루어져있는가",
                tags = listOf("compose", "runTest"),
                nickname = "Sam",
            ),
            Task(
                taskTitle = "test2",
                taskScript = "행성",
                tags = listOf("compose", "coffee"),
                nickname = "Sam",
            ),
        )

        setContent {
            TaskUIMapper().createTaskUI(tasks)
        }

        // Then: 리스트에 있는 항목들이 화면에 잘 표시되는지 검증
        onNodeWithText("test1").assertIsDisplayed()
        onNodeWithText("행성").assertIsDisplayed()
    }
}