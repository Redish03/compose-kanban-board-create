package woowacourse.kanban.board.component.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import kotlinx.coroutines.launch
import woowacourse.kanban.board.InputValidator
import woowacourse.kanban.board.component.kanbanboard.KanbanBoard
import woowacourse.kanban.board.component.kanbanboard.KanbanBoardScreenTopBar
import woowacourse.kanban.board.component.newTaskCreate.CreateNewTaskDialog
import woowacourse.kanban.board.data.Tasks
import woowacourse.kanban.board.tasksExample

@Composable
fun KanbanBoardScreen() {
    var isCreatingNewTask by remember { mutableStateOf(false) }
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var tags by remember { mutableStateOf("") }
    var selectedStatusIndex by remember { mutableStateOf(0) }
    var selectedProfileIndex by remember { mutableStateOf(0) }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }


    val tasks = remember { Tasks(tasksExample.toMutableStateList()) }

    val statusOptions = listOf("To Do", "In Progress", "Done")
    val profileOptions = listOf("다이노", "페임스")

    val isCreateEnabled by remember(title, tags) {
        derivedStateOf {
            (InputValidator.validateTitle(title) == null) &&
                    (InputValidator.validateTagsAndWordCount(tags) == null)
        }
    }

    if (isCreatingNewTask) Dialog(
        onDismissRequest = { isCreatingNewTask = false },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false,
        ),
    ) {
        CreateNewTaskDialog(
            title = title,
            onTitleChange = { title = it },
            description = description,
            onDescriptionChange = { description = it },
            tags = tags,
            onTagsChange = { tags = it },
            selectedStatusIndex = selectedStatusIndex,
            statusOptions = statusOptions,
            onStatusChange = { selectedStatusIndex = it },
            selectedProfileIndex = selectedProfileIndex,
            profileOptions = profileOptions,
            onProfileChange = { selectedProfileIndex = it },
            isCreateEnabled = isCreateEnabled,
            onClickCreateButton = {
                tasks.addNewTask(
                    title,
                    description,
                    tags,
                    statusOptions[selectedStatusIndex],
                    profileOptions[selectedProfileIndex],
                )

                scope.launch {
                    snackbarHostState.showSnackbar("새로운 태스크가 추가되었습니다.")
                }

                title = ""
                description = ""
                tags = ""
                selectedStatusIndex = 0
                selectedProfileIndex = 0
                isCreatingNewTask = false
            },
            onClickCloseButton = { isCreatingNewTask = false },
            modifier = Modifier
                .padding(vertical = 15.dp)
                .background(color = Color.White)
                .width(750.dp),
        )
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Top,
        ) {
            KanbanBoardScreenTopBar(
                tasksCount = tasks.tasksSize(),
                completeCount = tasks.doneTasksSize(),
                completeRate = tasks.calculateDoneTasksRatio(),
                onClickCreateNewTaskButton = { isCreatingNewTask = true },
            )
            KanbanBoard(
                tasks = tasks,
            )
        }
    }
}

@Preview(widthDp = 1200)
@Composable
private fun KanbanBoardScreenPreview() {
    KanbanBoardScreen()
}
