// 希尔排序
function shellSort(arr) {
	const n = arr.length;
	let gap = Math.floor(n / 2); // 初始增量（通常取数组长度的一半）

	while (gap > 0) {
		// 对每个子序列进行插入排序
		for (let i = gap; i < n; i++) {
			const temp = arr[i]; // 当前待插入元素
			let j = i;

			// 在子序列中向前比较并移动元素
			while (j >= 0 && arr[j - gap] > temp) {
				arr[j] = arr[j - gap];
				j -= gap;
			}
			arr[j] = temp; // 插入到正确位置
		}
		gap = Math.floor(gap / 2); // 缩小增量
	}

	return arr;
}

// 测试示例
const arr = [9, 6, 2, 12, 4, 3, 5];
console.log(shellSort(arr)); // 输出: [2, 3, 4, 6, 9, 12]
