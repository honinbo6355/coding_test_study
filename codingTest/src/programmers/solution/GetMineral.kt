package programmers.solution

import java.util.Comparator

/**
 * - https://school.programmers.co.kr/learn/courses/30/lessons/172927?language=kotlin
 * - 그리디 문제
 * - https://velog.io/@seowj0710/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Level-2-%EA%B4%91%EB%AC%BC-%EC%BA%90%EA%B8%B0-Java
 * - lib/GetMineral_풀이.png
 */
fun main() {
    val s = GetMineral()

    println(s.solution(intArrayOf(1,3,2), arrayOf("diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone")))
    println(s.solution(intArrayOf(0,1,1), arrayOf("diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond")))
}

class GetMineral {
    class Calculate(val diamond: Int, val iron: Int, val stone: Int)

    fun solution(picks: IntArray, minerals: Array<String>): Int {
        var answer = 0
        var totalCount = picks.sum()
        val scoreBoard = arrayOf(
            intArrayOf(1,1,1),
            intArrayOf(5,1,1),
            intArrayOf(25,5,1),
        )
        var totalCalculates = mutableListOf<Calculate>()
        for (i in 0..minerals.size-1 step 5) {
            if (totalCount <= 0) {
                break
            }
            var diamond: Int = 0
            var iron: Int = 0
            var stone: Int = 0

            for (j in i..i+4) {
                if (j >= minerals.size) {
                    break
                }
                val idx = when (minerals[j]) {
                    "diamond" -> 0
                    "iron" -> 1
                    else -> 2
                }
                diamond += scoreBoard[0][idx]
                iron += scoreBoard[1][idx]
                stone += scoreBoard[2][idx]
            }

            totalCalculates.add(Calculate(diamond, iron, stone))
            totalCount--
        }

//        totalCalculates.sortWith(Comparator { o1, o2 ->
//            when {
//                o1.stone != o2.stone -> o2.stone - o2.stone
//                o2.iron != o2.iron -> o2.iron - o2.iron
//                else -> o2.diamond - o2.diamond
//            }
//        })

        totalCalculates.sortWith(Comparator { o1, o2 -> o2.stone - o1.stone })

        for (calculate in totalCalculates) {
            if (picks[0] > 0) {
                answer += calculate.diamond
                picks[0]--
                continue
            }
            if (picks[1] > 0) {
                answer += calculate.iron
                picks[1]--
                continue
            }
            if (picks[2] > 0) {
                answer += calculate.stone
                picks[2]--
                continue
            }
        }

        return answer
    }
}