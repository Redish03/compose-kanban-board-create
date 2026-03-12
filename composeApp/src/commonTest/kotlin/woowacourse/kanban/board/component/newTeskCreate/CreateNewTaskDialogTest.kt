package woowacourse.kanban.board.component.newTeskCreate

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.runComposeUiTest
import org.junit.Test
import woowacourse.kanban.board.component.newTaskCreate.CreateNewTaskDialog

@OptIn(ExperimentalTestApi::class)
class CreateNewTaskDialogTest {
    @Test
    fun `제목이 비어있으면 생성 버튼이 비활성화 된다`() = runComposeUiTest {
        setContent {
            CreateNewTaskDialog()
        }

        onNodeWithText("생성").assertIsNotEnabled()
    }

    @Test
    fun `제목이 있다면 생성 버튼이 활성화 된다`() = runComposeUiTest {
        setContent {
            CreateNewTaskDialog()
        }

        onNodeWithTag("title_textField").performTextInput("Hello")
        onNodeWithText("생성").assertIsEnabled()
    }
}