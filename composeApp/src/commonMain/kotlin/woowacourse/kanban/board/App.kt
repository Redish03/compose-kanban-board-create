package woowacourse.kanban.board

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import woowacourse.kanban.board.component.TaskBackground
import woowacourse.kanban.board.component.newTaskCreate.CreateNewTaskDialog
import woowacourse.kanban.board.data.Task

@Composable
fun App() {
    CreateNewTaskDialog()
}

@Composable
fun MainScreen() {
    TaskBackground(tasksExample)
}

@Composable
fun CheckerScreen() {
    var checked by remember { mutableStateOf(true) }

    CheckerView(checked = checked) {
        checked = !checked
    }
}

@Composable
fun CheckerView(checked: Boolean, check: () -> Unit) {
    Column {
        Checkbox(
            checked = checked,
            onCheckedChange = { check() },
        )
        if (checked) Text(text = "체크됨!")
    }
}

val tasksExample = listOf<Task>(
    Task(
        Title("LazyColumn 컴포넌트 구현"),
        Script("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다."),
        Tags(listOf("컴포넌트", "성능")),
        Nickname("다이노"),
    ),
    Task(
        taskTitle = Title("LazyColumn 컴포넌트 구현"),
        tags = Tags(listOf("컴포넌트", "성능")),
        nickname = Nickname("다이노"),
    ),
    Task(
        taskTitle = Title("LazyColumn 컴포넌트 구현"),
        taskScript = Script("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다."),
        nickname = Nickname("다이노"),
    ),
    Task(
        taskTitle = Title("LazyColumn 컴포넌트 구현"),
        nickname = Nickname("다이노"),
    ),
    Task(
        taskTitle = Title("너무 너무 긴 제목은 한 줄 까지만 노출시킵니다."),
        taskScript = Script("너무 너무 너무 긴 설명은 두 줄까지만 노출하고 말 줄임표로 처리합니다. 두 줄 까지만 노출합니다."),
        tags = Tags(listOf("너무너무", "긴 태그", "최대로", "5자까지", "5개제한임")),
        nickname = Nickname("다이노"),
    ),
)
