package woowacourse.kanban.board.component.screen

import woowacourse.kanban.board.InputValidator

data class CreateNewTaskDialogState(
    val title: String = "",
    val description: String = "",
    val tags: String = "",
    val selectedStatusIndex: Int = 0,
    val selectedProfileIndex: Int = 0,
    val statusOptions: List<String> = listOf("To Do", "In Progress", "Done"),
    val profileOptions: List<String> = listOf("다이노", "페임스"),
) {
    val isCreateEnabled: Boolean
        get() = (InputValidator.validateTitle(title) == null) &&
                (InputValidator.validateTagsAndWordCount(tags) == null)
}
