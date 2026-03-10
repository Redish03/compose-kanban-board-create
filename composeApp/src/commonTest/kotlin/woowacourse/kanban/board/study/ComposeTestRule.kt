package woowacourse.kanban.board.study

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.printToLog
import androidx.compose.ui.test.runComposeUiTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

@OptIn(ExperimentalTestApi::class)
class ComposeTestRule {
    @Test
    fun `동기화1`() = runComposeUiTest {
        var counter by mutableStateOf(0)
        var latestCounter = 0

        setContent {
            Column {
                Button(
                    onClick = { counter++ },
                ) {
                    Text(counter.toString())
                }
                latestCounter = counter
            }
        }
        counter = 1

        waitForIdle()
        // recomposition을 사용하지 않는, JUnit의 Assertion 테스트는 waitForIdle()을 통해서 동기화를 해줘야한다.
        assertThat(latestCounter).isEqualTo(counter)
    }

    @Test
    fun `동기화2`() = runComposeUiTest {
        var counter by mutableStateOf(0)
        var latestCounter = 0

        setContent {
            Column {
                Button(
                    onClick = { counter++ },
                ) {
                    Text(counter.toString())
                }
                latestCounter = counter
            }
        }
        counter = 1

        // Compose에서 제공하는 UI 테스트는 waitForIdle을 할 필요가 없다.
        onNodeWithText("1").assertExists()

        // recomposition을 사용하지 않는 테스트는 waitForIdle()을 통해서 동기화를 해줘야한다.
        assertThat(latestCounter).isEqualTo(counter)
    }

    @Test
    fun `노드 병합1`() = runComposeUiTest {
        setContent {
            Button({}, modifier = Modifier.testTag("버튼")) {
                Text("확인")
                Text("버튼")
            }
        }
        onNodeWithText("확인").assertExists()
    }

    @Test
    fun `노드 병합2`() = runComposeUiTest {
        setContent {
            Button({}, modifier = Modifier.testTag("버튼")) {
                Text("확인", modifier = Modifier.testTag("text"))
                Text("버튼")
            }
        }
        /*
        onNodeWithTag("text").assertExists()
        onNodeWithTag("text").assertTextEquals("확인")
        */
        onNodeWithTag("text", useUnmergedTree = true).assertExists()
        onNodeWithTag("text", useUnmergedTree = true).assertTextEquals("확인")
    }

    @Test
    fun `노드 병합3`() = runComposeUiTest {
        setContent {
            Button({}, modifier = Modifier.testTag("버튼")) {
                Text("확인", modifier = Modifier.testTag("text"))
                Text("버튼")
            }
        }
        onNodeWithTag("버튼", useUnmergedTree = true).printToLog("로그") // Text = '[확인, 버튼]'
        onNodeWithTag("버튼").printToLog("확인")
        onNodeWithTag("text", useUnmergedTree = true).assertTextEquals("확인")
    }

    @Test
    fun `노드 병합4`() = runComposeUiTest {
        setContent {
            Button({}, modifier = Modifier.testTag("버튼")) {
                Text("확인", modifier = Modifier.testTag("text"))
                Text("버튼")
            }
        }

//        testTag = "[확인, 버튼]" 지정시 x

        onNodeWithTag("버튼").assertTextEquals("확인", "버튼")
            .printToLog("자식 병합 확인")
    }
}