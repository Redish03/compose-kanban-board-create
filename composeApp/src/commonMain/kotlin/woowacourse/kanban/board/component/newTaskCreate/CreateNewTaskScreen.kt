package woowacourse.kanban.board.component.newTaskCreate

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.InputValidator

@Composable
fun CreateNewTaskScreen() {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var tags by remember { mutableStateOf("") }
    var selectedStatusIndex by remember { mutableStateOf(0) }
    var selectedProfileIndex by remember { mutableStateOf(0) }

    val statusOptions = listOf("To Do", "In Progress", "Done")
    val profileOptions = listOf("다이노", "페임스")

    val isCreateEnabled by remember(title, tags) {
        derivedStateOf {
            (InputValidator.validateTitle(title) == null) &&
                    (InputValidator.validateTagsAndWordCount(tags) == null)
        }
    }

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
    )
}

@Composable
fun CreateNewTaskDialog(
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    tags: String,
    onTagsChange: (String) -> Unit,
    selectedStatusIndex: Int,
    statusOptions: List<String>,
    onStatusChange: (Int) -> Unit,
    selectedProfileIndex: Int,
    profileOptions: List<String>,
    onProfileChange: (Int) -> Unit,
    isCreateEnabled: Boolean,
) {
    Column {
        TopBar()
        HorizontalDivider()
        NewTaskForm(
            title = title,
            onTitleChange = onTitleChange,
            description = description,
            onDescriptionChange = onDescriptionChange,
            tags = tags,
            onTagsChange = onTagsChange,
            selectedStatusIndex = selectedStatusIndex,
            statusOptions = statusOptions,
            onStatusChange = onStatusChange,
            profileOptions = profileOptions,
            selectedProfileIndex = selectedProfileIndex,
            onProfileChange = onProfileChange,
            modifier = Modifier.weight(1f),
        )
        HorizontalDivider(Modifier.padding(24.dp))
        Box(modifier = Modifier.padding(vertical = 16.dp)) {
            CreateNewTaskDialogBottom(isCreateEnabled = isCreateEnabled)
        }
    }
}

@Preview(widthDp = 700)
@Composable
private fun CreateNewTaskDialogPreview() {
    CreateNewTaskDialog(
        title = "제목제목",
        onTitleChange = { },
        description = "설명",
        onDescriptionChange = { },
        tags = "안녕,사무엘",
        onTagsChange = { },
        selectedStatusIndex = 0,
        statusOptions = listOf("To Do", "In Progress", "Done"),
        onStatusChange = { },
        selectedProfileIndex = 0,
        profileOptions = listOf("다이노", "페임스"),
        onProfileChange = { },
        isCreateEnabled = true,
    )
}
