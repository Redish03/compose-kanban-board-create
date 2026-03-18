package woowacourse.kanban.board

import androidx.compose.ui.graphics.Color

enum class CustomColor(
    val color: Color,
) {
    CARD_BORDER(Color(0xFFE5E7EB)),
    DIVIDER(Color(0xFFF3F4F6)),
    TITLE(Color(0xFF101828)),
    SCRIPT(Color(0xFF4A5565)),
    TAG_BACKGROUND(Color(0xFFF3F4F6)),
    DEFAULT_TEXT_COLOR(Color(0xFF364153)),
    PROFILE_NICKNAME(Color(0xff364153)),
    TEXT_INPUT_ERROR_BORDER_COLOR(Color(0xFFB3261E)),
    TEXT_INPUT_DEFAULT_BORDER_COLOR(Color(0xFFAAAAAA)),
    GRAY_TEXT_COLOR(Color(0xFF0A0A0A)),
    SELECTED_BUTTON_BORDER_AND_TEXT_COLOR(Color(0xFF1447E6)),
    SELECTED_BUTTON_BACKGROUND_COLOR(Color(0xFFEFF6FF)),
}