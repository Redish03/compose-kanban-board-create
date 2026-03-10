package woowacourse.kanban.board.data

import org.junit.Assert.assertThrows
import org.junit.Test

class TaskTest {
    @Test
    fun `빈 제목이 들어오면 IllegalArgumentException을 발생시킨다`() {
        val emptyTitle = ""
        val emptyTitle2 = "  "

        assertThrows(IllegalArgumentException::class.java) { Task(taskTitle = emptyTitle, nickname = "사무엘") }
        assertThrows(IllegalArgumentException::class.java) { Task(taskTitle = emptyTitle2, nickname = "사무엘") }
    }

    @Test
    fun `빈 닉네임이 들어오면 IllegalArgumentException을 발생시킨다`() {
        val emptyName = ""
        val emptyName2 = "  "

        assertThrows(IllegalArgumentException::class.java) { Task(taskTitle = "title", nickname = emptyName) }
        assertThrows(IllegalArgumentException::class.java) { Task(taskTitle = "title", nickname = emptyName2) }
    }
}