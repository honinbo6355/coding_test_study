package leetcode.solution

class AssignCookies {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        val sortedArrayDescendingFactor = g.sortedArrayDescending()
        var sortedArrayDescendingFactorIdx = 0

        val sortedArrayDescendingCookie = s.sortedArrayDescending()
        var sortedArrayDescendingCookieIdx = 0

        while (sortedArrayDescendingFactorIdx < g.size && sortedArrayDescendingCookieIdx < s.size) {
            if (sortedArrayDescendingFactor[sortedArrayDescendingFactorIdx] <= sortedArrayDescendingCookie[sortedArrayDescendingCookieIdx]) {
                sortedArrayDescendingCookieIdx++
            }

            sortedArrayDescendingFactorIdx++
        }

        return sortedArrayDescendingCookieIdx
    }
}

fun main() {
    val assignCookies = AssignCookies()

    println(assignCookies.findContentChildren(intArrayOf(1,2,3), intArrayOf(1,1)))
    println(assignCookies.findContentChildren(intArrayOf(1,2), intArrayOf(1,2,3)))
}