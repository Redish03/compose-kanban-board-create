package woowacourse.kanban.board.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults.outlinedButtonColors
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.CustomColor
import woowacourse.kanban.board.component.task.Profile

@Composable
fun DefaultSelectButton(
    content: @Composable BoxScope.() -> Unit,
) {
    var isSelected by remember { mutableStateOf(false) }

    OutlinedButton(
        onClick = { isSelected = !isSelected },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.width(200.dp),
        colors = outlinedButtonColors(
            containerColor = if (isSelected) CustomColor.SELECTED_BUTTON_BACKGROUND_COLOR.color else Color.Transparent,
            contentColor = if (isSelected) CustomColor.SELECTED_BUTTON_BORDER_AND_TEXT_COLOR.color else CustomColor.DEFAULT_TEXT_COLOR.color,
        ),
        border = BorderStroke(
            width = 2.dp,
            color = if (isSelected) CustomColor.SELECTED_BUTTON_BORDER_AND_TEXT_COLOR.color
            else CustomColor.TEXT_INPUT_DEFAULT_BORDER_COLOR.color,
        ),
    ) {
        Box(
            modifier = Modifier
                .width(200.dp),
        ) {
            content()
        }
    }
}

@Preview
@Composable
fun DefaultSelectButtonPreview() {
    Column {
        DefaultSelectButton({ Text("Hello", modifier = Modifier.align(Alignment.CenterStart)) })
        DefaultSelectButton({ Text("조디악사무엘조디악사무엘조디악사무엘조디악사무엘조디악사무엘조디악사무엘조디악사무엘조디악사무엘조디악사무엘조디악사무엘조디악사무엘조디악사무엘") })
        DefaultSelectButton({ Text("To Do", modifier = Modifier.align(Alignment.Center)) })
        DefaultSelectButton({ Text("In Progress") })
        DefaultSelectButton({ Profile("조디악", Modifier.align(Alignment.CenterStart)) })
    }
}