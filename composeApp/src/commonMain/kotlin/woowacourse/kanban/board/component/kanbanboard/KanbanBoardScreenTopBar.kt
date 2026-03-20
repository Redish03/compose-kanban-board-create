package woowacourse.kanban.board.component.kanbanboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kanbanboard.composeapp.generated.resources.Res
import kanbanboard.composeapp.generated.resources.ic_add
import org.jetbrains.compose.resources.painterResource
import woowacourse.kanban.board.CustomColor

@Composable
fun KanbanBoardScreenTopBar(onClickCreateNewTaskButton: () -> Unit) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            KanbanBoardTopBarTitle()
            CreateNewTaskButton(onClickCreateNewTaskButton)
        }
        TaskProgressBar()
    }
}

@Composable
fun KanbanBoardTopBarTitle() {
    Column {
        Text(
            text = "Compose Desktop 칸반 보드",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
        )
        Text(
            text = "완료율: 50% (3/6)",
            color = Color.Gray,
            fontSize = 9.sp,
        )
    }
}

@Composable
fun CreateNewTaskButton(onClickCreateNewTaskButton: () -> Unit) {
    Button(
        onClick = onClickCreateNewTaskButton,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier,
        colors = ButtonColors(
            containerColor = CustomColor.CREATE_NEW_TASK_BUTTON_COLOR.color,
            contentColor = Color.White,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.White,
        ),
        content = {
            Icon(
                painter = painterResource(Res.drawable.ic_add),
                contentDescription = "새 태스크 생성 버튼",
                modifier = Modifier,
            )
            Text("새 태스크 생성")
        },
    )
}

@Composable
fun TaskProgressBar(/* 퍼센트 및 완료율 포함되어야함 */) {
    var currentProgress by remember { mutableStateOf(0.7f) }
    LinearProgressIndicator(
        progress = { currentProgress },
        modifier = Modifier.fillMaxWidth(),
        color = CustomColor.CREATE_NEW_TASK_BUTTON_COLOR.color,
        trackColor = CustomColor.CARD_BORDER.color,
        strokeCap = StrokeCap.Butt,
        gapSize = 0.dp,
    )
}

@Preview
@Composable
private fun KanbanBoardScreenTopBarPreview() {
    KanbanBoardScreenTopBar(
        onClickCreateNewTaskButton = { },
    )
}

@Preview
@Composable
private fun KanbanBoardTopBarTitlePreview() {
    KanbanBoardTopBarTitle()
}

@Preview
@Composable
private fun CreateNewTaskButtonPreview() {
    CreateNewTaskButton(
        onClickCreateNewTaskButton = {  },
    )
}

@Preview
@Composable
private fun TaskProgressBarPreview() {
    TaskProgressBar()
}
