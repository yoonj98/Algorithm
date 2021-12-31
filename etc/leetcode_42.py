# leetcode 빗물 트래핑
class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        
        res = 0
        left, right = 0, len(height)-1
        left_height, right_height = height[left], height[right]
        
        while left < right:
            left_height, right_height = max(left_height, height[left]), max(right_height, height[right])
            if left_height <= right_height:
                res += left_height - height[left]
                left += 1
            else:
                res += right_height - height[right]
                right -= 1
        return res