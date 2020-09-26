# Merge k Sorted Lists #23

## What is a Divide and Conquer Algorithm?

[Reference](https://www.khanacademy.org/computing/computer-science/algorithms/merge-sort/a/divide-and-conquer-algorithms)

## What is the Problem?

See problem [#23 on Leetcode](https://leetcode.com/problems/merge-k-sorted-lists/).

### Runtime and Space Complexity

The runtime of `mergeKLists()` is `0(n*m)` since it requires a nested for-loop of size `n` where `n` is the number of rows and `m` is the number of columns.

This nested for-loop was to flatten the 2D array into a single dimension array.

`mergeSort()` was used to sort the flattened array. The average runtime for Merge Sort is `0(n log n)`. This because the array is recursively divided into half until it can no longer be divided i.e. reaching a single element. When the array is "rebuilt" or when the elements `merge()`, they are compared and combined recursively as well.

The space complexity is usually the number of elements in the unsorted 2D array. However my implementation uses a temporary array as a placeholder. Hence, the space complexity of this implementation is two times of the total number of elements in the unsorted 2D array.