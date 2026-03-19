package woowacourse.kanban.board.component.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import woowacourse.kanban.board.InputValidator
import woowacourse.kanban.board.component.newTaskCreate.CreateNewTaskDialog

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
