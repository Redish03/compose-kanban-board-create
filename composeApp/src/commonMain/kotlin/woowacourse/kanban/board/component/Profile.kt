package woowacourse.kanban.board.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kanbanboard.composeapp.generated.resources.Res
import kanbanboard.composeapp.generated.resources.profile
import org.jetbrains.compose.resources.painterResource
import woowacourse.kanban.board.CustomColor

@Composable
fun Profile(nickname: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(Res.drawable.profile),
            contentDescription = "프로필 이미지",
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = nickname,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = CustomColor.PROFILE_NICKNAME.color,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}