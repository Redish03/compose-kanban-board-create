package woowacourse.kanban.board.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CreateNewTaskDialogBottom() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.End,
    ) {
        BottomButton(
            text = "취소",
            textColor = Color.Black,
            backgroundColor = Color.White,
            onClick = { },
        )
        Spacer(modifier = Modifier.width(12.dp))
        BottomButton(
            text = "생성",
            textColor = Color.White,
            backgroundColor = Color.Unspecified,
            onClick = { },
        )
    }
}

@Composable
fun BottomButton(text: String, textColor: Color, backgroundColor: Color, onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier,
        colors = buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor,
        ),
    ) {
        Text(
            text = text,
            modifier = Modifier,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
            ),
        )
    }
}

@Preview
@Composable
private fun CreateNewTaskDialogBottomPreview() {
    CreateNewTaskDialogBottom()
}

@Preview
@Composable
private fun BottomButtonPreview() {
    BottomButton(
        text = "생성",
        textColor = Color.White,
        backgroundColor = Color.Magenta,
        onClick = { },
    )
}
