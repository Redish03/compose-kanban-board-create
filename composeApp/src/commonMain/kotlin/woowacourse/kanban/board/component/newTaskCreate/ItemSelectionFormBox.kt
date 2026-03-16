package woowacourse.kanban.board.component.newTaskCreate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ItemSelectionFormBox(
    text: String,
    selectedItemIndex: Int,
    onItemSelected: (Int) -> Unit,
    vararg createButton: @Composable BoxScope.() -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Text(text = text)
        Spacer(modifier = Modifier.height(8.dp))
        FlowRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            maxItemsInEachRow = createButton.size
            // maxItemsInEachRow는 디폴트 값이 Int의 MAX임
        ) {
            createButton.forEachIndexed { index, element ->
                DefaultSelectButton(
                    isSelected = (selectedItemIndex == index),
                    onClick = { onItemSelected(index) },
                    content = element,
                )
            }
        }
    }
}

@Preview(widthDp = 672)
@Composable
private fun ItemSelectionFormBoxPreview() {
    Column {
        ItemSelectionFormBox(
            "상태 *",
            0,
            { },
            { Text("btn1", modifier = Modifier.align(Alignment.CenterStart)) },
            { Text("btn2", modifier = Modifier.align(Alignment.CenterStart)) },
            { Text("btn3", modifier = Modifier.align(Alignment.CenterStart)) },
        )
        ItemSelectionFormBox("상태 *", 0, { }, { Text("Hello", modifier = Modifier.align(Alignment.Center)) })
        ItemSelectionFormBox(
            "상태 *",
            0,
            { },
            { Text("MAX_TEST", modifier = Modifier.align(Alignment.CenterStart)) },
            { Text("MAX_TEST", modifier = Modifier.align(Alignment.CenterStart)) },
            { Text("MAX_TEST", modifier = Modifier.align(Alignment.CenterStart)) },
            { Text("MAX_TEST", modifier = Modifier.align(Alignment.CenterStart)) },
            { Text("MAX_TEST", modifier = Modifier.align(Alignment.CenterStart)) },
            { Text("MAX_TEST", modifier = Modifier.align(Alignment.CenterStart)) },
            { Text("MAX_TEST", modifier = Modifier.align(Alignment.CenterStart)) },
            { Text("MAX_TEST", modifier = Modifier.align(Alignment.CenterStart)) },
            { Text("MAX_TEST", modifier = Modifier.align(Alignment.CenterStart)) },
            { Text("MAX_TEST", modifier = Modifier.align(Alignment.CenterStart)) },
            { Text("MAX_TEST", modifier = Modifier.align(Alignment.CenterStart)) },
            { Text("MAX_TEST", modifier = Modifier.align(Alignment.CenterStart)) },
            { Text("MAX_TEST", modifier = Modifier.align(Alignment.CenterStart)) },
        )
    }
}
