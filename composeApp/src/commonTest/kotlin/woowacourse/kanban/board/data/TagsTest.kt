package woowacourse.kanban.board.data

import org.assertj.core.api.Assertions.assertThatNoException
import org.junit.Assert.assertThrows
import kotlin.test.Test

class TagsTest {
    @Test
    fun `태그에 5자 이상 또는 5개 이상의 태그가 들어올 경우 IllegalArgumentException을 발생시킨다`() {
        val wrongTag1 = listOf("fivetag", "overfive")
        val wrongTag2 = listOf("tag1", "tag2", "tag3", "tag4", "tag5", "tag6")

        assertThrows(IllegalArgumentException::class.java) {
            Tags(wrongTag1)
            Tags(wrongTag2)
        }
    }

    @Test
    fun `태그가 비어있거나 형식에 맞을 경우 Task를 생성한다`() {
        val correctTag1 = emptyList<String>()
        val correctTag2 = listOf("tag1")
        val correctTag3 = listOf("tag1", "tag2", "tag3", "tag4", "tag5")
        val correctTag4 = listOf("   ")

        assertThatNoException().isThrownBy {
            Tags(correctTag1)
            Tags(correctTag2)
            Tags(correctTag3)
            Tags(correctTag4)
        }

    }
}
