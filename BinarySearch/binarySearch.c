#include <stdio.h>
#include <stdlib.h>


int binarySearch(int arr[], int size, int target) {
    int left = 0;
    int right = size - 1;

    while (right >= left) {
        int mid = (left + right) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return -1;
}

int main() {
    int arr[10] = {1, 2, 3, 4, 5, 6, 7, 9, 10};
    int size = sizeof(arr) / sizeof(arr[0]); 
    int res = binarySearch(arr, size, 10);

    printf("%d\n", res);

    return 0;
}
