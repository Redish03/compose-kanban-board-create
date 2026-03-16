package woowacourse.kanban.board.component.newTeskCreate

import org.junit.Test
import woowacourse.kanban.board.InputValidator
import kotlin.test.assertEquals

class NewTaskFormTest {
    @Test
    fun `제목이 null 또는 공백인 경우 제목을 입력해달라는 안내 문구 반환`() {
        val title1 = ""
        val title2 = "  "
        val title3 = null

        val answerString = "제목을 입력해 주세요."

        assertEquals(answerString, InputValidator.validateTitle(title1))
        assertEquals(answerString, InputValidator.validateTitle(title2))
        assertEquals(answerString, InputValidator.validateTitle(title3))
    }

    @Test
    fun `태그의 개수가 5개가 넘어가는 경우 포맷에 맞춰 입력해달라는 안내 문구 반환`() {
        val tags = "조디악,사무엘,호이,앨리,아키,허닛"

        val answerString = "태그는 5자 이내로 5개까지만 등록할 수 있습니다."

        assertEquals(answerString, InputValidator.validateTagsAndWordCount(tags))
    }
}
