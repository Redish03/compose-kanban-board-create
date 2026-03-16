package woowacourse.kanban.board.component.newTeskCreate

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.hasAnyAncestor
import androidx.compose.ui.test.hasSetTextAction
import androidx.compose.ui.test.hasTestTag
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
    fun `제목에 공백이 주어지면 생성 버튼이 비활성화 된다`() = runComposeUiTest {
        setContent {
            CreateNewTaskDialog()
        }

        onNode(hasSetTextAction() and hasAnyAncestor(hasTestTag("title_textField")))
            .performTextInput("")
        onNode(hasSetTextAction() and hasAnyAncestor(hasTestTag("title_textField")))
            .performTextInput("  ")
        onNode(hasSetTextAction() and hasAnyAncestor(hasTestTag("title_textField")))
            .performTextInput("\n\t")
        onNodeWithText("생성").assertIsNotEnabled()
    }

    @Test
    fun `제목이 있다면 생성 버튼이 활성화 된다`() = runComposeUiTest {
        setContent {
            CreateNewTaskDialog()
        }

        onNode(hasSetTextAction() and hasAnyAncestor(hasTestTag("title_textField")))
            .performTextInput("입력 테스트")
        onNodeWithText("생성").assertIsEnabled()
    }

    @Test
    fun `제목이 있어도 태그에 유효하지 않은 값이 입력되면 버튼이 비활성화 된다`() = runComposeUiTest {
        setContent {
            CreateNewTaskDialog()
        }

        onNode(hasSetTextAction() and hasAnyAncestor(hasTestTag("title_textField")))
            .performTextInput("입력 테스트")
        onNode(hasSetTextAction() and hasAnyAncestor(hasTestTag("tag_textField")))
            .performTextInput("hello,world,")
        onNodeWithText("생성").assertIsNotEnabled()
    }

    @Test
    fun `태그를 5개 초과하여 등록하려 하면 에러메세지를 띄운다`() = runComposeUiTest {
        setContent {
            CreateNewTaskDialog()
        }
        val input = "test1, test2, test3, test4, test5, test6"

        onNode(hasSetTextAction() and hasAnyAncestor(hasTestTag("tag_textField")))
            .performTextInput(input)

        onNodeWithText("태그는 5자 이내로 5개까지만 등록할 수 있습니다.")
            .assertIsDisplayed()
    }

    @Test
    fun `형식에 맞지 않는 태그를 입력 시 에러메세지를 띄운다`() = runComposeUiTest {
        setContent {
            CreateNewTaskDialog()
        }
        val input = "test1, test2,"

        onNode(hasSetTextAction() and hasAnyAncestor(hasTestTag("tag_textField")))
            .performTextInput(input)

        onNodeWithText("태그는 5자 이내로 5개까지만 등록할 수 있습니다.")
            .assertIsDisplayed()
    }

//    @Test
//    fun `제목을 입력했다가 지우면 에러메세지를 띄운다`() = runComposeUiTest {
//    } 이건 어떻게 하지?
}
