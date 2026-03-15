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
    val tasks = listOf<Task>(
        Task(
            "LazyColumn 컴포넌트 구현",
            "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            listOf("컴포넌트", "성능"),
            "다이노",
        ),
        Task(
            taskTitle = "LazyColumn 컴포넌트 구현",
            tags = listOf("컴포넌트", "성능"),
            nickname = "다이노",
        ),
        Task(
            taskTitle = "LazyColumn 컴포넌트 구현",
            taskScript = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            nickname = "다이노",
        ),
        Task(
            taskTitle = "LazyColumn 컴포넌트 구현",
            nickname = "다이노",
        ),
        Task(
            taskTitle = "너무 너무 긴 제목은 한 줄 까지만 노출시킵니다.",
            taskScript = "너무 너무 너무 긴 설명은 두 줄까지만 노출하고 말 줄임표로 처리합니다. 두 줄 까지만 노출합니다.",
            tags = listOf("너무너무", "긴 태그", "최대로", "5자까지", "5개제한임"),
            nickname = "다이노",
        ),
    )

    // Task UI를 생성하는 로직을 Background에 람다로 전달했지만, 더 좋은 방법은 없을까? 람다까지 해야할까?
    TaskBackground { TaskUIMapper().createTaskUI(tasks) }
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
