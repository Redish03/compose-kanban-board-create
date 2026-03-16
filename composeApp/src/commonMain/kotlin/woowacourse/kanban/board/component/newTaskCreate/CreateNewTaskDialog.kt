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
fun CreateNewTaskDialog() {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var tags by remember { mutableStateOf("") }
    var selectedStatusIndex by remember { mutableStateOf(0) }
    var selectedProfileIndex by remember { mutableStateOf(0) }

    val isCreateEnabled by remember(title, tags) {
        derivedStateOf {
            (InputValidator.validateTitle(title) == null) && (InputValidator.validateTagsAndWordCount(tags) == null)
        }
    }

    Column {
        TopBar()
        HorizontalDivider()
        NewTaskForm(
            title = title,
            onTitleChange = { title = it },
            description = description,
            onDescriptionChange = { description = it },
            tags = tags,
            onTagsChange = { tags = it },
            selectedStatusIndex = selectedStatusIndex,
            onStatusChange = { selectedStatusIndex = it },
            selectedProfileIndex = selectedProfileIndex,
            onProfileChange = { selectedProfileIndex = it },
            modifier = Modifier.weight(1f),
        )
        HorizontalDivider(Modifier.padding(24.dp))
        Box(modifier = Modifier.padding(vertical = 16.dp)) {
            CreateNewTaskDialogBottom(isCreateEnabled = isCreateEnabled)
        }
    }
}

@Preview
@Composable
private fun CreateNewTaskDialogPreview() {
    CreateNewTaskDialog()
}
