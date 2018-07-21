"use strict";


// 1. Two Sum
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    const indexArray =[];
    const hashmap = new Map();
    nums.forEach((value, index)=> {
        console.log("item:", value, index);
        if(hashmap.has( value )) {
            indexArray[0] = hashmap.get(value);
            indexArray[1] = index;
        } else {
            hashmap.set((target-value),index);
        }
    });
    return indexArray;
};

// 167. sort array two sum

/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
    const indices = [];
    let left = 0;
    let right = numbers.length-1;
    
    while(left<right) {
        const temp = numbers[left] + numbers[right];
        if (temp === target) {
            indices[0] = left +1;
            indices[1] = right + 1;
            return indices;
        } else if (temp > target) {
            right--;
        } else {
            left++;
        };
    };
};


// 653. Two Sum IV - Input is a BST
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {boolean}
 */

// BFS 
var findTarget = function(root, k) {
    const queue = new Array();
    queue.push(root);
    const hashMap = new Map();
    
    while(queue.length > 0) {
        const item = queue.shift();
        
        if (hashMap.has(item.val)) {
            return true;
        } else {
            const val = k - item.val;
            hashMap.set(val,false);
        }
        // push into the queue     
        if (item.left !==null) {
            queue.push(item.left);
        };
        if (item.right !==null) {
            queue.push(item.right);
        };
        
    };
    return false;
};


